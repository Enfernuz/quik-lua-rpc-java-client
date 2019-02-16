package com.enfernuz.quik.lua.rpc.api.zmq;

import com.enfernuz.quik.lua.rpc.api.*;
import com.enfernuz.quik.lua.rpc.api.messages.*;
import com.enfernuz.quik.lua.rpc.api.messages.bit.*;
import com.enfernuz.quik.lua.rpc.api.messages.datasource.*;
import com.enfernuz.quik.lua.rpc.api.security.zmq.AuthContext;
import com.enfernuz.quik.lua.rpc.api.security.zmq.ZmqSecurable;
import com.enfernuz.quik.lua.rpc.api.structures.*;
import com.enfernuz.quik.lua.rpc.config.ClientConfiguration;
import com.enfernuz.quik.lua.rpc.io.transport.NetworkAddress;
import com.enfernuz.quik.lua.rpc.serde.SerdeModule;
import com.enfernuz.quik.lua.rpc.serde.SerdeUtils;
import lombok.NonNull;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.zeromq.ZMQ;
import org.zeromq.ZMsg;

import java.util.Map;

import static com.google.common.base.Preconditions.checkState;
import static java.util.Objects.requireNonNull;

/**
 * Реализация компонента <b>Java-обёртка над API QLua терминала QUIK на базе ZeroMQ</b>.
 */
public final class ZmqTcpQluaRpcClient extends AbstractTcpZmqClient implements RemoteProcedureCaller, TcpQluaRpcClient, ZmqSecurable {

    private ZMQ.Context zmqContext;
    private ZMQ.Socket reqSocket;
    private final AuthContext authContext;

    private final SerdeModule serdeModule;

    /**
     * Создаёт новый экземпляр компонента {@link ZmqTcpQluaRpcClient}, соответствующий заданной конфигурации клиента
     * точки подключения к RPC-сервису QUIK.
     *
     * @param config  конфигурация клиента точки подключения к RPC-сервису QUIK
     * @return новый экземпляр компонента {@link ZmqTcpQluaRpcClient}
     * @throws NullPointerException если аргумент {@code config} является null
     */
    public static @NotNull ZmqTcpQluaRpcClient newInstance(@NotNull @NonNull final ClientConfiguration config) {

        return new ZmqTcpQluaRpcClient(
                requireNonNull(config.getNetworkAddress(), "Свойство аргумента 'config.getNetworkAddress()' не должно быть null."),
                requireNonNull(config.getAuthContext(), "Свойство аргумента 'config.getAuthContext()' не должно быть null."),
                SerdeUtils.getSerdeModule( config.getSerdeProtocol() )
        );
    }

    private ZmqTcpQluaRpcClient(
            final NetworkAddress networkAddress,
            final AuthContext authContext,
            final SerdeModule serdeModule) {

        super(networkAddress);

        this.authContext = authContext;
        this.serdeModule = serdeModule;
    }

    @Contract(pure = true)
    @Override
    public AuthContext getAuthContext() {
        return authContext;
    }

    @Contract(pure = true)
    @Override
    public ZMQ.Socket getSocket() {
        return reqSocket;
    }

    @Override
    void initializeIO() {

        zmqContext = ZMQ.context(1);

        reqSocket = zmqContext.socket(ZMQ.REQ);
        reqSocket.setLinger(0); // no waiting before closing the socket

        ZmqUtils.setSocketSecurity(reqSocket, authContext);
    }

    @Override
    void deinitializeIO() {

        reqSocket.close();
        zmqContext.term();
        zmqContext = null;
        reqSocket = null;
    }

    @Override
    public int qlua_AddColumn(@NotNull final AddColumn.Args args) {
        return makeRPC(AddColumn.class, requireNonNull(args), AddColumn.Result.class).getResult();
    }

    @Override
    public @Nullable Integer qlua_AddLabel(@NotNull final String chartTag, final Map<String, String> labelParams) {

        final AddLabel.Args args = AddLabel.Args.builder()
                .chartTag(chartTag)
                .labelParams(labelParams)
                .build();

        return makeRPC(AddLabel.class, args, AddLabel.Result.class).getLabelId();
    }

