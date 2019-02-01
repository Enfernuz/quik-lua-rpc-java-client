package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.datasource.O;
import com.enfernuz.quik.lua.rpc.serde.Serializer;
import org.jetbrains.annotations.NotNull;

public class DatasourceOArgsPbSerdeTest extends AbstractPbSerializationTest<O.Args, qlua.rpc.datasource.O.Args> {

    private static final String DATASOURCE_UUID = "1";
    private static final int CANDLE_INDEX = 2;

    @Override
    public @NotNull Serializer<O.Args> getSerializerUnderTest() {
        return DsOArgsPbSerializer.INSTANCE;
    }

    @NotNull
    @Override
    public qlua.rpc.datasource.O.Args getTargetObjectAsPbMessage() {

        return qlua.rpc.datasource.O.Args.newBuilder()
                .setDatasourceUuid(DATASOURCE_UUID)
                .setCandleIndex(CANDLE_INDEX)
                .build();
    }

    @NotNull
    @Override
    public O.Args getTargetObject() {
        return new O.Args(DATASOURCE_UUID, CANDLE_INDEX);
    }
}
