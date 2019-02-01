package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.datasource.V;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import org.jetbrains.annotations.NotNull;

public class DatasourceVResultPbSerdeTest extends AbstractPbDeserializationTest<qlua.rpc.datasource.V.Result, V.Result> {

    private static final String VALUE = "1";

    @Override
    public @NotNull Deserializer<V.Result> getDeserializerUnderTest() {
        return DsVResultPbDeserializer.INSTANCE;
    }

    @NotNull
    @Override
    public V.Result getTargetObject() {
        return new V.Result(VALUE);
    }

    @NotNull
    @Override
    public qlua.rpc.datasource.V.Result getTargetObjectAsPbMessage() {

        return qlua.rpc.datasource.V.Result.newBuilder()
                .setValue(VALUE)
                .build();
    }
}
