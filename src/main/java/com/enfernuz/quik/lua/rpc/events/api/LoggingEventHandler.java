package com.enfernuz.quik.lua.rpc.events.api;

import com.enfernuz.quik.lua.rpc.api.structures.*;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Обработчик событий API QLua терминала QUIK, журналирующий (логгирующий) события и их данные.
 */
public enum LoggingEventHandler implements QluaEventHandler {

    /**
     * Экземпляр журналирующего обработчика событий.
     */
    INSTANCE;

    private static final Logger LOGGER = LoggerFactory.getLogger("qlua-events");

    @Override
    public void onClose() {
        LOGGER.info("onClose");
    }

    @Override
    public void onStop(@NotNull final StopEventInfo stopEventInfo) {
        LOGGER.info("onStop:\n{}", stopEventInfo);
    }

    @Override
    public void onConnected(@NotNull final ConnectedEventInfo connectedEventInfo) {
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
    public void onFirm(@NotNull final Firm firm) {
        LOGGER.info("onFirm:\n{}", firm);
    }

    @Override
    public void onAllTrade(@NotNull final AllTrade allTrade) {
        LOGGER.info("onAllTrade:\n{}", allTrade);
    }

    @Override
    public void onTrade(@NotNull final Trade trade) {
        LOGGER.info("onTrade:\n{}", trade);
    }

    @Override
    public void onOrder(@NotNull final Order order) {
        LOGGER.info("onOrder:\n{}", order);
    }

    @Override
    public void onAccountBalance(@NotNull final AccountBalance accountBalance) {
        LOGGER.info("onAccountBalance:\n{}", accountBalance);
    }

    @Override
    public void onFuturesLimitChange(@NotNull final FuturesLimit futuresLimit) {
        LOGGER.info("onFuturesLimitChange:\n{}", futuresLimit);
    }

    @Override
    public void onFuturesLimitDelete(@NotNull final FuturesLimitDelete futuresLimitDelete) {
        LOGGER.info("onFuturesLimitDelete:\n{}", futuresLimitDelete);
    }

    @Override
    public void onFuturesClientHolding(@NotNull final FuturesClientHolding futuresClientHolding) {
        LOGGER.info("onFuturesClientHolding:\n{}", futuresClientHolding);
    }

    @Override
    public void onMoneyLimit(@NotNull final MoneyLimit moneyLimit) {
        LOGGER.info("onMoneyLimit:\n{}", moneyLimit);
    }

    @Override
    public void onMoneyLimitDelete(@NotNull final MoneyLimitDelete moneyLimitDelete) {
        LOGGER.info("onMoneyLimitDelete:\n{}", moneyLimitDelete);
    }

    @Override
    public void onDepoLimit(@NotNull final DepoLimit depoLimit) {
        LOGGER.info("onDepoLimit:\n{}", depoLimit);
    }

    @Override
    public void onDepoLimitDelete(@NotNull final DepoLimitDelete depoLimitDelete) {
        LOGGER.info("onDepoLimitDelete:\n{}", depoLimitDelete);
    }

    @Override
    public void onAccountPosition(@NotNull final AccountPosition accountPosition) {
        LOGGER.info("onAccountPosition:\n{}", accountPosition);
    }

    @Override
    public void onNegDeal(@NotNull final NegDeal negDeal) {
        LOGGER.info("onNegDeal:\n{}", negDeal);
    }

    @Override
    public void onNegTrade(@NotNull final NegTrade negTrade) {
        LOGGER.info("onNegTrade:\n{}", negTrade);
    }

    @Override
    public void onStopOrder(@NotNull final StopOrder stopOrder) {
        LOGGER.info("onStopOrder:\n{}", stopOrder);
    }

    @Override
    public void onTransReply(@NotNull final TransReply transReply) {
        LOGGER.info("onTransReply:\n{}", transReply);
    }

    @Override
    public void onParam(@NotNull final ParamEventInfo param) {
        LOGGER.info("onParam:\n{}", param);
    }

    @Override
    public void onQuote(@NotNull final QuoteEventInfo quote) {
        LOGGER.info("onQuote:\n{}", quote);
    }

    @Override
    public void onCleanUp() {
        LOGGER.info("onCleanUp");
    }

    @Override
    public void onDataSourceUpdate(@NotNull final DataSourceUpdateInfo dataSourceUpdate) {
        LOGGER.info("onDataSourceUpdate:\n{}", dataSourceUpdate);
    }
}
