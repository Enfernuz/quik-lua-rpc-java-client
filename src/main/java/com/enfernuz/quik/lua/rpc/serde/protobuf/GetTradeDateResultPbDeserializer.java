package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetTradeDate;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;

enum GetTradeDateResultPbDeserializer implements Deserializer<GetTradeDate.Result>, FromPbConverter<qlua.rpc.GetTradeDate.Result, GetTradeDate.Result> {

    INSTANCE;

    @NotNull
    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public GetTradeDate.Result deserialize(final byte[] data) {
        return convert( qlua.rpc.GetTradeDate.Result.parseFrom(data) );
    }

    @NotNull
    @Override
    public GetTradeDate.Result convert(@NotNull final qlua.rpc.GetTradeDate.Result result) {

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
}
