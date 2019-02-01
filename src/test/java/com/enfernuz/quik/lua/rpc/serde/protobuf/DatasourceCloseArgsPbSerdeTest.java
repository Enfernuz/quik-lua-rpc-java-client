package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.datasource.Close;
import com.enfernuz.quik.lua.rpc.serde.Serializer;
import org.jetbrains.annotations.NotNull;

public class DatasourceCloseArgsPbSerdeTest extends AbstractPbSerializationTest<Close.Args, qlua.rpc.datasource.Close.Args> {

    private static final String DATASOURCE_UUID = "1";

    @Override
    public @NotNull Serializer<Close.Args> getSerializerUnderTest() {
        return DsClosePbArgsSerializer.INSTANCE;
    }

    @NotNull
    @Override
    public qlua.rpc.datasource.Close.Args getTargetObjectAsPbMessage() {

        return qlua.rpc.datasource.Close.Args.newBuilder()
                .setDatasourceUuid(DATASOURCE_UUID)
                .build();
    }

    @NotNull
    @Override
    public Close.Args getTargetObject() {
        return new Close.Args(DATASOURCE_UUID);
    }
}
