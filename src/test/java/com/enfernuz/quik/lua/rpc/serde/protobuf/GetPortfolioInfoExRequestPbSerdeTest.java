package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetPortfolioInfoEx;
import com.google.protobuf.MessageLite;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qlua.rpc.RPC;

public class GetPortfolioInfoExRequestPbSerdeTest extends AbstractRequestPbSerdeTest<GetPortfolioInfoEx.Request> {

    private static final String FIRM_ID = "1";
    private static final String CLIENT_CODE = "2";
    private static final int LIMIT_KIND = 3;

    @Override
    public RPC.@NotNull ProcedureType getProcedureType() {
        return RPC.ProcedureType.GET_PORTFOLIO_INFO_EX;
    }

    @Override
    public @Nullable MessageLite getPbRequestArgs() {
        return qlua.rpc.GetPortfolioInfoEx.Request.newBuilder()
                .setFirmId(FIRM_ID)
                .setClientCode(CLIENT_CODE)
                .setLimitKind(LIMIT_KIND)
                .build();
    }

    @Override
    public @NotNull Class<GetPortfolioInfoEx.Request> getTargetObjectClass() {
        return GetPortfolioInfoEx.Request.class;
    }

    @NotNull
    @Override
    public GetPortfolioInfoEx.Request getTargetObject() {
        return GetPortfolioInfoEx.Request.builder()
                .firmId(FIRM_ID)
                .clientCode(CLIENT_CODE)
                .limitKind(LIMIT_KIND)
                .build();
    }
}
