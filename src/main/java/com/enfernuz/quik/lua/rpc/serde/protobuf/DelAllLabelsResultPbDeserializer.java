package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.DelAllLabels;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;

enum DelAllLabelsResultPbDeserializer implements Deserializer<DelAllLabels.Result>, FromPbConverter<qlua.rpc.DelAllLabels.Result, DelAllLabels.Result> {

    INSTANCE;

    @NotNull
    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public DelAllLabels.Result deserialize(final byte[] data) {
        return convert( qlua.rpc.DelAllLabels.Result.parseFrom(data) );
    }

    @Override
    public DelAllLabels.Result convert(@NotNull final qlua.rpc.DelAllLabels.Result result) {
        return DelAllLabels.Result.getInstance( result.getResult() );
    }
}
