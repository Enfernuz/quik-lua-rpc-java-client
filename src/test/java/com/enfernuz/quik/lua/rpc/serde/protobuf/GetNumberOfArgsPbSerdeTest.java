package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetNumberOf;
import com.enfernuz.quik.lua.rpc.serde.Serializer;
import org.jetbrains.annotations.NotNull;

public class GetNumberOfArgsPbSerdeTest extends AbstractPbSerializationTest<GetNumberOf.Args, qlua.rpc.GetNumberOf.Args> {

    private static final String TABLE_NAME = "1";

    @Override
    public @NotNull Serializer<GetNumberOf.Args> getSerializerUnderTest() {
        return GetNumberOfArgsPbSerializer.INSTANCE;
    }

    @NotNull
    @Override
    public qlua.rpc.GetNumberOf.Args getTargetObjectAsPbMessage() {

        return qlua.rpc.GetNumberOf.Args.newBuilder()
                .setTableName(TABLE_NAME)
                .build();
    }

    @NotNull
    @Override
    public GetNumberOf.Args getTargetObject() {
        return new GetNumberOf.Args(TABLE_NAME);
    }
}
