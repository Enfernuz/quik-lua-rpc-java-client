package com.enfernuz.quik.lua.rpc.events.api;

import com.enfernuz.quik.lua.rpc.api.structures.*;
import org.jetbrains.annotations.NotNull;

/**
 * Обработчик событий API QLua терминала QUIK.
 */
public interface QluaEventHandler {

    /**
     * Функция обратного вызова для события терминала <b>OnClose</b>.
     * <br/>
     * Событие происходит перед закрытием терминала QUIK и при выгрузке файла qlua.dll
     */
    default void onClose() {}

    /**
     * Функция обратного вызова для события терминала <b>OnStop</b>.
     * <br/>
     * Событие происходит при остановке скрипта из диалога управления и при закрытии терминала QUIK.
     *
     * @param stopEventInfo  аргументы функции обратного вызова OnStop
     */
    default void onStop(@NotNull final StopEventInfo stopEventInfo) {}

    /**
     * Функция обратного вызова для события терминала <b>OnConnected</b>.
     * <br/>
     * Событие происходит при установлении связи с сервером QUIK и получении терминалом описания хотя бы одного класса.
     * <br/>
     * Если в течение торгового дня терминал получает новый класс, то функция вызывается еще раз, при этом параметр
     * вызова flag принимает значение «false».
     */
    default void onConnected(@NotNull final ConnectedEventInfo connectedEventInfo) {}

    /**
     * Функция обратного вызова для события терминала <b>OnDisconnected</b>.
     * <br/>
     * Событие происходит при отключении от сервера QUIK.
     */
    default void onDisconnected() {}

    /**
     * Функция обратного вызова для события терминала <b>OnInit</b>.
     * <br/>
     * Событие происходит перед вызовом функции main().
     */
    default void onInit() {}

    /**
     * Функция обратного вызова для события терминала <b>OnFirm</b>.
     * <br/>
     * Событие происходит при получении описания новой фирмы от сервера.
     *
     * @param firm  новая фирма
     */
    default void onFirm(@NotNull final Firm firm) {}

    /**
     * Функция обратного вызова для события терминала <b>OnAllTrade</b>.
     * <br/>
     * Событие происходит при получении обезличенной сделки.
     *
     * @param allTrade  обезличенная сделка
     */
    default void onAllTrade(@NotNull final AllTrade allTrade) {}

    /**
     * Функция обратного вызова для события терминала <b>OnTrade</b>.
     * <br/>
     * Событие происходит при получении сделки или при изменении параметров существующей сделки.
     *
     * @param trade  сделка
     */
    default void onTrade(@NotNull final Trade trade) {}

    /**
     * Функция обратного вызова для события терминала <b>OnOrder</b>.
     * <br/>
     * Событие происходит при получении новой заявки или при изменении параметров существующей заявки.
     *
     * @param order  заявка
     */
    default void onOrder(@NotNull final Order order) {}

    /**
     * Функция обратного вызова для события терминала <b>OnAccountBalance</b>.
     * <br/>
     * Событие происходит при получении изменений текущей позиции по счету.
     *
     * @param accountBalance  текущие позиции по счетам
     */
    default void onAccountBalance(@NotNull final AccountBalance accountBalance) {}

    /**
     * Функция обратного вызова для события терминала <b>OnFuturesLimitChange</b>.
     * <br/>
     * Событие происходит при получении изменений ограничений по срочному рынку.
     *
     * @param futuresLimit  текущие значения лимита по срочному рынку
     */
    default void onFuturesLimitChange(@NotNull final FuturesLimit futuresLimit) {}

    /**
     * Функция обратного вызова для события терминала <b>OnFuturesLimitDelete</b>.
     * <br/>
     * Событие происходит при удалении лимита по срочному рынку.
     *
     * @param futuresLimitDelete  удаляемый лимит по срочному рынку
     */
    default void onFuturesLimitDelete(@NotNull final FuturesLimitDelete futuresLimitDelete) {}

    /**
     * Функция обратного вызова для события терминала <b>OnFuturesClientHolding</b>.
     * <br/>
     * Событие происходит при изменении позиции по срочному рынку.
     *
     * @param futuresClientHolding  описание позиции по срочному рынку
     */
    default void onFuturesClientHolding(@NotNull final FuturesClientHolding futuresClientHolding) {}

