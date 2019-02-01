package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.InsertRow;
import com.enfernuz.quik.lua.rpc.serde.Serializer;
import org.jetbrains.annotations.NotNull;

public class InsertRowArgsPbSerdeTest extends AbstractPbSerializationTest<InsertRow.Args, qlua.rpc.InsertRow.Args> {

    private static final int T_ID = 1;
    private static final int KEY = 2;

    @Override
    public @NotNull Serializer<InsertRow.Args> getSerializerUnderTest() {
        return InsertRowArgsPbSerializer.INSTANCE;
    }

    @NotNull
    @Override
    public qlua.rpc.InsertRow.Args getTargetObjectAsPbMessage() {

        return qlua.rpc.InsertRow.Args.newBuilder()
                .setTId(T_ID)
                .setKey(KEY)
                .build();
    }

    @NotNull
    @Override
    public InsertRow.Args getTargetObject() {

        return InsertRow.Args.builder()
                .tId(T_ID)
                .key(KEY)
                .build();
    }
}
