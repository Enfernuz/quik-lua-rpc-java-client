package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.SetLabelParams;
import com.enfernuz.quik.lua.rpc.serde.Serializer;
import org.jetbrains.annotations.NotNull;

enum SetLabelParamsArgsPbSerializer implements Serializer<SetLabelParams.Args>, ToPbConverter<SetLabelParams.Args, qlua.rpc.SetLabelParams.Args> {

    INSTANCE;

    @NotNull
    @Override
    public byte[] serialize(@NotNull final SetLabelParams.Args args) {
        return convert(args).toByteArray();
    }

    @NotNull
    @Override
    public qlua.rpc.SetLabelParams.Args convert(@NotNull final SetLabelParams.Args args) {

        return qlua.rpc.SetLabelParams.Args.newBuilder()
                .setChartTag( args.getChartTag() )
                .setLabelId( args.getLabelId() )
                .putAllLabelParams( args.getLabelParams() )
                .build();
    }
}
