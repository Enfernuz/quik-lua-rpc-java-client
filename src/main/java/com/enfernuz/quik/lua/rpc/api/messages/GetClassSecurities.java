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

public final class GetClassSecurities implements RemoteProcedure {

    private GetClassSecurities() {}

    @EqualsAndHashCode
    public static final class Args implements RpcArgs<GetClassSecurities> {

        private static final String CLASS_CODE = "class_code";

        @JsonProperty(CLASS_CODE)
        private final String classCode;

        public Args(@NonNull final String classCode) {
            this.classCode = classCode;
        }

        @JsonIgnore
        public String getClassCode() {
            return classCode;
        }

        @NotNull
        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add(CLASS_CODE, classCode)
                    .toString();
        }
    }

    @Value
    public static class Result implements RpcResult<GetClassSecurities> {

        private static final String CLASS_SECURITIES = "class_securities";

        String classSecurities;

        @JsonCreator
        public Result(@JsonProperty(value = CLASS_SECURITIES, required = true) @NonNull final String classSecurities) {
            this.classSecurities = classSecurities;
        }

        @NotNull
        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add(CLASS_SECURITIES, classSecurities)
                    .toString();
        }
    }
}
