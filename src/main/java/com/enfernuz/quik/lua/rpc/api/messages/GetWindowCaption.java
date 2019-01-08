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
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class GetWindowCaption implements RemoteProcedure {

    private GetWindowCaption() {}

    @EqualsAndHashCode
    public static final class Args implements RpcArgs<GetWindowCaption> {

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
    public static class Result implements RpcResult<GetWindowCaption> {

        private static final String CAPTION = "caption";

        String caption;

        @JsonCreator
        public static Result getInstance(@JsonProperty(CAPTION) @Nullable final String caption) {
            return isError(caption) ? InstanceHolder.ERROR : new Result(caption);
        }

        public static Result getErrorInstance() {
            return InstanceHolder.ERROR;
        }

        private Result(final String caption) {
            this.caption = caption;
        }

        public boolean isError() {
            return isError(caption);
        }

        @Contract(value = "null -> true; !null -> false", pure = true)
        private static boolean isError(final String caption) {
            return caption == null;
        }

        @NotNull
        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add(CAPTION, caption)
                    .toString();
        }

        private static final class InstanceHolder {

            private static final Result ERROR = new Result(null);

            // sanity check
            static {
                assert ERROR.isError();
            }
        }
    }
}
