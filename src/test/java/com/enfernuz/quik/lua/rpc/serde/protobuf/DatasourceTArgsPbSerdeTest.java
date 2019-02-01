package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.datasource.T;
import com.enfernuz.quik.lua.rpc.serde.Serializer;
import org.jetbrains.annotations.NotNull;

public class DatasourceTArgsPbSerdeTest extends AbstractPbSerializationTest<T.Args, qlua.rpc.datasource.T.Args> {

    private static final String DATASOURCE_UUID = "1";
    private static final int CANDLE_INDEX = 2;

    @Override
    public @NotNull Serializer<T.Args> getSerializerUnderTest() {
        return DsTArgsPbSerializer.INSTANCE;
    }

    @NotNull
    @Override
    public qlua.rpc.datasource.T.Args getTargetObjectAsPbMessage() {

        return qlua.rpc.datasource.T.Args.newBuilder()
                .setDatasourceUuid(DATASOURCE_UUID)
                .setCandleIndex(CANDLE_INDEX)
                .build();
    }

    @NotNull
    @Override
    public T.Args getTargetObject() {
        return new T.Args(DATASOURCE_UUID, CANDLE_INDEX);
    }
}
