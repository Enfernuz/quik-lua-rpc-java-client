package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetOrderByNumber;
import com.google.protobuf.MessageLite;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qlua.rpc.RPC;

public class GetOrderByNumberRequestPbSerdeTest extends AbstractRequestPbSerdeTest<GetOrderByNumber.Request> {

    private static final String CLASS_CODE = "1";
    private static final long ORDER_ID = 12345678910L;

    @Override
    public RPC.@NotNull ProcedureType getProcedureType() {
        return RPC.ProcedureType.GET_ORDER_BY_NUMBER;
    }

    @Override
    public @Nullable MessageLite getPbRequestArgs() {
        return qlua.rpc.GetOrderByNumber.Request.newBuilder()
                .setClassCode(CLASS_CODE)
                .setOrderId(ORDER_ID)
                .build();
    }

    @Override
    public @NotNull Class<GetOrderByNumber.Request> getTargetObjectClass() {
        return GetOrderByNumber.Request.class;
    }

    @NotNull
    @Override
    public GetOrderByNumber.Request getTargetObject() {
        return new GetOrderByNumber.Request(CLASS_CODE, ORDER_ID);
    }
}
