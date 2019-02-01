package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.datasource.H;
import com.enfernuz.quik.lua.rpc.serde.Serializer;
import org.jetbrains.annotations.NotNull;

public class DatasourceHArgsPbSerdeTest extends AbstractPbSerializationTest<H.Args, qlua.rpc.datasource.H.Args> {

    private static final String DATASOURCE_UUID = "1";
    private static final int CANDLE_INDEX = 2;

    @Override
    public @NotNull Serializer<H.Args> getSerializerUnderTest() {
        return DsHArgsPbSerializer.INSTANCE;
    }

    @NotNull
    @Override
    public qlua.rpc.datasource.H.Args getTargetObjectAsPbMessage() {

        return qlua.rpc.datasource.H.Args.newBuilder()
                .setDatasourceUuid(DATASOURCE_UUID)
                .setCandleIndex(CANDLE_INDEX)
                .build();
    }

    @NotNull
    @Override
    public H.Args getTargetObject() {
        return new H.Args(DATASOURCE_UUID, CANDLE_INDEX);
    }
}
