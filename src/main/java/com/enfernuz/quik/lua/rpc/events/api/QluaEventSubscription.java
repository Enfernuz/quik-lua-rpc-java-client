package com.enfernuz.quik.lua.rpc.events.api;

import com.google.common.collect.ImmutableSet;

/**
 * Менеджер подписок на события API QLua терминала QUIK.
 */
public interface QluaEventSubscription {

    /**
     * Добавляет подписку на событие заданного типа.
     *
     * @param eventType  тип события
     */
    void subscribe(QluaEvent.EventType eventType);

    /**
     * Добавляет подписки на события заданных типов.
     *
     * @param eventTypes  типы событий
     */
    void subscribe(Iterable<? extends QluaEvent.EventType> eventTypes);

    /**
     * Добавляет подписки на события заданных типов.
     *
     * @param eventTypes  типы событий
     */
    void subscribe(QluaEvent.EventType... eventTypes);

    /**
     * Добавляет подписки на события всех типов.
     */
    void subscribeToEverything();

    /**
     * Удаляет подписку на событие заданного типа.
     *
     * @param eventType  тип события
     */
    void unsubscribe(QluaEvent.EventType eventType);

    /**
     * Удаляет подписки на события заданных типов.
     *
     * @param eventTypes  типы событий
     */
    void unsubscribe(Iterable<? extends QluaEvent.EventType> eventTypes);

    /**
     * Удаляет подписки на события заданных типов.
     *
     * @param eventTypes  типы событий
     */
    void unsubscribe(QluaEvent.EventType... eventTypes);

    /**
     * Удаляет подписки на событиях всех типов.
     */
    void unsubscribeFromEverything();

    /**
     * Получает неизменяемый набор типов событий, подписки на которые активны в данный момент.
     *
     * @return {@link ImmutableSet неизменяемый набор} типов событий, подписки на которые активны в данный момент
     */
    ImmutableSet<QluaEvent.EventType> getCurrentSubscription();

}
