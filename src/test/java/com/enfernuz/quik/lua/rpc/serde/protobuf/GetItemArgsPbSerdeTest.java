package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetItem;
import com.enfernuz.quik.lua.rpc.serde.Serializer;
import org.jetbrains.annotations.NotNull;

public class GetItemArgsPbSerdeTest extends AbstractPbSerializationTest<GetItem.Args, qlua.rpc.GetItem.Args> {

    private static final String TABLE_NAME = "1";
    private static final int INDEX = 2;

    @Override
    public @NotNull Serializer<GetItem.Args> getSerializerUnderTest() {
        return GetItemArgsPbSerializer.INSTANCE;
    }

    @NotNull
    @Override
    public qlua.rpc.GetItem.Args getTargetObjectAsPbMessage() {

        return qlua.rpc.GetItem.Args.newBuilder()
                .setTableName(TABLE_NAME)
                .setIndex(INDEX)
                .build();
    }

    @NotNull
    @Override
    public GetItem.Args getTargetObject() {
        return new GetItem.Args(TABLE_NAME, INDEX);
    }
}
