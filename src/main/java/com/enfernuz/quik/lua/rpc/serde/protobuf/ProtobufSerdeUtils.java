package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetBuySellInfo;
import com.enfernuz.quik.lua.rpc.api.messages.GetBuySellInfoEx;
import com.enfernuz.quik.lua.rpc.api.messages.GetQuoteLevel2;
import com.enfernuz.quik.lua.rpc.api.structures.*;
import com.google.common.base.Strings;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qlua.rpc.GetDepo;
import qlua.rpc.GetMoney;
import qlua.rpc.GetPortfolioInfo;
import qlua.structs.QluaStructures;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

final class ProtobufSerdeUtils {

    static final Charset DEFAULT_PROTOBUF_CHARSET = StandardCharsets.UTF_8;

    private static final FromPbConverter<QluaStructures.DateTimeEntry, DateTimeEntry> DATE_TIME_ENTRY_PB_CONVERTER =
            DateTimeEntryPbDeserializer.INSTANCE;

    private static final FromPbConverter<qlua.rpc.GetBuySellInfo.BuySellInfo, GetBuySellInfo.BuySellInfo> BUY_SELL_INFO_PB_CONVERTER =
            BuySellInfoPbDeserializer.INSTANCE;

    private static final FromPbConverter<qlua.rpc.GetBuySellInfoEx.BuySellInfoEx, GetBuySellInfoEx.BuySellInfoEx> BUY_SELL_INFO_EX_PB_CONVERTER =
            BuySellInfoExPbDeserializer.INSTANCE;

    private static final FromPbConverter<QluaStructures.CandleEntry, CandleEntry> CANDLE_ENTRY_PB_CONVERTER =
            CandleEntryPbDeserializer.INSTANCE;

    private static final FromPbConverter<QluaStructures.Klass, ClassInfo> CLASS_INFO_PB_CONVERTER =
            ClassInfoPbDeserializer.INSTANCE;

    private static final FromPbConverter<GetDepo.Depo, Depo> DEPO_PB_CONVERTER = DepoPbDeserializer.INSTANCE;

    private static final FromPbConverter<QluaStructures.DepoLimit, DepoLimit> DEPO_LIMIT_PB_CONVERTER = DepoLimitPbDeserializer.INSTANCE;

    private static final FromPbConverter<QluaStructures.FuturesClientHolding, FuturesClientHolding> FUTURES_CLIENT_HOLDING_PB_CONVERTER =
            FuturesClientHoldingPbDeserializer.INSTANCE;

    private static final FromPbConverter<QluaStructures.FuturesLimit, FuturesLimit> FUTURES_LIMIT_PB_CONVERTER =
            FuturesLimitPbDeserializer.INSTANCE;

    private static final FromPbConverter<GetMoney.Money, Money> MONEY_PB_CONVERTER = MoneyPbDeserializer.INSTANCE;

    private static final FromPbConverter<QluaStructures.MoneyLimit, MoneyLimit> MONEY_LIMIT_PB_CONVERTER =
            MoneyLimitPbDeserializer.INSTANCE;

    private static final FromPbConverter<QluaStructures.Order, Order> ORDER_PB_CONVERTER = OrderPbDeserializer.INSTANCE;

    private static final FromPbConverter<GetPortfolioInfo.PortfolioInfo, PortfolioInfo> PORTFOLIO_INFO_PB_CONVERTER =
            PortfolioInfoPbDeserializer.INSTANCE;

    private static final FromPbConverter<qlua.rpc.GetQuoteLevel2.QuoteEntry, GetQuoteLevel2.QuoteEntry> QUOTE_ENTRY_PB_CONVERTER =
            QuoteEntryPbDeserializer.INSTANCE;

    private static final FromPbConverter<QluaStructures.Security, Security> SECURITY_PB_CONVERTER = SecurityPbDeserializer.INSTANCE;

    private static final FromPbConverter<QluaStructures.DataSourceTime, DataSourceTime> DATA_SOURCE_TIME_PB_CONVERTER =
            DataSourceTimePbDeserializer.INSTANCE;

    @Contract(" -> fail")
    private ProtobufSerdeUtils() {
        throw new AssertionError("This should never be invoked.");
    }

