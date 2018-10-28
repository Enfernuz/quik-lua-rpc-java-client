package com.enfernuz.quik.lua.rpc.api.messages;

import com.enfernuz.quik.lua.rpc.api.RemoteProcedure;
import com.enfernuz.quik.lua.rpc.api.RpcArgs;
import com.enfernuz.quik.lua.rpc.api.RpcResult;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.base.MoreObjects;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import org.jetbrains.annotations.NotNull;

public final class PrintDbgStr implements RemoteProcedure {

    private PrintDbgStr() {}

    @EqualsAndHashCode
    public static final class Args implements RpcArgs<PrintDbgStr> {

        private static final String S = "s";

        @JsonProperty(S)
        private final String s;

        public Args(@NonNull final String s) {
            this.s = s;
        }

        @JsonIgnore
        public String getS() {
            return s;
        }

        @NotNull
        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add(S, s)
                    .toString();
        }
    }
}
