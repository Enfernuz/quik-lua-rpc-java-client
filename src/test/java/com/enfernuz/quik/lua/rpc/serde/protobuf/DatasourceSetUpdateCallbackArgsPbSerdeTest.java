package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.datasource.SetUpdateCallback;
import com.enfernuz.quik.lua.rpc.serde.Serializer;
import org.jetbrains.annotations.NotNull;

public class DatasourceSetUpdateCallbackArgsPbSerdeTest extends AbstractPbSerializationTest<SetUpdateCallback.Args, qlua.rpc.datasource.SetUpdateCallback.Args> {

    private static final String DATASOURCE_UUID = "1";
    private static final String F_CB_DEF = "2";
    private static final boolean WATCHING_O = true;
    private static final boolean WATCHING_H = true;
    private static final boolean WATCHING_L = true;
    private static final boolean WATCHING_C = true;
    private static final boolean WATCHING_V = true;
    private static final boolean WATCHING_T = true;
    private static final boolean WATCHING_SIZE = true;

    @Override
    public @NotNull Serializer<SetUpdateCallback.Args> getSerializerUnderTest() {
        return DsSetUpdateCallbackPbArgsSerializer.INSTANCE;
    }

    @NotNull
    @Override
    public qlua.rpc.datasource.SetUpdateCallback.Args getTargetObjectAsPbMessage() {

        return qlua.rpc.datasource.SetUpdateCallback.Args.newBuilder()
                .setDatasourceUuid(DATASOURCE_UUID)
                .setFCbDef(F_CB_DEF)
                .setWatchingO(WATCHING_O)
                .setWatchingH(WATCHING_H)
                .setWatchingL(WATCHING_L)
                .setWatchingC(WATCHING_C)
                .setWatchingV(WATCHING_V)
                .setWatchingT(WATCHING_T)
                .setWatchingSize(WATCHING_SIZE)
                .build();
    }

    @NotNull
    @Override
    public SetUpdateCallback.Args getTargetObject() {

        return SetUpdateCallback.Args.builder()
                .datasourceUUID(DATASOURCE_UUID)
                .fCbDef(F_CB_DEF)
                .watchingO(WATCHING_O)
                .watchingH(WATCHING_H)
                .watchingL(WATCHING_L)
                .watchingC(WATCHING_C)
                .watchingV(WATCHING_V)
                .watchingT(WATCHING_T)
                .watchingSize(WATCHING_SIZE)
                .build();
    }
}
