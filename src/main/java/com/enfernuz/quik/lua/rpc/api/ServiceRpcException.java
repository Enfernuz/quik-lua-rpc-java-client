package com.enfernuz.quik.lua.rpc.api;

import lombok.NonNull;
import lombok.Value;

@Value
public class ServiceRpcException extends RpcException {

    @NonNull ServiceError error;

    public ServiceRpcException(@NonNull final ServiceError error) {
        this.error = error;
    }
}
