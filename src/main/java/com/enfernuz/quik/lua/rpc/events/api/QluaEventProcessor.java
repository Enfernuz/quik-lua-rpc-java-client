package com.enfernuz.quik.lua.rpc.events.api;

import com.enfernuz.quik.lua.rpc.io.Gateway;

/**
 * Обработчик очереди событий API QLua терминала QUIK, полученных из удалённого RPC-сервиса <b>quik-lua-rpc</b>.
 * @see <a href="https://github.com/Enfernuz/quik-lua-rpc">quik-lua-rpc</a>
 */
public interface QluaEventProcessor extends QluaEventHandlerRegistry, QluaEventSubscription, Gateway {

    /**
     * Обрабатывает очередь полученных события до того момента, пока она не окажется пуста.
     * <br/>
     * Запускает зарегистрированные обработчики событий по полученным событиям в порядке получения этих событий.
     *
     * @throws QluaEventProcessingException  в случае ошибки при обработке событий
     */
    void process() throws QluaEventProcessingException;

    // process up to maxEvents events
    /**
     * Обрабатывает несколько полученных событий в очереди вплоть до заданного количества.
     * <br/>
     * Запускает зарегистрированные обработчики событий по полученным событиям в порядке получения этих событий. После
     * обработки заданного количества значений или при заканчивании очереди событий обработка прекращается.
     *
     * @param maxEvents  заданное максимальное количество событий для обработки
     * @throws QluaEventProcessingException  в случае ошибки при обработке событий
     */
    void process(int maxEvents) throws QluaEventProcessingException;

    /**
     * Исключение, возникающее в случае ошибки при обработке очереди событий API QLua терминала QUIK.
     */
    final class QluaEventProcessingException extends RuntimeException {

        /**
         * Создаёт новое исключение с заданным сообщением и причиной.
         *
         * @param message  заданное сообщение. Сообщение сохраняется для дальнейшего его получения с помощью метода
         * {@link #getMessage()}
         * @param cause  заданное сообщение. Сообщение сохраняется для дальнейшего его получения с помощью метода
         * {@link #getCause()}. Значение null разрешено и означает, что причина неизвестна или не существует
         */
        public QluaEventProcessingException(final String message, final Throwable cause) {
            super(message, cause);
        }

        /**
         * Создаёт новое исключение с заданным сообщением.
         *
         * @param message  заданное сообщение. Сообщение сохраняется для дальнейшего его получения с помощью метода
         * {@link #getMessage()}
         */
        public QluaEventProcessingException(final String message) {
            super(message);
        }
    }
}
