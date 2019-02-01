package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetDepo;
import com.enfernuz.quik.lua.rpc.serde.Serializer;
import org.jetbrains.annotations.NotNull;

public class GetDepoArgsPbSerdeTest extends AbstractPbSerializationTest<GetDepo.Args, qlua.rpc.GetDepo.Args> {

    private static final String CLIENT_CODE = "1";
    private static final String FIRM_ID = "2";
    private static final String SEC_CODE = "3";
    private static final String TRD_ACC_ID = "4";

    @Override
    public @NotNull Serializer<GetDepo.Args> getSerializerUnderTest() {
        return GetDepoArgsPbSerializer.INSTANCE;
    }

    @NotNull
    @Override
    public qlua.rpc.GetDepo.Args getTargetObjectAsPbMessage() {

        return qlua.rpc.GetDepo.Args.newBuilder()
                .setFirmid(FIRM_ID)
                .setClientCode(CLIENT_CODE)
                .setSecCode(SEC_CODE)
                .setTrdaccid(TRD_ACC_ID)
                .build();
    }

    @NotNull
    @Override
    public GetDepo.Args getTargetObject() {

        return GetDepo.Args.builder()
                .firmId(FIRM_ID)
                .clientCode(CLIENT_CODE)
                .secCode(SEC_CODE)
                .trdAccId(TRD_ACC_ID)
                .build();
    }
}
