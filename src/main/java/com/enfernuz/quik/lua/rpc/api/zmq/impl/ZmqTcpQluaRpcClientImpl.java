package com.enfernuz.quik.lua.rpc.api.zmq.impl;

import com.enfernuz.quik.lua.rpc.api.security.zmq.AuthContext;
import com.enfernuz.quik.lua.rpc.api.security.zmq.CurveCredentials;
import com.enfernuz.quik.lua.rpc.api.security.zmq.CurveKeyPair;
import com.enfernuz.quik.lua.rpc.api.security.zmq.PlainCredentials;
import com.enfernuz.quik.lua.rpc.api.structures.*;
import com.enfernuz.quik.lua.rpc.api.zmq.ZmqTcpQluaRpcClient;
import com.enfernuz.quik.lua.rpc.api.structures.GetCandlesByIndex;
import com.enfernuz.quik.lua.rpc.io.transport.NetworkAddress;
import com.enfernuz.quik.lua.rpc.serde.SerdeModule;
import com.google.protobuf.ByteString;
import org.zeromq.ZFrame;
import org.zeromq.ZMQ;
import org.zeromq.ZMsg;
import qlua.rpc.RPC;
import qlua.rpc.bit.*;
import qlua.rpc.datasource.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import static com.google.common.base.Preconditions.checkState;
import static java.util.Objects.requireNonNull;

/**
 * Реализация компонента <b>Java-обёртка над API QLua терминала QUIK на базе ZeroMQ</b>.
 */
public class ZmqTcpQluaRpcClientImpl implements ZmqTcpQluaRpcClient {

    private final NetworkAddress networkAddress;
    private final String uri;
    private ZMQ.Context zmqContext;
    private ZMQ.Socket reqSocket;
    private final AuthContext authContext;
    private boolean isOpened;

    private final SerdeModule serdeModule;

    /**
     * Создаёт новый экземпляр компонента {@link ZmqTcpQluaRpcClientImpl}, с точкой подключения RPC-сервиса на стороне
     * терминала QUIK по заданному сетевому адресу с заданным контекстом защиты передачи данных.
     *
     * @param networkAddress  сетевой адрес точки подключения RPC-сервиса на стороне терминала QUIK
     * @param authContext  контекст защиты передачи данных
     * @return новый экземпляр компонента {@link ZmqTcpQluaRpcClientImpl}
     */
    public static ZmqTcpQluaRpcClientImpl newInstance(
            final NetworkAddress networkAddress,
            final AuthContext authContext,
            final SerdeModule serdeModule) {

        return new ZmqTcpQluaRpcClientImpl(
                requireNonNull(networkAddress, "Аргумент 'networkAddress' не должен быть null."),
                requireNonNull(authContext, "Аргумент 'authContext' не должен быть null."),
                requireNonNull(serdeModule, "Аргумент 'serdeModule' не должен быть null.")
        );
    }

    private ZmqTcpQluaRpcClientImpl(
            final NetworkAddress networkAddress,
            final AuthContext authContext,
            final SerdeModule serdeModule) {

        this.networkAddress = networkAddress;
        this.authContext = authContext;
        this.serdeModule = serdeModule;
        this.uri = String.format("tcp://%s:%d", networkAddress.getHost(), networkAddress.getPort());
    }

    @Override
    public NetworkAddress getNetworkAddress() {
        return networkAddress
    }

    @Override
    public AuthContext getAuthContext() {
        return authContext
    }

    @Override
    public void open() throws IOException {

        if (!isOpened) {

            zmqContext = ZMQ.context(1);

            reqSocket = zmqContext.socket(ZMQ.REQ);
            reqSocket.setLinger(0); // no waiting before closing the socket

            switch (authContext.getAuthMechanism()) {
                case PLAIN:
                    final PlainCredentials plainCredentials = authContext.getPlainCredentials();
                    reqSocket.setPlainUsername( plainCredentials.getUsername() );
                    reqSocket.setPlainPassword( plainCredentials.getPassword() );
                    break;
                case CURVE:
                    final CurveCredentials curveCredentials = authContext.getCurveCredentials();
                    final CurveKeyPair clientKeyPair = curveCredentials.getClientKeyPair();
                    reqSocket.setCurveServerKey( curveCredentials.getServerPublicKey().asBinary() );
                    reqSocket.setCurvePublicKey( clientKeyPair.getPublicKey().asBinary() );
                    reqSocket.setCurveSecretKey( clientKeyPair.getSecretKey().asBinary() );
                    break;
                case NULL:
                    break;
                default:
                    throw new IllegalStateException(
                            String.format(
                                    "Unsupported authentication mechanism: \"s\".",
                                    authContext.getAuthMechanism()
                            )
                    );
            }

            final boolean _isConnected  = this.reqSocket.connect(uri);
            if (_isConnected) {
                isOpened = true;
            } else {

                final String errorMessage =
                        String.format("Couldn't connect to '%s'. ZMQ socket errno:", uri, reqSocket.errno());

                reqSocket.close();
                zmqContext.term();
                zmqContext = null;
                reqSocket = null;

                throw new IOException(errorMessage);
            }
        }
    }