    @Override
    public int qlua_AllocTable() {
        return makeRPC(AllocTable.class, null, AllocTable.Result.class).getTId();
    }

    @Override
    public @NotNull CalcBuySell.Result qlua_CalcBuySell(@NotNull final CalcBuySell.Args args) {
        return makeRPC(CalcBuySell.class, requireNonNull(args), CalcBuySell.Result.class);
    }

    @Override
    public boolean qlua_CancelParamRequest(@NotNull final CancelParamRequest.Args args) {
        return makeRPC(CancelParamRequest.class, requireNonNull(args), CancelParamRequest.Result.class).isResult();
    }

    @Override
    public boolean qlua_Clear(final int tId) {
        return makeRPC(Clear.class, new Clear.Args(tId), Clear.Result.class).isResult();
    }

    @Override
    public int qlua_CreateWindow(final int tId) {
        return makeRPC(CreateWindow.class, new CreateWindow.Args(tId), CreateWindow.Result.class).getResult();
    }

    @Override
    public boolean qlua_DelAllLabels(@NotNull final String chartTag) {
        return makeRPC(DelAllLabels.class, new DelAllLabels.Args(chartTag), DelAllLabels.Result.class).isResult();
    }

    @Override
    public boolean qlua_DeleteRow(@NotNull final DeleteRow.Args args) {
        return makeRPC(DeleteRow.class, requireNonNull(args), DeleteRow.Result.class).isResult();
    }

    @Override
    public boolean qlua_DelLabel(@NotNull final String chartTag, final int labelId) {
        return makeRPC(DelLabel.class, new DelLabel.Args(chartTag, labelId), DelLabel.Result.class).isResult();
    }

    @Override
    public boolean qlua_DestroyTable(final int tId) {
        return makeRPC(DestroyTable.class, new DestroyTable.Args(tId), DestroyTable.Result.class).isResult();
    }

    @Override
    public @NotNull GetBuySellInfo.BuySellInfo qlua_getBuySellInfo(@NotNull final GetBuySellInfo.Args args) {
        return makeRPC(GetBuySellInfo.class, requireNonNull(args), GetBuySellInfo.Result.class).getBuySellInfo();
    }

    @Override
    public @NotNull GetBuySellInfoEx.BuySellInfoEx qlua_getBuySellInfoEx(@NotNull final GetBuySellInfoEx.Args args) {
        return makeRPC(GetBuySellInfoEx.class, requireNonNull(args), GetBuySellInfoEx.Result.class).getBuySellInfoEx();
    }

    @Override
    public @NotNull GetCandlesByIndex.Result qlua_getCandlesByIndex(@NotNull final GetCandlesByIndex.Args args) {
        return makeRPC(GetCandlesByIndex.class, requireNonNull(args), GetCandlesByIndex.Result.class);
    }

    @Override
    public @NotNull GetCell.Result qlua_GetCell(@NotNull final GetCell.Args args) {
        return makeRPC(GetCell.class, requireNonNull(args), GetCell.Result.class);
    }

    @Override
    public @NotNull String qlua_getClassesList() {
        return makeRPC(GetClassesList.class, null, GetClassesList.Result.class).getClassesList();
    }

    @Override
    public @NotNull ClassInfo qlua_getClassInfo(@NotNull final String classCode) {
        return makeRPC(GetClassInfo.class, new GetClassInfo.Args(classCode), GetClassInfo.Result.class).getClassInfo();
    }

    @Override
    public @NotNull String qlua_getClassSecurities(@NotNull final String classCode) {
        return makeRPC(GetClassSecurities.class, new GetClassSecurities.Args(classCode), GetClassSecurities.Result.class).getClassSecurities();
    }

    @Override
    public @NotNull Depo qlua_getDepo(@NotNull final GetDepo.Args args) {
        return makeRPC(GetDepo.class, requireNonNull(args), GetDepo.Result.class).getDepo();
    }

