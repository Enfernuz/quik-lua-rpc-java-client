package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetMoneyEx;
import com.google.protobuf.MessageLite;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qlua.rpc.RPC;

public class GetMoneyExRequestPbSerdeTest extends AbstractRequestPbSerdeTest<GetMoneyEx.Request> {

    private static final String FIRM_ID = "1";
    private static final String CLIENT_CODE = "2";
    private static final String TAG = "3";
    private static final String CURR_CODE = "4";
    private static final int LIMIT_KIND = 5;

    @Override
    public RPC.@NotNull ProcedureType getProcedureType() {
        return RPC.ProcedureType.GET_MONEY_EX;
    }

    @Override
    public @Nullable MessageLite getPbRequestArgs() {
        return qlua.rpc.GetMoneyEx.Request.newBuilder()
                .setFirmid(FIRM_ID)
                .setClientCode(CLIENT_CODE)
                .setTag(TAG)
                .setCurrcode(CURR_CODE)
                .setLimitKind(LIMIT_KIND)
                .build();
    }

    @Override
    public @NotNull Class<GetMoneyEx.Request> getTargetObjectClass() {
        return GetMoneyEx.Request.class;
    }

    @NotNull
    @Override
    public GetMoneyEx.Request getTargetObject() {
        return GetMoneyEx.Request.builder()
                .firmId(FIRM_ID)
                .clientCode(CLIENT_CODE)
                .tag(TAG)
                .currCode(CURR_CODE)
                .limitKind(LIMIT_KIND)
                .build();
    }
}
