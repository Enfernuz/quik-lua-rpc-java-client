package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.structures.DepoLimitDelete;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import org.jetbrains.annotations.NotNull;
import qlua.structs.QluaStructures;

public class DepoLimitDeletePbSerdeTest extends AbstractPbDeserializationTest<QluaStructures.DepoLimitDelete, DepoLimitDelete> {

    private static final String SEC_CODE = "1";
    private static final String TRD_ACC_ID = "2";
    private static final String FIRM_ID = "3";
    private static final String CLIENT_CODE = "4";
    private static final int LIMIT_KIND = 5;

    @Override
    public @NotNull Deserializer<DepoLimitDelete> getDeserializerUnderTest() {
        return DepoLimitDeletePbDeserializer.INSTANCE;
    }

    @NotNull
    @Override
    public DepoLimitDelete getTargetObject() {

        return DepoLimitDelete.builder()
                .secCode(SEC_CODE)
                .trdAccId(TRD_ACC_ID)
                .firmId(FIRM_ID)
                .clientCode(CLIENT_CODE)
                .limitKind(LIMIT_KIND)
                .build();
    }

    @NotNull
    @Override
    public QluaStructures.DepoLimitDelete getTargetObjectAsPbMessage() {

        return QluaStructures.DepoLimitDelete.newBuilder()
                .setSecCode(SEC_CODE)
                .setTrdaccid(TRD_ACC_ID)
                .setFirmid(FIRM_ID)
                .setClientCode(CLIENT_CODE)
                .setLimitKind(LIMIT_KIND)
                .build();
    }
}
