package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetFuturesLimit;
import com.enfernuz.quik.lua.rpc.serde.Serializer;
import org.jetbrains.annotations.NotNull;

public class GetFuturesLimitArgsPbSerdeTest extends AbstractPbSerializationTest<GetFuturesLimit.Args, qlua.rpc.GetFuturesLimit.Args> {

    private static final String FIRM_ID = "1";
    private static final String TRD_ACC_ID = "2";
    private static final int LIMIT_TYPE = 3;
    private static final String CURR_CODE = "4";

    @Override
    public @NotNull Serializer<GetFuturesLimit.Args> getSerializerUnderTest() {
        return GetFuturesLimitArgsPbSerializer.INSTANCE;
    }

    @NotNull
    @Override
    public qlua.rpc.GetFuturesLimit.Args getTargetObjectAsPbMessage() {

        return qlua.rpc.GetFuturesLimit.Args.newBuilder()
                .setFirmid(FIRM_ID)
                .setTrdaccid(TRD_ACC_ID)
                .setLimitType(LIMIT_TYPE)
                .setCurrcode(CURR_CODE)
                .build();
    }

    @NotNull
    @Override
    public GetFuturesLimit.Args getTargetObject() {

        return GetFuturesLimit.Args.builder()
                .firmId(FIRM_ID)
                .trdAccId(TRD_ACC_ID)
                .limitType(LIMIT_TYPE)
                .currCode(CURR_CODE)
                .build();
    }
}
