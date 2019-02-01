package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.AddLabel;
import com.enfernuz.quik.lua.rpc.serde.Serializer;
import org.jetbrains.annotations.NotNull;

enum AddLabelArgsPbSerializer implements Serializer<AddLabel.Args>, ToPbConverter<AddLabel.Args, qlua.rpc.AddLabel.Args> {

    INSTANCE;

    @Override
    public @NotNull byte[] serialize(@NotNull final AddLabel.Args args) {
        return convert(args).toByteArray();
    }

    @Override
    public @NotNull qlua.rpc.AddLabel.Args convert(@NotNull final AddLabel.Args args) {

        return qlua.rpc.AddLabel.Args.newBuilder()
                .setChartTag( args.getChartTag() )
                .putAllLabelParams( args.getLabelParams() )
                .build();
    }
}
