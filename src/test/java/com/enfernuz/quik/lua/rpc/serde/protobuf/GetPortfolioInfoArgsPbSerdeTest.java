package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetPortfolioInfo;
import com.enfernuz.quik.lua.rpc.serde.Serializer;
import org.jetbrains.annotations.NotNull;

public class GetPortfolioInfoArgsPbSerdeTest extends AbstractPbSerializationTest<GetPortfolioInfo.Args, qlua.rpc.GetPortfolioInfo.Args> {

    private static final String FIRM_ID = "1";
    private static final String CLIENT_CODE = "2";

    @Override
    public @NotNull Serializer<GetPortfolioInfo.Args> getSerializerUnderTest() {
        return GetPortfolioInfoArgsPbSerializer.INSTANCE;
    }

    @NotNull
    @Override
    public qlua.rpc.GetPortfolioInfo.Args getTargetObjectAsPbMessage() {

        return qlua.rpc.GetPortfolioInfo.Args.newBuilder()
                .setFirmId(FIRM_ID)
                .setClientCode(CLIENT_CODE)
                .build();
    }

    @NotNull
    @Override
    public GetPortfolioInfo.Args getTargetObject() {

        return GetPortfolioInfo.Args.builder()
                .firmId(FIRM_ID)
                .clientCode(CLIENT_CODE)
                .build();
    }
}
