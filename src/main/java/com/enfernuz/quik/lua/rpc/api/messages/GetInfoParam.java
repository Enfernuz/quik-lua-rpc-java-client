package com.enfernuz.quik.lua.rpc.api.messages;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import lombok.NonNull;
import lombok.Value;

public final class GetInfoParam {

    private GetInfoParam() {}

    @Value
    public static class Request {

        @NonNull String paramName;

        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add("param_name", paramName)
                    .toString();
        }
    }

    @Value
    public static class Result {

        String infoParam;

        @JsonCreator
        public Result(final @JsonProperty(value = "info_param") String infoParam) {
            this.infoParam = infoParam;
        }

        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add("info_param", infoParam)
                    .toString();
        }
    }
}
