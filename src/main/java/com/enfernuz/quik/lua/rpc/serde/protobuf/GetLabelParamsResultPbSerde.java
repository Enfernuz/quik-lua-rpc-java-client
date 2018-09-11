package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetLabelParams;
import com.enfernuz.quik.lua.rpc.serde.PbConverter;
import com.enfernuz.quik.lua.rpc.serde.Serde;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

enum GetLabelParamsResultPbSerde implements Serde<GetLabelParams.Result>, PbConverter<qlua.rpc.GetLabelParams.Result, GetLabelParams.Result> {

    INSTANCE;

    @Override
    public byte[] serialize(final GetLabelParams.Result result) {
        return convertToPb(result).toByteArray();
    }

    @NotNull
    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public GetLabelParams.Result deserialize(final byte[] data) {
        return convertFromPb( qlua.rpc.GetLabelParams.Result.parseFrom(data) );
    }

    @NotNull
    @Override
    public GetLabelParams.Result convertFromPb(@NotNull final qlua.rpc.GetLabelParams.Result result) {
        return GetLabelParams.Result.getInstance( result.getLabelParamsMap() );
    }

    @NotNull
    @Override
    public qlua.rpc.GetLabelParams.Result convertToPb(@NotNull final GetLabelParams.Result result) {

        final qlua.rpc.GetLabelParams.Result.Builder pbResult = qlua.rpc.GetLabelParams.Result.newBuilder();
        final Map<String, String> labelParams = result.getLabelParams();
        if (labelParams != null) {
            pbResult.putAllLabelParams(labelParams);
        }

        return pbResult.build();
    }
}
