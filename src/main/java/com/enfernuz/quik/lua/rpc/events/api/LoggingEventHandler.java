package com.enfernuz.quik.lua.rpc.events.api;

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
    public void onStop() {
        LOGGER.info("onStop");
    }

    @Override
    public void onConnected() {
        LOGGER.info("onConnected");
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
    public void onFirm(QluaStructures.Firm firm) {
        LOGGER.info("onFirm: {}", firm);
    }

    @Override
    public void onAllTrade(QluaStructures.AllTrade allTrade) {
        LOGGER.info("onAllTrade: {}", allTrade);
    }

    @Override
    public void onTrade(QluaStructures.Trade trade) {
        LOGGER.info("onTrade: {}", trade);
    }

    @Override
    public void onOrder(QluaStructures.Order order) {
        LOGGER.info("onOrder: {}", order);
    }

    @Override
    public void onAccountBalance(QluaStructures.AccountBalance accountBalance) {
        LOGGER.info("onAccountBalance: {}", accountBalance);
    }

    @Override
    public void onFuturesLimitChange(QluaStructures.FuturesLimit futuresLimit) {
        LOGGER.info("onFuturesLimitChange: {}", futuresLimit);
    }

    @Override
    public void onFuturesLimitDelete(QluaStructures.FuturesLimitDelete futuresLimitDelete) {
        LOGGER.info("onFuturesLimitDelete: {}", futuresLimitDelete);
    }

    @Override
    public void onFuturesClientHolding(QluaStructures.FuturesClientHolding futuresClientHolding) {
        LOGGER.info("onFuturesClientHolding: {}", futuresClientHolding);
    }

    @Override
    public void onMoneyLimit(QluaStructures.MoneyLimit moneyLimit) {
        LOGGER.info("onMoneyLimit: {}", moneyLimit);
    }

    @Override
    public void onMoneyLimitDelete(QluaStructures.MoneyLimitDelete moneyLimitDelete) {
        LOGGER.info("onMoneyLimitDelete: {}", moneyLimitDelete);
    }

    @Override
    public void onDepoLimit(QluaStructures.DepoLimit depoLimit) {
        LOGGER.info("onDepoLimit: {}", depoLimit);
    }

    @Override
    public void onDepoLimitDelete(QluaStructures.DepoLimitDelete depoLimitDelete) {
        LOGGER.info("onDepoLimitDelete: {}", depoLimitDelete);
    }

    @Override
    public void onAccountPosition(QluaStructures.AccountPosition accountPosition) {
        LOGGER.info("onAccountPosition: {}", accountPosition);
    }

    @Override
    public void onNegDeal(QluaStructures.NegDeal negDeal) {
        LOGGER.info("onNegDeal: {}", negDeal);
    }

    @Override
    public void onNegTrade(QluaStructures.NegTrade negTrade) {
        LOGGER.info("onNegTrade: {}", negTrade);
    }

    @Override
    public void onStopOrder(QluaStructures.StopOrder stopOrder) {
        LOGGER.info("onStopOrder: {}", stopOrder);
    }

    @Override
    public void onTransReply(QluaStructures.Transaction transaction) {
        LOGGER.info("onTransReply: {}", transaction);
    }

    @Override
    public void onParam(QluaStructures.ParamEventInfo param) {
        LOGGER.info("onParam: {}", param);
    }

    @Override
    public void onQuote(QluaStructures.QuoteEventInfo quote) {
        LOGGER.info("onQuote: {}", quote);
    }

    @Override
    public void onCleanUp() {
        LOGGER.info("onCleanUp");
    }
}
