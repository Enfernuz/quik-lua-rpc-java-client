package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetOrderByNumber;
import com.enfernuz.quik.lua.rpc.serde.Serializer;
import org.jetbrains.annotations.NotNull;

public class GetOrderByNumberArgsPbSerdeTest extends AbstractPbSerializationTest<GetOrderByNumber.Args, qlua.rpc.GetOrderByNumber.Args> {

    private static final String CLASS_CODE = "1";
    private static final long ORDER_ID = 12345678910L;

    @Override
    public @NotNull Serializer<GetOrderByNumber.Args> getSerializerUnderTest() {
        return GetOrderByNumberArgsPbSerializer.INSTANCE;
    }

    @NotNull
    @Override
    public qlua.rpc.GetOrderByNumber.Args getTargetObjectAsPbMessage() {

        return qlua.rpc.GetOrderByNumber.Args.newBuilder()
                .setClassCode(CLASS_CODE)
                .setOrderId(ORDER_ID)
                .build();
    }

    @NotNull
    @Override
    public GetOrderByNumber.Args getTargetObject() {
        return new GetOrderByNumber.Args(CLASS_CODE, ORDER_ID);
    }
}
