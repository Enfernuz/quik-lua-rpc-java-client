package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.AllocTable;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import org.jetbrains.annotations.NotNull;

public class AllocTableResultPbSerdeTest extends AbstractPbDeserializationTest<qlua.rpc.AllocTable.Result, AllocTable.Result> {

    private static final int T_ID = 1;

    @Override
    public @NotNull Deserializer<AllocTable.Result> getDeserializerUnderTest() {
        return AllocTableResultPbDeserializer.INSTANCE;
    }

    @NotNull
    @Override
    public AllocTable.Result getTargetObject() {
        return new AllocTable.Result(T_ID);
    }

    @NotNull
    @Override
    public qlua.rpc.AllocTable.Result getTargetObjectAsPbMessage() {

        return qlua.rpc.AllocTable.Result.newBuilder()
                .setTId(T_ID)
                .build();
    }
}
