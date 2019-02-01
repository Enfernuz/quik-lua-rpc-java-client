package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.SendTransaction;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;

enum SendTransactionResultPbDeserializer implements Deserializer<SendTransaction.Result>, FromPbConverter<qlua.rpc.SendTransaction.Result, SendTransaction.Result> {

    INSTANCE;

    @NotNull
    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public SendTransaction.Result deserialize(@NotNull final byte[] data) {
        return convert( qlua.rpc.SendTransaction.Result.parseFrom(data) );
    }

    @NotNull
    @Override
    public SendTransaction.Result convert(@NotNull final qlua.rpc.SendTransaction.Result result) {
        return new SendTransaction.Result( result.getResult() );
    }
}
