package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.datasource.SetUpdateCallback;
import com.enfernuz.quik.lua.rpc.serde.Serializer;
import org.jetbrains.annotations.NotNull;

enum DsSetUpdateCallbackPbArgsSerializer implements Serializer<SetUpdateCallback.Args>, ToPbConverter<SetUpdateCallback.Args, qlua.rpc.datasource.SetUpdateCallback.Request> {

    INSTANCE;

    @NotNull
    @Override
    public byte[] serialize(@NotNull final SetUpdateCallback.Args args) {
        return convert(args).toByteArray();
    }

    @NotNull
    @Override
    public qlua.rpc.datasource.SetUpdateCallback.Request convert(@NotNull final SetUpdateCallback.Args args) {

        final qlua.rpc.datasource.SetUpdateCallback.Request.Builder result =
                qlua.rpc.datasource.SetUpdateCallback.Request.newBuilder()
                        .setDatasourceUuid( args.getDatasourceUUID() )
                        .setWatchingO( args.isWatchingO() )
                        .setWatchingH( args.isWatchingH() )
                        .setWatchingL( args.isWatchingL() )
                        .setWatchingC( args.isWatchingC() )
                        .setWatchingV( args.isWatchingV() )
                        .setWatchingT( args.isWatchingT() )
                        .setWatchingSize( args.isWatchingSize() );

        final String fbCbDef = args.getCallbackFunctionDefinition();
        if (fbCbDef != null) {
            result.setFCbDef(fbCbDef);
        }

        return result.build();
    }
}
