package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetBuySellInfo;
import com.enfernuz.quik.lua.rpc.api.messages.GetBuySellInfoEx;
import com.enfernuz.quik.lua.rpc.api.messages.GetDepo;
import com.enfernuz.quik.lua.rpc.api.messages.GetQuoteLevel2;
import com.enfernuz.quik.lua.rpc.api.structures.*;
import com.enfernuz.quik.lua.rpc.serde.PbConverter;
import com.enfernuz.quik.lua.rpc.serde.SerdeException;
import com.google.common.base.Strings;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qlua.rpc.RPC;
import qlua.structs.QluaStructures;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

final class ProtobufSerdeUtils {

    static final Charset DEFAULT_PROTOBUF_CHARSET = StandardCharsets.UTF_8;

    private static final PbConverter<QluaStructures.DateTimeEntry, DateTimeEntry> DATE_TIME_ENTRY_PB_CONVERTER =
            DateTimeEntryPbSerde.INSTANCE;

    private static final PbConverter<qlua.rpc.GetBuySellInfo.BuySellInfo, GetBuySellInfo.BuySellInfo> BUY_SELL_INFO_PB_CONVERTER =
            BuySellInfoPbSerde.INSTANCE;

    private static final PbConverter<qlua.rpc.GetBuySellInfoEx.BuySellInfoEx, GetBuySellInfoEx.BuySellInfoEx> BUY_SELL_INFO_EX_PB_CONVERTER =
            BuySellInfoExPbSerde.INSTANCE;

    private static final PbConverter<QluaStructures.CandleEntry, CandleEntry> CANDLE_ENTRY_PB_CONVERTER =
            CandleEntryPbSerde.INSTANCE;

    private static final PbConverter<QluaStructures.Klass, ClassInfo> CLASS_INFO_PB_CONVERTER =
            ClassInfoPbSerde.INSTANCE;

    private static final PbConverter<qlua.rpc.GetDepo.Depo, Depo> DEPO_PB_CONVERTER = DepoPbSerde.INSTANCE;

    private static final PbConverter<QluaStructures.DepoLimit, DepoLimit> DEPO_LIMIT_PB_CONVERTER = DepoLimitPbSerde.INSTANCE;

    private static final PbConverter<QluaStructures.FuturesClientHolding, FuturesClientHolding> FUTURES_CLIENT_HOLDING_PB_CONVERTER =
            FuturesClientHoldingPbSerde.INSTANCE;

    private static final PbConverter<QluaStructures.FuturesLimit, FuturesLimit> FUTURES_LIMIT_PB_CONVERTER =
            FuturesLimitPbSerde.INSTANCE;

    private static final PbConverter<qlua.rpc.GetMoney.Money, Money> MONEY_PB_CONVERTER = MoneyPbSerde.INSTANCE;

    private static final PbConverter<QluaStructures.MoneyLimit, MoneyLimit> MONEY_LIMIT_PB_CONVERTER =
            MoneyLimitPbSerde.INSTANCE;

    private static final PbConverter<QluaStructures.Order, Order> ORDER_PB_CONVERTER = OrderPbSerde.INSTANCE;

    private static final PbConverter<qlua.rpc.GetPortfolioInfo.PortfolioInfo, PortfolioInfo> PORTFOLIO_INFO_PB_CONVERTER =
            PortfolioInfoPbSerde.INSTANCE;

