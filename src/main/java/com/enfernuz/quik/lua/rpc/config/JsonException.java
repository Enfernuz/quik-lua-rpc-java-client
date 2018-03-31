package com.enfernuz.quik.lua.rpc.config;

import com.fasterxml.jackson.core.JsonProcessingException;

/**
 * Исключение, возникающее в случае ошибки при обработки файла, содержащего данные в формате JSON.
 */
final class JsonException extends JsonProcessingException {

    /**
     * Создаёт новое исключение с заданным сообщением.
     *
     * @param message  заданное сообщение. Сообщение сохраняется для дальнейшего его получения с помощью метода
     * {@link #getMessage()}
     */
    public JsonException(final String message) {
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
    public JsonException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
