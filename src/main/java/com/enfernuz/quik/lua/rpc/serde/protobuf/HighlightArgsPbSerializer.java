package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.Highlight;
import com.enfernuz.quik.lua.rpc.serde.Serializer;
import org.jetbrains.annotations.NotNull;

enum HighlightArgsPbSerializer implements Serializer<Highlight.Args>, ToPbConverter<Highlight.Args, qlua.rpc.Highlight.Args> {

    INSTANCE;

    @Override
    public @NotNull byte[] serialize(@NotNull final Highlight.Args args) {
        return convert(args).toByteArray();
    }

    @Override
    public @NotNull qlua.rpc.Highlight.Args convert(@NotNull final Highlight.Args args) {

        final qlua.rpc.Highlight.Args.Builder pbResult =
                qlua.rpc.Highlight.Args.newBuilder()
                        .setTId( args.getTId() )
                        .setTimeout( args.getTimeout() );

        final Integer row = args.getRow();
        if (row == null) {
            pbResult.setNullRow(true);
        } else {
            pbResult.setValueRow(row);
        }

        final Integer col = args.getCol();
        if (col == null) {
            pbResult.setNullCol(true);
        } else {
            pbResult.setValueCol(col);
        }

        final Integer bColor = args.getBColor();
        if (bColor == null) {
            pbResult.setNullBColor(true);
        } else {
            pbResult.setValueBColor(bColor);
        }

        final Integer fColor = args.getFColor();
        if (fColor == null) {
            pbResult.setNullFColor(true);
        } else {
            pbResult.setValueFColor(fColor);
        }

        return pbResult.build();
    }
}
