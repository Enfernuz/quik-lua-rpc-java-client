package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.RemoteProcedure;
import com.enfernuz.quik.lua.rpc.api.RpcArgs;
import com.enfernuz.quik.lua.rpc.api.messages.*;
import com.enfernuz.quik.lua.rpc.api.messages.bit.*;
import com.enfernuz.quik.lua.rpc.api.messages.datasource.*;
import com.enfernuz.quik.lua.rpc.api.messages.os.SysDate;
import com.enfernuz.quik.lua.rpc.api.structures.*;
import com.enfernuz.quik.lua.rpc.events.api.QluaEvent;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import com.enfernuz.quik.lua.rpc.serde.SerdeException;
import com.enfernuz.quik.lua.rpc.serde.SerdeModule;
import com.enfernuz.quik.lua.rpc.serde.Serializer;
import com.google.common.collect.ImmutableMap;
import lombok.NonNull;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

public enum ProtobufSerdeModule implements SerdeModule {

    INSTANCE;

    private static final Map<Class<?>, Serializer<?>> CLASS_TO_SERIALIZER_MAP = createClassToSerializerMap();
    private static final Map<Class<?>, Deserializer<?>> CLASS_TO_DESERIALIZER_MAP = createClassToDeserializerMap();

    @Override
    public <T> byte[] serialize(@NonNull @NotNull final T t) {

        final byte[] result;
        if (t instanceof QluaEvent.EventType) {
            result = ProtobufQluaEventTypeSerde.INSTANCE.serialize((QluaEvent.EventType) t);
        } else {
            // This cast is safe because we use the registerSerializer method to fill the map.
            @SuppressWarnings("unchecked")
            final Serializer<T> serializer = (Serializer<T>) CLASS_TO_SERIALIZER_MAP.get(t.getClass());
            if (serializer == null) {
                throw new SerdeException(
                        String.format("Неподдерживаемый класс для сериализации в protobuf-представление: %s.", t.getClass().getName())
                );
            } else {
                try {
                    result = serializer.serialize(t);
                } catch (final Exception ex) {
                    throw new SerdeException(
                            String.format("Ошибка при сериализации экземпляра класса '%s' в protobuf-представление.", t.getClass().getName()),
                            ex
                    );
                }
            }
        }

        return result;
    }

    @Override
    public <T> @NotNull T deserialize(@NotNull final Class<T> clazz, @NotNull final byte[] data) {

        // This cast is safe because we use the registerDeserializer method to fill the map.
        @SuppressWarnings("unchecked")
        final Deserializer<T> deserializer = (Deserializer<T>) CLASS_TO_DESERIALIZER_MAP.get(clazz);
        if (deserializer == null) {
            throw new SerdeException(
                    new IllegalArgumentException(
                            String.format("Неподдерживаемый класс для десериализации из protobuf-представления: %s.", clazz.getName())
                    )
            );
        } else {
            try {
                return deserializer.deserialize(data);
            } catch (final Exception ex) {
                throw new SerdeException(
                        String.format("Ошибка при десериализации экземпляра класса '%s' из protobuf-представления.", clazz.getName()),
                        ex
                );
            }
        }
    }

    private static <T extends RpcArgs<? extends RemoteProcedure>> void registerSerializer(
            @NotNull final ImmutableMap.Builder<Class<?>, Serializer<?>> map,
            @NotNull final Class<T> clazz,
            @NotNull final Serializer<T> serde) {

        map.put(clazz, serde);
    }

    private static <T> void registerDeserializer(
            @NotNull final ImmutableMap.Builder<Class<?>, Deserializer<?>> map,
            @NotNull final Class<T> clazz,
            @NotNull final Deserializer<T> serde) {

        map.put(clazz, serde);
    }

