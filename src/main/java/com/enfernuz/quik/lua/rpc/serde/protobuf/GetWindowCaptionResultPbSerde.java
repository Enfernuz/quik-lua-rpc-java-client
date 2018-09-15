package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetWindowCaption;
import com.enfernuz.quik.lua.rpc.serde.PbConverter;
import com.enfernuz.quik.lua.rpc.serde.Serde;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;

import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.convertFromPbString;
import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.convertToPbString;

enum GetWindowCaptionResultPbSerde implements Serde<GetWindowCaption.Result>, PbConverter<qlua.rpc.GetWindowCaption.Result, GetWindowCaption.Result> {

    INSTANCE;

    @Override
    public byte[] serialize(final GetWindowCaption.Result result) {
        return convertToPb(result).toByteArray();
    }

    @NotNull
    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public GetWindowCaption.Result deserialize(final byte[] data) {
        return convertFromPb( qlua.rpc.GetWindowCaption.Result.parseFrom(data) );
    }

    @Override
    public GetWindowCaption.Result convertFromPb(@NotNull final qlua.rpc.GetWindowCaption.Result result) {
        return GetWindowCaption.Result.getInstance( convertFromPbString(result.getCaption()) );
    }

    @Override
    public qlua.rpc.GetWindowCaption.Result convertToPb(@NotNull final GetWindowCaption.Result result) {

        return qlua.rpc.GetWindowCaption.Result.newBuilder()
                .setCaption( convertToPbString(result.getCaption()) )
                .build();
    }
}
