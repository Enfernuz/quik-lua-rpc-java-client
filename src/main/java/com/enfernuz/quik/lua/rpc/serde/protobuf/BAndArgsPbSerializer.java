package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.bit.BAnd;
import com.enfernuz.quik.lua.rpc.serde.Serializer;
import org.jetbrains.annotations.NotNull;
import qlua.rpc.bit.Band;

import java.util.stream.IntStream;
import java.util.stream.LongStream;

import static java.util.stream.Collectors.toList;

enum BAndArgsPbSerializer implements Serializer<BAnd.Args>, ToPbConverter<BAnd.Args, qlua.rpc.bit.Band.Args> {

    INSTANCE;

    @NotNull
    @Override
    public byte[] serialize(@NotNull final BAnd.Args args) {
        return convert(args).toByteArray();
    }

    @NotNull
    @Override
    public Band.Args convert(@NotNull final BAnd.Args args) {

        final Band.Args.Builder result =
                Band.Args.newBuilder()
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
