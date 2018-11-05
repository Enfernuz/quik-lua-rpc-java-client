package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.RemoteProcedure;
import com.enfernuz.quik.lua.rpc.api.RpcArgs;
import com.enfernuz.quik.lua.rpc.api.messages.*;
import com.enfernuz.quik.lua.rpc.api.messages.bit.*;
import com.enfernuz.quik.lua.rpc.api.messages.datasource.*;
import com.enfernuz.quik.lua.rpc.api.messages.os.SysDate;
import com.enfernuz.quik.lua.rpc.api.structures.RequestEnvelope;
import com.enfernuz.quik.lua.rpc.serde.Serializer;
import com.google.common.collect.ImmutableMap;
import com.google.protobuf.ByteString;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import qlua.rpc.RPC;

import java.util.Map;

@RequiredArgsConstructor
public class RequestEnvelopePbSerializer implements Serializer<RequestEnvelope<? extends RemoteProcedure>>, ToPbConverter<RequestEnvelope<? extends RemoteProcedure>, qlua.rpc.RPC.Request> {

    private static final Map<Class<? extends RemoteProcedure>, RPC.ProcedureType> REMOTE_PROCEDURE_CLASS_TO_PB_PROCEDURE_TYPE_MAP =
            createRemoteProcedureClassToPbProcedureTypeMap();

    static {
        // PROCEDURE_TYPE_UNKNOWN + UNRECOGNIZED = 2
        assert RPC.ProcedureType.values().length - 2 == REMOTE_PROCEDURE_CLASS_TO_PB_PROCEDURE_TYPE_MAP.size();
    }

    @NonNull ProtobufSerdeModule protobufSerdeModule;

    @Override
    public @NotNull byte[] serialize(@NotNull final RequestEnvelope<? extends RemoteProcedure> requestEnvelope) {
        return convert(requestEnvelope).toByteArray();
    }

    @Override
    public @NotNull RPC.Request convert(@NotNull final RequestEnvelope<? extends RemoteProcedure> requestEnvelope) {

        final qlua.rpc.RPC.Request.Builder pbRequest = qlua.rpc.RPC.Request.newBuilder();

        pbRequest.setType(
                REMOTE_PROCEDURE_CLASS_TO_PB_PROCEDURE_TYPE_MAP.get( requestEnvelope.getRemoteProcedureClass() )
        );

        final RpcArgs<? extends RemoteProcedure> args = requestEnvelope.getArgs();
        if (args != null) {
            // TODO: optimization.
            // The ProtobufSerdeModule::serialize method uses the GeneratedMessageV3::toByteArray method under the hood.
            // We can get the ByteString instance from the GeneratedMessageV3::toByteString method right away if we use
            // ToPbConverter here. Not doing so leads to doing the unnecessary work: RpcArgs -> GeneratedMessageV3 -> byte[] -> ByteString
            // (while the preferred way would be: RpcArgs -> GeneratedMessageV3 -> ByteString).
            // But the former way is cheap in terms of the development time, and I've opted in for it.
            pbRequest.setArgs(
                    ByteString.copyFrom(protobufSerdeModule.serialize(args))
            );
        }

        return pbRequest.build();
    }

