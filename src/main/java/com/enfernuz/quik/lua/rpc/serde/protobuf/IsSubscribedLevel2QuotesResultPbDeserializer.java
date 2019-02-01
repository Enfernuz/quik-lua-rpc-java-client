package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.IsSubscribedLevel2Quotes;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import qlua.rpc.IsSubscribedLevelIIQuotes;

enum IsSubscribedLevel2QuotesResultPbDeserializer implements Deserializer<IsSubscribedLevel2Quotes.Result>, FromPbConverter<IsSubscribedLevelIIQuotes.Result, IsSubscribedLevel2Quotes.Result> {

    INSTANCE;

    @NotNull
    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public IsSubscribedLevel2Quotes.Result deserialize(final byte[] data) {
        return convert( qlua.rpc.IsSubscribedLevelIIQuotes.Result.parseFrom(data) );
    }

    @Override
    public IsSubscribedLevel2Quotes.Result convert(@NotNull final qlua.rpc.IsSubscribedLevelIIQuotes.Result result) {
        return IsSubscribedLevel2Quotes.Result.getInstance( result.getResult() );
    }
}