    private static Map<Class<?>, Serializer<?>> createClassToSerializerMap() {

        final ImmutableMap.Builder<Class<?>, Serializer<?>> result = ImmutableMap.builder();

        result.put(RequestEnvelope.class, new RequestEnvelopePbSerializer(ProtobufSerdeModule.INSTANCE));

        registerSerializer(result, AddColumn.Args.class, AddColumnArgsPbSerializer.INSTANCE);
        registerSerializer(result, AddLabel.Args.class, AddLabelArgsPbSerializer.INSTANCE);
        registerSerializer(result, CalcBuySell.Args.class, CalcBuySellArgsPbSerializer.INSTANCE);
        registerSerializer(result, CancelParamRequest.Args.class, CancelParamRequestArgsPbSerializer.INSTANCE);
        registerSerializer(result, Clear.Args.class, ClearArgsPbSerializer.INSTANCE);
        registerSerializer(result, CreateWindow.Args.class, CreateWindowArgsPbSerializer.INSTANCE);
        registerSerializer(result, DelAllLabels.Args.class, DelAllLabelsArgsPbSerializer.INSTANCE);
        registerSerializer(result, DeleteRow.Args.class, DeleteRowArgsPbSerializer.INSTANCE);
        registerSerializer(result, DelLabel.Args.class, DelLabelArgsPbSerializer.INSTANCE);
        registerSerializer(result, DestroyTable.Args.class, DestroyTableArgsPbSerializer.INSTANCE);
        registerSerializer(result, GetBuySellInfo.Args.class, GetBuySellInfoArgsPbSerializer.INSTANCE);
        registerSerializer(result, GetBuySellInfoEx.Args.class, GetBuySellInfoExArgsPbSerializer.INSTANCE);
        registerSerializer(result, GetCandlesByIndex.Args.class, GetCandlesByIndexArgsPbSerializer.INSTANCE);
        registerSerializer(result, GetCell.Args.class, GetCellArgsPbSerializer.INSTANCE);
        registerSerializer(result, GetClassInfo.Args.class, GetClassInfoArgsPbSerializer.INSTANCE);
        registerSerializer(result, GetClassSecurities.Args.class, GetClassSecuritiesArgsPbSerializer.INSTANCE);
        registerSerializer(result, GetDepo.Args.class, GetDepoArgsPbSerializer.INSTANCE);
        registerSerializer(result, GetDepoEx.Args.class, GetDepoExArgsPbSerializer.INSTANCE);
        registerSerializer(result, GetFuturesHolding.Args.class, GetFuturesHoldingArgsPbSerializer.INSTANCE);
        registerSerializer(result, GetFuturesLimit.Args.class, GetFuturesLimitArgsPbSerializer.INSTANCE);
        registerSerializer(result, GetInfoParam.Args.class, GetInfoParamArgsPbSerializer.INSTANCE);
        registerSerializer(result, GetItem.Args.class, GetItemArgsPbSerializer.INSTANCE);
        registerSerializer(result, GetLabelParams.Args.class, GetLabelParamsArgsPbSerializer.INSTANCE);
        registerSerializer(result, GetLinesCount.Args.class, GetLinesCountArgsPbSerializer.INSTANCE);
        registerSerializer(result, GetMoney.Args.class, GetMoneyArgsPbSerializer.INSTANCE);
        registerSerializer(result, GetMoneyEx.Args.class, GetMoneyExArgsPbSerializer.INSTANCE);
        registerSerializer(result, GetNumberOf.Args.class, GetNumberOfArgsPbSerializer.INSTANCE);
        registerSerializer(result, GetNumCandles.Args.class, GetNumCandlesArgsPbSerializer.INSTANCE);
        registerSerializer(result, GetOrderByNumber.Args.class, GetOrderByNumberArgsPbSerializer.INSTANCE);
        registerSerializer(result, GetParamEx.Args.class, GetParamExArgsPbSerializer.INSTANCE);
        registerSerializer(result, GetParamEx2.Args.class, GetParamEx2ArgsPbSerializer.INSTANCE);
        registerSerializer(result, GetPortfolioInfo.Args.class, GetPortfolioInfoArgsPbSerializer.INSTANCE);
        registerSerializer(result, GetPortfolioInfoEx.Args.class, GetPortfolioInfoExArgsPbSerializer.INSTANCE);
        registerSerializer(result, GetQuoteLevel2.Args.class, GetQuoteLevel2ArgsPbSerializer.INSTANCE);
        registerSerializer(result, GetSecurityInfo.Args.class, GetSecurityInfoArgsPbSerializer.INSTANCE);
        registerSerializer(result, GetTableSize.Args.class, GetTableSizeArgsPbSerializer.INSTANCE);
        registerSerializer(result, GetWindowCaption.Args.class, GetWindowCaptionArgsPbSerializer.INSTANCE);
        registerSerializer(result, GetWindowRect.Args.class, GetWindowRectArgsPbSerializer.INSTANCE);
        registerSerializer(result, Highlight.Args.class, HighlightArgsPbSerializer.INSTANCE);
        registerSerializer(result, InsertRow.Args.class, InsertRowArgsPbSerializer.INSTANCE);
        registerSerializer(result, IsSubscribedLevel2Quotes.Args.class, IsSubscribedLevel2QuotesArgsPbSerializer.INSTANCE);
        registerSerializer(result, IsWindowClosed.Args.class, IsWindowClosedArgsPbSerializer.INSTANCE);
        registerSerializer(result, ParamRequest.Args.class, ParamRequestArgsPbSerializer.INSTANCE);
        registerSerializer(result, Message.Args.class, MessageArgsPbSerializer.INSTANCE);
        registerSerializer(result, PrintDbgStr.Args.class, PrintDbgStrArgsPbSerializer.INSTANCE);
        registerSerializer(result, RGB.Args.class, RGBArgsPbSerializer.INSTANCE);
        registerSerializer(result, SearchItems.Args.class, SearchItemsArgsPbSerializer.INSTANCE);
        registerSerializer(result, SendTransaction.Args.class, SendTransactionArgsPbSerializer.INSTANCE);
        registerSerializer(result, SetCell.Args.class, SetCellArgsPbSerializer.INSTANCE);
        registerSerializer(result, SetColor.Args.class, SetColorArgsPbSerializer.INSTANCE);
        registerSerializer(result, SetLabelParams.Args.class, SetLabelParamsArgsPbSerializer.INSTANCE);
        registerSerializer(result, SetSelectedRow.Args.class, SetSelectedRowArgsPbSerializer.INSTANCE);
        registerSerializer(result, SetTableNotificationCallback.Args.class, SetTableNotificationCallbackArgsPbSerializer.INSTANCE);
        registerSerializer(result, SetWindowCaption.Args.class, SetWindowCaptionArgsPbSerializer.INSTANCE);
        registerSerializer(result, SetWindowPos.Args.class, SetWindowPosArgsPbSerializer.INSTANCE);
        registerSerializer(result, Sleep.Args.class, SleepArgsPbSerializer.INSTANCE);
        registerSerializer(result, SubscribeLevel2Quotes.Args.class, SubscribeLevel2QuotesArgsPbSerializer.INSTANCE);
        registerSerializer(result, UnsubscribeLevel2Quotes.Args.class, UnsubscribeLevel2QuotesArgsPbSerializer.INSTANCE);

        registerSerializer(result, BAnd.Args.class, BAndArgsPbSerializer.INSTANCE);
        registerSerializer(result, BNot.Args.class, BNotArgsPbSerializer.INSTANCE);
        registerSerializer(result, BOr.Args.class, BOrArgsPbSerializer.INSTANCE);
        registerSerializer(result, BXor.Args.class, BXorArgsPbSerializer.INSTANCE);
        registerSerializer(result, Test.Args.class, BitTestArgsPbSerializer.INSTANCE);
        registerSerializer(result, ToHex.Args.class, BitToHexArgsPbSerializer.INSTANCE);

        registerSerializer(result, O.Args.class, DsOArgsPbSerializer.INSTANCE);
        registerSerializer(result, H.Args.class, DsHArgsPbSerializer.INSTANCE);
        registerSerializer(result, L.Args.class, DsLArgsPbSerializer.INSTANCE);
        registerSerializer(result, C.Args.class, DsCArgsPbSerializer.INSTANCE);
        registerSerializer(result, V.Args.class, DsVArgsPbSerializer.INSTANCE);
        registerSerializer(result, T.Args.class, DsTArgsPbSerializer.INSTANCE);
        registerSerializer(result, Size.Args.class, DsSizePbArgsSerializer.INSTANCE);
        registerSerializer(result, Close.Args.class, DsClosePbArgsSerializer.INSTANCE);
        registerSerializer(result, SetEmptyCallback.Args.class, DsSetEmptyCallbackPbArgsSerializer.INSTANCE);
        registerSerializer(result, SetUpdateCallback.Args.class, DsSetUpdateCallbackPbArgsSerializer.INSTANCE);
        registerSerializer(result, CreateDataSource.Args.class, DsCreateDataSourcePbArgsSerializer.INSTANCE);

        return result.build();
    }

