package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.Message;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;

enum MessageResultPbDeserializer implements Deserializer<Message.Result>, FromPbConverter<qlua.rpc.Message.Result, Message.Result> {

    INSTANCE;

    @NotNull
    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public Message.Result deserialize(final byte[] data) {
        return convert( qlua.rpc.Message.Result.parseFrom(data) );
    }

    @Override
    public Message.Result convert(@NotNull final qlua.rpc.Message.Result result) {

        if (result.getNullResult()) {
            return Message.Result.getInstance(null);
        }

        return Message.Result.getInstance(result.getValueResult());
    }
}
