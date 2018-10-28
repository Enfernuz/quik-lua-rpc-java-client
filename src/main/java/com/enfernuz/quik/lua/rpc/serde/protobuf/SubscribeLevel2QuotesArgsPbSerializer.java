package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.SubscribeLevel2Quotes;
import com.enfernuz.quik.lua.rpc.serde.Serializer;
import org.jetbrains.annotations.NotNull;
import qlua.rpc.SubscribeLevelIIQuotes;

enum SubscribeLevel2QuotesArgsPbSerializer implements Serializer<SubscribeLevel2Quotes.Args>, ToPbConverter<SubscribeLevel2Quotes.Args, qlua.rpc.SubscribeLevelIIQuotes.Request> {

    INSTANCE;

    @NotNull
    @Override
    public byte[] serialize(@NotNull final SubscribeLevel2Quotes.Args args) {
        return convert(args).toByteArray();
    }

    @NotNull
    @Override
    public SubscribeLevelIIQuotes.Request convert(@NotNull final SubscribeLevel2Quotes.Args args) {

        return SubscribeLevelIIQuotes.Request.newBuilder()
                .setClassCode( args.getClassCode() )
                .setSecCode( args.getSecCode() )
                .build();
    }
}
