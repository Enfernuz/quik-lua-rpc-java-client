package com.enfernuz.quik.lua.rpc.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import lombok.Value;

@Value
public class ServiceError {

    int code;
    String message;

    @JsonCreator
    public ServiceError(
            @JsonProperty(value = "code", required = true) final int code,
            @JsonProperty(value = "message", required = true) final String message) {

        this.code = code;
        this.message = message;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("code", code)
                .add("message", message)
                .toString();
    }
}
