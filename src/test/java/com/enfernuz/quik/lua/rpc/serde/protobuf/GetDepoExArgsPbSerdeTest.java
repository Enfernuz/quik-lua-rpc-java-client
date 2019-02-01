package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetDepoEx;
import com.enfernuz.quik.lua.rpc.serde.Serializer;
import org.jetbrains.annotations.NotNull;

public class GetDepoExArgsPbSerdeTest extends AbstractPbSerializationTest<GetDepoEx.Args, qlua.rpc.GetDepoEx.Args> {

    private static final String FIRM_ID = "1";
    private static final String CLIENT_CODE = "2";
    private static final String SEC_CODE = "3";
    private static final String TRD_ACC_ID = "4";
    private static final int LIMIT_KIND = 5;

    @Override
    public @NotNull Serializer<GetDepoEx.Args> getSerializerUnderTest() {
        return GetDepoExArgsPbSerializer.INSTANCE;
    }

    @NotNull
    @Override
    public qlua.rpc.GetDepoEx.Args getTargetObjectAsPbMessage() {

        return qlua.rpc.GetDepoEx.Args.newBuilder()
                .setFirmid(FIRM_ID)
                .setClientCode(CLIENT_CODE)
                .setSecCode(SEC_CODE)
                .setTrdaccid(TRD_ACC_ID)
                .setLimitKind(LIMIT_KIND)
                .build();
    }

    @NotNull
    @Override
    public GetDepoEx.Args getTargetObject() {

        return GetDepoEx.Args.builder()
                .firmId(FIRM_ID)
                .clientCode(CLIENT_CODE)
                .secCode(SEC_CODE)
                .trdAccId(TRD_ACC_ID)
                .limitKind(LIMIT_KIND)
                .build();
    }
}
