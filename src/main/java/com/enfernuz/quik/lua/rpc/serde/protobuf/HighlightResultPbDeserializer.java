package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.Highlight;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;

enum HighlightResultPbDeserializer implements Deserializer<Highlight.Result>, FromPbConverter<qlua.rpc.Highlight.Result, Highlight.Result> {

    INSTANCE;

    @NotNull
    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public Highlight.Result deserialize(final byte[] data) {
        return convert( qlua.rpc.Highlight.Result.parseFrom(data) );
    }

    @Override
    public Highlight.Result convert(@NotNull final qlua.rpc.Highlight.Result result) {
        return Highlight.Result.getInstance( result.getResult() );
    }
}
