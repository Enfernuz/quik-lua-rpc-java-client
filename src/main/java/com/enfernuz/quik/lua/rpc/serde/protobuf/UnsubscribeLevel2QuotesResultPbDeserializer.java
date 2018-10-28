package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.UnsubscribeLevel2Quotes;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import qlua.rpc.UnsubscribeLevelIIQuotes;

enum UnsubscribeLevel2QuotesResultPbDeserializer implements Deserializer<UnsubscribeLevel2Quotes.Result>, FromPbConverter<UnsubscribeLevelIIQuotes.Result, UnsubscribeLevel2Quotes.Result> {

    INSTANCE;

    @NotNull
    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public UnsubscribeLevel2Quotes.Result deserialize(@NotNull final byte[] data) {
        return convert( UnsubscribeLevelIIQuotes.Result.parseFrom(data) );
    }

    @NotNull
    @Override
    public UnsubscribeLevel2Quotes.Result convert(@NotNull final UnsubscribeLevelIIQuotes.Result result) {
        return UnsubscribeLevel2Quotes.Result.getInstance( result.getResult() );
    }
}
