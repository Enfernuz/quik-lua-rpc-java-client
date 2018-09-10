package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.ServiceError;
import com.enfernuz.quik.lua.rpc.api.messages.*;
import com.enfernuz.quik.lua.rpc.api.structures.*;
import com.enfernuz.quik.lua.rpc.events.api.QluaEvent;
import com.enfernuz.quik.lua.rpc.serde.Serde;
import com.enfernuz.quik.lua.rpc.serde.SerdeException;
import com.enfernuz.quik.lua.rpc.serde.SerdeModule;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

import static java.util.Objects.requireNonNull;

public enum ProtobufSerdeModule implements SerdeModule {

    INSTANCE;

    private static final Map<Class<?>, Serde<?>> CLASS_TO_SERDE_MAP = createClassToSerdeMap();

    @Override
    public <T> byte[] serialize(final T t) {

        requireNonNull(t, "Аргумент не должен быть null.");

        // This cast is safe because we used the registerSerde method to fill the map.
        @SuppressWarnings("unchecked")
        final Serde<T> serde = (Serde<T>) CLASS_TO_SERDE_MAP.get(t.getClass());
        if (serde == null) {
            throw new SerdeException(
                    String.format("Неподдерживаемый класс для сериализации в protobuf-представление: %s.", t.getClass().getName())
            );
        } else {
            try {
                return serde.serialize(t);
            } catch (final Exception ex) {
                throw new SerdeException(
                        String.format("Ошибка при сериализации экземпляра класса '%s' в protobuf-представление.", t.getClass().getName()),
                        ex
                );
            }
        }
    }

    @Override
    public <T> T deserialize(final Class<T> clazz, final byte[] data) {

        // This cast is safe because we used the registerSerde method to fill the map.
        @SuppressWarnings("unchecked")
        final Serde<T> serde = (Serde<T>) CLASS_TO_SERDE_MAP.get(clazz);
        if (serde == null) {
            throw new SerdeException(
                    new IllegalArgumentException(
                            String.format("Неподдерживаемый класс для десериализации из protobuf-представления: %s.", clazz.getName())
                    )
            );
        } else {
            try {
                return serde.deserialize(data);
            } catch (final Exception ex) {
                throw new SerdeException(
                        String.format("Ошибка при десериализации экземпляра класса '%s' из protobuf-представления.", clazz.getName()),
                        ex
                );
            }
        }
    }

    private static <T> void registerSerde(
            @NotNull final Map<Class<?>, Serde<?>> map,
            @NotNull final Class<T> clazz,
            @NotNull final Serde<T> serde) {

        map.put(clazz, serde);
    }

