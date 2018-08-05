package com.enfernuz.quik.lua.rpc.api.messages;

import com.enfernuz.quik.lua.rpc.api.structures.Order;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import lombok.NonNull;
import lombok.Value;

public final class GetOrderByNumber {

    @Value
    public static class Request {

        String classCode;
        long orderId;

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
        public Result(
                final @JsonProperty(value = "order", required = true) @NonNull Order order,
                final @JsonProperty(value = "indx", required = true) int indx) {

            this.order = order;
            this.indx = indx;
        }

        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add("order", order)
                    .add("indx", indx)
                    .toString();
        }
    }
}
