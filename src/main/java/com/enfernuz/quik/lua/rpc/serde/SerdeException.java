package com.enfernuz.quik.lua.rpc.serde;

public class SerdeException extends RuntimeException {

    public SerdeException(final String message) {
        super(message);
    }

    public SerdeException(final Throwable cause) {
        super(cause);
    }

    public SerdeException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
