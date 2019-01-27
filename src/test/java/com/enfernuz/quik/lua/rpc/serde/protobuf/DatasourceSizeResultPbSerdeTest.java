package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.datasource.Size;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import org.jetbrains.annotations.NotNull;

public class DatasourceSizeResultPbSerdeTest extends AbstractPbDeserializationTest<qlua.rpc.datasource.Size.Result, Size.Result> {

    private static final int VALUE = 1;

    @Override
    public @NotNull Deserializer<Size.Result> getDeserializerUnderTest() {
        return DsSizeResultPbDeserializer.INSTANCE;
    }

    @NotNull
    @Override
    public Size.Result getTargetObject() {
        return new Size.Result(VALUE);
    }

    @NotNull
    @Override
    public qlua.rpc.datasource.Size.Result getTargetObjectAsPbMessage() {

        return qlua.rpc.datasource.Size.Result.newBuilder()
                .setValue(VALUE)
                .build();
    }
}
