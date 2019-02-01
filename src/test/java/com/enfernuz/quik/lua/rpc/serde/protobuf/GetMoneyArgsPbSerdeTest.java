package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetMoney;
import com.enfernuz.quik.lua.rpc.serde.Serializer;
import org.jetbrains.annotations.NotNull;

public class GetMoneyArgsPbSerdeTest extends AbstractPbSerializationTest<GetMoney.Args, qlua.rpc.GetMoney.Args> {

    private static final String CLIENT_CODE = "1";
    private static final String FIRM_ID = "2";
    private static final String TAG = "3";
    private static final String CURR_CODE = "4";

    @Override
    public @NotNull Serializer<GetMoney.Args> getSerializerUnderTest() {
        return GetMoneyArgsPbSerializer.INSTANCE;
    }

    @NotNull
    @Override
    public qlua.rpc.GetMoney.Args getTargetObjectAsPbMessage() {

        return qlua.rpc.GetMoney.Args.newBuilder()
                .setClientCode(CLIENT_CODE)
                .setFirmid(FIRM_ID)
                .setTag(TAG)
                .setCurrcode(CURR_CODE)
                .build();
    }

    @NotNull
    @Override
    public GetMoney.Args getTargetObject() {

        return GetMoney.Args.builder()
                .clientCode(CLIENT_CODE)
                .firmId(FIRM_ID)
                .tag(TAG)
                .currCode(CURR_CODE)
                .build();
    }
}
