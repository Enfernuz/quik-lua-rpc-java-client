package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.datasource.L;
import com.enfernuz.quik.lua.rpc.serde.Serializer;
import org.jetbrains.annotations.NotNull;

public class DatasourceLArgsPbSerdeTest extends AbstractPbSerializationTest<L.Args, qlua.rpc.datasource.L.Args> {

    private static final String DATASOURCE_UUID = "1";
    private static final int CANDLE_INDEX = 2;

    @Override
    public @NotNull Serializer<L.Args> getSerializerUnderTest() {
        return DsLArgsPbSerializer.INSTANCE;
    }

    @NotNull
    @Override
    public qlua.rpc.datasource.L.Args getTargetObjectAsPbMessage() {

        return qlua.rpc.datasource.L.Args.newBuilder()
                .setDatasourceUuid(DATASOURCE_UUID)
                .setCandleIndex(CANDLE_INDEX)
                .build();
    }

    @NotNull
    @Override
    public L.Args getTargetObject() {
        return new L.Args(DATASOURCE_UUID, CANDLE_INDEX);
    }
}
