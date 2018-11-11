package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetMoneyEx;
import com.enfernuz.quik.lua.rpc.serde.Serializer;
import org.jetbrains.annotations.NotNull;

public class GetMoneyExRequestPbSerdeTest extends AbstractPbSerializationTest<GetMoneyEx.Args, qlua.rpc.GetMoneyEx.Request> {

    private static final String FIRM_ID = "1";
    private static final String CLIENT_CODE = "2";
    private static final String TAG = "3";
    private static final String CURR_CODE = "4";
    private static final int LIMIT_KIND = 5;

    @Override
    public @NotNull Serializer<GetMoneyEx.Args> getSerializerUnderTest() {
        return GetMoneyExArgsPbSerializer.INSTANCE;
    }

    @NotNull
    @Override
    public qlua.rpc.GetMoneyEx.Request getTargetObjectAsPbMessage() {

        return qlua.rpc.GetMoneyEx.Request.newBuilder()
                .setFirmid(FIRM_ID)
                .setClientCode(CLIENT_CODE)
                .setTag(TAG)
                .setCurrcode(CURR_CODE)
                .setLimitKind(LIMIT_KIND)
                .build();
    }

    @NotNull
    @Override
    public GetMoneyEx.Args getTargetObject() {

        return GetMoneyEx.Args.builder()
                .firmId(FIRM_ID)
                .clientCode(CLIENT_CODE)
                .tag(TAG)
                .currCode(CURR_CODE)
                .limitKind(LIMIT_KIND)
                .build();
    }
}
