package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.datasource.SetEmptyCallback;
import com.enfernuz.quik.lua.rpc.serde.Serializer;
import org.jetbrains.annotations.NotNull;

public class DatasourceSetEmptyCallbackArgsPbSerdeTest extends AbstractPbSerializationTest<SetEmptyCallback.Args, qlua.rpc.datasource.SetEmptyCallback.Args> {

    private static final String DATASOURCE_UUID = "1";

    @Override
    public @NotNull Serializer<SetEmptyCallback.Args> getSerializerUnderTest() {
        return DsSetEmptyCallbackPbArgsSerializer.INSTANCE;
    }

    @NotNull
    @Override
    public qlua.rpc.datasource.SetEmptyCallback.Args getTargetObjectAsPbMessage() {

        return qlua.rpc.datasource.SetEmptyCallback.Args.newBuilder()
                .setDatasourceUuid(DATASOURCE_UUID)
                .build();
    }

    @NotNull
    @Override
    public SetEmptyCallback.Args getTargetObject() {
        return new SetEmptyCallback.Args(DATASOURCE_UUID);
    }
}