    private static Map<Class<?>, Serde<?>> createClassToSerdeMap() {

        final Map<Class<?>, Serde<?>> result = new HashMap<>();

        registerSerde(result, QluaEvent.EventType.class, ProtobufQluaEventTypeSerde.INSTANCE);
        registerSerde(result, StopEventInfo.class, StopEventInfoPbSerde.INSTANCE);
        registerSerde(result, ConnectedEventInfo.class, ConnectedEventInfoPbSerde.INSTANCE);
        registerSerde(result, Trade.class, TradePbSerde.INSTANCE);
        registerSerde(result, Order.class, OrderPbSerde.INSTANCE);
        registerSerde(result, FuturesLimitDelete.class, FuturesLimitDeletePbSerde.INSTANCE);
        registerSerde(result, Firm.class, FirmPbSerde.INSTANCE);
        registerSerde(result, MoneyLimit.class, MoneyLimitPbSerde.INSTANCE);
        registerSerde(result, MoneyLimitDelete.class, MoneyLimitDeletePbSerde.INSTANCE);
        registerSerde(result, DepoLimit.class, DepoLimitPbSerde.INSTANCE);
        registerSerde(result, DepoLimitDelete.class, DepoLimitDeletePbSerde.INSTANCE);
        registerSerde(result, AccountBalance.class, AccountBalancePbSerde.INSTANCE);
        registerSerde(result, AccountPosition.class, AccountPositionPbSerde.INSTANCE);
        registerSerde(result, NegDeal.class, NegDealPbSerde.INSTANCE);
        registerSerde(result, NegTrade.class, NegTradePbSerde.INSTANCE);
        registerSerde(result, StopOrder.class, StopOrderPbSerde.INSTANCE);
        registerSerde(result, TransReply.class, TransReplyPbSerde.INSTANCE);
        registerSerde(result, DateTimeEntry.class, DateTimeEntryPbSerde.INSTANCE);
        registerSerde(result, AllTrade.class, AllTradePbSerde.INSTANCE);
        registerSerde(result, FuturesClientHolding.class, FuturesClientHoldingPbSerde.INSTANCE);
        registerSerde(result, FuturesLimit.class, FuturesLimitPbSerde.INSTANCE);
        registerSerde(result, ParamEventInfo.class, ParamEventInfoPbSerde.INSTANCE);
        registerSerde(result, QuoteEventInfo.class, QuoteEventInfoPbSerde.INSTANCE);
        registerSerde(result, CandleEntry.class, CandleEntryPbSerde.INSTANCE);
        registerSerde(result, ClassInfo.class, ClassInfoPbSerde.INSTANCE);
        registerSerde(result, Depo.class, DepoPbSerde.INSTANCE);

        registerSerde(result, ServiceError.class, ServiceErrorPbSerde.INSTANCE);
        registerSerde(result, ResponseEnvelope.class, ResponseEnvelopePbSerde.INSTANCE);
        registerSerde(result, AddColumn.Request.class, AddColumnRequestPbSerde.INSTANCE);
        registerSerde(result, AddColumn.Result.class, AddColumnResultPbSerde.INSTANCE);
        registerSerde(result, AddLabel.Request.class, AddLabelRequestPbSerde.INSTANCE);
        registerSerde(result, AddLabel.Result.class, AddLabelResultPbSerde.INSTANCE);
        registerSerde(result, AllocTable.Request.class, AllocTableRequestPbSerde.INSTANCE);
        registerSerde(result, AllocTable.Result.class, AllocTableResultPbSerde.INSTANCE);
        registerSerde(result, CalcBuySell.Request.class, CalcBuySellRequestPbSerde.INSTANCE);
        registerSerde(result, CalcBuySell.Result.class, CalcBuySellResultPbSerde.INSTANCE);
        registerSerde(result, CancelParamRequest.Request.class, CancelParamRequestRequestPbSerde.INSTANCE);
        registerSerde(result, CancelParamRequest.Result.class, CancelParamRequestResultPbSerde.INSTANCE);
        registerSerde(result, Clear.Request.class, ClearRequestPbSerde.INSTANCE);
        registerSerde(result, Clear.Result.class, ClearResultPbSerde.INSTANCE);
        registerSerde(result, CreateWindow.Request.class, CreateWindowRequestPbSerde.INSTANCE);
        registerSerde(result, CreateWindow.Result.class, CreateWindowResultPbSerde.INSTANCE);
        registerSerde(result, DelAllLabels.Request.class, DelAllLabelsRequestPbSerde.INSTANCE);
        registerSerde(result, DelAllLabels.Result.class, DelAllLabelsResultPbSerde.INSTANCE);
        registerSerde(result, DeleteRow.Request.class, DeleteRowRequestPbSerde.INSTANCE);
        registerSerde(result, DeleteRow.Result.class, DeleteRowResultPbSerde.INSTANCE);
        registerSerde(result, DelLabel.Request.class, DelLabelRequestPbSerde.INSTANCE);
        registerSerde(result, DelLabel.Result.class, DelLabelResultPbSerde.INSTANCE);
        registerSerde(result, DestroyTable.Request.class, DestroyTableRequestPbSerde.INSTANCE);
        registerSerde(result, DestroyTable.Result.class, DestroyTableResultPbSerde.INSTANCE);
        registerSerde(result, GetBuySellInfo.BuySellInfo.class, BuySellInfoPbSerde.INSTANCE);
        registerSerde(result, GetBuySellInfo.Request.class, GetBuySellInfoRequestPbSerde.INSTANCE);
        registerSerde(result, GetBuySellInfo.Result.class, GetBuySellInfoResultPbSerde.INSTANCE);
        registerSerde(result, GetBuySellInfoEx.BuySellInfoEx.class, BuySellInfoExPbSerde.INSTANCE);
        registerSerde(result, GetBuySellInfoEx.Request.class, GetBuySellInfoExRequestPbSerde.INSTANCE);
        registerSerde(result, GetBuySellInfoEx.Result.class, GetBuySellInfoExResultPbSerde.INSTANCE);
        registerSerde(result, GetCandlesByIndex.Request.class, GetCandlesByIndexRequestPbSerde.INSTANCE);
        registerSerde(result, GetCandlesByIndex.Result.class, GetCandlesByIndexResultPbSerde.INSTANCE);
        registerSerde(result, GetCell.Request.class, GetCellRequestPbSerde.INSTANCE);
        registerSerde(result, GetCell.Result.class, GetCellResultPbSerde.INSTANCE);
        registerSerde(result, GetClassesList.Request.class, GetClassesListRequestPbSerde.INSTANCE);
        registerSerde(result, GetClassesList.Result.class, GetClassesListResultPbSerde.INSTANCE);
        registerSerde(result, GetClassInfo.Request.class, GetClassInfoRequestPbSerde.INSTANCE);
        registerSerde(result, GetClassInfo.Result.class, GetClassInfoResultPbSerde.INSTANCE);
        registerSerde(result, GetClassSecurities.Request.class, GetClassSecuritiesRequestPbSerde.INSTANCE);
        registerSerde(result, GetClassSecurities.Result.class, GetClassSecuritiesResultPbSerde.INSTANCE);
        registerSerde(result, GetDepo.Request.class, GetDepoRequestPbSerde.INSTANCE);
        registerSerde(result, GetDepo.Result.class, GetDepoResultPbSerde.INSTANCE);
        registerSerde(result, GetDepoEx.Request.class, GetDepoExRequestPbSerde.INSTANCE);
        registerSerde(result, GetDepoEx.Result.class, GetDepoExResultPbSerde.INSTANCE);
        registerSerde(result, GetFuturesHolding.Request.class, GetFuturesHoldingRequestPbSerde.INSTANCE);
        registerSerde(result, GetFuturesHolding.Result.class, GetFuturesHoldingResultPbSerde.INSTANCE);
        registerSerde(result, GetFuturesLimit.Request.class, GetFuturesLimitRequestPbSerde.INSTANCE);
        registerSerde(result, GetFuturesLimit.Result.class, GetFuturesLimitResultPbSerde.INSTANCE);
        registerSerde(result, GetInfoParam.Request.class, GetInfoParamRequestPbSerde.INSTANCE);
        registerSerde(result, GetInfoParam.Result.class, GetInfoParamResultPbSerde.INSTANCE);
        registerSerde(result, GetItem.Request.class, GetItemRequestPbSerde.INSTANCE);
        registerSerde(result, GetItem.Result.class, GetItemResultPbSerde.INSTANCE);
        registerSerde(result, Message.Request.class, MessageRequestPbSerde.INSTANCE);
        registerSerde(result, Message.Result.class, MessageResultPbSerde.INSTANCE);

        return result;
    }
}
