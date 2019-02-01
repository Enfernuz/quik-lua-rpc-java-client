package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetBuySellInfoEx;
import com.enfernuz.quik.lua.rpc.serde.Serializer;
import org.jetbrains.annotations.NotNull;

public class GetBuySellInfoExArgsPbSerdeTest extends AbstractPbSerializationTest<GetBuySellInfoEx.Args, qlua.rpc.GetBuySellInfoEx.Args> {

    private static final String FIRM_ID = "1";
    private static final String CLIENT_CODE = "2";
    private static final String CLASS_CODE = "3";
    private static final String SEC_CODE = "4";
    private static final String PRICE = "5";

    @Override
    public @NotNull Serializer<GetBuySellInfoEx.Args> getSerializerUnderTest() {
        return GetBuySellInfoExArgsPbSerializer.INSTANCE;
    }

    @NotNull
    @Override
    public qlua.rpc.GetBuySellInfoEx.Args getTargetObjectAsPbMessage() {

        return qlua.rpc.GetBuySellInfoEx.Args.newBuilder()
                .setFirmId(FIRM_ID)
                .setClientCode(CLIENT_CODE)
                .setClassCode(CLASS_CODE)
                .setSecCode(SEC_CODE)
                .setPrice(PRICE)
                .build();
    }

    @NotNull
    @Override
    public GetBuySellInfoEx.Args getTargetObject() {

        return GetBuySellInfoEx.Args.builder()
                .firmId(FIRM_ID)
                .clientCode(CLIENT_CODE)
                .classCode(CLASS_CODE)
                .secCode(SEC_CODE)
                .price(PRICE)
                .build();
    }
}
