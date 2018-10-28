package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.SetWindowCaption;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;

enum SetWindowCaptionResultPbDeserializer implements Deserializer<SetWindowCaption.Result>, FromPbConverter<qlua.rpc.SetWindowCaption.Result, SetWindowCaption.Result> {

    INSTANCE;

    @NotNull
    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public SetWindowCaption.Result deserialize(@NotNull final byte[] data) {
        return convert( qlua.rpc.SetWindowCaption.Result.parseFrom(data) );
    }

    @Override
    public SetWindowCaption.Result convert(@NotNull final qlua.rpc.SetWindowCaption.Result result) {
        return SetWindowCaption.Result.getInstance( result.getResult() );
    }
}
