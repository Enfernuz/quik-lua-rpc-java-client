package com.enfernuz.quik.lua.rpc.events.api;

import com.google.common.collect.ImmutableList;
import qlua.events.QluaEvents;

/**
 * Журнала для регистрации обработчиков событий API QLua терминала QUIK.
 */
public interface QluaEventHandlerRegistry {

    /**
     * Регистрирует заданный обработчик событий в этом журнале.
     *
     * @param eventHandler  обработчик событий
     */
    void register(QluaEventHandler eventHandler);

    /**
     * Регистрирует заданные обработчики событий в этом журнале.
     *
     * @param eventHandlers  обработчики событий
     */
    void register(Iterable<? extends QluaEventHandler> eventHandlers);

    /**
     * Отменяет регистрацию заданного обработчика событий в этом журнале.
     *
     * @param eventHandler  обработчик событий
     */
    void unregister(QluaEventHandler eventHandler);

    /**
     * Отменяет регистрацию заданных обработчиков событий в этом журнале.
     *
     * @param eventHandlers  обработчики событий
     */
    void unregister(Iterable<? extends QluaEventHandler> eventHandlers);

    /**
     * Получает список зарегистрированных в этом журнале обработчиков событий.
     *
     * @return список зарегистрированных в этом журнале обработчиков событий. Порядок появления обработчиков в списке
     * совпадает с порядком их регистрации в этом журнале.
     */
    ImmutableList<QluaEventHandler> getRegisteredEventHandlers();
}
