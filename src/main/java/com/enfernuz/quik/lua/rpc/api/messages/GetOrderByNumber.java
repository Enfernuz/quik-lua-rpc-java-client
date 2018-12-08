package com.enfernuz.quik.lua.rpc.api.messages;

import com.enfernuz.quik.lua.rpc.api.RemoteProcedure;
import com.enfernuz.quik.lua.rpc.api.RpcArgs;
import com.enfernuz.quik.lua.rpc.api.RpcResult;
import com.enfernuz.quik.lua.rpc.api.structures.Order;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.MoreObjects;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.Value;
import org.jetbrains.annotations.NotNull;

public final class GetOrderByNumber implements RemoteProcedure {

    @JsonPropertyOrder({Args.CLASS_CODE, Args.ORDER_ID})
    @EqualsAndHashCode
    public static final class Args implements RpcArgs<GetOrderByNumber> {

        private static final String CLASS_CODE = "class_code";
        private static final String ORDER_ID = "order_id";

        @JsonProperty(CLASS_CODE)
        private final String classCode;

        @JsonProperty(ORDER_ID)
        private final long orderId;

        public Args(@NonNull final String classCode, final long orderId) {
            this.classCode = classCode;
            this.orderId = orderId;
        }

        @JsonIgnore
        public String getClassCode() {
            return classCode;
        }

        @JsonIgnore
        public long getOrderId() {
            return orderId;
        }

        @NotNull
        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add(CLASS_CODE, classCode)
                    .add(ORDER_ID, orderId)
                    .toString();
        }
    }

    @Value
    public static class Result implements RpcResult<GetOrderByNumber> {

        private static final String ORDER = "order";
        private static final String INDX = "indx";

        Order order;
        Integer indx;

        @JsonCreator
        public static Result getInstance(
                @JsonProperty(ORDER) final Order order,
                @JsonProperty(INDX) final Integer indx) {

            return (order == null && indx == null) ? InstanceHolder.ERROR : new Result(order, indx);
        }

        private Result(final Order order, final Integer indx) {
            this.order = order;
            this.indx = indx;
        }

        public boolean isError() {
            return order == null && indx == null;
        }

        @NotNull
        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add(ORDER, order)
                    .add(INDX, indx)
                    .toString();
        }

        private static final class InstanceHolder {

            private static final Result ERROR = new Result(null, null);

            // sanity check
            static  {
                assert ERROR.isError();
            }
        }
    }
}
