package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetMoney;
import com.google.protobuf.MessageLite;
import org.jetbrains.annotations.NotNull;
import qlua.rpc.RPC;

public class GetMoneyRequestPbSerdeTest extends AbstractRequestPbSerdeTest<GetMoney.Request> {

    private static final String CLIENT_CODE = "1";
    private static final String FIRM_ID = "2";
    private static final String TAG = "3";
    private static final String CURR_CODE = "4";

    @NotNull
    @Override
    public GetMoney.Request getTargetObject() {
        return GetMoney.Request.builder()
                .clientCode(CLIENT_CODE)
                .firmId(FIRM_ID)
                .tag(TAG)
                .currCode(CURR_CODE)
                .build();
    }

    @NotNull
    @Override
    public RPC.ProcedureType getProcedureType() {
        return RPC.ProcedureType.GET_MONEY;
    }

    @NotNull
    @Override
    public MessageLite getPbRequestArgs() {
        return qlua.rpc.GetMoney.Request.newBuilder()
                .setClientCode(CLIENT_CODE)
                .setFirmid(FIRM_ID)
                .setTag(TAG)
                .setCurrcode(CURR_CODE)
                .build();
    }

    @NotNull
    @Override
    public Class<GetMoney.Request> getTargetObjectClass() {
        return GetMoney.Request.class;
    }
}