    @Override
    public @Nullable DepoLimit qlua_getDepoEx(@NotNull final GetDepoEx.Args args) {
        return makeRPC(GetDepoEx.class, requireNonNull(args), GetDepoEx.Result.class).getDepoEx();
    }

    @Override
    public @Nullable FuturesClientHolding qlua_getFuturesHolding(@NotNull final GetFuturesHolding.Args args) {
        return makeRPC(GetFuturesHolding.class, requireNonNull(args), GetFuturesHolding.Result.class).getFuturesHolding();
    }

    @Override
    public @Nullable FuturesLimit qlua_getFuturesLimit(@NotNull final GetFuturesLimit.Args args) {
        return makeRPC(GetFuturesLimit.class, requireNonNull(args), GetFuturesLimit.Result.class).getFuturesLimit();
    }

    @Override
    public @NotNull String qlua_getInfoParam(@NotNull final String paramName) {
        return makeRPC(GetInfoParam.class, new GetInfoParam.Args(paramName), GetInfoParam.Result.class).getInfoParam();
    }

    @Override
    public @Nullable Map<String, String> qlua_getItem(@NotNull final String tableName, final int index) {
        return makeRPC(GetItem.class, new GetItem.Args(tableName, index), GetItem.Result.class).getTableRow();
    }

    @Override
    public @Nullable Map<String, String> qlua_GetLabelParams(@NotNull final String chartTag, final int labelId) {
        return makeRPC(GetLabelParams.class, new GetLabelParams.Args(chartTag, labelId), GetLabelParams.Result.class).getLabelParams();
    }

    @Override
    public int qlua_getLinesCount(@NotNull final String tag) {
        return makeRPC(GetLinesCount.class, new GetLinesCount.Args(tag), GetLinesCount.Result.class).getLinesCount();
    }

    @Override
    public @NotNull Money qlua_getMoney(@NotNull final GetMoney.Args args) {
        return makeRPC(GetMoney.class, requireNonNull(args), GetMoney.Result.class).getMoney();
    }

    @Override
    public @Nullable MoneyLimit qlua_getMoneyEx(@NotNull final GetMoneyEx.Args args) {
        return makeRPC(GetMoneyEx.class, requireNonNull(args), GetMoneyEx.Result.class).getMoneyEx();
    }

    @Override
    public int qlua_getNumberOf(@NotNull final String tableName) {
        return makeRPC(GetNumberOf.class, new GetNumberOf.Args(tableName), GetNumberOf.Result.class).getResult();
    }

    @Override
    public int qlua_getNumCandles(@NotNull final String tag) {
        return makeRPC(GetNumCandles.class, new GetNumCandles.Args(tag), GetNumCandles.Result.class).getNumCandles();
    }

    @Override
    public @NotNull GetOrderByNumber.Result qlua_getOrderByNumber(@NotNull final String classCode, final long orderId) {
        return makeRPC(GetOrderByNumber.class, new GetOrderByNumber.Args(classCode, orderId), GetOrderByNumber.Result.class);
    }

    @Override
    public @NotNull GetParamEx.ParamEx qlua_getParamEx(@NotNull final GetParamEx.Args args) {
        return makeRPC(GetParamEx.class, requireNonNull(args), GetParamEx.Result.class).getParamEx();
    }

    @Override
    public @NotNull GetParamEx2.ParamEx2 qlua_getParamEx2(@NotNull final GetParamEx2.Args args) {
        return makeRPC(GetParamEx2.class, requireNonNull(args), GetParamEx2.Result.class).getParamEx();
    }

    @Override
    public @NotNull PortfolioInfo qlua_getPortfolioInfo(@NotNull final GetPortfolioInfo.Args args) {
        return makeRPC(GetPortfolioInfo.class, requireNonNull(args), GetPortfolioInfo.Result.class).getPortfolioInfo();
    }

    @Override
    public @NotNull GetPortfolioInfoEx.Result qlua_getPortfolioInfoEx(@NotNull final GetPortfolioInfoEx.Args args) {
        return makeRPC(GetPortfolioInfoEx.class, requireNonNull(args), GetPortfolioInfoEx.Result.class);
    }

