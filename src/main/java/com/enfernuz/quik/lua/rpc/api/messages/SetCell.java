package com.enfernuz.quik.lua.rpc.api.messages;

import com.enfernuz.quik.lua.rpc.api.RemoteProcedure;
import com.enfernuz.quik.lua.rpc.api.RpcArgs;
import com.enfernuz.quik.lua.rpc.api.RpcResult;
import com.fasterxml.jackson.annotation.*;
import com.google.common.base.MoreObjects;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.Value;
import org.jetbrains.annotations.NotNull;

public final class SetCell implements RemoteProcedure {

    private SetCell() {}

    @JsonPropertyOrder({Args.T_ID, Args.KEY, Args.CODE, Args.TEXT, Args.VALUE})
    @EqualsAndHashCode
    public static final class Args implements RpcArgs<SetCell> {

        private static final String T_ID = "t_id";
        private static final String KEY = "key";
        private static final String CODE = "code";
        private static final String TEXT = "text";
        private static final String VALUE = "value";

        @JsonProperty(T_ID)
        private final int tId;

        @JsonProperty(KEY)
        private final int key;

        @JsonProperty(CODE)
        private final int code;

        @JsonProperty(TEXT)
        private final String text;

        @JsonProperty(VALUE)
        @JsonInclude(JsonInclude.Include.NON_NULL)
        private final Number value;

        @Builder
        private Args(
                final int tId,
                final int key,
                final int code,
                @NonNull final String text,
                final Number value) {

            this.tId = tId;
            this.key = key;
            this.code = code;
            this.text = text;
            this.value = value;
        }

        @JsonIgnore
        public int getTId() {
            return tId;
        }

        @JsonIgnore
        public int getKey() {
            return key;
        }

        @JsonIgnore
        public int getCode() {
            return code;
        }

        @JsonIgnore
        public String getText() {
            return text;
        }

        @JsonIgnore
        public Number getValue() {
            return value;
        }

        @NotNull
        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add(T_ID, tId)
                    .add(KEY, key)
                    .add(CODE, code)
                    .add(TEXT, text)
                    .add(VALUE, value)
                    .toString();
        }
    }

    @Value
    public static class Result implements RpcResult<SetCell> {

        private static final String RESULT = "result";

        boolean result;

        @JsonCreator
        public static Result getInstance(@JsonProperty(value = RESULT, required = true) final boolean result) {
            return result ? InstanceHolder.TRUE : InstanceHolder.FALSE;
        }

        private Result(final boolean result) {
            this.result = result;
        }

        private static final class InstanceHolder {

            private static final Result TRUE = new Result(true);
            private static final Result FALSE = new Result(false);

            // sanity check
            static {
                assert TRUE.result;
                assert !FALSE.result;
            }
        }
    }
}