    private static final PbConverter<qlua.rpc.GetQuoteLevel2.QuoteEntry, GetQuoteLevel2.QuoteEntry> QUOTE_ENTRY_PB_CONVERTER =
            QuoteEntryPbSerde.INSTANCE;

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
        return DATE_TIME_ENTRY_PB_CONVERTER.convertFromPb(dateTimeEntry);
    }

    static QluaStructures.DateTimeEntry convertToPbDateTimeEntry(@NotNull final DateTimeEntry dateTimeEntry) {
        return DATE_TIME_ENTRY_PB_CONVERTER.convertToPb(dateTimeEntry);
    }

    @NotNull
    static GetBuySellInfo.BuySellInfo convertFromPbBuySellInfo(@NotNull final qlua.rpc.GetBuySellInfo.BuySellInfo buySellInfo) {
        return BUY_SELL_INFO_PB_CONVERTER.convertFromPb(buySellInfo);
    }

    @NotNull
    static qlua.rpc.GetBuySellInfo.BuySellInfo convertToPbBuySellInfo(@NotNull final GetBuySellInfo.BuySellInfo buySellInfo) {
        return BUY_SELL_INFO_PB_CONVERTER.convertToPb(buySellInfo);
    }

    @NotNull
    static GetBuySellInfoEx.BuySellInfoEx convertFromPbBuySellInfoEx(@NotNull final qlua.rpc.GetBuySellInfoEx.BuySellInfoEx buySellInfoEx) {
        return BUY_SELL_INFO_EX_PB_CONVERTER.convertFromPb(buySellInfoEx);
    }

    @NotNull
    static qlua.rpc.GetBuySellInfoEx.BuySellInfoEx convertToPbBuySellInfoEx(@NotNull final GetBuySellInfoEx.BuySellInfoEx buySellInfoEx) {
        return BUY_SELL_INFO_EX_PB_CONVERTER.convertToPb(buySellInfoEx);
    }

    @NotNull
    static QluaStructures.CandleEntry convertToPbCandleEntry(@NotNull final CandleEntry candleEntry) {
        return CANDLE_ENTRY_PB_CONVERTER.convertToPb(candleEntry);
    }

    @NotNull
    static CandleEntry convertFromPbCandleEntry(@NotNull final QluaStructures.CandleEntry candleEntry) {
        return CANDLE_ENTRY_PB_CONVERTER.convertFromPb(candleEntry);
    }

    @NotNull
    static QluaStructures.Klass convertToPbClassInfo(@NotNull final ClassInfo classInfo) {
        return CLASS_INFO_PB_CONVERTER.convertToPb(classInfo);
    }

    @NotNull
    static ClassInfo convertFromPbClassInfo(@NotNull final QluaStructures.Klass classInfo) {
        return CLASS_INFO_PB_CONVERTER.convertFromPb(classInfo);
    }

    @NotNull
    static qlua.rpc.GetDepo.Depo convertToPbDepo(@NotNull final Depo depo) {
        return DEPO_PB_CONVERTER.convertToPb(depo);
    }

    @NotNull
    static Depo convertFromPbDepo(@NotNull final qlua.rpc.GetDepo.Depo depo) {
        return DEPO_PB_CONVERTER.convertFromPb(depo);
    }

    @NotNull
    static QluaStructures.DepoLimit convertToPbDepoLimit(@NotNull final DepoLimit depoLimit) {
        return DEPO_LIMIT_PB_CONVERTER.convertToPb(depoLimit);
    }

    @NotNull
    static DepoLimit convertFromPbDepoLimit(@NotNull final QluaStructures.DepoLimit depoLimit) {
        return DEPO_LIMIT_PB_CONVERTER.convertFromPb(depoLimit);
    }

    @NotNull
    static QluaStructures.FuturesClientHolding convertToPbFuturesClientHolding(@NotNull final FuturesClientHolding futuresClientHolding) {
        return FUTURES_CLIENT_HOLDING_PB_CONVERTER.convertToPb(futuresClientHolding);
    }

    @NotNull
    static FuturesClientHolding convertFromPbFuturesClientHolding(@NotNull final QluaStructures.FuturesClientHolding futuresClientHolding) {
        return FUTURES_CLIENT_HOLDING_PB_CONVERTER.convertFromPb(futuresClientHolding);
    }

    @NotNull
    static QluaStructures.FuturesLimit convertToPbFuturesLimit(@NotNull final FuturesLimit futuresLimit) {
        return FUTURES_LIMIT_PB_CONVERTER.convertToPb(futuresLimit);
    }

    @NotNull
    static FuturesLimit convertFromPbFuturesLimit(@NotNull final QluaStructures.FuturesLimit futuresLimit) {
        return FUTURES_LIMIT_PB_CONVERTER.convertFromPb(futuresLimit);
    }

    @NotNull
    static qlua.rpc.GetMoney.Money convertToPbMoney(@NotNull final Money money) {
        return MONEY_PB_CONVERTER.convertToPb(money);
    }

    @NotNull
    static Money convertFromPbMoney(@NotNull final qlua.rpc.GetMoney.Money money) {
        return MONEY_PB_CONVERTER.convertFromPb(money);
    }

    @NotNull
    static QluaStructures.MoneyLimit convertToPbMoneyLimit(@NotNull final MoneyLimit moneyLimit) {
        return MONEY_LIMIT_PB_CONVERTER.convertToPb(moneyLimit);
    }

    @NotNull
    static MoneyLimit convertFromPbMoneyLimit(@NotNull final QluaStructures.MoneyLimit moneyLimit) {
        return MONEY_LIMIT_PB_CONVERTER.convertFromPb(moneyLimit);
    }

    @NotNull
    static QluaStructures.Order convertToPbOrder(@NotNull final Order order) {
        return ORDER_PB_CONVERTER.convertToPb(order);
    }

    @NotNull
    static Order convertFromPbOrder(@NotNull final QluaStructures.Order order) {
        return ORDER_PB_CONVERTER.convertFromPb(order);
    }

    @NotNull
    static qlua.rpc.GetPortfolioInfo.PortfolioInfo convertToPbPortfolioInfo(@NotNull final PortfolioInfo portfolioInfo) {
        return PORTFOLIO_INFO_PB_CONVERTER.convertToPb(portfolioInfo);
    }

    @NotNull
    static PortfolioInfo convertFromPbPortfolioInfo(@NotNull final qlua.rpc.GetPortfolioInfo.PortfolioInfo portfolioInfo) {
        return PORTFOLIO_INFO_PB_CONVERTER.convertFromPb(portfolioInfo);
    }

    @NotNull
    static qlua.rpc.GetQuoteLevel2.QuoteEntry convertToPbQuoteEntry(@NotNull final GetQuoteLevel2.QuoteEntry quoteEntry) {
        return QUOTE_ENTRY_PB_CONVERTER.convertToPb(quoteEntry);
    }

    @NotNull
    static GetQuoteLevel2.QuoteEntry convertFromPbQuoteEntry(@NotNull final qlua.rpc.GetQuoteLevel2.QuoteEntry quoteEntry) {
        return QUOTE_ENTRY_PB_CONVERTER.convertFromPb(quoteEntry);
    }

    static void assertEquals(@NotNull final RPC.ProcedureType actual, @NotNull final RPC.ProcedureType expected) {

        if (actual != expected) {
            throw new SerdeException(
                    String.format("Неожиданный тип процедуры. Получено: %s, ожидалось: %s.", actual, expected)
            );
        }
    }
}