    @Override
    public boolean isOpened() {
        return isOpened;
    }

    @Override
    public void close() throws IOException {

        if (isOpened) {

            final boolean isDisconnected = reqSocket.disconnect(uri);

            if (isDisconnected) {
                reqSocket.close();
                zmqContext.term();
                zmqContext = null;
                reqSocket = null;

                isOpened = false;
            } else {
                throw new IOException(
                        String.format(
                                "Couldn't disconnect from '%s'. ZMQ socket errno: %d",
                                uri,
                                reqSocket.errno()
                        )
                );
            }
        }
    }

    @Override
    public AddColumn.Result qlua_AddColumn(final AddColumn.Request request) {
        return makeRPC(request, AddColumn.Result.class);
    }

    @Override
    public AddLabel.Result qlua_AddLabel(final AddLabel.Request request) {
        return makeRPC(request, AddLabel.Result.class);
    }

    @Override
    public AllocTable.Result qlua_AllocTable() {
        return makeRPC(AllocTable.Request.INSTANCE, AllocTable.Result.class);
    }

    @Override
    public CalcBuySell.Result qlua_CalcBuySell(final CalcBuySell.Request request) {
        return makeRPC(request, CalcBuySell.Result.class);
    }

    @Override
    public CancelParamRequest.Result qlua_CancelParamRequest(final CancelParamRequest.Request request) {
        return makeRPC(request, CancelParamRequest.Result.class);
    }

    @Override
    public Clear.Result qlua_Clear(final Clear.Request request) {
        return makeRPC(request, Clear.Result.class);
    }

    @Override
    public CreateWindow.Result qlua_CreateWindow(final CreateWindow.Request request) {
        return makeRPC(request, CreateWindow.Result.class);
    }

    @Override
    public DelAllLabels.Result qlua_DelAllLabels(final DelAllLabels.Request request) {
        return makeRPC(request, DelAllLabels.Result.class);
    }

    @Override
    public DeleteRow.Result qlua_DeleteRow(final DeleteRow.Request request) {
        return makeRPC(request, DeleteRow.Result.class);
    }

