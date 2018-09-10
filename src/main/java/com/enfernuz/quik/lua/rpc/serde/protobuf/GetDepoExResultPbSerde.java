package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetDepoEx;
import com.enfernuz.quik.lua.rpc.api.structures.DepoLimit;
import com.enfernuz.quik.lua.rpc.serde.PbConverter;
import com.enfernuz.quik.lua.rpc.serde.Serde;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;

import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.*;

enum GetDepoExResultPbSerde implements Serde<GetDepoEx.Result>, PbConverter<qlua.rpc.GetDepoEx.Result, GetDepoEx.Result> {

    INSTANCE;

    @Override
    public byte[] serialize(final GetDepoEx.Result result) {
        return convertToPb(result).toByteArray();
    }

    @NotNull
    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public GetDepoEx.Result deserialize(final byte[] data) {
        return convertFromPb( qlua.rpc.GetDepoEx.Result.parseFrom(data) );
    }

    @NotNull
    @Override
    public GetDepoEx.Result convertFromPb(@NotNull final qlua.rpc.GetDepoEx.Result result) {

        final DepoLimit depoLimit = result.hasDepoEx() ? convertFromPbDepoLimit(result.getDepoEx()) : null;
        return GetDepoEx.Result.getInstance(depoLimit);
    }

    @NotNull
    @Override
    public qlua.rpc.GetDepoEx.Result convertToPb(@NotNull final GetDepoEx.Result result) {

        final qlua.rpc.GetDepoEx.Result.Builder pbResult = qlua.rpc.GetDepoEx.Result.newBuilder();
        final DepoLimit depoLimit = result.getDepoEx();
        if (depoLimit != null) {
            pbResult.setDepoEx( convertToPbDepoLimit(depoLimit) );
        }

        return pbResult.build();
    }
}
