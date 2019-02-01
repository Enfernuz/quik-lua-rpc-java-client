package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.DeleteRow;
import com.enfernuz.quik.lua.rpc.serde.Serializer;
import org.jetbrains.annotations.NotNull;

public class DeleteRowArgsPbSerdeTest extends AbstractPbSerializationTest<DeleteRow.Args, qlua.rpc.DeleteRow.Args> {

    private static final int T_ID = 1;
    private static final int KEY = 2;

    @Override
    public @NotNull Serializer<DeleteRow.Args> getSerializerUnderTest() {
        return DeleteRowArgsPbSerializer.INSTANCE;
    }

    @NotNull
    @Override
    public qlua.rpc.DeleteRow.Args getTargetObjectAsPbMessage() {

        return qlua.rpc.DeleteRow.Args.newBuilder()
                .setTId(T_ID)
                .setKey(KEY)
                .build();
    }

    @NotNull
    @Override
    public DeleteRow.Args getTargetObject() {

        return DeleteRow.Args.builder()
                .tId(T_ID)
                .key(KEY)
                .build();
    }
}
