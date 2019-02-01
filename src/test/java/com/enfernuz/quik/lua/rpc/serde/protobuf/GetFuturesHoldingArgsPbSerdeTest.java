package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetFuturesHolding;
import com.enfernuz.quik.lua.rpc.serde.Serializer;
import org.jetbrains.annotations.NotNull;

public class GetFuturesHoldingArgsPbSerdeTest extends AbstractPbSerializationTest<GetFuturesHolding.Args, qlua.rpc.GetFuturesHolding.Args> {

    private static final String FIRM_ID = "1";
    private static final String TRD_ACC_ID = "2";
    private static final String SEC_CODE = "3";
    private static final int TYPE = 4;

    @Override
    public @NotNull Serializer<GetFuturesHolding.Args> getSerializerUnderTest() {
        return GetFuturesHoldingArgsPbSerializer.INSTANCE;
    }

    @NotNull
    @Override
    public qlua.rpc.GetFuturesHolding.Args getTargetObjectAsPbMessage() {

        return qlua.rpc.GetFuturesHolding.Args.newBuilder()
                .setFirmid(FIRM_ID)
                .setTrdaccid(TRD_ACC_ID)
                .setSecCode(SEC_CODE)
                .setType(TYPE)
                .build();
    }

    @NotNull
    @Override
    public GetFuturesHolding.Args getTargetObject() {

        return GetFuturesHolding.Args.builder()
                .firmId(FIRM_ID)
                .trdAccId(TRD_ACC_ID)
                .secCode(SEC_CODE)
                .type(TYPE)
                .build();
    }
}
