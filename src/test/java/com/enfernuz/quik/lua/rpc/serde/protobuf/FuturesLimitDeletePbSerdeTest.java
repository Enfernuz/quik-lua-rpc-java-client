package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.structures.FuturesLimitDelete;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import org.jetbrains.annotations.NotNull;
import qlua.structs.QluaStructures;

public class FuturesLimitDeletePbSerdeTest extends AbstractPbDeserializationTest<QluaStructures.FuturesLimitDelete, FuturesLimitDelete> {

    private static final String FIRM_ID = "1";
    private static final int LIMIT_TYPE = 2;

    @Override
    public @NotNull Deserializer<FuturesLimitDelete> getDeserializerUnderTest() {
        return FuturesLimitDeletePbDeserializer.INSTANCE;
    }

    @NotNull
    @Override
    public FuturesLimitDelete getTargetObject() {

        return FuturesLimitDelete.builder()
                .firmId(FIRM_ID)
                .limitType(LIMIT_TYPE)
                .build();
    }

    @NotNull
    @Override
    public QluaStructures.FuturesLimitDelete getTargetObjectAsPbMessage() {

        return QluaStructures.FuturesLimitDelete.newBuilder()
                .setFirmid(FIRM_ID)
                .setLimitType(LIMIT_TYPE)
                .build();
    }
}
