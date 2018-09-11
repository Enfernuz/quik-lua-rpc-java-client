package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetDepo;
import com.google.protobuf.MessageLite;
import org.jetbrains.annotations.NotNull;
import qlua.rpc.RPC;

public class GetDepoRequestPbSerdeTest extends AbstractRequestPbSerdeTest<GetDepo.Request> {

    private static final String CLIENT_CODE = "1";
    private static final String FIRM_ID = "2";
    private static final String SEC_CODE = "3";
    private static final String TRD_ACC_ID = "4";

    @NotNull
    @Override
    public RPC.ProcedureType getProcedureType() {
        return RPC.ProcedureType.GET_DEPO;
    }

    @NotNull
    @Override
    public Class<GetDepo.Request> getTargetObjectClass() {
        return GetDepo.Request.class;
    }

    @NotNull
    @Override
    public GetDepo.Request getTargetObject() {
        return GetDepo.Request.builder()
                .clientCode(CLIENT_CODE)
                .firmId(FIRM_ID)
                .secCode(SEC_CODE)
                .trdAccId(TRD_ACC_ID)
                .build();
    }

    @NotNull
    @Override
    public MessageLite getPbRequestArgs() {
        return qlua.rpc.GetDepo.Request.newBuilder()
                .setClientCode(CLIENT_CODE)
                .setFirmid(FIRM_ID)
                .setSecCode(SEC_CODE)
                .setTrdaccid(TRD_ACC_ID)
                .build();
    }
}
