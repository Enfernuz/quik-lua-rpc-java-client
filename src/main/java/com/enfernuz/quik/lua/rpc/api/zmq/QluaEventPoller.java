package com.enfernuz.quik.lua.rpc.api.zmq;

import com.enfernuz.quik.lua.rpc.events.api.QluaEvent;
import com.enfernuz.quik.lua.rpc.events.api.QluaEventSubscription;
import com.enfernuz.quik.lua.rpc.io.Gateway;

/**
 * Компонент, опрашивающий удалённый RPC-сервис <b>quik-lua-rpc</b> на предмет появления новых событий API QLua
 * терминала QUIK.
 * @see <a href="https://github.com/Enfernuz/quik-lua-rpc">quik-lua-rpc</a>
 */
interface QluaEventPoller extends QluaEventSubscription, Gateway {

    /**
     * Опрашивает удалённый RPC-сервис <b>quik-lua-rpc</b> на предмет появления нового события API QLua терминала QUIK.
     *
     * @return {@link QluaEvent событие} API QLua терминала QUIK или null в случае отсутствия новых событий
     * @throws PollingException в случае ошибки при опросе удалённого RPC-сервиса <b>quik-lua-rpc</b> на предмет
     * появления нового события API QLua терминала QUIK
     */
    QluaEvent poll() throws PollingException;

    /**
     * Исключение, возникающее в случае ошибки при опросе удалённого RPC-сервиса <b>quik-lua-rpc</b> на предмет
     * появления нового события API QLua терминала QUIK.
     */
    final class PollingException extends RuntimeException {

        /**
         * Создаёт новое исключение с заданным сообщением.
         *
         * @param message  заданное сообщение. Сообщение сохраняется для дальнейшего его получения с помощью метода
         * {@link #getMessage()}
         */
        public PollingException(final String message) {
            super(message);
        }

        /**
         * Создаёт новое исключение с заданным сообщением и причиной.
         *
         * @param message  заданное сообщение. Сообщение сохраняется для дальнейшего его получения с помощью метода
         * {@link #getMessage()}
         * @param cause  заданное сообщение. Сообщение сохраняется для дальнейшего его получения с помощью метода
         * {@link #getCause()}. Значение null разрешено и означает, что причина неизвестна или не существует
         */
        public PollingException(final String message, final Throwable cause) {
            super(message, cause);
        }
    }
}
