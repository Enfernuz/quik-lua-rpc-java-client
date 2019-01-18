package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.SendTransaction;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import org.jetbrains.annotations.NotNull;

public class SendTransactionResultPbSerdeTest extends AbstractPbDeserializationTest<qlua.rpc.SendTransaction.Result, SendTransaction.Result> {

    private static final String RESULT = "1";

    @Override
    public @NotNull Deserializer<SendTransaction.Result> getDeserializerUnderTest() {
        return SendTransactionResultPbDeserializer.INSTANCE;
    }

    @NotNull
    @Override
    public SendTransaction.Result getTargetObject() {
        return new SendTransaction.Result(RESULT);
    }

    @NotNull
    @Override
    public qlua.rpc.SendTransaction.Result getTargetObjectAsPbMessage() {

        return qlua.rpc.SendTransaction.Result.newBuilder()
                .setResult(RESULT)
                .build();
    }
}
