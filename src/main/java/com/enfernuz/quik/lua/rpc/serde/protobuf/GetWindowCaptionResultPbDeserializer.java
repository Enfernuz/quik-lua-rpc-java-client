package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetWindowCaption;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;

import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.convertFromPbString;

enum GetWindowCaptionResultPbDeserializer implements Deserializer<GetWindowCaption.Result>, FromPbConverter<qlua.rpc.GetWindowCaption.Result, GetWindowCaption.Result> {

    INSTANCE;

    @NotNull
    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public GetWindowCaption.Result deserialize(final byte[] data) {
        return convert( qlua.rpc.GetWindowCaption.Result.parseFrom(data) );
    }

    @Override
    public GetWindowCaption.Result convert(@NotNull final qlua.rpc.GetWindowCaption.Result result) {
        return GetWindowCaption.Result.getInstance( convertFromPbString(result.getCaption()) );
    }
}
