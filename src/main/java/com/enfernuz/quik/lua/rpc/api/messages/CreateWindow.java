package com.enfernuz.quik.lua.rpc.api.messages;

import com.enfernuz.quik.lua.rpc.api.RemoteProcedure;
import com.enfernuz.quik.lua.rpc.api.RpcArgs;
import com.enfernuz.quik.lua.rpc.api.RpcResult;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import lombok.EqualsAndHashCode;
import lombok.Value;
import org.jetbrains.annotations.NotNull;

public final class CreateWindow implements RemoteProcedure {

    private CreateWindow() {}

    @EqualsAndHashCode
    public static final class Args implements RpcArgs<CreateWindow> {

        private static final String T_ID = "t_id";

        @JsonProperty(T_ID)
        private final int tId;

        public Args(final int tId) {
            this.tId = tId;
        }

        @JsonIgnore
        public int getTId() {
            return tId;
        }

        @NotNull
        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add(T_ID, tId)
                    .toString();
        }
    }

    @Value
    public static class Result implements RpcResult<CreateWindow> {

        private static final String RESULT = "result";

        int result;

        @JsonCreator
        public Result(@JsonProperty(value = RESULT, required = true) final int result) {
            this.result = result;
        }

        @NotNull
        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add(RESULT, result)
                    .toString();
        }

        // TODO: optimize for 0 and 1
    }
}