    @Override
    public @NotNull GetQuoteLevel2.Result qlua_getQuoteLevel2(@NotNull final GetQuoteLevel2.Args args) {
        return makeRPC(GetQuoteLevel2.class, requireNonNull(args), GetQuoteLevel2.Result.class);
    }

    @Override
    public @NotNull String qlua_getScriptPath() {
        return makeRPC(GetScriptPath.class, null, GetScriptPath.Result.class).getScriptPath();
    }

    @Override
    public @Nullable Security qlua_getSecurityInfo(@NotNull final GetSecurityInfo.Args args) {
        return makeRPC(GetSecurityInfo.class, requireNonNull(args), GetSecurityInfo.Result.class).getSecurityInfo();
    }

    @Override
    public @Nullable GetTableSize.TableSize qlua_GetTableSize(final int tId) {
        return makeRPC(GetTableSize.class, new GetTableSize.Args(tId), GetTableSize.Result.class).getTableSize();
    }

    @Override
    public @NotNull GetTradeDate.TradeDate qlua_getTradeDate() {
        return makeRPC(GetTradeDate.class, null, GetTradeDate.Result.class).getTradeDate();
    }

    @Override
    public @Nullable String qlua_GetWindowCaption(final int tId) {
        return makeRPC(GetWindowCaption.class, new GetWindowCaption.Args(tId), GetWindowCaption.Result.class).getCaption();
    }

    @Override
    public @NotNull GetWindowRect.WindowRect qlua_GetWindowRect(final int tId) {
        return makeRPC(GetWindowRect.class, new GetWindowRect.Args(tId), GetWindowRect.Result.class).getWindowRect();
    }

    @Override
    public @NotNull String qlua_getWorkingFolder() {
        return makeRPC(GetWorkingFolder.class, null, GetWorkingFolder.Result.class).getWorkingFolder();
    }

    @Override
    public boolean qlua_Highlight(@NotNull final Highlight.Args args) {
        return makeRPC(Highlight.class, requireNonNull(args), Highlight.Result.class).isResult();
    }

    @Override
    public int qlua_InsertRow(@NotNull final InsertRow.Args args) {
        return makeRPC(InsertRow.class, requireNonNull(args), InsertRow.Result.class).getResult();
    }

    @Override
    public int qlua_isConnected() {
        return makeRPC(IsConnected.class, null, IsConnected.Result.class).getIsConnected();
    }

    @Override
    public boolean qlua_IsSubscribedLevelIIQuotes(@NotNull final IsSubscribedLevel2Quotes.Args args) {
        return makeRPC(IsSubscribedLevel2Quotes.class, requireNonNull(args), IsSubscribedLevel2Quotes.Result.class).isResult();
    }

    @Override
    public Boolean qlua_IsWindowClosed(final int tId) {
        return makeRPC(IsWindowClosed.class, new IsWindowClosed.Args(tId), IsWindowClosed.Result.class).getResult();
    }

    @Override
    public @Nullable Integer qlua_message(@NotNull final String message, final Message.IconType iconType) {
        return makeRPC(Message.class, new Message.Args(message, iconType), Message.Result.class).getResult();
    }

    @Override
    public Integer qlua_message(@NotNull final String message) {
        return makeRPC(Message.class, new Message.Args(message), Message.Result.class).getResult();
    }

    @Override
    public boolean qlua_ParamRequest(@NotNull final ParamRequest.Args args) {
        return makeRPC(ParamRequest.class, args, ParamRequest.Result.class).isResult();
    }

    @Override
    public void qlua_PrintDbgStr(@NotNull final String s) {
        makeRPC(PrintDbgStr.class, new PrintDbgStr.Args(s));
    }

    @Override
    public int qlua_RGB(@NotNull final RGB.Args args) {
        return makeRPC(RGB.class, args, RGB.Result.class).getResult();
    }

