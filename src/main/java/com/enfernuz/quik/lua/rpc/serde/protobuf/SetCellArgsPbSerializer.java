package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.SetCell;
import com.enfernuz.quik.lua.rpc.serde.Serializer;
import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;

enum SetCellArgsPbSerializer implements Serializer<SetCell.Args>, ToPbConverter<SetCell.Args, qlua.rpc.SetCell.Args> {

    INSTANCE;

    @NotNull
    @Override
    public byte[] serialize(@NotNull final SetCell.Args args) {
        return convert(args).toByteArray();
    }

    @NotNull
    @Override
    public qlua.rpc.SetCell.Args convert(@NotNull final SetCell.Args args) {

        final qlua.rpc.SetCell.Args.Builder result =
                qlua.rpc.SetCell.Args.newBuilder()
                        .setTId( args.getTId() )
                        .setKey( args.getKey() )
                        .setCode( args.getCode() )
                        .setText( args.getText() );

        final Number value = args.getValue();
        if (value != null) {
            result.setValue( BigDecimal.valueOf(args.getValue().doubleValue()).toPlainString() );
        }

        return result.build();
    }
}
