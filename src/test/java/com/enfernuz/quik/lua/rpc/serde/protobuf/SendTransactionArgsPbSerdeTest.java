package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.SendTransaction;
import com.enfernuz.quik.lua.rpc.serde.Serializer;
import com.google.common.collect.ImmutableMap;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

public class SendTransactionArgsPbSerdeTest extends AbstractPbSerializationTest<SendTransaction.Args, qlua.rpc.SendTransaction.Args> {

    private static final Map<String, String> TRANSACTION = createTransaction();

    @Override
    public @NotNull Serializer<SendTransaction.Args> getSerializerUnderTest() {
        return SendTransactionArgsPbSerializer.INSTANCE;
    }

    @NotNull
    @Override
    public qlua.rpc.SendTransaction.Args getTargetObjectAsPbMessage() {

        return qlua.rpc.SendTransaction.Args.newBuilder()
                .putAllTransaction(TRANSACTION)
                .build();
    }

    @NotNull
    @Override
    public SendTransaction.Args getTargetObject() {
        return new SendTransaction.Args(TRANSACTION);
    }

    private static Map<String, String> createTransaction() {

        return ImmutableMap.<String, String>builder()
                    .put("k1", "v1")
                    .put("k2", "v2")
                    .put("k3", "v3")
                    .put("k4", "v4")
                    .put("k5", "v5")
                    .build();
    }
}