    private static Map<Class<?>, Deserializer<?>> createClassToDeserializerMap() {

        final ImmutableMap.Builder<Class<?>, Deserializer<?>> result = ImmutableMap.builder();

        registerDeserializer(result, ResponseEnvelope.class, ResponseEnvelopePbDeserializer.INSTANCE);

        registerDeserializer(result, QluaEvent.EventType.class, ProtobufQluaEventTypeSerde.INSTANCE);
        registerDeserializer(result, StopEventInfo.class, StopEventInfoPbDeserializer.INSTANCE);
        registerDeserializer(result, ConnectedEventInfo.class, ConnectedEventInfoPbDeserializer.INSTANCE);
        registerDeserializer(result, Trade.class, TradePbDeserializer.INSTANCE);
        registerDeserializer(result, Order.class, OrderPbDeserializer.INSTANCE);
        registerDeserializer(result, FuturesLimitDelete.class, FuturesLimitDeletePbDeserializer.INSTANCE);
        registerDeserializer(result, Firm.class, FirmPbDeserializer.INSTANCE);
        registerDeserializer(result, MoneyLimit.class, MoneyLimitPbDeserializer.INSTANCE);
        registerDeserializer(result, MoneyLimitDelete.class, MoneyLimitDeletePbDeserializer.INSTANCE);
        registerDeserializer(result, DepoLimit.class, DepoLimitPbDeserializer.INSTANCE);
        registerDeserializer(result, DepoLimitDelete.class, DepoLimitDeletePbDeserializer.INSTANCE);
        registerDeserializer(result, AccountBalance.class, AccountBalancePbDeserializer.INSTANCE);
        registerDeserializer(result, AccountPosition.class, AccountPositionPbDeserializer.INSTANCE);
        registerDeserializer(result, NegDeal.class, NegDealPbDeserializer.INSTANCE);
        registerDeserializer(result, NegTrade.class, NegTradePbDeserializer.INSTANCE);
        registerDeserializer(result, StopOrder.class, StopOrderPbDeserializer.INSTANCE);
        registerDeserializer(result, TransReply.class, TransReplyPbDeserializer.INSTANCE);
        registerDeserializer(result, DateTimeEntry.class, DateTimeEntryPbDeserializer.INSTANCE);
        registerDeserializer(result, AllTrade.class, AllTradePbDeserializer.INSTANCE);
        registerDeserializer(result, FuturesClientHolding.class, FuturesClientHoldingPbDeserializer.INSTANCE);
        registerDeserializer(result, FuturesLimit.class, FuturesLimitPbDeserializer.INSTANCE);
        registerDeserializer(result, ParamEventInfo.class, ParamEventInfoPbDeserializer.INSTANCE);
        registerDeserializer(result, QuoteEventInfo.class, QuoteEventInfoPbDeserializer.INSTANCE);
        registerDeserializer(result, CandleEntry.class, CandleEntryPbDeserializer.INSTANCE);
        registerDeserializer(result, ClassInfo.class, ClassInfoPbDeserializer.INSTANCE);
        registerDeserializer(result, Depo.class, DepoPbDeserializer.INSTANCE);
        registerDeserializer(result, Money.class, MoneyPbDeserializer.INSTANCE);
        registerDeserializer(result, PortfolioInfo.class, PortfolioInfoPbDeserializer.INSTANCE);
        registerDeserializer(result, Security.class, SecurityPbDeserializer.INSTANCE);
        registerDeserializer(result, DataSourceTime.class, DataSourceTimePbDeserializer.INSTANCE);
        registerDeserializer(result, DataSourceUpdateInfo.class, DataSourceUpdateInfoPbDeserializer.INSTANCE);

        registerDeserializer(result, AddColumn.Result.class, AddColumnResultPbDeserializer.INSTANCE);
        registerDeserializer(result, AddLabel.Result.class, AddLabelResultPbDeserializer.INSTANCE);
        registerDeserializer(result, AllocTable.Result.class, AllocTableResultPbDeserializer.INSTANCE);
        registerDeserializer(result, CalcBuySell.Result.class, CalcBuySellResultPbDeserializer.INSTANCE);
        registerDeserializer(result, CancelParamRequest.Result.class, CancelParamRequestResultPbDeserializer.INSTANCE);
        registerDeserializer(result, Clear.Result.class, ClearResultPbDeserializer.INSTANCE);
        registerDeserializer(result, CreateWindow.Result.class, CreateWindowResultPbDeserializer.INSTANCE);
        registerDeserializer(result, DelAllLabels.Result.class, DelAllLabelsResultPbDeserializer.INSTANCE);
        registerDeserializer(result, DeleteRow.Result.class, DeleteRowResultPbDeserializer.INSTANCE);
        registerDeserializer(result, DelLabel.Result.class, DelLabelResultPbDeserializer.INSTANCE);
        registerDeserializer(result, DestroyTable.Result.class, DestroyTableResultPbDeserializer.INSTANCE);
        registerDeserializer(result, GetBuySellInfoEx.Result.class, GetBuySellInfoExResultPbDeserializer.INSTANCE);
        registerDeserializer(result, GetBuySellInfo.Result.class, GetBuySellInfoResultPbDeserializer.INSTANCE);
        registerDeserializer(result, GetCandlesByIndex.Result.class, GetCandlesByIndexResultPbDeserializer.INSTANCE);
        registerDeserializer(result, GetCell.Result.class, GetCellResultPbDeserializer.INSTANCE);
        registerDeserializer(result, GetClassesList.Result.class, GetClassesListResultPbDeserializer.INSTANCE);
        registerDeserializer(result, GetClassInfo.Result.class, GetClassInfoResultPbDeserializer.INSTANCE);
        registerDeserializer(result, GetClassSecurities.Result.class, GetClassSecuritiesResultPbDeserializer.INSTANCE);
        registerDeserializer(result, GetDepoEx.Result.class, GetDepoExResultPbDeserializer.INSTANCE);
        registerDeserializer(result, GetDepo.Result.class, GetDepoResultPbDeserializer.INSTANCE);
        registerDeserializer(result, GetFuturesHolding.Result.class, GetFuturesHoldingResultPbDeserializer.INSTANCE);
        registerDeserializer(result, GetFuturesLimit.Result.class, GetFuturesLimitResultPbDeserializer.INSTANCE);
        registerDeserializer(result, GetInfoParam.Result.class, GetInfoParamResultPbDeserializer.INSTANCE);
        registerDeserializer(result, GetItem.Result.class, GetItemResultPbDeserializer.INSTANCE);
        registerDeserializer(result, GetLabelParams.Result.class, GetLabelParamsResultPbDeserializer.INSTANCE);
        registerDeserializer(result, GetLinesCount.Result.class, GetLinesCountResultPbDeserializer.INSTANCE);
        registerDeserializer(result, GetMoneyEx.Result.class, GetMoneyExResultPbDeserializer.INSTANCE);
        registerDeserializer(result, GetMoney.Result.class, GetMoneyResultPbDeserializer.INSTANCE);
        registerDeserializer(result, GetNumberOf.Result.class, GetNumberOfResultPbDeserializer.INSTANCE);
        registerDeserializer(result, GetNumCandles.Result.class, GetNumCandlesResultPbDeserializer.INSTANCE);
        registerDeserializer(result, GetOrderByNumber.Result.class, GetOrderByNumberResultPbDeserializer.INSTANCE);
        registerDeserializer(result, GetParamEx2.Result.class, GetParamEx2ResultPbDeserializer.INSTANCE);
        registerDeserializer(result, GetParamEx.Result.class, GetParamExResultPbDeserializer.INSTANCE);
        registerDeserializer(result, GetPortfolioInfo.Result.class, GetPortfolioInfoResultPbDeserializer.INSTANCE);
        registerDeserializer(result, GetPortfolioInfoEx.Result.class, GetPortfolioInfoExResultPbDeserializer.INSTANCE);
        registerDeserializer(result, GetQuoteLevel2.Result.class, GetQuoteLevel2ResultPbDeserializer.INSTANCE);
        registerDeserializer(result, GetScriptPath.Result.class, GetScriptPathResultPbDeserializer.INSTANCE);
        registerDeserializer(result, GetSecurityInfo.Result.class, GetSecurityInfoResultPbDeserializer.INSTANCE);
        registerDeserializer(result, GetTableSize.Result.class, GetTableSizeResultPbDeserializer.INSTANCE);
        registerDeserializer(result, GetTradeDate.Result.class, GetTradeDateResultPbDeserializer.INSTANCE);
        registerDeserializer(result, GetWindowCaption.Result.class, GetWindowCaptionResultPbDeserializer.INSTANCE);
        registerDeserializer(result, GetWindowRect.Result.class, GetWindowRectResultPbDeserializer.INSTANCE);
        registerDeserializer(result, GetWorkingFolder.Result.class, GetWorkingFolderResultPbDeserializer.INSTANCE);
        registerDeserializer(result, Highlight.Result.class, HighlightResultPbDeserializer.INSTANCE);
        registerDeserializer(result, InsertRow.Result.class, InsertRowResultPbDeserializer.INSTANCE);
        registerDeserializer(result, IsConnected.Result.class, IsConnectedResultPbDeserializer.INSTANCE);
        registerDeserializer(result, IsSubscribedLevel2Quotes.Result.class, IsSubscribedLevel2QuotesResultPbDeserializer.INSTANCE);
        registerDeserializer(result, IsWindowClosed.Result.class, IsWindowClosedResultPbDeserializer.INSTANCE);
        registerDeserializer(result, Message.Result.class, MessageResultPbDeserializer.INSTANCE);
        registerDeserializer(result, ParamRequest.Result.class, ParamRequestResultPbDeserializer.INSTANCE);
        registerDeserializer(result, RGB.Result.class, RGBResultPbDeserializer.INSTANCE);
        registerDeserializer(result, SearchItems.Result.class, SearchItemsResultPbDeserializer.INSTANCE);
        registerDeserializer(result, SendTransaction.Result.class, SendTransactionResultPbDeserializer.INSTANCE);
        registerDeserializer(result, SetCell.Result.class, SetCellResultPbDeserializer.INSTANCE);
        registerDeserializer(result, SetColor.Result.class, SetColorResultPbDeserializer.INSTANCE);
        registerDeserializer(result, SetLabelParams.Result.class, SetLabelParamsResultPbDeserializer.INSTANCE);
        registerDeserializer(result, SetSelectedRow.Result.class, SetSelectedRowResultPbDeserializer.INSTANCE);
        registerDeserializer(result, SetTableNotificationCallback.Result.class, SetTableNotificationCallbackResultPbDeserializer.INSTANCE);
        registerDeserializer(result, SetWindowCaption.Result.class, SetWindowCaptionResultPbDeserializer.INSTANCE);
        registerDeserializer(result, SetWindowPos.Result.class, SetWindowPosResultPbDeserializer.INSTANCE);
        registerDeserializer(result, Sleep.Result.class, SleepResultPbDeserializer.INSTANCE);
        registerDeserializer(result, SubscribeLevel2Quotes.Result.class, SubscribeLevel2QuotesResultPbDeserializer.INSTANCE);
        registerDeserializer(result, UnsubscribeLevel2Quotes.Result.class, UnsubscribeLevel2QuotesResultPbDeserializer.INSTANCE);

        registerDeserializer(result, BAnd.Result.class, BAndResultPbDeserializer.INSTANCE);
        registerDeserializer(result, BNot.Result.class, BNotResultPbDeserializer.INSTANCE);
        registerDeserializer(result, BOr.Result.class, BOrResultPbDeserializer.INSTANCE);
        registerDeserializer(result, BXor.Result.class, BXorResultPbDeserializer.INSTANCE);
        registerDeserializer(result, Test.Result.class, BitTestResultPbDeserializer.INSTANCE);
        registerDeserializer(result, ToHex.Result.class, BitToHexResultPbDeserializer.INSTANCE);

        registerDeserializer(result, O.Result.class, DsOResultPbDeserializer.INSTANCE);
        registerDeserializer(result, H.Result.class, DsHResultPbDeserializer.INSTANCE);
        registerDeserializer(result, L.Result.class, DsLResultPbDeserializer.INSTANCE);
        registerDeserializer(result, C.Result.class, DsCResultPbDeserializer.INSTANCE);
        registerDeserializer(result, V.Result.class, DsVResultPbDeserializer.INSTANCE);
        registerDeserializer(result, T.Result.class, DsTResultPbDeserializer.INSTANCE);
        registerDeserializer(result, Size.Result.class, DsSizeResultPbDeserializer.INSTANCE);
        registerDeserializer(result, Close.Result.class, DsClosePbResultDeserializer.INSTANCE);
        registerDeserializer(result, SetEmptyCallback.Result.class, DsSetEmptyCallbackPbResultDeserializer.INSTANCE);
        registerDeserializer(result, SetUpdateCallback.Result.class, DsSetUpdateCallbackPbResultDeserializer.INSTANCE);
        registerDeserializer(result, CreateDataSource.Result.class, DsCreateDataSourcePbResultDeserializer.INSTANCE);

        registerDeserializer(result, SysDate.Result.class, SysDateResultPbDeserializer.INSTANCE);

        return result.build();
    }
}
