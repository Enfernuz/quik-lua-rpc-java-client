package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.Highlight;
import com.enfernuz.quik.lua.rpc.serde.PbConverter;
import com.enfernuz.quik.lua.rpc.serde.Serde;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;

enum HighlightResultPbSerde implements Serde<Highlight.Result>, PbConverter<qlua.rpc.Highlight.Result, Highlight.Result> {

    INSTANCE;

    @Override
    public byte[] serialize(final Highlight.Result result) {
        return convertToPb(result).toByteArray();
    }

    @NotNull
    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public Highlight.Result deserialize(final byte[] data) {
        return convertFromPb( qlua.rpc.Highlight.Result.parseFrom(data) );
    }

    @Override
    public Highlight.Result convertFromPb(@NotNull final qlua.rpc.Highlight.Result result) {
        return Highlight.Result.getInstance( result.getResult() );
    }

    @Override
    public qlua.rpc.Highlight.Result convertToPb(@NotNull final Highlight.Result result) {
        return qlua.rpc.Highlight.Result.newBuilder()
                .setResult( result.isResult() )
                .build();
    }
}
