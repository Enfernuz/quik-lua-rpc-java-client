package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetDepoEx;
import com.enfernuz.quik.lua.rpc.api.structures.DepoLimit;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;

import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.convertFromPbDepoLimit;

enum GetDepoExResultPbDeserializer implements Deserializer<GetDepoEx.Result>, FromPbConverter<qlua.rpc.GetDepoEx.Result, GetDepoEx.Result> {

    INSTANCE;

    @NotNull
    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public GetDepoEx.Result deserialize(final byte[] data) {
        return convert( qlua.rpc.GetDepoEx.Result.parseFrom(data) );
    }

    @NotNull
    @Override
    public GetDepoEx.Result convert(@NotNull final qlua.rpc.GetDepoEx.Result result) {

        final DepoLimit depoLimit = result.hasDepoEx() ? convertFromPbDepoLimit(result.getDepoEx()) : null;
        return GetDepoEx.Result.getInstance(depoLimit);
    }
}
