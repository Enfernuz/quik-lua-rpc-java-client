package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.datasource.L;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import org.jetbrains.annotations.NotNull;

public class DatasourceLResultPbSerdeTest extends AbstractPbDeserializationTest<qlua.rpc.datasource.L.Result, L.Result> {

    private static final String VALUE = "1";

    @Override
    public @NotNull Deserializer<L.Result> getDeserializerUnderTest() {
        return DsLResultPbDeserializer.INSTANCE;
    }

    @NotNull
    @Override
    public L.Result getTargetObject() {
        return new L.Result(VALUE);
    }

    @NotNull
    @Override
    public qlua.rpc.datasource.L.Result getTargetObjectAsPbMessage() {

        return qlua.rpc.datasource.L.Result.newBuilder()
                .setValue(VALUE)
                .build();
    }
}
