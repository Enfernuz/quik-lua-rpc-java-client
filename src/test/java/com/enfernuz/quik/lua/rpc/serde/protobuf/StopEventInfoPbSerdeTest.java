package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.structures.StopEventInfo;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import org.jetbrains.annotations.NotNull;
import qlua.structs.QluaStructures;

public class StopEventInfoPbSerdeTest extends AbstractPbDeserializationTest<QluaStructures.StopEventInfo, StopEventInfo> {

    private static final int FLAG = 123;

    @Override
    public @NotNull Deserializer<StopEventInfo> getDeserializerUnderTest() {
        return StopEventInfoPbDeserializer.INSTANCE;
    }

    @NotNull
    @Override
    public StopEventInfo getTargetObject() {
        return StopEventInfo.getInstance(FLAG);
    }

    @NotNull
    @Override
    public QluaStructures.StopEventInfo getTargetObjectAsPbMessage() {

        return QluaStructures.StopEventInfo.newBuilder()
                .setFlag(FLAG)
                .build();
    }
}
