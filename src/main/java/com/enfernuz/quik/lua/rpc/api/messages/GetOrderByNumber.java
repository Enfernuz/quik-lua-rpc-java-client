package com.enfernuz.quik.lua.rpc.api.messages;

import com.enfernuz.quik.lua.rpc.api.structures.Order;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import lombok.NonNull;
import lombok.Value;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public final class GetOrderByNumber {

    @Value
    public static class Request {

        String classCode;
        long orderId;

        public Request(@NonNull final String classCode, final long orderId) {
            this.classCode = classCode;
            this.orderId = orderId;
        }

        @NotNull
        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add("class_code", classCode)
                    .add("order_id", orderId)
                    .toString();
        }
    }

    @Value
    public static class Result {

        Order order;
        int indx;

        @JsonCreator
        public static Result getInstance(
                @JsonProperty("order") final Order order,
                @JsonProperty("indx") final int indx) {

            return (order == null) ? InstanceHolder.ERROR : new Result(order, indx);
        }

        private Result(final Order order, final int indx) {
            this.order = order;
            this.indx = indx;
        }

        @Contract(pure = true)
        public boolean isError() {
            return order == null;
        }

        @NotNull
        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add("order", order)
                    .add("indx", indx)
                    .toString();
        }

        private static final class InstanceHolder {

            private static final Result ERROR = new Result(null, 0);

            // sanity check
            static  {
                assert ERROR.isError();
            }
        }
    }
}