    private static @NotNull Map<Class<? extends RemoteProcedure>, qlua.rpc.RPC.ProcedureType> createRemoteProcedureClassToPbProcedureTypeMap() {

        final ImmutableMap.Builder<Class<? extends RemoteProcedure>, qlua.rpc.RPC.ProcedureType> result = ImmutableMap.builder();

        result.put(AddColumn.class, RPC.ProcedureType.ADD_COLUMN);
        result.put(AddLabel.class, RPC.ProcedureType.ADD_LABEL);
        result.put(AllocTable.class, RPC.ProcedureType.ALLOC_TABLE);
        result.put(CalcBuySell.class, RPC.ProcedureType.CALC_BUY_SELL);
        result.put(CancelParamRequest.class, RPC.ProcedureType.CANCEL_PARAM_REQUEST);
        result.put(Clear.class, RPC.ProcedureType.CLEAR);
        result.put(CreateWindow.class, RPC.ProcedureType.CREATE_WINDOW);
        result.put(DelAllLabels.class, RPC.ProcedureType.DEL_ALL_LABELS);
        result.put(DeleteRow.class, RPC.ProcedureType.DELETE_ROW);
        result.put(DelLabel.class, RPC.ProcedureType.DEL_LABEL);
        result.put(DestroyTable.class, RPC.ProcedureType.DESTROY_TABLE);
        result.put(GetBuySellInfoEx.class, RPC.ProcedureType.GET_BUY_SELL_INFO_EX);
        result.put(GetBuySellInfo.class, RPC.ProcedureType.GET_BUY_SELL_INFO);
        result.put(GetCandlesByIndex.class, RPC.ProcedureType.GET_CANDLES_BY_INDEX);
        result.put(GetCell.class, RPC.ProcedureType.GET_CELL);
        result.put(GetClassesList.class, RPC.ProcedureType.GET_CLASSES_LIST);
        result.put(GetClassInfo.class, RPC.ProcedureType.GET_CLASS_INFO);
        result.put(GetClassSecurities.class, RPC.ProcedureType.GET_CLASS_SECURITIES);
        result.put(GetDepo.class, RPC.ProcedureType.GET_DEPO);
        result.put(GetDepoEx.class, RPC.ProcedureType.GET_DEPO_EX);
        result.put(GetFuturesHolding.class, RPC.ProcedureType.GET_FUTURES_HOLDING);
        result.put(GetFuturesLimit.class, RPC.ProcedureType.GET_FUTURES_LIMIT);
        result.put(GetInfoParam.class, RPC.ProcedureType.GET_INFO_PARAM);
        result.put(GetItem.class, RPC.ProcedureType.GET_ITEM);
        result.put(GetLabelParams.class, RPC.ProcedureType.GET_LABEL_PARAMS);
        result.put(GetLinesCount.class, RPC.ProcedureType.GET_LINES_COUNT);
        result.put(GetMoney.class, RPC.ProcedureType.GET_MONEY);
        result.put(GetMoneyEx.class, RPC.ProcedureType.GET_MONEY_EX);
        result.put(GetNumberOf.class, RPC.ProcedureType.GET_NUMBER_OF);
        result.put(GetNumCandles.class, RPC.ProcedureType.GET_NUM_CANDLES);
        result.put(GetOrderByNumber.class, RPC.ProcedureType.GET_ORDER_BY_NUMBER);
        result.put(GetParamEx.class, RPC.ProcedureType.GET_PARAM_EX);
        result.put(GetParamEx2.class, RPC.ProcedureType.GET_PARAM_EX_2);
        result.put(GetPortfolioInfo.class, RPC.ProcedureType.GET_PORTFOLIO_INFO);
        result.put(GetPortfolioInfoEx.class, RPC.ProcedureType.GET_PORTFOLIO_INFO_EX);
        result.put(GetQuoteLevel2.class, RPC.ProcedureType.GET_QUOTE_LEVEL2);
        result.put(GetScriptPath.class, RPC.ProcedureType.GET_SCRIPT_PATH);
        result.put(GetSecurityInfo.class, RPC.ProcedureType.GET_SECURITY_INFO);
        result.put(GetTableSize.class, RPC.ProcedureType.GET_TABLE_SIZE);
        result.put(GetTradeDate.class, RPC.ProcedureType.GET_TRADE_DATE);
        result.put(GetWindowCaption.class, RPC.ProcedureType.GET_WINDOW_CAPTION);
        result.put(GetWindowRect.class, RPC.ProcedureType.GET_WINDOW_RECT);
        result.put(GetWorkingFolder.class, RPC.ProcedureType.GET_WORKING_FOLDER);
        result.put(Highlight.class, RPC.ProcedureType.HIGHLIGHT);
        result.put(InsertRow.class, RPC.ProcedureType.INSERT_ROW);
        result.put(IsConnected.class, RPC.ProcedureType.IS_CONNECTED);
        result.put(IsSubscribedLevel2Quotes.class, RPC.ProcedureType.IS_SUBSCRIBED_LEVEL_II_QUOTES);
        result.put(IsWindowClosed.class, RPC.ProcedureType.IS_WINDOW_CLOSED);
        result.put(Message.class, RPC.ProcedureType.MESSAGE);
        result.put(ParamRequest.class, RPC.ProcedureType.PARAM_REQUEST);
        result.put(PrintDbgStr.class, RPC.ProcedureType.PRINT_DBG_STR);
        result.put(RGB.class, RPC.ProcedureType.RGB);
        result.put(SearchItems.class, RPC.ProcedureType.SEARCH_ITEMS);
        result.put(SendTransaction.class, RPC.ProcedureType.SEND_TRANSACTION);
        result.put(SetCell.class, RPC.ProcedureType.SET_CELL);
        result.put(SetColor.class, RPC.ProcedureType.SET_COLOR);
        result.put(SetLabelParams.class, RPC.ProcedureType.SET_LABEL_PARAMS);
        result.put(SetSelectedRow.class, RPC.ProcedureType.SET_SELECTED_ROW);
        result.put(SetTableNotificationCallback.class, RPC.ProcedureType.SET_TABLE_NOTIFICATION_CALLBACK);
        result.put(SetWindowCaption.class, RPC.ProcedureType.SET_WINDOW_CAPTION);
        result.put(SetWindowPos.class, RPC.ProcedureType.SET_WINDOW_POS);
        result.put(Sleep.class, RPC.ProcedureType.SLEEP);
        result.put(SubscribeLevel2Quotes.class, RPC.ProcedureType.SUBSCRIBE_LEVEL_II_QUOTES);
        result.put(UnsubscribeLevel2Quotes.class, RPC.ProcedureType.UNSUBSCRIBE_LEVEL_II_QUOTES);

        result.put(BAnd.class, RPC.ProcedureType.BIT_BAND);
        result.put(BNot.class, RPC.ProcedureType.BIT_BNOT);
        result.put(BOr.class, RPC.ProcedureType.BIT_BOR);
        result.put(BXor.class, RPC.ProcedureType.BIT_BXOR);
        result.put(Test.class, RPC.ProcedureType.BIT_TEST);
        result.put(ToHex.class, RPC.ProcedureType.BIT_TOHEX);

        result.put(C.class, RPC.ProcedureType.DS_C);
        result.put(Close.class, RPC.ProcedureType.DS_CLOSE);
        result.put(CreateDataSource.class, RPC.ProcedureType.CREATE_DATA_SOURCE);
        result.put(H.class, RPC.ProcedureType.DS_H);
        result.put(L.class, RPC.ProcedureType.DS_L);
        result.put(O.class, RPC.ProcedureType.DS_O);
        result.put(SetEmptyCallback.class, RPC.ProcedureType.DS_SET_EMPTY_CALLBACK);
        result.put(SetUpdateCallback.class, RPC.ProcedureType.DS_SET_UPDATE_CALLBACK);
        result.put(Size.class, RPC.ProcedureType.DS_SIZE);
        result.put(T.class, RPC.ProcedureType.DS_T);
        result.put(V.class, RPC.ProcedureType.DS_V);

        result.put(SysDate.class, RPC.ProcedureType.OS_SYSDATE);

        return result.build();
    }
}
