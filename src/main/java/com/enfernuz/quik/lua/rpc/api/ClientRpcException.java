package com.enfernuz.quik.lua.rpc.api;

public final class ClientRpcException extends RpcException {

    public ClientRpcException(final String message) {
        super(message);
    }

    public ClientRpcException(final Throwable cause) {
        super(cause);
    }

    public ClientRpcException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
