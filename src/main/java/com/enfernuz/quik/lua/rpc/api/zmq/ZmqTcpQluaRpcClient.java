package com.enfernuz.quik.lua.rpc.api.zmq;

import com.enfernuz.quik.lua.rpc.api.ClientRpcException;
import com.enfernuz.quik.lua.rpc.api.ServiceError;
import com.enfernuz.quik.lua.rpc.api.ServiceRpcException;
import com.enfernuz.quik.lua.rpc.api.messages.*;
import com.enfernuz.quik.lua.rpc.api.messages.bit.*;
import com.enfernuz.quik.lua.rpc.api.messages.datasource.*;
import com.enfernuz.quik.lua.rpc.api.security.zmq.AuthContext;
import com.enfernuz.quik.lua.rpc.api.security.zmq.ZmqSecurable;
import com.enfernuz.quik.lua.rpc.api.structures.ResponseEnvelope;
import com.enfernuz.quik.lua.rpc.api.messages.GetCandlesByIndex;
import com.enfernuz.quik.lua.rpc.config.ClientConfiguration;
import com.enfernuz.quik.lua.rpc.io.transport.NetworkAddress;
import com.enfernuz.quik.lua.rpc.serde.SerdeModule;
import com.enfernuz.quik.lua.rpc.serde.SerdeUtils;
import org.jetbrains.annotations.Contract;
import org.zeromq.ZMQ;
import org.zeromq.ZMsg;

import static com.google.common.base.Preconditions.checkState;
import static java.util.Objects.requireNonNull;

/**
 * Реализация компонента <b>Java-обёртка над API QLua терминала QUIK на базе ZeroMQ</b>.
 */
