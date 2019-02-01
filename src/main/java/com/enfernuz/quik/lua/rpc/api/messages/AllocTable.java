package com.enfernuz.quik.lua.rpc.api.messages;

import com.enfernuz.quik.lua.rpc.api.RemoteProcedure;
import com.enfernuz.quik.lua.rpc.api.RpcResult;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import lombok.Value;
import org.jetbrains.annotations.NotNull;

public final class AllocTable implements RemoteProcedure {

    private AllocTable() {}

    @Value
    public static class Result implements RpcResult<AllocTable> {

        private static final String T_ID = "t_id";

        int tId;

        @JsonCreator
        public Result(@JsonProperty(value = T_ID, required = true) final int tId) {
            this.tId = tId;
        }

        @NotNull
        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add(T_ID, tId)
                    .toString();
        }
    }
}