    @Override
    public @NotNull SearchItems.Result qlua_SearchItems(@NotNull final SearchItems.Args args) {
        return makeRPC(SearchItems.class, args, SearchItems.Result.class);
    }

    @Override
    public @NotNull String qlua_sendTransaction(@NotNull final SendTransaction.Args args) {
        return makeRPC(SendTransaction.class, args, SendTransaction.Result.class).getResult();
    }

    @Override
    public boolean qlua_SetCell(@NotNull final SetCell.Args args) {
        return makeRPC(SetCell.class, args, SetCell.Result.class).isResult();
    }

    @Override
    public boolean qlua_SetColor(@NotNull final SetColor.Args args) {
        return makeRPC(SetColor.class, args, SetColor.Result.class).isResult();
    }

    @Override
    public boolean qlua_SetLabelParams(@NotNull final String chartTag, final int labelId, @NotNull final Map<String, String> labelParams) {
        return makeRPC(SetLabelParams.class, new SetLabelParams.Args(chartTag, labelId, labelParams), SetLabelParams.Result.class).isResult();
    }

    @Override
    public @NotNull SetSelectedRow.Result qlua_SetSelectedRow(@NotNull final SetSelectedRow.Args args) {
        return makeRPC(SetSelectedRow.class, args, SetSelectedRow.Result.class);
    }

    @Override
    public @NotNull SetTableNotificationCallback.Result qlua_SetTableNotificationCallback(final int tId, @NotNull final String fCbDef) {
        return makeRPC(SetTableNotificationCallback.class, new SetTableNotificationCallback.Args(tId, fCbDef), SetTableNotificationCallback.Result.class);
    }

    @Override
    public boolean qlua_SetWindowCaption(final int tId, @NotNull final String str) {
        return makeRPC(SetWindowCaption.class, new SetWindowCaption.Args(tId, str), SetWindowCaption.Result.class).isResult();
    }

    @Override
    public boolean qlua_SetWindowPos(@NotNull final SetWindowPos.Args args) {
        return makeRPC(SetWindowPos.class, args, SetWindowPos.Result.class).isResult();
    }

    @Override
    public @Nullable Long qlua_sleep(final long time) {
        return makeRPC(Sleep.class, new Sleep.Args(time), Sleep.Result.class).getResult();
    }

    @Override
    public boolean qlua_SubscribeLevelIIQuotes(@NotNull final SubscribeLevel2Quotes.Args args) {
        return makeRPC(SubscribeLevel2Quotes.class, args, SubscribeLevel2Quotes.Result.class).isResult();
    }

    @Override
    public boolean qlua_UnsubscribeLevelIIQuotes(@NotNull final UnsubscribeLevel2Quotes.Args args) {
        return makeRPC(UnsubscribeLevel2Quotes.class, args, UnsubscribeLevel2Quotes.Result.class).isResult();
    }

    @Override
    public long bit_band(final long x1, final long x2, final long... xi) {
        return makeRPC(BAnd.class, BAnd.Args.builder().x1(x1).x2(x2).xi(xi).build(), BAnd.Result.class).getResult();
    }

    @Override
    public long bit_bnot(final long x) {
        return makeRPC(BNot.class, new BNot.Args(x), BNot.Result.class).getResult();
    }

    @Override
    public long bit_bor(final long x1, final long x2, final long... xi) {
        return makeRPC(BOr.class, BOr.Args.builder().x1(x1).x2(x2).xi(xi).build(), BOr.Result.class).getResult();
    }

    @Override
    public long bit_bxor(final long x1, final long x2, final long... xi) {
        return makeRPC(BXor.class, BXor.Args.builder().x1(x1).x2(x2).xi(xi).build(), BXor.Result.class).getResult();
    }

    @Override
    public @NotNull String bit_tohex(@NotNull final ToHex.Args args) {
        return makeRPC(ToHex.class, args, ToHex.Result.class).getResult();
    }

    @Override
    public boolean bit_test(final long x, final int n) {
        return makeRPC(Test.class, Test.Args.builder().x(x).n(n).build(), Test.Result.class).isResult();
    }

