package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetLabelParams;
import com.enfernuz.quik.lua.rpc.serde.Serializer;
import org.jetbrains.annotations.NotNull;

enum GetLabelParamsArgsPbSerializer implements Serializer<GetLabelParams.Args>, ToPbConverter<GetLabelParams.Args, qlua.rpc.GetLabelParams.Args> {

    INSTANCE;

    @Override
    public @NotNull byte[] serialize(@NotNull final GetLabelParams.Args args) {
        return convert(args).toByteArray();
    }

    @Override
    public @NotNull qlua.rpc.GetLabelParams.Args convert(@NotNull final GetLabelParams.Args args) {

        return qlua.rpc.GetLabelParams.Args.newBuilder()
                .setChartTag( args.getChartTag() )
                .setLabelId( args.getLabelId() )
                .build();
    }
}
