package com.enfernuz.quik.lua.rpc.client.api.exception;

import java.io.IOException;

public final class RpcGatewayException extends IOException {

    public RpcGatewayException(String message) {
        super(message);
    }

    public RpcGatewayException(String message, Throwable cause) {
        super(message, cause);
    }
}
