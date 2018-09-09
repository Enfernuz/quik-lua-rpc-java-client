package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetCandlesByIndex;
import com.enfernuz.quik.lua.rpc.api.structures.CandleEntry;
import com.enfernuz.quik.lua.rpc.serde.PbConverter;
import com.enfernuz.quik.lua.rpc.serde.Serde;
import com.google.common.collect.ImmutableList;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import qlua.structs.QluaStructures;

import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.convertFromPbCandleEntry;
import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.convertToPbCandleEntry;

enum GetCandlesByIndexResultPbSerde implements Serde<GetCandlesByIndex.Result>, PbConverter<qlua.rpc.GetCandlesByIndex.Result, GetCandlesByIndex.Result> {

    INSTANCE;

    @Override
    public byte[] serialize(final GetCandlesByIndex.Result result) {
        return convertToPb(result).toByteArray();
    }

    @NotNull
    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public GetCandlesByIndex.Result deserialize(final byte[] data) {
        return convertFromPb( qlua.rpc.GetCandlesByIndex.Result.parseFrom(data) );
    }

    @Override
    public GetCandlesByIndex.Result convertFromPb(@NotNull final qlua.rpc.GetCandlesByIndex.Result result) {

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

    @Override
    public qlua.rpc.GetCandlesByIndex.Result convertToPb(@NotNull final GetCandlesByIndex.Result result) {

        final ImmutableList.Builder<QluaStructures.CandleEntry> pbCandles = ImmutableList.builder();
        for (final CandleEntry candleEntry : result.getT()) {
            pbCandles.add( convertToPbCandleEntry(candleEntry) );
        }

        return qlua.rpc.GetCandlesByIndex.Result.newBuilder()
                .addAllT(pbCandles.build())
                .setN( result.getN() )
                .setL( result.getL() )
                .build();
    }
}
