package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.bit.BOr;
import com.enfernuz.quik.lua.rpc.serde.Serializer;
import org.jetbrains.annotations.NotNull;
import qlua.rpc.bit.Bor;

import java.util.stream.LongStream;

import static java.util.stream.Collectors.toList;

enum BOrArgsPbSerializer implements Serializer<BOr.Args>, ToPbConverter<BOr.Args, Bor.Args> {

    INSTANCE;

    @NotNull
    @Override
    public byte[] serialize(@NotNull final BOr.Args args) {
        return convert(args).toByteArray();
    }

    @NotNull
    @Override
    public Bor.Args convert(@NotNull final BOr.Args args) {

        final Bor.Args.Builder result =
                Bor.Args.newBuilder()
                    .setX1( args.getX1() )
                    .setX2( args.getX2() );

        final long[] xi = args.getXi();
        if (xi != null) {
            result.addAllXi(
                    LongStream.of(xi)
                            .boxed()
                            .collect( toList() )
            );
        }

        return result.build();
    }
}
