package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.SetCell;
import com.enfernuz.quik.lua.rpc.serde.Serializer;
import org.jetbrains.annotations.NotNull;

enum SetCellArgsPbSerializer implements Serializer<SetCell.Args>, ToPbConverter<SetCell.Args, qlua.rpc.SetCell.Request> {

    INSTANCE;

    @NotNull
    @Override
    public byte[] serialize(@NotNull final SetCell.Args args) {
        return convert(args).toByteArray();
    }

    @NotNull
    @Override
    public qlua.rpc.SetCell.Request convert(@NotNull final SetCell.Args args) {

        final qlua.rpc.SetCell.Request.Builder result =
                qlua.rpc.SetCell.Request.newBuilder()
                        .setTId( args.getTId() )
                        .setKey( args.getKey() )
                        .setCode( args.getCode() )
                        .setText( args.getText() );

        final Number value = args.getValue();
        if (value != null) {
            result.setValue( args.getValue().doubleValue() );
        }

        return result.build();
    }
}
