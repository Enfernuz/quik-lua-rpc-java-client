package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.SetLabelParams;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;

enum SetLabelParamsResultPbDeserializer implements Deserializer<SetLabelParams.Result>, FromPbConverter<qlua.rpc.SetLabelParams.Result, SetLabelParams.Result> {

    INSTANCE;

    @NotNull
    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public SetLabelParams.Result deserialize(@NotNull final byte[] data) {
        return convert( qlua.rpc.SetLabelParams.Result.parseFrom(data) );
    }

    @NotNull
    @Override
    public SetLabelParams.Result convert(@NotNull final qlua.rpc.SetLabelParams.Result result) {
        return SetLabelParams.Result.getInstance( result.getResult() );
    }
}
