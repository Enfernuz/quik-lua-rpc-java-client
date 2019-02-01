package com.enfernuz.quik.lua.rpc.api.messages.os;

import com.enfernuz.quik.lua.rpc.api.RemoteProcedure;
import com.enfernuz.quik.lua.rpc.api.RpcResult;
import com.enfernuz.quik.lua.rpc.api.structures.DateTimeEntry;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import lombok.NonNull;
import lombok.Value;
import org.jetbrains.annotations.NotNull;

public final class SysDate implements RemoteProcedure {

    private SysDate() {}

    @Value
    public static class Result implements RpcResult<SysDate> {

        private static final String RESULT = "result";

        DateTimeEntry result;

        @JsonCreator
        public Result(@JsonProperty(value = RESULT, required = true) @NonNull final DateTimeEntry result) {
            this.result = result;
        }

        @NotNull
        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add(RESULT, result)
                    .toString();
        }
    }
}
