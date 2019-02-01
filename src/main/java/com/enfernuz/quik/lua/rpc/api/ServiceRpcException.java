package com.enfernuz.quik.lua.rpc.api;

import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.Value;

@Value
@EqualsAndHashCode(callSuper = true)
public class ServiceRpcException extends RpcException {

    @NonNull ServiceError error;

    public ServiceRpcException(final ServiceError error) {
        this.error = error;
    }

    @Override
    public String getMessage() {
        return error.getMessage();
    }
}
