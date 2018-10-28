package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetLabelParams;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;

enum GetLabelParamsResultPbDeserializer implements Deserializer<GetLabelParams.Result>, FromPbConverter<qlua.rpc.GetLabelParams.Result, GetLabelParams.Result> {

    INSTANCE;

    @NotNull
    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public GetLabelParams.Result deserialize(final byte[] data) {
        return convert( qlua.rpc.GetLabelParams.Result.parseFrom(data) );
    }

    @NotNull
    @Override
    public GetLabelParams.Result convert(@NotNull final qlua.rpc.GetLabelParams.Result result) {
        return GetLabelParams.Result.getInstance(result.getNullLabelParams() ? null : result.getLabelParamsMap());
    }
}
