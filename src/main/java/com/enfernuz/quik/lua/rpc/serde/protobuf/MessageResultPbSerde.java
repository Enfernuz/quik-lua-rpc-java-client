package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.Message;
import com.enfernuz.quik.lua.rpc.serde.PbConverter;
import com.enfernuz.quik.lua.rpc.serde.Serde;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import qlua.rpc.RPC;

import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.assertEquals;

enum MessageResultPbSerde implements Serde<Message.Result>, PbConverter<qlua.rpc.Message.Result, Message.Result> {

    INSTANCE;

    @Override
    public byte[] serialize(final Message.Result result) {
        return convertToPb(result).toByteArray();
    }

    @NotNull
    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public Message.Result deserialize(final byte[] data) {
        return convertFromPb( qlua.rpc.Message.Result.parseFrom(data) );
    }

    @Override
    public Message.Result convertFromPb(@NotNull final qlua.rpc.Message.Result result) {
        return new Message.Result( result.getResult() );
    }

    @Override
    public qlua.rpc.Message.Result convertToPb(@NotNull final Message.Result result) {
        return qlua.rpc.Message.Result.newBuilder()
                .setResult( result.getResult() )
                .build();
    }
}
