package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetScriptPath;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;

enum GetScriptPathResultPbDeserializer implements Deserializer<GetScriptPath.Result>, FromPbConverter<qlua.rpc.GetScriptPath.Result, GetScriptPath.Result> {

    INSTANCE;

    @NotNull
    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public GetScriptPath.Result deserialize(final byte[] data) {
        return convert( qlua.rpc.GetScriptPath.Result.parseFrom(data) );
    }

    @Override
    public GetScriptPath.Result convert(@NotNull final qlua.rpc.GetScriptPath.Result result) {
        return new GetScriptPath.Result( result.getScriptPath() );
    }
}
