package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.DelLabel;
import com.enfernuz.quik.lua.rpc.serde.Serializer;
import org.jetbrains.annotations.NotNull;

enum DelLabelArgsPbSerializer implements Serializer<DelLabel.Args>, ToPbConverter<DelLabel.Args, qlua.rpc.DelLabel.Request> {

    INSTANCE;

    @Override
    public @NotNull byte[] serialize(@NotNull final DelLabel.Args args) {
        return convert(args).toByteArray();
    }

    @Override
    public @NotNull qlua.rpc.DelLabel.Request convert(@NotNull final DelLabel.Args args) {

        return qlua.rpc.DelLabel.Request.newBuilder()
                .setChartTag( args.getChartTag() )
                .setLabelId( args.getLabelId() )
                .build();
    }
}
