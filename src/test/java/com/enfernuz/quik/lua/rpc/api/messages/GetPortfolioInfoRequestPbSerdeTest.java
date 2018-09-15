package com.enfernuz.quik.lua.rpc.api.messages;

import com.enfernuz.quik.lua.rpc.serde.protobuf.AbstractRequestPbSerdeTest;
import com.google.protobuf.MessageLite;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qlua.rpc.RPC;

public class GetPortfolioInfoRequestPbSerdeTest extends AbstractRequestPbSerdeTest<GetPortfolioInfo.Request> {

    private static final String FIRM_ID = "1";
    private static final String CLIENT_CODE = "2";

    @Override
    public RPC.@NotNull ProcedureType getProcedureType() {
        return RPC.ProcedureType.GET_PORTFOLIO_INFO;
    }

    @Override
    public @Nullable MessageLite getPbRequestArgs() {
        return qlua.rpc.GetPortfolioInfo.Request.newBuilder()
                .setFirmId(FIRM_ID)
                .setClientCode(CLIENT_CODE)
                .build();
    }

    @Override
    public @NotNull Class<GetPortfolioInfo.Request> getTargetObjectClass() {
        return GetPortfolioInfo.Request.class;
    }

    @NotNull
    @Override
    public GetPortfolioInfo.Request getTargetObject() {
        return GetPortfolioInfo.Request.builder()
                .firmId(FIRM_ID)
                .clientCode(CLIENT_CODE)
                .build();
    }
}
