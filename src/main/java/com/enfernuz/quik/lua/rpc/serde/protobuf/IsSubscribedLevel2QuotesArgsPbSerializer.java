package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.IsSubscribedLevel2Quotes;
import com.enfernuz.quik.lua.rpc.serde.Serializer;
import org.jetbrains.annotations.NotNull;
import qlua.rpc.IsSubscribedLevelIIQuotes;

enum IsSubscribedLevel2QuotesArgsPbSerializer implements Serializer<IsSubscribedLevel2Quotes.Args>, ToPbConverter<IsSubscribedLevel2Quotes.Args, IsSubscribedLevelIIQuotes.Args> {

    INSTANCE;

    @Override
    public @NotNull byte[] serialize(@NotNull final IsSubscribedLevel2Quotes.Args args) {
        return convert(args).toByteArray();
    }

    @Override
    public @NotNull qlua.rpc.IsSubscribedLevelIIQuotes.Args convert(@NotNull final IsSubscribedLevel2Quotes.Args args) {

        return qlua.rpc.IsSubscribedLevelIIQuotes.Args.newBuilder()
                .setClassCode( args.getClassCode() )
                .setSecCode( args.getSecCode() )
                .build();
    }
}
