package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.datasource.C;
import com.enfernuz.quik.lua.rpc.serde.Serializer;
import org.jetbrains.annotations.NotNull;

public class DatasourceCArgsPbSerdeTest extends AbstractPbSerializationTest<C.Args, qlua.rpc.datasource.C.Args> {

    private static final String DATASOURCE_UUID = "1";
    private static final int CANDLE_INDEX = 2;

    @Override
    public @NotNull Serializer<C.Args> getSerializerUnderTest() {
        return DsCArgsPbSerializer.INSTANCE;
    }

    @NotNull
    @Override
    public qlua.rpc.datasource.C.Args getTargetObjectAsPbMessage() {

        return qlua.rpc.datasource.C.Args.newBuilder()
                .setDatasourceUuid(DATASOURCE_UUID)
                .setCandleIndex(CANDLE_INDEX)
                .build();
    }

    @NotNull
    @Override
    public C.Args getTargetObject() {
        return new C.Args(DATASOURCE_UUID, CANDLE_INDEX);
    }
}
