package com.enfernuz.quik.lua.rpc.serde.json.jackson;

import com.enfernuz.quik.lua.rpc.api.RemoteProcedure;
import com.enfernuz.quik.lua.rpc.api.messages.*;
import com.enfernuz.quik.lua.rpc.api.messages.bit.*;
import com.enfernuz.quik.lua.rpc.api.messages.datasource.*;
import com.enfernuz.quik.lua.rpc.api.messages.os.SysDate;
import com.enfernuz.quik.lua.rpc.serde.SerdeException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.google.common.collect.ImmutableMap;

import java.io.IOException;
import java.util.Map;

public final class RemoteProcedureClassJsonSerde {

    private static final int PROCEDURES_COUNT = 82;
    private static final Map<Class<? extends RemoteProcedure>, String> CLASS_TO_METHOD_NAME_MAP = createRegistry();

    static {
        assert PROCEDURES_COUNT == CLASS_TO_METHOD_NAME_MAP.size();
    }

    private RemoteProcedureClassJsonSerde() {}

    public static final class Serializer extends JsonSerializer<Class<? extends RemoteProcedure>> {

        @Override
        public void serialize(final Class<? extends RemoteProcedure> value, final JsonGenerator gen, final SerializerProvider provider) throws IOException {

            final String methodName = CLASS_TO_METHOD_NAME_MAP.get(value);
            if (methodName == null) {
                throw new SerdeException(
                        String.format("Для класса удалённой процедуры '%s' не найдено строчного представления наименования удалённой процедуры.", value.getName())
                );
            }

            gen.writeString(methodName);
        }
    }

    private static Map<Class<? extends RemoteProcedure>, String> createRegistry() {

        final ImmutableMap.Builder<Class<? extends RemoteProcedure>, String> result = ImmutableMap.builder();

        result.put(AddColumn.class, "AddColumn");
        result.put(AddLabel.class, "AddLabel");
        result.put(AllocTable.class, "AllocTable");
        result.put(CalcBuySell.class, "CalcBuySell");
        result.put(CancelParamRequest.class, "CancelParamRequest");
        result.put(Clear.class, "Clear");
        result.put(CreateWindow.class, "AllocTable");
        result.put(DelAllLabels.class, "DelAllLabels");
        result.put(DeleteRow.class, "DeleteRow");
        result.put(DelLabel.class, "DelLabel");
        result.put(DestroyTable.class, "DestroyTable");
        result.put(GetBuySellInfo.class, "getBuySellInfo");
        result.put(GetBuySellInfoEx.class, "getBuySellInfoEx");
        result.put(GetCandlesByIndex.class, "getCandlesByIndex");
        result.put(GetCell.class, "GetCell");
        result.put(GetClassesList.class, "getClassesList");
        result.put(GetClassInfo.class, "getClassInfo");
        result.put(GetClassSecurities.class, "getClassSecurities");
        result.put(GetDepo.class, "getDepo");
        result.put(GetDepoEx.class, "getDepoEx");
        result.put(GetFuturesHolding.class, "getFuturesHolding");
        result.put(GetFuturesLimit.class, "getFuturesLimit");
        result.put(GetInfoParam.class, "getInfoParam");
        result.put(GetItem.class, "getItem");
        result.put(GetLabelParams.class, "GetLabelParams");
        result.put(GetLinesCount.class, "getLinesCount");
        result.put(GetMoney.class, "getMoney");
        result.put(GetMoneyEx.class, "getMoneyEx");
        result.put(GetNumberOf.class, "getNumberOf");
        result.put(GetNumCandles.class, "getNumCandles");
        result.put(GetOrderByNumber.class, "getOrderByNumber");
        result.put(GetParamEx.class, "getParamEx");
        result.put(GetParamEx2.class, "getParamEx2");
        result.put(GetPortfolioInfo.class, "getPortfolioInfo");
        result.put(GetPortfolioInfoEx.class, "getPortfolioInfoEx");
        result.put(GetQuoteLevel2.class, "getQuoteLevel2");
        result.put(GetScriptPath.class, "getScriptPath");
        result.put(GetSecurityInfo.class, "getSecurityInfo");
        result.put(GetTableSize.class, "GetTableSize");
        result.put(GetTradeDate.class, "getTradeDate");
        result.put(GetWindowCaption.class, "GetWindowCaption");
        result.put(GetWindowRect.class, "GetWindowRect");
        result.put(GetWorkingFolder.class, "getWorkingFolder");
        result.put(Highlight.class, "Highlight");
        result.put(InsertRow.class, "InsertRow");
        result.put(IsConnected.class, "isConnected");
        result.put(IsSubscribedLevel2Quotes.class, "IsSubscribed_Level_II_Quotes");
        result.put(IsWindowClosed.class, "IsWindowClosed");
        result.put(Message.class, "message");
        result.put(ParamRequest.class, "ParamRequest");
        result.put(PrintDbgStr.class, "PrintDbgStr");
        result.put(RGB.class, "RGB");
        result.put(SearchItems.class, "SearchItems");
        result.put(SendTransaction.class, "sendTransaction");
        result.put(SetCell.class, "SetCell");
        result.put(SetColor.class, "SetColor");
        result.put(SetLabelParams.class, "SetLabelParams");
        result.put(SetSelectedRow.class, "SetSelectedRow");
        result.put(SetTableNotificationCallback.class, "SetTableNotificationCallback");
        result.put(SetWindowCaption.class, "SetWindowCaption");
        result.put(SetWindowPos.class, "SetWindowPos");
        result.put(Sleep.class, "sleep");
        result.put(SubscribeLevel2Quotes.class, "Subscribe_Level_II_Quotes");
        result.put(UnsubscribeLevel2Quotes.class, "Unsubscribe_Level_II_Quotes");

        result.put(BAnd.class, "bit.band");
        result.put(BNot.class, "bit.bnot");
        result.put(BOr.class, "bit.bor");
        result.put(BXor.class, "bit.bxor");
        result.put(Test.class, "bit.test");
        result.put(ToHex.class, "bit.tohex");

        result.put(C.class, "datasource.C");
        result.put(Close.class, "datasource.Close");
        result.put(CreateDataSource.class, "datasource.CreateDataSource");
        result.put(H.class, "datasource.H");
        result.put(L.class, "datasource.L");
        result.put(O.class, "datasource.O");
        result.put(SetEmptyCallback.class, "datasource.SetEmptyCallback");
        result.put(SetUpdateCallback.class, "datasource.SetUpdateCallback");
        result.put(Size.class, "datasource.Size");
        result.put(T.class, "datasource.T");
        result.put(V.class, "datasource.V");

        result.put(SysDate.class, "os.sysdate");

        return result.build();
    }
}
