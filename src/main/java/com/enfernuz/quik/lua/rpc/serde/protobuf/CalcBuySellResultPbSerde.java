package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.CalcBuySell;
import com.enfernuz.quik.lua.rpc.serde.PbConverter;
import com.enfernuz.quik.lua.rpc.serde.Serde;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;

enum CalcBuySellResultPbSerde implements Serde<CalcBuySell.Result>, PbConverter<qlua.rpc.CalcBuySell.Result, CalcBuySell.Result> {

    INSTANCE;

    @Override
    public byte[] serialize(final CalcBuySell.Result result) {
        return convertToPb(result).toByteArray();
    }

    @NotNull
    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public CalcBuySell.Result deserialize(final byte[] data) {
        return convertFromPb( qlua.rpc.CalcBuySell.Result.parseFrom(data) );
    }

    @Override
    public CalcBuySell.Result convertFromPb(@NotNull final qlua.rpc.CalcBuySell.Result result) {
        return new CalcBuySell.Result(result.getQty(), result.getComission());
    }

    @Override
    public qlua.rpc.CalcBuySell.Result convertToPb(@NotNull final CalcBuySell.Result result) {
        return qlua.rpc.CalcBuySell.Result.newBuilder()
                .setQty( result.getQty() )
                .setComission( result.getComission() )
                .build();
    }
}
