package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.CalcBuySell;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;

enum CalcBuySellResultPbDeserializer implements Deserializer<CalcBuySell.Result>, FromPbConverter<qlua.rpc.CalcBuySell.Result, CalcBuySell.Result> {

    INSTANCE;

    @NotNull
    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public CalcBuySell.Result deserialize(final byte[] data) {
        return convert( qlua.rpc.CalcBuySell.Result.parseFrom(data) );
    }

    @Override
    public CalcBuySell.Result convert(@NotNull final qlua.rpc.CalcBuySell.Result result) {
        return new CalcBuySell.Result(result.getQty(), result.getComission());
    }
}
