package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetCandlesByIndex;
import com.enfernuz.quik.lua.rpc.api.structures.CandleEntry;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import com.google.common.collect.ImmutableList;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import qlua.structs.QluaStructures;

import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.convertFromPbCandleEntry;

enum GetCandlesByIndexResultPbDeserializer implements Deserializer<GetCandlesByIndex.Result>, FromPbConverter<qlua.rpc.GetCandlesByIndex.Result, GetCandlesByIndex.Result> {

    INSTANCE;

    @NotNull
    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public GetCandlesByIndex.Result deserialize(final byte[] data) {
        return convert( qlua.rpc.GetCandlesByIndex.Result.parseFrom(data) );
    }

    @Override
    public GetCandlesByIndex.Result convert(@NotNull final qlua.rpc.GetCandlesByIndex.Result result) {

        final ImmutableList.Builder<CandleEntry> candles = ImmutableList.builder();
        for (final QluaStructures.CandleEntry pbCandleEntry : result.getTList()) {
            candles.add( convertFromPbCandleEntry(pbCandleEntry) );
        }

        return new GetCandlesByIndex.Result(
                candles.build(),
                result.getN(),
                result.getL()
        );
    }
}
