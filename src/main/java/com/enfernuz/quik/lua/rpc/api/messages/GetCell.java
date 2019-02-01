package com.enfernuz.quik.lua.rpc.api.messages;

import com.enfernuz.quik.lua.rpc.api.RemoteProcedure;
import com.enfernuz.quik.lua.rpc.api.RpcArgs;
import com.enfernuz.quik.lua.rpc.api.RpcResult;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.MoreObjects;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Value;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public final class GetCell implements RemoteProcedure {

    private GetCell() {}

    @JsonPropertyOrder({Args.T_ID, Args.KEY, Args.CODE})
    @EqualsAndHashCode
    public static final class Args implements RpcArgs<GetCell> {

        private static final String T_ID = "t_id";
        private static final String KEY = "key";
        private static final String CODE = "code";

        @JsonProperty(T_ID)
        private final int tId;

        @JsonProperty(KEY)
        private final int key;

        @JsonProperty(CODE)
        private final int code;

        @Builder
        private Args(final int tId, final int key, final int code) {
            this.tId = tId;
            this.key = key;
            this.code = code;
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

        @NotNull
        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add(T_ID, tId)
                    .add(KEY, key)
                    .add(CODE, code)
                    .toString();
        }
    }

    @Value
    public static class Result implements RpcResult<GetCell> {

        private static final String IMAGE = "image";
        private static final String VALUE = "value";

        String image;
        String value;

        @JsonCreator
        @Builder
        private static Result getInstance(
                @JsonProperty(value = IMAGE) final String image,
                @JsonProperty(value = VALUE) final String value) {

            return image == null && value == null ? InstanceHolder.ERROR : new Result(image, value);
        }

        private Result(final String image, final String value) {
            this.image = image;
            this.value = value;
        }

        @Contract(pure = true)
        public boolean isError() {
            return image == null && value == null;
        }

        @NotNull
        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add(IMAGE, image)
                    .add(VALUE, value)
                    .toString();
        }

        private static final class InstanceHolder {

            private static final Result ERROR = new Result(null, null);

            // just in case
            static {
                assert ERROR.isError();
            }
        }
    }
}
