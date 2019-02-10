package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.SetColor;
import com.enfernuz.quik.lua.rpc.serde.Serializer;
import org.jetbrains.annotations.NotNull;

enum SetColorArgsPbSerializer implements Serializer<SetColor.Args>, ToPbConverter<SetColor.Args, qlua.rpc.SetColor.Args> {

    INSTANCE;

    @NotNull
    @Override
    public byte[] serialize(@NotNull final SetColor.Args args) {
        return convert(args).toByteArray();
    }

    @NotNull
    @Override
    public qlua.rpc.SetColor.Args convert(@NotNull final SetColor.Args args) {

        final qlua.rpc.SetColor.Args.Builder pbResult =
                qlua.rpc.SetColor.Args.newBuilder()
                        .setTId( args.getTId() );

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

        final Integer selBColor = args.getSelBColor();
        if (selBColor == null) {
            pbResult.setNullSelBColor(true);
        } else {
            pbResult.setValueSelBColor(selBColor);
        }

        final Integer selFColor = args.getSelFColor();
        if (selFColor == null) {
            pbResult.setNullSelFColor(true);
        } else {
            pbResult.setValueSelFColor(selFColor);
        }

        return pbResult.build();
    }
}
