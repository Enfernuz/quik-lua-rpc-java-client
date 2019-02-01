package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.bit.ToHex;
import com.enfernuz.quik.lua.rpc.serde.Serializer;
import org.jetbrains.annotations.NotNull;
import qlua.rpc.bit.Tohex;

enum BitToHexArgsPbSerializer implements Serializer<ToHex.Args>, ToPbConverter<ToHex.Args, qlua.rpc.bit.Tohex.Args> {

    INSTANCE;

    @NotNull
    @Override
    public byte[] serialize(@NotNull final ToHex.Args args) {
        return convert(args).toByteArray();
    }

    @NotNull
    @Override
    public Tohex.Args convert(@NotNull final ToHex.Args args) {

        final Tohex.Args.Builder result =
                Tohex.Args.newBuilder()
                    .setX( args.getX() );

        final Integer n = args.getN();
        if (n == null) {
            result.setNullN(true);
        } else {
            result.setValueN(n);
        }

        return result.build();
    }
}
