package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.Highlight;
import com.enfernuz.quik.lua.rpc.serde.Serializer;
import org.jetbrains.annotations.NotNull;

enum HighlightArgsPbSerializer implements Serializer<Highlight.Args>, ToPbConverter<Highlight.Args, qlua.rpc.Highlight.Args> {

    INSTANCE;

    @Override
    public @NotNull byte[] serialize(@NotNull final Highlight.Args args) {
        return convert(args).toByteArray();
    }

    @Override
    public @NotNull qlua.rpc.Highlight.Args convert(@NotNull final Highlight.Args args) {

        return qlua.rpc.Highlight.Args.newBuilder()
                .setTId( args.getTId() )
                .setRow( args.getRow() )
                .setCol( args.getCol() )
                .setBColor( args.getBColor() )
                .setFColor( args.getFColor() )
                .setTimeout( args.getTimeout() )
                .build();
    }
}
