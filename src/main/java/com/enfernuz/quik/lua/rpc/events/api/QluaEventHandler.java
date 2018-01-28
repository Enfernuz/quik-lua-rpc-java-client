package com.enfernuz.quik.lua.rpc.events.api;

import qlua.structs.QluaStructures;

public interface QluaEventHandler {

    default void onClose() {}

    default void onStop() {}

    default void onInit() {}

    default void onFirm(final QluaStructures.Firm firm) {}

    default void onAllTrade(final QluaStructures.AllTrade allTrade) {}

    default void onTrade(final QluaStructures.Trade trade) {}

    default void onOrder(final QluaStructures.Order order) {}

    default void onAccountBalance(final QluaStructures.AccountBalance accountBalance) {}

    default void onFuturesLimitChange(final QluaStructures.FuturesLimit futuresLimit) {}

    default void onFuturesLimitDelete(final QluaStructures.FuturesLimitDelete futuresLimitDelete) {}

    default void onFuturesClientHolding(final QluaStructures.FuturesClientHolding futuresClientHolding) {}

    default void onMoneyLimit(final QluaStructures.MoneyLimit moneyLimit) {}

    default void onMoneyLimitDelete(final QluaStructures.MoneyLimitDelete moneyLimitDelete) {}

    default void onDepoLimit(final QluaStructures.DepoLimit depoLimit) {}

    default void onDepoLimitDelete(final QluaStructures.DepoLimitDelete depoLimitDelete) {}

    default void onAccountPosition(final QluaStructures.AccountPosition accountPosition) {}

    default void onNegDeal(final QluaStructures.NegDeal negDeal) {}

    default void onNegTrade(final QluaStructures.NegTrade negTrade) {}

    default void onStopOrder(final QluaStructures.StopOrder stopOrder) {}

    default void onTransReply(final QluaStructures.Transaction transaction) {}

    default void onParam(final QluaStructures.ParamEventInfo param) {}

    default void onQuote(final QluaStructures.QuoteEventInfo quote) {}

    default void onCleanUp() {}

}
