package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.bit.BXor;
import com.enfernuz.quik.lua.rpc.serde.Serializer;
import org.jetbrains.annotations.NotNull;
import qlua.rpc.bit.Bxor;

import java.util.stream.LongStream;

import static java.util.stream.Collectors.toList;

enum BXorArgsPbSerializer implements Serializer<BXor.Args>, ToPbConverter<BXor.Args, Bxor.Args> {

    INSTANCE;

    @NotNull
    @Override
    public byte[] serialize(@NotNull final BXor.Args args) {
        return convert(args).toByteArray();
    }

    @NotNull
    @Override
    public Bxor.Args convert(@NotNull final BXor.Args args) {

        final Bxor.Args.Builder result =
                Bxor.Args.newBuilder()
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
