package com.enfernuz.quik.lua.rpc.api;

public abstract class RpcException extends RuntimeException {

    protected RpcException() {}

    protected RpcException(final String message) {
        super(message);
    }

    protected RpcException(final Throwable cause) {
        super(cause);
    }

    protected RpcException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