    @Nullable
    @Contract(pure = true)
    static String convertFromPbString(final String protobufString) {
        return Strings.isNullOrEmpty(protobufString) ? null : protobufString;
    }

    @Contract("_ -> !null")
    static String convertToPbString(final String string) {
        return (string == null) ? "" : string;
    }

    @NotNull
    static DateTimeEntry convertFromPbDateTimeEntry(@NotNull final QluaStructures.DateTimeEntry dateTimeEntry) {
        return DATE_TIME_ENTRY_PB_CONVERTER.convert(dateTimeEntry);
    }

    @NotNull
    static GetBuySellInfo.BuySellInfo convertFromPbBuySellInfo(@NotNull final qlua.rpc.GetBuySellInfo.BuySellInfo buySellInfo) {
        return BUY_SELL_INFO_PB_CONVERTER.convert(buySellInfo);
    }

    @NotNull
    static GetBuySellInfoEx.BuySellInfoEx convertFromPbBuySellInfoEx(@NotNull final qlua.rpc.GetBuySellInfoEx.BuySellInfoEx buySellInfoEx) {
        return BUY_SELL_INFO_EX_PB_CONVERTER.convert(buySellInfoEx);
    }

    @NotNull
    static CandleEntry convertFromPbCandleEntry(@NotNull final QluaStructures.CandleEntry candleEntry) {
        return CANDLE_ENTRY_PB_CONVERTER.convert(candleEntry);
    }

    @NotNull
    static ClassInfo convertFromPbClassInfo(@NotNull final QluaStructures.Klass classInfo) {
        return CLASS_INFO_PB_CONVERTER.convert(classInfo);
    }

    @NotNull
    static Depo convertFromPbDepo(@NotNull final qlua.rpc.GetDepo.Depo depo) {
        return DEPO_PB_CONVERTER.convert(depo);
    }

    @NotNull
    static DepoLimit convertFromPbDepoLimit(@NotNull final QluaStructures.DepoLimit depoLimit) {
        return DEPO_LIMIT_PB_CONVERTER.convert(depoLimit);
    }

    @NotNull
    static FuturesClientHolding convertFromPbFuturesClientHolding(@NotNull final QluaStructures.FuturesClientHolding futuresClientHolding) {
        return FUTURES_CLIENT_HOLDING_PB_CONVERTER.convert(futuresClientHolding);
    }

    @NotNull
    static FuturesLimit convertFromPbFuturesLimit(@NotNull final QluaStructures.FuturesLimit futuresLimit) {
        return FUTURES_LIMIT_PB_CONVERTER.convert(futuresLimit);
    }

    @NotNull
    static Money convertFromPbMoney(@NotNull final qlua.rpc.GetMoney.Money money) {
        return MONEY_PB_CONVERTER.convert(money);
    }

    @NotNull
    static MoneyLimit convertFromPbMoneyLimit(@NotNull final QluaStructures.MoneyLimit moneyLimit) {
        return MONEY_LIMIT_PB_CONVERTER.convert(moneyLimit);
    }

    @NotNull
    static Order convertFromPbOrder(@NotNull final QluaStructures.Order order) {
        return ORDER_PB_CONVERTER.convert(order);
    }

    @NotNull
    static PortfolioInfo convertFromPbPortfolioInfo(@NotNull final qlua.rpc.GetPortfolioInfo.PortfolioInfo portfolioInfo) {
        return PORTFOLIO_INFO_PB_CONVERTER.convert(portfolioInfo);
    }

    @NotNull
    static GetQuoteLevel2.QuoteEntry convertFromPbQuoteEntry(@NotNull final qlua.rpc.GetQuoteLevel2.QuoteEntry quoteEntry) {
        return QUOTE_ENTRY_PB_CONVERTER.convert(quoteEntry);
    }

    @NotNull
    static Security convertFromPbSecurity(@NotNull final QluaStructures.Security security) {
        return SECURITY_PB_CONVERTER.convert(security);
    }

    @NotNull
    static DataSourceTime convertFromDataSourceTime(@NotNull final QluaStructures.DataSourceTime time) {
        return DATA_SOURCE_TIME_PB_CONVERTER.convert(time);
    }
}
