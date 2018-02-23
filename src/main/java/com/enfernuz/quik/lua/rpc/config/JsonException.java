package com.enfernuz.quik.lua.rpc.config;

import com.fasterxml.jackson.core.JsonProcessingException;

final class JsonException extends JsonProcessingException {

    public JsonException(final String message) {
        super(message);
    }

    public JsonException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