    /**
     * Функция обратного вызова для события терминала <b>OnMoneyLimit</b>.
     * <br/>
     * Событие происходит при получении изменений по денежному лимиту клиента.
     *
     * @param moneyLimit  текущие значения денежного лимита
     */
    default void onMoneyLimit(@NotNull final MoneyLimit moneyLimit) {}

    /**
     * Функция обратного вызова для события терминала <b>OnMoneyLimitDelete</b>.
     * <br/>
     * Событие происходит при удалении денежного лимита.
     *
     * @param moneyLimitDelete  удаляемый денежный лимит
     */
    default void onMoneyLimitDelete(@NotNull final MoneyLimitDelete moneyLimitDelete) {}

    /**
     * Функция обратного вызова для события терминала <b>OnDepoLimit</b>.
     * <br/>
     * Событие происходит при получении изменений лимита по бумагам.
     *
     * @param depoLimit  текущие значения лимитов по бумагам
     */
    default void onDepoLimit(@NotNull final DepoLimit depoLimit) {}

    /**
     * Функция обратного вызова для события терминала <b>OnDepoLimitDelete</b>.
     * <br/>
     * Событие происходит при удалении клиентского лимита по бумагам.
     *
     * @param depoLimitDelete  удаляемый лимит по бумагам
     */
    default void onDepoLimitDelete(@NotNull final DepoLimitDelete depoLimitDelete) {}

    /**
     * Функция обратного вызова для события терминала <b>OnAccountPosition</b>.
     * <br/>
     * Событие происходит при изменении денежной позиции по счету.
     *
     * @param accountPosition  текущие значения денежной позиции по счету
     */
    default void onAccountPosition(@NotNull final AccountPosition accountPosition) {}

    /**
     * Функция обратного вызова для события терминала <b>OnNegDeal</b>.
     * <br/>
     * Событие происходит при получении внебиржевой заявки или при изменении параметров существующей внебиржевой заявки.
     *
     * @param negDeal  заявка на внебиржевые сделки
     */
    default void onNegDeal(@NotNull final NegDeal negDeal) {}

    /**
     * Функция обратного вызова для события терминала <b>OnNegTrade</b>.
     * <br/>
     * Событие происходит при получении сделки для исполнения или при изменении параметров существующей сделки
     * для исполнения.
     *
     * @param negTrade  сделка для исполнения
     */
    default void onNegTrade(@NotNull final NegTrade negTrade) {}

    /**
     * Функция обратного вызова для события терминала <b>OnStopOrder</b>.
     * <br/>
     * Событие происходит при получении новой стоп-заявки или при изменении параметров существующей стоп-заявки.
     *
     * @param stopOrder  стоп-заявка
     */
    default void onStopOrder(@NotNull final StopOrder stopOrder) {}

    /**
     * Функция обратного вызова для события терминала <b>OnTransReply</b>.
     * <br/>
     * Событие происходит при получении ответа на транзакцию пользователя, отправленную с помощью любого плагина
     * Рабочего места QUIK (в том числе QLua).
     * Событие не происходит для транзакций, отправленных с помощью Trans2quik.dll, QPILE, или динамической загрузки
     * транзакций из файла.
     *
     * @param transReply  описание транзакции
     */
    default void onTransReply(@NotNull final TransReply transReply) {}

    /**
     * Функция обратного вызова для события терминала <b>OnParam</b>.
     * <br/>
     * Событие происходит при изменении текущих параметров.
     *
     * @param param  объект, содержащий код бумаги и код класса инструмента, по которому изменились текущие параметры
     */
    default void onParam(@NotNull final ParamEventInfo param) {}

    /**
     * Функция обратного вызова для события терминала <b>OnQuote</b>.
     * <br/>
     * Событие происходит при получении изменения стакана котировок.
     *
     * @param quote  объект, содержащий код бумаги и код класса инструмента, по которому изменился стакан котировок
     */
    default void onQuote(@NotNull final QuoteEventInfo quote) {}

    /**
     * Функция обратного вызова для события терминала <b>OnCleanUp</b>.
     * <br/>
     * Событие происходит в следующих случаях:
     * <ul>
     *     <li>смена сервера QUIK внутри торговой сессии;</li>
     *     <li>смена пользователя, которым выполняется подключение к серверу QUIK, внутри торговой сессии;</li>
     *     <li>смена сессии.</li>
     * </ul>
     */
    default void onCleanUp() {}

    //FIXME: javadoc
    default void onDataSourceUpdate(@NotNull final DataSourceUpdateInfo dataSourceUpdate) {};
}
