package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetCell;
import com.enfernuz.quik.lua.rpc.serde.Serializer;
import org.jetbrains.annotations.NotNull;

public class GetCellArgsPbSerdeTest extends AbstractPbSerializationTest<GetCell.Args, qlua.rpc.GetCell.Args> {

    private static final int T_ID = 1;
    private static final int KEY = 2;
    private static final int CODE = 3;

    @Override
    public @NotNull Serializer<GetCell.Args> getSerializerUnderTest() {
        return GetCellArgsPbSerializer.INSTANCE;
    }

    @NotNull
    @Override
    public qlua.rpc.GetCell.Args getTargetObjectAsPbMessage() {

        return qlua.rpc.GetCell.Args.newBuilder()
                .setTId(T_ID)
                .setKey(KEY)
                .setCode(CODE)
                .build();
    }

    @NotNull
    @Override
    public GetCell.Args getTargetObject() {

        return GetCell.Args.builder()
                .tId(T_ID)
                .key(KEY)
                .code(CODE)
                .build();
    }
}
