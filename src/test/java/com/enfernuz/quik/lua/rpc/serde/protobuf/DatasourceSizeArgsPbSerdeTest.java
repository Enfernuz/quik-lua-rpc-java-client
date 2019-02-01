package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.datasource.Size;
import com.enfernuz.quik.lua.rpc.serde.Serializer;
import org.jetbrains.annotations.NotNull;

public class DatasourceSizeArgsPbSerdeTest extends AbstractPbSerializationTest<Size.Args, qlua.rpc.datasource.Size.Args> {

    private static final String DATASOURCE_UUID = "1";

    @Override
    public @NotNull Serializer<Size.Args> getSerializerUnderTest() {
        return DsSizePbArgsSerializer.INSTANCE;
    }

    @NotNull
    @Override
    public qlua.rpc.datasource.Size.Args getTargetObjectAsPbMessage() {

        return qlua.rpc.datasource.Size.Args.newBuilder()
                .setDatasourceUuid(DATASOURCE_UUID)
                .build();
    }

    @NotNull
    @Override
    public Size.Args getTargetObject() {
        return new Size.Args(DATASOURCE_UUID);
    }
}
