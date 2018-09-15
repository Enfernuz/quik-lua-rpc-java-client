package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetScriptPath;
import com.enfernuz.quik.lua.rpc.serde.PbConverter;
import com.enfernuz.quik.lua.rpc.serde.Serde;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;

enum GetScriptPathResultPbSerde implements Serde<GetScriptPath.Result>, PbConverter<qlua.rpc.GetScriptPath.Result, GetScriptPath.Result> {

    INSTANCE;

    @Override
    public byte[] serialize(final GetScriptPath.Result result) {
        return convertToPb(result).toByteArray();
    }

    @NotNull
    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public GetScriptPath.Result deserialize(final byte[] data) {
        return convertFromPb( qlua.rpc.GetScriptPath.Result.parseFrom(data) );
    }

    @Override
    public GetScriptPath.Result convertFromPb(@NotNull final qlua.rpc.GetScriptPath.Result result) {
        return new GetScriptPath.Result( result.getScriptPath() );
    }

    @Override
    public qlua.rpc.GetScriptPath.Result convertToPb(@NotNull final GetScriptPath.Result result) {
        return qlua.rpc.GetScriptPath.Result.newBuilder()
                .setScriptPath( result.getScriptPath() )
                .build();
    }
}