    @Override
    public DelLabel.Result qlua_DelLabel(final DelLabel.Request request) {
        return makeRPC(request, DelLabel.Result.class);
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
    public GetCell.Result qlua_GetCell(final GetCell.Result args) {

        try {
            final ByteString resultAsByteString = makeRPC(RPC.ProcedureType.GET_CELL, args);
            return GetCell.Result.parseFrom(resultAsByteString);
        } catch (final RpcClientException ex) {
            throw ex;
        } catch (final Exception ex) {
            throw new RpcClientException(ex);
        }
    }

    @Override
    public GetClassesList.Result qlua_getClassesList() {

        try {
            final ByteString resultAsByteString = makeRPC(RPC.ProcedureType.GET_CLASSES_LIST);
            return GetClassesList.Result.parseFrom(resultAsByteString);
        } catch (final RpcClientException ex) {
            throw ex;
        } catch (final Exception ex) {
            throw new RpcClientException(ex);
        }
    }

    @Override
    public GetClassInfo.Result qlua_getClassInfo(final GetClassInfo.Request args) {

        try {
            final ByteString resultAsByteString = makeRPC(RPC.ProcedureType.GET_CLASS_INFO, args);
            return GetClassInfo.Result.parseFrom(resultAsByteString);
        } catch (final RpcClientException ex) {
            throw ex;
        } catch (final Exception ex) {
            throw new RpcClientException(ex);
        }
    }

    @Override
    public GetClassSecurities.Result qlua_getClassSecurities(final GetClassSecurities.Request args) {

        try {
            final ByteString resultAsByteString = makeRPC(RPC.ProcedureType.GET_CLASS_SECURITIES, args);
            return GetClassSecurities.Result.parseFrom(resultAsByteString);
        } catch (final RpcClientException ex) {
            throw ex;
        } catch (final Exception ex) {
            throw new RpcClientException(ex);
        }
    }

    @Override
    public GetDepo.Result qlua_getDepo(final GetDepo.Request args) {

        try {
            final ByteString resultAsByteString = makeRPC(RPC.ProcedureType.GET_DEPO, args);
            return GetDepo.Result.parseFrom(resultAsByteString);
        } catch (final RpcClientException ex) {
            throw ex;
        } catch (final Exception ex) {
            throw new RpcClientException(ex);
        }
    }

    @Override
    public GetDepoEx.Result qlua_getDepoEx(final GetDepoEx.Request args) {

        try {
            final ByteString resultAsByteString = makeRPC(RPC.ProcedureType.GET_DEPO_EX, args);
            return GetDepoEx.Result.parseFrom(resultAsByteString);
        } catch (final RpcClientException ex) {
            throw ex;
        } catch (final Exception ex) {
            throw new RpcClientException(ex);
        }
    }

    @Override
    public GetFuturesHolding.Result qlua_getFuturesHolding(final GetFuturesHolding.Request args) {

        try {
            final ByteString resultAsByteString = makeRPC(RPC.ProcedureType.GET_FUTURES_HOLDING, args);
            return GetFuturesHolding.Result.parseFrom(resultAsByteString);
        } catch (final RpcClientException ex) {
            throw ex;
        } catch (final Exception ex) {
            throw new RpcClientException(ex);
        }
    }

    @Override
    public GetFuturesLimit.Result qlua_getFuturesLimit(final GetFuturesLimit.Request args) {

        try {
            final ByteString resultAsByteString = makeRPC(RPC.ProcedureType.GET_FUTURES_LIMIT, args);
            return GetFuturesLimit.Result.parseFrom(resultAsByteString);
        } catch (final RpcClientException ex) {
            throw ex;
        } catch (final Exception ex) {
            throw new RpcClientException(ex);
        }
    }

    @Override
    public GetInfoParam.Result qlua_getInfoParam(final GetInfoParam.Request args) {

        try {
            final ByteString resultAsByteString = makeRPC(RPC.ProcedureType.GET_INFO_PARAM, args);
            return GetInfoParam.Result.parseFrom(resultAsByteString);
        } catch (final RpcClientException ex) {
            throw ex;
        } catch (final Exception ex) {
            throw new RpcClientException(ex);
        }
    }

    @Override
    public GetItem.Result qlua_getItem(final GetItem.Request args) {

        try {
            final ByteString resultAsByteString = makeRPC(RPC.ProcedureType.GET_ITEM, args);
            return GetItem.Result.parseFrom(resultAsByteString);
        } catch (final RpcClientException ex) {
            throw ex;
        } catch (final Exception ex) {
            throw new RpcClientException(ex);
        }
    }

    @Override
    public GetLabelParams.Result qlua_GetLabelParams(final GetLabelParams.Request args) {

        try {
            final ByteString resultAsByteString = makeRPC(RPC.ProcedureType.GET_LABEL_PARAMS, args);
            return GetLabelParams.Result.parseFrom(resultAsByteString);
        } catch (final RpcClientException ex) {
            throw ex;
        } catch (final Exception ex) {
            throw new RpcClientException(ex);
        }
    }

    @Override
    public GetLinesCount.Result qlua_getLinesCount(final GetLinesCount.Request args) {

        try {
            final ByteString resultAsByteString = makeRPC(RPC.ProcedureType.GET_LINES_COUNT, args);
            return GetLinesCount.Result.parseFrom(resultAsByteString);
        } catch (final RpcClientException ex) {
            throw ex;
        } catch (final Exception ex) {
            throw new RpcClientException(ex);
        }
    }

    @Override
    public GetMoney.Result qlua_getMoney(final GetMoney.Request args) {

        try {
            final ByteString resultAsByteString = makeRPC(RPC.ProcedureType.GET_MONEY, args);
            return GetMoney.Result.parseFrom(resultAsByteString);
        } catch (final RpcClientException ex) {
            throw ex;
        } catch (final Exception ex) {
            throw new RpcClientException(ex);
        }
    }

    @Override
    public GetMoneyEx.Result qlua_getMoneyEx(final GetMoneyEx.Request args) {

        try {
            final ByteString resultAsByteString = makeRPC(RPC.ProcedureType.GET_MONEY_EX, args);
            return GetMoneyEx.Result.parseFrom(resultAsByteString);
        } catch (final RpcClientException ex) {
            throw ex;
        } catch (final Exception ex) {
            throw new RpcClientException(ex);
        }
    }

    @Override
    public GetNumberOf.Result qlua_getNumberOf(final GetNumberOf.Request args) {

        try {
            final ByteString resultAsByteString = makeRPC(RPC.ProcedureType.GET_NUMBER_OF, args);
            return GetNumberOf.Result.parseFrom(resultAsByteString);
        } catch (final RpcClientException ex) {
            throw ex;
        } catch (final Exception ex) {
            throw new RpcClientException(ex);
        }
    }

    @Override
    public GetNumCandles.Result qlua_getNumCandles(final GetNumCandles.Request args) {

        try {
            final ByteString resultAsByteString = makeRPC(RPC.ProcedureType.GET_NUM_CANDLES, args);
            return GetNumCandles.Result.parseFrom(resultAsByteString);
        } catch (final RpcClientException ex) {
            throw ex;
        } catch (final Exception ex) {
            throw new RpcClientException(ex);
        }
    }

    @Override
    public GetOrderByNumber.Result qlua_getOrderByNumber(final GetOrderByNumber.Request args) {

        try {
            final ByteString resultAsByteString = makeRPC(RPC.ProcedureType.GET_ORDER_BY_NUMBER, args);
            return GetOrderByNumber.Result.parseFrom(resultAsByteString);
        } catch (final RpcClientException ex) {
            throw ex;
        } catch (final Exception ex) {
            throw new RpcClientException(ex);
        }
    }

    @Override
    public GetParamEx.Result qlua_getParamEx(final GetParamEx.Request args) {

        try {
            final ByteString resultAsByteString = makeRPC(RPC.ProcedureType.GET_PARAM_EX, args);
            return GetParamEx.Result.parseFrom(resultAsByteString);
        } catch (final RpcClientException ex) {
            throw ex;
        } catch (final Exception ex) {
            throw new RpcClientException(ex);
        }
    }

    @Override
    public GetParamEx2.Result qlua_getParamEx2(final GetParamEx2.Request args) {

        try {
            final ByteString resultAsByteString = makeRPC(RPC.ProcedureType.GET_PARAM_EX_2, args);
            return GetParamEx2.Result.parseFrom(resultAsByteString);
        } catch (final RpcClientException ex) {
            throw ex;
        } catch (final Exception ex) {
            throw new RpcClientException(ex);
        }
    }

    @Override
    public GetPortfolioInfo.Result qlua_getPortfolioInfo(final GetPortfolioInfo.Request args) {

        try {
            final ByteString resultAsByteString = makeRPC(RPC.ProcedureType.GET_PORTFOLIO_INFO, args);
            return GetPortfolioInfo.Result.parseFrom(resultAsByteString);
        } catch (final RpcClientException ex) {
            throw ex;
        } catch (final Exception ex) {
            throw new RpcClientException(ex);
        }
    }

    @Override
    public GetPortfolioInfoEx.Result qlua_getPortfolioInfoEx(final GetPortfolioInfoEx.Request args) {

        try {
            final ByteString resultAsByteString = makeRPC(RPC.ProcedureType.GET_PORTFOLIO_INFO_EX, args);
            return GetPortfolioInfoEx.Result.parseFrom(resultAsByteString);
        } catch (final RpcClientException ex) {
            throw ex;
        } catch (final Exception ex) {
            throw new RpcClientException(ex);
        }
    }

    @Override
    public GetQuoteLevel2.Result qlua_getQuoteLevel2(final GetQuoteLevel2.Request args) {

        try {
            final ByteString resultAsByteString = makeRPC(RPC.ProcedureType.GET_QUOTE_LEVEL2, args);
            return GetQuoteLevel2.Result.parseFrom(resultAsByteString);
        } catch (final RpcClientException ex) {
            throw ex;
        } catch (final Exception ex) {
            throw new RpcClientException(ex);
        }
    }

    @Override
    public GetScriptPath.Result qlua_getScriptPath() {

        try {
            final ByteString resultAsByteString = makeRPC(RPC.ProcedureType.GET_SCRIPT_PATH);
            return GetScriptPath.Result.parseFrom(resultAsByteString);
        } catch (final RpcClientException ex) {
            throw ex;
        } catch (final Exception ex) {
            throw new RpcClientException(ex);
        }
    }

    @Override
    public GetSecurityInfo.Result qlua_getSecurityInfo(final GetSecurityInfo.Request args) {

        try {
            final ByteString resultAsByteString = makeRPC(RPC.ProcedureType.GET_SECURITY_INFO, args);
            return GetSecurityInfo.Result.parseFrom(resultAsByteString);
        } catch (final RpcClientException ex) {
            throw ex;
        } catch (final Exception ex) {
            throw new RpcClientException(ex);
        }
    }

    @Override
    public GetTableSize.Result qlua_GetTableSize(final GetTableSize.Request args) {

        try {
            final ByteString resultAsByteString = makeRPC(RPC.ProcedureType.GET_TABLE_SIZE, args);
            return GetTableSize.Result.parseFrom(resultAsByteString);
        } catch (final RpcClientException ex) {
            throw ex;
        } catch (final Exception ex) {
            throw new RpcClientException(ex);
        }
    }

    @Override
    public GetTradeDate.Result qlua_getTradeDate() {

        try {
            final ByteString resultAsByteString = makeRPC(RPC.ProcedureType.GET_TRADE_DATE);
            return GetTradeDate.Result.parseFrom(resultAsByteString);
        } catch (final RpcClientException ex) {
            throw ex;
        } catch (final Exception ex) {
            throw new RpcClientException(ex);
        }
    }

    @Override
    public GetWindowCaption.Result qlua_GetWindowCaption(final GetWindowCaption.Request args) {

        try {
            final ByteString resultAsByteString = makeRPC(RPC.ProcedureType.GET_WINDOW_CAPTION, args);
            return GetWindowCaption.Result.parseFrom(resultAsByteString);
        } catch (final RpcClientException ex) {
            throw ex;
        } catch (final Exception ex) {
            throw new RpcClientException(ex);
        }
    }

    @Override
    public GetWindowRect.Result qlua_GetWindowRect(final GetWindowRect.Request args) {

        try {
            final ByteString resultAsByteString = makeRPC(RPC.ProcedureType.GET_WINDOW_RECT, args);
            return GetWindowRect.Result.parseFrom(resultAsByteString);
        } catch (final RpcClientException ex) {
            throw ex;
        } catch (final Exception ex) {
            throw new RpcClientException(ex);
        }
    }

    @Override
    public GetWorkingFolder.Result qlua_getWorkingFolder() {

        try {
            final ByteString resultAsByteString = makeRPC(RPC.ProcedureType.GET_WORKING_FOLDER);
            return GetWorkingFolder.Result.parseFrom(resultAsByteString);
        } catch (final RpcClientException ex) {
            throw ex;
        } catch (final Exception ex) {
            throw new RpcClientException(ex);
        }
    }

    @Override
    public Highlight.Result qlua_Highlight(final Highlight.Request args) {

        try {
            final ByteString resultAsByteString = makeRPC(RPC.ProcedureType.HIGHLIGHT, args);
            return Highlight.Result.parseFrom(resultAsByteString);
        } catch (final RpcClientException ex) {
            throw ex;
        } catch (final Exception ex) {
            throw new RpcClientException(ex);
        }
    }

    @Override
    public InsertRow.Result qlua_InsertRow(final InsertRow.Request args) {

        try {
            final ByteString resultAsByteString = makeRPC(RPC.ProcedureType.INSERT_ROW, args);
            return InsertRow.Result.parseFrom(resultAsByteString);
        } catch (final RpcClientException ex) {
            throw ex;
        } catch (final Exception ex) {
            throw new RpcClientException(ex);
        }
    }

    @Override
    public IsConnected.Result qlua_isConnected() {

        try {
            final ByteString resultAsByteString = makeRPC(RPC.ProcedureType.IS_CONNECTED);
            return IsConnected.Result.parseFrom(resultAsByteString);
        } catch (final RpcClientException ex) {
            throw ex;
        } catch (final Exception ex) {
            throw new RpcClientException(ex);
        }
    }

    @Override
    public IsSubscribedLevelIIQuotes.Result qlua_IsSubscribedLevelIIQuotes(
            final IsSubscribedLevelIIQuotes.Request args) {

        try {
            final ByteString resultAsByteString = makeRPC(RPC.ProcedureType.IS_SUBSCRIBED_LEVEL_II_QUOTES, args);
            return IsSubscribedLevelIIQuotes.Result.parseFrom(resultAsByteString);
        } catch (final RpcClientException ex) {
            throw ex;
        } catch (final Exception ex) {
            throw new RpcClientException(ex);
        }
    }

    @Override
    public IsWindowClosed.Result qlua_IsWindowClosed(final IsWindowClosed.Request args) {

        try {
            final ByteString resultAsByteString = makeRPC(RPC.ProcedureType.IS_WINDOW_CLOSED, args);
            return IsWindowClosed.Result.parseFrom(resultAsByteString);
        } catch (final RpcClientException ex) {
            throw ex;
        } catch (final Exception ex) {
            throw new RpcClientException(ex);
        }
    }

    @Override
    public Message.Result qlua_message(final Message.Request request) {
        return makeRPC(request, Message.Result.class);
    }

    @Override
    public ParamRequest.Result qlua_ParamRequest(final ParamRequest.Request args) {

        try {
            final ByteString resultAsByteString = makeRPC(RPC.ProcedureType.PARAM_REQUEST, args);
            return ParamRequest.Result.parseFrom(resultAsByteString);
        } catch (final RpcClientException ex) {
            throw ex;
        } catch (final Exception ex) {
            throw new RpcClientException(ex);
        }
    }

    @Override
    public void qlua_PrintDbgStr(final PrintDbgStr.Request args) {

        try {
            makeRPC(RPC.ProcedureType.PRINT_DBG_STR, args);
        } catch (final RpcClientException ex) {
            throw ex;
        } catch (final Exception ex) {
            throw new RpcClientException(ex);
        }
    }

    @Override
    public RGB.Result qlua_RGB(final RGB.Request args) {

        try {
            final ByteString resultAsByteString = makeRPC(RPC.ProcedureType.RGB, args);
            return RGB.Result.parseFrom(resultAsByteString);
        } catch (final RpcClientException ex) {
            throw ex;
        } catch (final Exception ex) {
            throw new RpcClientException(ex);
        }
    }

    @Override
    public SearchItems.Result qlua_SearchItems(final SearchItems.Request args) {

        try {
            final ByteString resultAsByteString = makeRPC(RPC.ProcedureType.SEARCH_ITEMS, args);
            return SearchItems.Result.parseFrom(resultAsByteString);
        } catch (final RpcClientException ex) {
            throw ex;
        } catch (final Exception ex) {
            throw new RpcClientException(ex);
        }
    }

    @Override
    public SendTransaction.Result qlua_sendTransaction(final SendTransaction.Request args) {

        try {
            final ByteString resultAsByteString = makeRPC(RPC.ProcedureType.SEND_TRANSACTION, args);
            return SendTransaction.Result.parseFrom(resultAsByteString);
        } catch (final RpcClientException ex) {
            throw ex;
        } catch (final Exception ex) {
            throw new RpcClientException(ex);
        }
    }

    @Override
    public SetCell.Result qlua_SetCell(final SetCell.Request args) {

        try {
            final ByteString resultAsByteString = makeRPC(RPC.ProcedureType.SET_CELL, args);
            return SetCell.Result.parseFrom(resultAsByteString);
        } catch (final RpcClientException ex) {
            throw ex;
        } catch (final Exception ex) {
            throw new RpcClientException(ex);
        }
    }

    @Override
    public SetColor.Result qlua_SetColor(final SetColor.Request args) {

        try {
            final ByteString resultAsByteString = makeRPC(RPC.ProcedureType.SET_COLOR, args);
            return SetColor.Result.parseFrom(resultAsByteString);
        } catch (final RpcClientException ex) {
            throw ex;
        } catch (final Exception ex) {
            throw new RpcClientException(ex);
        }
    }

    @Override
    public SetLabelParams.Result qlua_SetLabelParams(final SetLabelParams.Request args) {

        try {
            final ByteString resultAsByteString = makeRPC(RPC.ProcedureType.SET_LABEL_PARAMS, args);
            return SetLabelParams.Result.parseFrom(resultAsByteString);
        } catch (final RpcClientException ex) {
            throw ex;
        } catch (final Exception ex) {
            throw new RpcClientException(ex);
        }
    }

    @Override
    public SetSelectedRow.Result qlua_SetSelectedRow(final SetSelectedRow.Request args) {

        try {
            final ByteString resultAsByteString = makeRPC(RPC.ProcedureType.SET_SELECTED_ROW, args);
            return SetSelectedRow.Result.parseFrom(resultAsByteString);
        } catch (final RpcClientException ex) {
            throw ex;
        } catch (final Exception ex) {
            throw new RpcClientException(ex);
        }
    }

    @Override
    public SetTableNotificationCallback.Result qlua_SetTableNotificationCallback(
            final SetTableNotificationCallback.Request args) {

        try {
            final ByteString resultAsByteString = makeRPC(RPC.ProcedureType.SET_TABLE_NOTIFICATION_CALLBACK, args);
            return SetTableNotificationCallback.Result.parseFrom(resultAsByteString);
        } catch (final RpcClientException ex) {
            throw ex;
        } catch (final Exception ex) {
            throw new RpcClientException(ex);
        }
    }

    @Override
    public SetWindowCaption.Result qlua_SetWindowCaption(final SetWindowCaption.Request args) {

        try {
            final ByteString resultAsByteString = makeRPC(RPC.ProcedureType.SET_WINDOW_CAPTION, args);
            return SetWindowCaption.Result.parseFrom(resultAsByteString);
        } catch (final RpcClientException ex) {
            throw ex;
        } catch (final Exception ex) {
            throw new RpcClientException(ex);
        }
    }

    @Override
    public SetWindowPos.Result qlua_SetWindowPos(final SetWindowPos.Request args) {

        try {
            final ByteString resultAsByteString = makeRPC(RPC.ProcedureType.SET_WINDOW_POS, args);
            return SetWindowPos.Result.parseFrom(resultAsByteString);
        } catch (final RpcClientException ex) {
            throw ex;
        } catch (final Exception ex) {
            throw new RpcClientException(ex);
        }
    }

    @Override
    public Sleep.Result qlua_sleep(final Sleep.Request args) {

        try {
            final ByteString resultAsByteString = makeRPC(RPC.ProcedureType.SLEEP, args);
            return Sleep.Result.parseFrom(resultAsByteString);
        } catch (final RpcClientException ex) {
            throw ex;
        } catch (final Exception ex) {
            throw new RpcClientException(ex);
        }
    }

    @Override
    public SubscribeLevelIIQuotes.Result qlua_SubscribeLevelIIQuotes(final SubscribeLevelIIQuotes.Request args) {

        try {
            final ByteString resultAsByteString = makeRPC(RPC.ProcedureType.SUBSCRIBE_LEVEL_II_QUOTES, args);
            return SubscribeLevelIIQuotes.Result.parseFrom(resultAsByteString);
        } catch (final RpcClientException ex) {
            throw ex;
        } catch (final Exception ex) {
            throw new RpcClientException(ex);
        }
    }

    @Override
    public UnsubscribeLevelIIQuotes.Result qlua_UnsubscribeLevelIIQuotes(final UnsubscribeLevelIIQuotes.Request args) {

        try {
            final ByteString resultAsByteString = makeRPC(RPC.ProcedureType.UNSUBSCRIBE_LEVEL_II_QUOTES, args);
            return UnsubscribeLevelIIQuotes.Result.parseFrom(resultAsByteString);
        } catch (final RpcClientException ex) {
            throw ex;
        } catch (final Exception ex) {
            throw new RpcClientException(ex);
        }
    }

    @Override
    public Band.Result bit_band(final Band.Request args) {

        try {
            final ByteString resultAsByteString = makeRPC(RPC.ProcedureType.BIT_BAND, args);
            return Band.Result.parseFrom(resultAsByteString);
        } catch (final RpcClientException ex) {
            throw ex;
        } catch (final Exception ex) {
            throw new RpcClientException(ex);
        }
    }

    @Override
    public Bnot.Result bit_bnot(final Bnot.Request args) {

        try {
            final ByteString resultAsByteString = makeRPC(RPC.ProcedureType.BIT_BNOT, args);
            return Bnot.Result.parseFrom(resultAsByteString);
        } catch (final RpcClientException ex) {
            throw ex;
        } catch (final Exception ex) {
            throw new RpcClientException(ex);
        }
    }

    @Override
    public Bor.Result bit_bor(final Bor.Request args) {

        try {
            final ByteString resultAsByteString = makeRPC(RPC.ProcedureType.BIT_BOR, args);
            return Bor.Result.parseFrom(resultAsByteString);
        } catch (final RpcClientException ex) {
            throw ex;
        } catch (final Exception ex) {
            throw new RpcClientException(ex);
        }
    }

    @Override
    public Bxor.Result bit_bxor(final Bxor.Request args) {

        try {
            final ByteString resultAsByteString = makeRPC(RPC.ProcedureType.BIT_BXOR, args);
            return Bxor.Result.parseFrom(resultAsByteString);
        } catch (final RpcClientException ex) {
            throw ex;
        } catch (final Exception ex) {
            throw new RpcClientException(ex);
        }
    }

    @Override
    public Tohex.Result bit_tohex(final Tohex.Request args) {

        try {
            final ByteString resultAsByteString = makeRPC(RPC.ProcedureType.BIT_TOHEX, args);
            return Tohex.Result.parseFrom(resultAsByteString);
        } catch (final RpcClientException ex) {
            throw ex;
        } catch (final Exception ex) {
            throw new RpcClientException(ex);
        }
    }

    @Override
    public C.Result datasource_C(final C.Request args) {

        try {
            final ByteString resultAsByteString = makeRPC(RPC.ProcedureType.DS_C, args);
            return C.Result.parseFrom(resultAsByteString);
        } catch (final RpcClientException ex) {
            throw ex;
        } catch (final Exception ex) {
            throw new RpcClientException(ex);
        }
    }

    @Override
    public Close.Result datasource_Close(final Close.Request args) {

        try {
            final ByteString resultAsByteString = makeRPC(RPC.ProcedureType.DS_CLOSE, args);
            return Close.Result.parseFrom(resultAsByteString);
        } catch (final RpcClientException ex) {
            throw ex;
        } catch (final Exception ex) {
            throw new RpcClientException(ex);
        }
    }

    @Override
    public CreateDataSource.Result datasource_CreateDataSource(final CreateDataSource.Request args) {

        try {
            final ByteString resultAsByteString = makeRPC(RPC.ProcedureType.CREATE_DATA_SOURCE, args);
            return CreateDataSource.Result.parseFrom(resultAsByteString);
        } catch (final RpcClientException ex) {
            throw ex;
        } catch (final Exception ex) {
            throw new RpcClientException(ex);
        }
    }

    @Override
    public H.Result datasource_H(final H.Request args) {

        try {
            final ByteString resultAsByteString = makeRPC(RPC.ProcedureType.DS_H, args);
            return H.Result.parseFrom(resultAsByteString);
        } catch (final RpcClientException ex) {
            throw ex;
        } catch (final Exception ex) {
            throw new RpcClientException(ex);
        }
    }

    @Override
    public L.Result datasource_L(final L.Request args) {

        try {
            final ByteString resultAsByteString = makeRPC(RPC.ProcedureType.DS_L, args);
            return L.Result.parseFrom(resultAsByteString);
        } catch (final RpcClientException ex) {
            throw ex;
        } catch (final Exception ex) {
            throw new RpcClientException(ex);
        }
    }

    @Override
    public O.Result datasource_O(final O.Request args) {

        try {
            final ByteString resultAsByteString = makeRPC(RPC.ProcedureType.DS_O, args);
            return O.Result.parseFrom(resultAsByteString);
        } catch (final RpcClientException ex) {
            throw ex;
        } catch (final Exception ex) {
            throw new RpcClientException(ex);
        }
    }

    @Override
    public SetEmptyCallback.Result datasource_SetEmptyCallback(final SetEmptyCallback.Request args) {

        try {
            final ByteString resultAsByteString = makeRPC(RPC.ProcedureType.DS_SET_EMPTY_CALLBACK, args);
            return SetEmptyCallback.Result.parseFrom(resultAsByteString);
        } catch (final RpcClientException ex) {
            throw ex;
        } catch (final Exception ex) {
            throw new RpcClientException(ex);
        }
    }

    @Override
    public SetUpdateCallback.Result datasource_SetUpdateCallback(final SetUpdateCallback.Request args) {

        try {
            final ByteString resultAsByteString = makeRPC(RPC.ProcedureType.DS_SET_UPDATE_CALLBACK, args);
            return SetUpdateCallback.Result.parseFrom(resultAsByteString);
        } catch (final RpcClientException ex) {
            throw ex;
        } catch (final Exception ex) {
            throw new RpcClientException(ex);
        }
    }

    @Override
    public Size.Result datasource_Size(final Size.Request args) {

        try {
            final ByteString resultAsByteString = makeRPC(RPC.ProcedureType.DS_SIZE, args);
            return Size.Result.parseFrom(resultAsByteString);
        } catch (final RpcClientException ex) {
            throw ex;
        } catch (final Exception ex) {
            throw new RpcClientException(ex);
        }
    }

    @Override
    public T.Result datasource_T(final T.Request args) {

        try {
            final ByteString resultAsByteString = makeRPC(RPC.ProcedureType.DS_T, args);
            return T.Result.parseFrom(resultAsByteString);
        } catch (final RpcClientException ex) {
            throw ex;
        } catch (final Exception ex) {
            throw new RpcClientException(ex);
        }
    }

    @Override
    public V.Result datasource_V(final V.Request args) {

        try {
            final ByteString resultAsByteString = makeRPC(RPC.ProcedureType.DS_V, args);
            return V.Result.parseFrom(resultAsByteString);
        } catch (final RpcClientException ex) {
            throw ex;
        } catch (final Exception ex) {
            throw new RpcClientException(ex);
        }
    }

    private void checkIfOpen() {
        checkState(isOpened, "The connection must be open.");
    }

    private <T, U> U makeRPC(final T request, final Class<U> resultClass) {

        try {

            checkIfOpen();

            final ZMsg zRequest = new ZMsg();
            zRequest.add( serdeModule.serialize(request) );
            zRequest.send(reqSocket);

            final ZMsg zResponse = ZMsg.recvMsg(reqSocket);

            final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream( (int) zResponse.contentSize() );
            for (final ZFrame frame : zResponse) {
                byteArrayOutputStream.write( frame.getData() );
            }

            return serdeModule.deserialize(resultClass, byteArrayOutputStream.toByteArray());
        } catch (final Exception ex) {
            throw new RpcClientException(ex);
        }
    }
}
