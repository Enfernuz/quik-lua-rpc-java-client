package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.datasource.H;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import org.jetbrains.annotations.NotNull;

public class DatasourceHResultPbSerdeTest extends AbstractPbDeserializationTest<qlua.rpc.datasource.H.Result, H.Result> {

    private static final String VALUE = "1";

    @Override
    public @NotNull Deserializer<H.Result> getDeserializerUnderTest() {
        return DsHResultPbDeserializer.INSTANCE;
    }

    @NotNull
    @Override
    public H.Result getTargetObject() {
        return new H.Result(VALUE);
    }

    @NotNull
    @Override
    public qlua.rpc.datasource.H.Result getTargetObjectAsPbMessage() {

        return qlua.rpc.datasource.H.Result.newBuilder()
                .setValue(VALUE)
                .build();
    }
}
