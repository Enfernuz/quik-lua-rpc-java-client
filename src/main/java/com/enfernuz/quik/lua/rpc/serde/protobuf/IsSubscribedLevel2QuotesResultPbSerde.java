package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.IsSubscribedLevel2Quotes;
import com.enfernuz.quik.lua.rpc.serde.PbConverter;
import com.enfernuz.quik.lua.rpc.serde.Serde;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;

enum IsSubscribedLevel2QuotesResultPbSerde implements Serde<IsSubscribedLevel2Quotes.Result>, PbConverter<qlua.rpc.IsSubscribedLevelIIQuotes.Result, IsSubscribedLevel2Quotes.Result> {

    INSTANCE;

    @Override
    public byte[] serialize(final IsSubscribedLevel2Quotes.Result result) {
        return convertToPb(result).toByteArray();
    }

    @NotNull
    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public IsSubscribedLevel2Quotes.Result deserialize(final byte[] data) {
        return convertFromPb( qlua.rpc.IsSubscribedLevelIIQuotes.Result.parseFrom(data) );
    }

    @Override
    public IsSubscribedLevel2Quotes.Result convertFromPb(@NotNull final qlua.rpc.IsSubscribedLevelIIQuotes.Result result) {
        return IsSubscribedLevel2Quotes.Result.getInstance( result.getResult() );
    }

    @Override
    public qlua.rpc.IsSubscribedLevelIIQuotes.Result convertToPb(@NotNull final IsSubscribedLevel2Quotes.Result result) {
        return qlua.rpc.IsSubscribedLevelIIQuotes.Result.newBuilder()
                .setResult( result.isResult() )
                .build();
    }
}
