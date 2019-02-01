package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.DelAllLabels;
import com.enfernuz.quik.lua.rpc.serde.Serializer;
import org.jetbrains.annotations.NotNull;

enum DelAllLabelsArgsPbSerializer implements Serializer<DelAllLabels.Args>, ToPbConverter<DelAllLabels.Args, qlua.rpc.DelAllLabels.Args> {

    INSTANCE;

    @Override
    public @NotNull byte[] serialize(@NotNull final DelAllLabels.Args args) {
        return convert(args).toByteArray();
    }

    @Override
    public @NotNull qlua.rpc.DelAllLabels.Args convert(@NotNull final DelAllLabels.Args args) {

        return qlua.rpc.DelAllLabels.Args.newBuilder()
                .setChartTag( args.getChartTag() )
                .build();
    }
}
