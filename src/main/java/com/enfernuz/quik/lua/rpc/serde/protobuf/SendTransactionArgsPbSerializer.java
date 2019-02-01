package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.SendTransaction;
import com.enfernuz.quik.lua.rpc.serde.Serializer;
import org.jetbrains.annotations.NotNull;

enum SendTransactionArgsPbSerializer implements Serializer<SendTransaction.Args>, ToPbConverter<SendTransaction.Args, qlua.rpc.SendTransaction.Args> {

    INSTANCE;

    @NotNull
    @Override
    public byte[] serialize(@NotNull final SendTransaction.Args args) {
        return convert(args).toByteArray();
    }

    @NotNull
    @Override
    public qlua.rpc.SendTransaction.Args convert(@NotNull final SendTransaction.Args args) {

        return qlua.rpc.SendTransaction.Args.newBuilder()
                .putAllTransaction( args.getTransaction() )
                .build();
    }
}
