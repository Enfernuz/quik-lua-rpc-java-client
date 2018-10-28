package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.SetTableNotificationCallback;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;

enum SetTableNotificationCallbackResultPbDeserializer implements Deserializer<SetTableNotificationCallback.Result>, FromPbConverter<qlua.rpc.SetTableNotificationCallback.Result, SetTableNotificationCallback.Result> {

    INSTANCE;

    @NotNull
    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public SetTableNotificationCallback.Result deserialize(@NotNull final byte[] data) {
        return convert( qlua.rpc.SetTableNotificationCallback.Result.parseFrom(data) );
    }

    @NotNull
    @Override
    public SetTableNotificationCallback.Result convert(@NotNull final qlua.rpc.SetTableNotificationCallback.Result result) {
        return SetTableNotificationCallback.Result.getInstance( result.getResult() );
    }
}