    @Override
    public @NotNull String datasource_C(@NotNull final C.Args args) {
        return makeRPC(C.class, args, C.Result.class).getValue();
    }

    @Override
    public boolean datasource_Close(@NotNull final String datasourceUUID) {
        return makeRPC(Close.class, new Close.Args(datasourceUUID), Close.Result.class).isResult();
    }

    @Override
    public @NotNull CreateDataSource.Result datasource_CreateDataSource(@NotNull final CreateDataSource.Args args) {
        return makeRPC(CreateDataSource.class, args, CreateDataSource.Result.class);
    }

    @Override
    public @NotNull String datasource_H(@NotNull final H.Args args) {
        return makeRPC(H.class, args, H.Result.class).getValue();
    }

    @Override
    public @NotNull String datasource_L(@NotNull final L.Args args) {
        return makeRPC(L.class, args, L.Result.class).getValue();
    }

    @Override
    public @NotNull String datasource_O(@NotNull final O.Args args) {
        return makeRPC(O.class, args, O.Result.class).getValue();
    }

    @Override
    public boolean datasource_SetEmptyCallback(@NotNull final String datasourceUUID) {
        return makeRPC(SetEmptyCallback.class, new SetEmptyCallback.Args(datasourceUUID), SetEmptyCallback.Result.class).isResult();
    }

    @Override
    public boolean datasource_SetUpdateCallback(@NotNull final SetUpdateCallback.Args args) {
        return makeRPC(SetUpdateCallback.class, args, SetUpdateCallback.Result.class).isResult();
    }

    @Override
    public int datasource_Size(@NotNull final Size.Args args) {
        return makeRPC(Size.class, args, Size.Result.class).getValue();
    }

    @Override
    public @NotNull DataSourceTime datasource_T(@NotNull final T.Args args) {
        return makeRPC(T.class, args, T.Result.class).getTime();
    }

    @Override
    public @NotNull String datasource_V(@NotNull final V.Args args) {
        return makeRPC(V.class, args, V.Result.class).getValue();
    }

    private <T extends RemoteProcedure> void makeRPC(@NotNull final Class<T> remoteProcedureClass, final RpcArgs<T> args) {
        makeRPC(remoteProcedureClass, args, null);
    }

    @Contract("_, _, null -> null; _, _, !null -> !null")
    @Override
    public <T extends RemoteProcedure, U extends RpcResult<T>> U makeRPC(
            @NotNull final Class<T> remoteProcedureClass,
            final RpcArgs<T> args,
            @Nullable final Class<U> resultClass) throws RpcException {

        try {

            checkState(isOpened(), "Соединение должно быть открыто.");

            final ZMsg zRequest = new ZMsg();
            zRequest.add( serdeModule.serialize(new RequestEnvelope<>(remoteProcedureClass, args)) );
            zRequest.send(reqSocket);
            zRequest.destroy();

            final ZMsg zResponse = ZMsg.recvMsg(reqSocket);
            final byte[] response = ZmqUtils.convertZMsgToByteArray(zResponse);
            zResponse.destroy();

            final ResponseEnvelope responseEnvelope = serdeModule.deserialize(ResponseEnvelope.class, response);
            final ServiceError error = responseEnvelope.getError();
            if (error == null) {
                if (resultClass == null) {
                    return null;
                } else {
                    final byte[] result = responseEnvelope.getResult();
                    if (result == null) {
                        throw new RpcException("В ответе на вызов удалённой процедуры отсутствует результат.");
                    } else {
                        final U ret = serdeModule.deserialize(resultClass, result);
                        if (ret == null) {
                            throw new RpcException(
                                    String.format(
                                            "Десериализация результата, находящегося в ответе на вызов удалённой процедуры, в экземпляр класса %s вернула null.",
                                            resultClass.getName()
                                    )
                            );
                        }
                        return ret;
                    }
                }
            } else {
                throw new ServiceRpcException(error);
            }
        } catch (final RpcException  ex) {
            throw ex;
        } catch (final Exception ex) {
            throw new ClientRpcException(ex);
        }
    }
}
