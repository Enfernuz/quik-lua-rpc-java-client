package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.datasource.C;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import org.jetbrains.annotations.NotNull;

public class DatasourceCResultPbSerdeTest extends AbstractPbDeserializationTest<qlua.rpc.datasource.C.Result, C.Result> {

    private static final String VALUE = "1";

    @Override
    public @NotNull Deserializer<C.Result> getDeserializerUnderTest() {
        return DsCResultPbDeserializer.INSTANCE;
    }

    @NotNull
    @Override
    public C.Result getTargetObject() {
        return new C.Result(VALUE);
    }

    @NotNull
    @Override
    public qlua.rpc.datasource.C.Result getTargetObjectAsPbMessage() {

        return qlua.rpc.datasource.C.Result.newBuilder()
                .setValue(VALUE)
                .build();
    }
}
