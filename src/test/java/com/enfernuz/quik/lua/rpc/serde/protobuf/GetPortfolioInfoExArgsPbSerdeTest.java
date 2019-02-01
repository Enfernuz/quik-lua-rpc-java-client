package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetPortfolioInfoEx;
import com.enfernuz.quik.lua.rpc.serde.Serializer;
import org.jetbrains.annotations.NotNull;

public class GetPortfolioInfoExArgsPbSerdeTest extends AbstractPbSerializationTest<GetPortfolioInfoEx.Args, qlua.rpc.GetPortfolioInfoEx.Args> {

    private static final String FIRM_ID = "1";
    private static final String CLIENT_CODE = "2";
    private static final int LIMIT_KIND = 3;

    @Override
    public @NotNull Serializer<GetPortfolioInfoEx.Args> getSerializerUnderTest() {
        return GetPortfolioInfoExArgsPbSerializer.INSTANCE;
    }

    @NotNull
    @Override
    public qlua.rpc.GetPortfolioInfoEx.Args getTargetObjectAsPbMessage() {

        return qlua.rpc.GetPortfolioInfoEx.Args.newBuilder()
                .setFirmId(FIRM_ID)
                .setClientCode(CLIENT_CODE)
                .setLimitKind(LIMIT_KIND)
                .build();
    }

    @NotNull
    @Override
    public GetPortfolioInfoEx.Args getTargetObject() {

        return GetPortfolioInfoEx.Args.builder()
                .firmId(FIRM_ID)
                .clientCode(CLIENT_CODE)
                .limitKind(LIMIT_KIND)
                .build();
    }
}
