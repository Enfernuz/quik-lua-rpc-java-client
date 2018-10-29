package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.bit.ToHex;
import com.enfernuz.quik.lua.rpc.serde.Serializer;
import org.jetbrains.annotations.NotNull;
import qlua.rpc.bit.Tohex;

enum BitToHexArgsPbSerializer implements Serializer<ToHex.Args>, ToPbConverter<ToHex.Args, qlua.rpc.bit.Tohex.Request> {

    INSTANCE;

    @NotNull
    @Override
    public byte[] serialize(@NotNull final ToHex.Args args) {
        return convert(args).toByteArray();
    }

    @NotNull
    @Override
    public Tohex.Request convert(@NotNull final ToHex.Args args) {

        final Tohex.Request.Builder result =
                Tohex.Request.newBuilder()
                    .setX( args.getX() );

        final Integer n = args.getN();
        if (n != null) {
            result.setN(n);
        }

        return result.build();
    }
}
