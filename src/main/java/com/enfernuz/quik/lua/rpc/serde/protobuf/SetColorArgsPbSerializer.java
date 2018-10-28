package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.SetColor;
import com.enfernuz.quik.lua.rpc.serde.Serializer;
import org.jetbrains.annotations.NotNull;

enum SetColorArgsPbSerializer implements Serializer<SetColor.Args>, ToPbConverter<SetColor.Args, qlua.rpc.SetColor.Request> {

    INSTANCE;

    @NotNull
    @Override
    public byte[] serialize(@NotNull final SetColor.Args args) {
        return convert(args).toByteArray();
    }

    @NotNull
    @Override
    public qlua.rpc.SetColor.Request convert(@NotNull final SetColor.Args args) {

        return qlua.rpc.SetColor.Request.newBuilder()
                .setTId( args.getTId() )
                .setRow( args.getRow() )
                .setCol( args.getCol() )
                .setBColor( args.getbColor() )
                .setFColor( args.getfColor() )
                .setSelBColor( args.getSelBColor() )
                .setSelFColor( args.getSelFColor() )
                .build();
    }
}
