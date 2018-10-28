package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.SetTableNotificationCallback;
import com.enfernuz.quik.lua.rpc.serde.Serializer;
import org.jetbrains.annotations.NotNull;

enum SetTableNotificationCallbackArgsPbSerializer implements Serializer<SetTableNotificationCallback.Args>, ToPbConverter<SetTableNotificationCallback.Args, qlua.rpc.SetTableNotificationCallback.Request> {

    INSTANCE;

    @NotNull
    @Override
    public byte[] serialize(@NotNull final SetTableNotificationCallback.Args args) {
        return convert(args).toByteArray();
    }

    @NotNull
    @Override
    public qlua.rpc.SetTableNotificationCallback.Request convert(@NotNull final SetTableNotificationCallback.Args args) {

        return qlua.rpc.SetTableNotificationCallback.Request.newBuilder()
                .setTId( args.getTId() )
                .setFCbDef( args.getFunctionCallbackDefinition() )
                .build();
    }
}
