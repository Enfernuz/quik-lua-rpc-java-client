package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.SubscribeLevel2Quotes;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import qlua.rpc.SubscribeLevelIIQuotes;

enum SubscribeLevel2QuotesResultPbDeserializer implements Deserializer<SubscribeLevel2Quotes.Result>, FromPbConverter<qlua.rpc.SubscribeLevelIIQuotes.Result, SubscribeLevel2Quotes.Result> {

    INSTANCE;

    @NotNull
    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public SubscribeLevel2Quotes.Result deserialize(@NotNull final byte[] data) {
        return convert( SubscribeLevelIIQuotes.Result.parseFrom(data) );
    }

    @NotNull
    @Override
    public SubscribeLevel2Quotes.Result convert(@NotNull final SubscribeLevelIIQuotes.Result result) {
        return SubscribeLevel2Quotes.Result.getInstance( result.getResult() );
    }
}
