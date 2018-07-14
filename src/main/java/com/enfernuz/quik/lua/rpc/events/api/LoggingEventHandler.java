package com.enfernuz.quik.lua.rpc.events.api;

import com.enfernuz.quik.lua.rpc.events.api.structures.*;
import org.slf4j.*;
import qlua.structs.QluaStructures;

/**
 * Обработчик событий API QLua терминала QUIK, журналирующий (логгирующий) события и их данные.
 */
public enum LoggingEventHandler implements QluaEventHandler {

    /**
     * Экземпляр журналирующего обработчика событий.
     */
    INSTANCE;

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingEventHandler.class);

    @Override
    public void onClose() {
        LOGGER.info("onClose");
    }

    @Override
    public void onStop(final StopEventInfo stopEventInfo) {
        LOGGER.info("onStop:\n{}", stopEventInfo);
    }

    @Override
    public void onConnected(final ConnectedEventInfo connectedEventInfo) {
        LOGGER.info("onConnected:\n{}", connectedEventInfo);
    }

    @Override
    public void onDisconnected() {
        LOGGER.info("onDisconnected");
    }

    @Override
    public void onInit() {
        LOGGER.info("onInit");
    }

    @Override
    public void onFirm(final Firm firm) {
        LOGGER.info("onFirm:\n{}", firm);
    }

    @Override
    public void onAllTrade(final AllTrade allTrade) {
        LOGGER.info("onAllTrade:\n{}", allTrade);
    }

    @Override
    public void onTrade(final Trade trade) {
        LOGGER.info("onTrade:\n{}", trade);
    }

    @Override
    public void onOrder(final Order order) {
        LOGGER.info("onOrder:\n{}", order);
    }

    @Override
    public void onAccountBalance(final AccountBalance accountBalance) {
        LOGGER.info("onAccountBalance:\n{}", accountBalance);
    }

    @Override
    public void onFuturesLimitChange(final FuturesLimit futuresLimit) {
        LOGGER.info("onFuturesLimitChange:\n{}", futuresLimit);
    }

    @Override
    public void onFuturesLimitDelete(final FuturesLimitDelete futuresLimitDelete) {
        LOGGER.info("onFuturesLimitDelete:\n{}", futuresLimitDelete);
    }

    @Override
    public void onFuturesClientHolding(final FuturesClientHolding futuresClientHolding) {
        LOGGER.info("onFuturesClientHolding:\n{}", futuresClientHolding);
    }

    @Override
    public void onMoneyLimit(final MoneyLimit moneyLimit) {
        LOGGER.info("onMoneyLimit:\n{}", moneyLimit);
    }

    @Override
    public void onMoneyLimitDelete(final MoneyLimitDelete moneyLimitDelete) {
        LOGGER.info("onMoneyLimitDelete:\n{}", moneyLimitDelete);
    }

    @Override
    public void onDepoLimit(final DepoLimit depoLimit) {
        LOGGER.info("onDepoLimit:\n{}", depoLimit);
    }

    @Override
    public void onDepoLimitDelete(final DepoLimitDelete depoLimitDelete) {
        LOGGER.info("onDepoLimitDelete:\n{}", depoLimitDelete);
    }

    @Override
    public void onAccountPosition(final QluaStructures.AccountPosition accountPosition) {
        LOGGER.info("onAccountPosition:\n{}", accountPosition);
    }

    @Override
    public void onNegDeal(final QluaStructures.NegDeal negDeal) {
        LOGGER.info("onNegDeal:\n{}", negDeal);
    }

    @Override
    public void onNegTrade(final QluaStructures.NegTrade negTrade) {
        LOGGER.info("onNegTrade:\n{}", negTrade);
    }

    @Override
    public void onStopOrder(final QluaStructures.StopOrder stopOrder) {
        LOGGER.info("onStopOrder:\n{}", stopOrder);
    }

    @Override
    public void onTransReply(final QluaStructures.Transaction transaction) {
        LOGGER.info("onTransReply:\n{}", transaction);
    }

    @Override
    public void onParam(final QluaStructures.ParamEventInfo param) {
        LOGGER.info("onParam:\n{}", param);
    }

    @Override
    public void onQuote(final QluaStructures.QuoteEventInfo quote) {
        LOGGER.info("onQuote:\n{}", quote);
    }

    @Override
    public void onCleanUp() {
        LOGGER.info("onCleanUp");
    }
}
