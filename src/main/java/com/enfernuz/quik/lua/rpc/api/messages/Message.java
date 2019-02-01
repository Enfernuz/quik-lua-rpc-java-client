package com.enfernuz.quik.lua.rpc.api.messages;

import com.enfernuz.quik.lua.rpc.api.RemoteProcedure;
import com.enfernuz.quik.lua.rpc.api.RpcArgs;
import com.enfernuz.quik.lua.rpc.api.RpcResult;
import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.common.base.MoreObjects;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.Value;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public final class Message implements RemoteProcedure {

    private Message() {}

    @JsonPropertyOrder({Args.MESSAGE, Args.ICON_TYPE})
    @EqualsAndHashCode
    public static final class Args implements RpcArgs<Message> {

        private static final String MESSAGE = "message";
        private static final String ICON_TYPE = "icon_type";

        @JsonProperty(MESSAGE)
        private final String message;

        @JsonProperty(ICON_TYPE)
        @JsonInclude(JsonInclude.Include.NON_NULL)
        private final IconType iconType;

        public Args(@NonNull final String message) {
            this(message, null);
        }

        public Args(@NonNull final String message, final IconType iconType) {
            this.message = message;
            this.iconType = iconType;
        }

        @JsonIgnore
        public String getMessage() {
            return message;
        }

        @JsonIgnore
        @JsonSerialize
        public IconType getIconType() {
            return iconType;
        }

        @NotNull
        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add(MESSAGE, message)
                    .add(ICON_TYPE, iconType)
                    .toString();
        }
    }

    @Value
    public static class Result implements RpcResult<Message> {

        private static final String RESULT = "result";

        Integer result;

        @JsonCreator
        public static Result getInstance(@JsonProperty(RESULT) final Integer result) {

            if ( isOk(result) ) {
                return InstanceHolder.OK;
            } else if ( isError(result) ) {
                return InstanceHolder.ERROR;
            }

            return new Result(result);
        }

        public static Result getErrorInstance() {
            return InstanceHolder.ERROR;
        }

        public static Result getOkInstance() {
            return InstanceHolder.OK;
        }

        private Result(final Integer result) {
            this.result = result;
        }

        public boolean isError() {
            return isError(result);
        }

        public boolean isOk() {
            return isOk(result);
        }

        @Contract("null -> false")
        private static boolean isOk(final Integer result) {
            return Integer.valueOf(1).equals(result);
        }

        @Contract(value = "null -> true; !null -> false", pure = true)
        private static boolean isError(final Integer result) {
            return result == null;
        }

        @NotNull
        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add(RESULT, result)
                    .toString();
        }

        private static final class InstanceHolder {

            private static final Result OK = new Result(1);
            private static final Result ERROR = new Result(null);

            // sanity check
            static {
                assert !OK.isError() && OK.isOk();
                assert ERROR.isError() && !ERROR.isOk();
            }
        }
    }

    public enum IconType {

        INFO(1),
        WARNING(2),
        ERROR(3);

        @JsonValue
        public final int value;

        IconType(final int value) {
            this.value = value;
        }
    }
}
