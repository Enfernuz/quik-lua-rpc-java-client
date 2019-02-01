package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.datasource.O;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import org.jetbrains.annotations.NotNull;

public class DatasourceOResultPbSerdeTest extends AbstractPbDeserializationTest<qlua.rpc.datasource.O.Result, O.Result> {

    private static final String VALUE = "1";

    @Override
    public @NotNull Deserializer<O.Result> getDeserializerUnderTest() {
        return DsOResultPbDeserializer.INSTANCE;
    }

    @NotNull
    @Override
    public O.Result getTargetObject() {
        return new O.Result(VALUE);
    }

    @NotNull
    @Override
    public qlua.rpc.datasource.O.Result getTargetObjectAsPbMessage() {

        return qlua.rpc.datasource.O.Result.newBuilder()
                .setValue(VALUE)
                .build();
    }
}
