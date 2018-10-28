package com.enfernuz.quik.lua.rpc.api;

public class RpcException extends RuntimeException {

    public RpcException() {}

    public RpcException(final String message) {
        super(message);
    }

    public RpcException(final Throwable cause) {
        super(cause);
    }

    public RpcException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