public final class ZmqTcpQluaRpcClient extends AbstractTcpZmqClient implements TcpQluaRpcClient, ZmqSecurable {

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
     */
    public static ZmqTcpQluaRpcClient newInstance(final ClientConfiguration config) {

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
    public int qlua_AddColumn(final AddColumn.Request request) {
        return makeRPC(request, AddColumn.Result.class).getResult();
    }

    @Override
    public int qlua_AddLabel(final AddLabel.Request request) {
        return makeRPC(request, AddLabel.Result.class).getLabelId();
    }

    @Override
    public int qlua_AllocTable() {
        return makeRPC(AllocTable.Request.INSTANCE, AllocTable.Result.class).getTId();
    }

    @Override
    public CalcBuySell.Result qlua_CalcBuySell(final CalcBuySell.Request request) {
        return makeRPC(request, CalcBuySell.Result.class);
    }

    @Override
    public boolean qlua_CancelParamRequest(final CancelParamRequest.Request request) {
        return makeRPC(request, CancelParamRequest.Result.class).isResult();
    }

    @Override
    public boolean qlua_Clear(final Clear.Request request) {
        return makeRPC(request, Clear.Result.class).isResult();
    }

    @Override
    public int qlua_CreateWindow(final CreateWindow.Request request) {
        return makeRPC(request, CreateWindow.Result.class).getResult();
    }

    @Override
    public boolean qlua_DelAllLabels(final DelAllLabels.Request request) {
        return makeRPC(request, DelAllLabels.Result.class).isResult();
    }

    @Override
    public boolean qlua_DeleteRow(final DeleteRow.Request request) {
        return makeRPC(request, DeleteRow.Result.class).isResult();
    }

    @Override
    public boolean qlua_DelLabel(final DelLabel.Request request) {
        return makeRPC(request, DelLabel.Result.class).isResult();
    }

    @Override
    public DestroyTable.Result qlua_DestroyTable(final DestroyTable.Request request) {
        return makeRPC(request, DestroyTable.Result.class);
    }

    @Override
    public GetBuySellInfo.Result qlua_getBuySellInfo(final GetBuySellInfo.Request request) {
        return makeRPC(request, GetBuySellInfo.Result.class);
    }

    @Override
    public GetBuySellInfoEx.Result qlua_getBuySellInfoEx(final GetBuySellInfoEx.Request request) {
        return makeRPC(request, GetBuySellInfoEx.Result.class);
    }

    @Override
    public GetCandlesByIndex.Result qlua_getCandlesByIndex(final GetCandlesByIndex.Request request) {
        return makeRPC(request, GetCandlesByIndex.Result.class);
    }

    @Override
    public GetCell.Result qlua_GetCell(final GetCell.Result request) {
        return makeRPC(request, GetCell.Result.class);
    }

    @Override
    public GetClassesList.Result qlua_getClassesList() {
        return makeRPC(GetClassesList.Request.INSTANCE, GetClassesList.Result.class);
    }

    @Override
    public GetClassInfo.Result qlua_getClassInfo(final GetClassInfo.Request request) {
        return makeRPC(request, GetClassInfo.Result.class);
    }

    @Override
    public GetClassSecurities.Result qlua_getClassSecurities(final GetClassSecurities.Request request) {
        return makeRPC(request, GetClassSecurities.Result.class);
    }

    @Override
    public GetDepo.Result qlua_getDepo(final GetDepo.Request request) {
        return makeRPC(request, GetDepo.Result.class);
    }

    @Override
    public GetDepoEx.Result qlua_getDepoEx(final GetDepoEx.Request request) {
        return makeRPC(request, GetDepoEx.Result.class);
    }

    @Override
    public GetFuturesHolding.Result qlua_getFuturesHolding(final GetFuturesHolding.Request request) {
        return makeRPC(request, GetFuturesHolding.Result.class);
    }

    @Override
    public GetFuturesLimit.Result qlua_getFuturesLimit(final GetFuturesLimit.Request request) {
        return makeRPC(request, GetFuturesLimit.Result.class);
    }

    @Override
    public GetInfoParam.Result qlua_getInfoParam(final GetInfoParam.Request request) {
        return makeRPC(request, GetInfoParam.Result.class);
    }

    @Override
    public GetItem.Result qlua_getItem(final GetItem.Request request) {
        return makeRPC(request, GetItem.Result.class);
    }

    @Override
    public GetLabelParams.Result qlua_GetLabelParams(final GetLabelParams.Request request) {
        return makeRPC(request, GetLabelParams.Result.class);
    }

    @Override
    public GetLinesCount.Result qlua_getLinesCount(final GetLinesCount.Request request) {
        return makeRPC(request, GetLinesCount.Result.class);
    }

    @Override
    public GetMoney.Result qlua_getMoney(final GetMoney.Request request) {
        return makeRPC(request, GetMoney.Result.class);
    }

    @Override
    public GetMoneyEx.Result qlua_getMoneyEx(final GetMoneyEx.Request request) {
        return makeRPC(request, GetMoneyEx.Result.class);
    }

    @Override
    public GetNumberOf.Result qlua_getNumberOf(final GetNumberOf.Request request) {
        return makeRPC(request, GetNumberOf.Result.class);
    }

    @Override
    public GetNumCandles.Result qlua_getNumCandles(final GetNumCandles.Request request) {
        return makeRPC(request, GetNumCandles.Result.class);
    }

    @Override
    public GetOrderByNumber.Result qlua_getOrderByNumber(final GetOrderByNumber.Request request) {
        return makeRPC(request, GetOrderByNumber.Result.class);
    }

    @Override
    public GetParamEx.Result qlua_getParamEx(final GetParamEx.Request request) {
        return makeRPC(request, GetParamEx.Result.class);
    }

    @Override
    public GetParamEx2.Result qlua_getParamEx2(final GetParamEx2.Request request) {
        return makeRPC(request, GetParamEx2.Result.class);
    }

    @Override
    public GetPortfolioInfo.Result qlua_getPortfolioInfo(final GetPortfolioInfo.Request request) {
        return makeRPC(request, GetPortfolioInfo.Result.class);
    }

    @Override
    public GetPortfolioInfoEx.Result qlua_getPortfolioInfoEx(final GetPortfolioInfoEx.Request request) {
        return makeRPC(request, GetPortfolioInfoEx.Result.class);
    }

    @Override
    public GetQuoteLevel2.Result qlua_getQuoteLevel2(final GetQuoteLevel2.Request request) {
        return makeRPC(request, GetQuoteLevel2.Result.class);
    }

    @Override
    public GetScriptPath.Result qlua_getScriptPath() {
        return makeRPC(GetScriptPath.Request.INSTANCE, GetScriptPath.Result.class);
    }

    @Override
    public GetSecurityInfo.Result qlua_getSecurityInfo(final GetSecurityInfo.Request request) {
        return makeRPC(request, GetSecurityInfo.Result.class);
    }

    @Override
    public GetTableSize.Result qlua_GetTableSize(final GetTableSize.Request request) {
        return makeRPC(request, GetTableSize.Result.class);
    }

    @Override
    public GetTradeDate.Result qlua_getTradeDate() {
        return makeRPC(GetTradeDate.Request.INSTANCE, GetTradeDate.Result.class);
    }

    @Override
    public GetWindowCaption.Result qlua_GetWindowCaption(final GetWindowCaption.Request request) {
        return makeRPC(request, GetWindowCaption.Result.class);
    }

    @Override
    public GetWindowRect.Result qlua_GetWindowRect(final GetWindowRect.Request request) {
        return makeRPC(request, GetWindowRect.Result.class);
    }

    @Override
    public GetWorkingFolder.Result qlua_getWorkingFolder() {
        return makeRPC(GetWorkingFolder.Request.INSTANCE, GetWorkingFolder.Result.class);
    }

    @Override
    public Highlight.Result qlua_Highlight(final Highlight.Request request) {
        return makeRPC(request, Highlight.Result.class);
    }

    @Override
    public InsertRow.Result qlua_InsertRow(final InsertRow.Request request) {
        return makeRPC(request, InsertRow.Result.class);
    }

    @Override
    public IsConnected.Result qlua_isConnected() {
        return makeRPC(IsConnected.Request.INSTANCE, IsConnected.Result.class);
    }

    @Override
    public IsSubscribedLevel2Quotes.Result qlua_IsSubscribedLevelIIQuotes(final IsSubscribedLevel2Quotes.Request request) {
        return makeRPC(request, IsSubscribedLevel2Quotes.Result.class);
    }

    @Override
    public IsWindowClosed.Result qlua_IsWindowClosed(final IsWindowClosed.Request request) {
        return makeRPC(request, IsWindowClosed.Result.class);
    }

    @Override
    public Message.Result qlua_message(final Message.Request request) {
        return makeRPC(request, Message.Result.class);
    }

    @Override
    public ParamRequest.Result qlua_ParamRequest(final ParamRequest.Request request) {
        return makeRPC(request, ParamRequest.Result.class);
    }

    @Override
    public PrintDbgStr.Result qlua_PrintDbgStr(final PrintDbgStr.Request request) {
        return makeRPC(request, PrintDbgStr.Result.class);
    }

    @Override
    public RGB.Result qlua_RGB(final RGB.Request request) {
        return makeRPC(request, RGB.Result.class);
    }

    @Override
    public SearchItems.Result qlua_SearchItems(final SearchItems.Request request) {
        return makeRPC(request, SearchItems.Result.class);
    }

    @Override
    public SendTransaction.Result qlua_sendTransaction(final SendTransaction.Request request) {
        return makeRPC(request, SendTransaction.Result.class);
    }

    @Override
    public SetCell.Result qlua_SetCell(final SetCell.Request request) {
        return makeRPC(request, SetCell.Result.class);
    }

    @Override
    public SetColor.Result qlua_SetColor(final SetColor.Request request) {
        return makeRPC(request, SetColor.Result.class);
    }

    @Override
    public SetLabelParams.Result qlua_SetLabelParams(final SetLabelParams.Request request) {
        return makeRPC(request, SetLabelParams.Result.class);
    }

    @Override
    public SetSelectedRow.Result qlua_SetSelectedRow(final SetSelectedRow.Request request) {
        return makeRPC(request, SetSelectedRow.Result.class);
    }

    @Override
    public SetTableNotificationCallback.Result qlua_SetTableNotificationCallback(final SetTableNotificationCallback.Request request) {
        return makeRPC(request, SetTableNotificationCallback.Result.class);
    }

    @Override
    public SetWindowCaption.Result qlua_SetWindowCaption(final SetWindowCaption.Request request) {
        return makeRPC(request, SetWindowCaption.Result.class);
    }

    @Override
    public SetWindowPos.Result qlua_SetWindowPos(final SetWindowPos.Request request) {
        return makeRPC(request, SetWindowPos.Result.class);
    }

    @Override
    public Sleep.Result qlua_sleep(final Sleep.Request request) {
        return makeRPC(request, Sleep.Result.class);
    }

    @Override
    public SubscribeLevel2Quotes.Result qlua_SubscribeLevelIIQuotes(final SubscribeLevel2Quotes.Request request) {
        return makeRPC(request, SubscribeLevel2Quotes.Result.class);
    }

    @Override
    public UnsubscribeLevel2Quotes.Result qlua_UnsubscribeLevelIIQuotes(final UnsubscribeLevel2Quotes.Request request) {
        return makeRPC(request, UnsubscribeLevel2Quotes.Result.class);
    }

    @Override
    public BAnd.Result bit_band(final BAnd.Request request) {
        return makeRPC(request, BAnd.Result.class);
    }

    @Override
    public BNot.Result bit_bnot(final BNot.Request request) {
        return makeRPC(request, BNot.Result.class);
    }

    @Override
    public BOr.Result bit_bor(final BOr.Request request) {
        return makeRPC(request, BOr.Result.class);
    }

    @Override
    public BXor.Result bit_bxor(final BXor.Request request) {
        return makeRPC(request, BXor.Result.class);
    }

    @Override
    public ToHex.Result bit_tohex(final ToHex.Request request) {
        return makeRPC(request, ToHex.Result.class);
    }

    @Override
    public C.Result datasource_C(final C.Request request) {
        return makeRPC(request, C.Result.class);
    }

    @Override
    public Close.Result datasource_Close(final Close.Request request) {
        return makeRPC(request, Close.Result.class);
    }

    @Override
    public CreateDataSource.Result datasource_CreateDataSource(final CreateDataSource.Request request) {
        return makeRPC(request, CreateDataSource.Result.class);
    }

    @Override
    public H.Result datasource_H(final H.Request request) {
        return makeRPC(request, H.Result.class);
    }

    @Override
    public L.Result datasource_L(final L.Request request) {
        return makeRPC(request, L.Result.class);
    }

    @Override
    public O.Result datasource_O(final O.Request request) {
        return makeRPC(request, O.Result.class);
    }

    @Override
    public SetEmptyCallback.Result datasource_SetEmptyCallback(final SetEmptyCallback.Request request) {
        return makeRPC(request, SetEmptyCallback.Result.class);
    }

    @Override
    public SetUpdateCallback.Result datasource_SetUpdateCallback(final SetUpdateCallback.Request request) {
        return makeRPC(request, SetUpdateCallback.Result.class);
    }

    @Override
    public Size.Result datasource_Size(final Size.Request request) {
        return makeRPC(request, Size.Result.class);
    }

    @Override
    public T.Result datasource_T(final T.Request request) {
        return makeRPC(request, T.Result.class);
    }

    @Override
    public V.Result datasource_V(final V.Request request) {
        return makeRPC(request, V.Result.class);
    }

    private <T, U> U makeRPC(final T request, final Class<U> resultClass) {

        try {

            checkState(isOpened(), "Соединение должно быть открыто.");

            final ZMsg zRequest = new ZMsg();
            zRequest.add( serdeModule.serialize(request) );
            zRequest.send(reqSocket);
            zRequest.destroy();

            final ZMsg zResponse = ZMsg.recvMsg(reqSocket);
            final byte[] response = ZmqUtils.convertZMsgToByteArray(zResponse);
            zResponse.destroy();

            final ResponseEnvelope responseEnvelope = serdeModule.deserialize(ResponseEnvelope.class, response);
            final ServiceError error = responseEnvelope.getError();
            if (error == null) {
                return serdeModule.deserialize(resultClass, responseEnvelope.getResult());
            } else {
                throw new ServiceRpcException(error);
            }
        } catch (final ServiceRpcException ex) {
            throw ex;
        } catch (final Exception ex) {
            throw new ClientRpcException(ex);
        }
    }
}
