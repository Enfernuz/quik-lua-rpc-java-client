package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetTradeDate;
import com.enfernuz.quik.lua.rpc.serde.PbConverter;
import com.enfernuz.quik.lua.rpc.serde.Serde;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;

enum GetTradeDateResultPbSerde implements Serde<GetTradeDate.Result>, PbConverter<qlua.rpc.GetTradeDate.Result, GetTradeDate.Result> {

    INSTANCE;

    @Override
    public byte[] serialize(final GetTradeDate.Result result) {
        return convertToPb(result).toByteArray();
    }

    @NotNull
    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public GetTradeDate.Result deserialize(final byte[] data) {
        return convertFromPb( qlua.rpc.GetTradeDate.Result.parseFrom(data) );
    }

    @NotNull
    @Override
    public GetTradeDate.Result convertFromPb(@NotNull final qlua.rpc.GetTradeDate.Result result) {

        if (!result.hasTradeDate()) {
            throw new IllegalArgumentException("Поле 'trade_date' экземпляра protobuf-представления qlua.rpc.GetTradeDate.Result не инициализировано.");
        }

        final qlua.rpc.GetTradeDate.TradeDate pbTradeDate = result.getTradeDate();
        final GetTradeDate.TradeDate tradeDate = GetTradeDate.TradeDate.builder()
                .date( pbTradeDate.getDate() )
                .year( pbTradeDate.getYear() )
                .month( pbTradeDate.getMonth() )
                .day( pbTradeDate.getDay() )
                .build();

        return new GetTradeDate.Result(tradeDate);
    }

    @NotNull
    @Override
    public qlua.rpc.GetTradeDate.Result convertToPb(@NotNull final GetTradeDate.Result result) {

        final GetTradeDate.TradeDate tradeDate = result.getTradeDate();
        final qlua.rpc.GetTradeDate.TradeDate pbTradeDate = qlua.rpc.GetTradeDate.TradeDate.newBuilder()
                .setDate( tradeDate.getDate() )
                .setYear( tradeDate.getYear() )
                .setMonth( tradeDate.getMonth() )
                .setDay( tradeDate.getDay() )
                .build();

        return qlua.rpc.GetTradeDate.Result.newBuilder()
                .setTradeDate(pbTradeDate)
                .build();
    }
}
