package com.enfernuz.quik.lua.rpc.api.messages;

import com.enfernuz.quik.lua.rpc.api.RemoteProcedure;
import com.enfernuz.quik.lua.rpc.api.RpcArgs;
import com.enfernuz.quik.lua.rpc.api.RpcResult;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.Value;
import org.jetbrains.annotations.NotNull;

public final class GetInfoParam implements RemoteProcedure {

    private GetInfoParam() {}

    @EqualsAndHashCode
    public static final class Args implements RpcArgs<GetInfoParam> {

        private static final String PARAM_NAME = "param_name";

        @JsonProperty(PARAM_NAME)
        private final String paramName;

        public Args(@NonNull final String paramName) {
            this.paramName = paramName;
        }

        @JsonIgnore
        public String getParamName() {
            return paramName;
        }

        @NotNull
        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add(PARAM_NAME, paramName)
                    .toString();
        }
    }

    @Value
    public static class Result implements RpcResult<GetInfoParam> {

        private static final String INFO_PARAM = "info_param";

        String infoParam;

        @JsonCreator
        public Result(@JsonProperty(value = INFO_PARAM, required = true) @NonNull final String infoParam) {
            this.infoParam = infoParam;
        }

        @NotNull
        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add(INFO_PARAM, infoParam)
                    .toString();
        }
    }
}
