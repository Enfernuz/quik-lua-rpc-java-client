package com.enfernuz.quik.lua.rpc.client.api.exception;

public final class RpcClientException extends RuntimeException {

    public RpcClientException(String message) {
        super(message);
    }

    public RpcClientException(String message, Throwable cause) {
        super(message, cause);
    }

}
