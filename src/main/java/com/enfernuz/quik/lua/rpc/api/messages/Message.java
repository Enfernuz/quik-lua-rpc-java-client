package com.enfernuz.quik.lua.rpc.api.messages;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;
import com.google.common.base.MoreObjects;
import lombok.NonNull;
import lombok.Value;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public final class Message {

    private Message() {}

    @Value
    public static class Request {

        @NonNull String message;
        IconType iconType;

        public Request(final String message) {
            this(message, null);
        }

        public Request(final String message, final IconType iconType) {
            this.message = message;
            this.iconType = iconType;
        }

        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add("message", message)
                    .add("icon_type", iconType)
                    .toString();
        }
    }

    @Value
    public static class MessageResult {

        private static final String RESULT_FIELD = "result";

        int result;

        @JsonCreator
        public static MessageResult getInstance(@JsonProperty(value = RESULT_FIELD, required = true) final int result) {
            return isOk(result) ? InstanceHolder.OK : new MessageResult(result);
        }

        public static MessageResult getOkInstance() {
            return InstanceHolder.OK;
        }

        @Contract(pure = true)
        public boolean isOk() {
            return isOk(result);
        }

        @Contract(pure = true)
        private static boolean isOk(final int result) {
            return result == 1;
        }

        private MessageResult(final int result) {
            this.result = result;
        }

        @NotNull
        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add(RESULT_FIELD, result)
                    .toString();
        }

        private static final class InstanceHolder {

            private static final MessageResult OK = new MessageResult(1);

            // sanity check
            static {
                assert OK.isOk();
            }
        }
    }

    @Value
    public static class Result {

        private static final String MESSAGE_RESULT_FIELD = "message_result";

        MessageResult messageResult;

        @JsonCreator
        public static Result getInstance(@JsonProperty(value = MESSAGE_RESULT_FIELD, required = true) final MessageResult messageResult) {

            if (isError(messageResult)) {
                return InstanceHolder.ERROR;
            }

            if (messageResult.isOk()) {
                return InstanceHolder.OK;
            }

            return new Result(messageResult);
        }

        public static Result getErrorInstance() {
            return InstanceHolder.ERROR;
        }

        private Result(final MessageResult messageResult) {
            this.messageResult = messageResult;
        }

        @Contract(pure = true)
        public boolean isError() {
            return isError(messageResult);
        }

        @Contract(value = "null -> true; !null -> false", pure = true)
        private static boolean isError(final MessageResult messageResult) {
            return messageResult == null;
        }

        @NotNull
        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add(MESSAGE_RESULT_FIELD, messageResult)
                    .toString();
        }

        private static final class InstanceHolder {

            private static final Result OK = new Result(MessageResult.getOkInstance());
            private static final Result ERROR = new Result(null);

            // sanity check
            static {
                assert !OK.isError() && OK.messageResult.isOk();
                assert ERROR.isError();
            }
        }
    }

    public enum IconType {

        INFO(1),
        WARNING(2),
        ERROR(3);

        public final int value;

        IconType(final int value) {
            this.value = value;
        }
    }
}
