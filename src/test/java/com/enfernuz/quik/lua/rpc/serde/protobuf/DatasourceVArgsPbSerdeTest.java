package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.datasource.V;
import com.enfernuz.quik.lua.rpc.serde.Serializer;
import org.jetbrains.annotations.NotNull;

public class DatasourceVArgsPbSerdeTest extends AbstractPbSerializationTest<V.Args, qlua.rpc.datasource.V.Args> {

    private static final String DATASOURCE_UUID = "1";
    private static final int CANDLE_INDEX = 2;

    @Override
    public @NotNull Serializer<V.Args> getSerializerUnderTest() {
        return DsVArgsPbSerializer.INSTANCE;
    }

    @NotNull
    @Override
    public qlua.rpc.datasource.V.Args getTargetObjectAsPbMessage() {

        return qlua.rpc.datasource.V.Args.newBuilder()
                .setDatasourceUuid(DATASOURCE_UUID)
                .setCandleIndex(CANDLE_INDEX)
                .build();
    }

    @NotNull
    @Override
    public V.Args getTargetObject() {
        return new V.Args(DATASOURCE_UUID, CANDLE_INDEX);
    }
}
