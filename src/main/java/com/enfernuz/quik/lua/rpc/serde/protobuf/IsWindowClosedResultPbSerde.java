package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.IsWindowClosed;
import com.enfernuz.quik.lua.rpc.serde.PbConverter;
import com.enfernuz.quik.lua.rpc.serde.Serde;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;

enum IsWindowClosedResultPbSerde implements Serde<IsWindowClosed.Result>, PbConverter<qlua.rpc.IsWindowClosed.Result, IsWindowClosed.Result> {

    INSTANCE;

    @Override
    public byte[] serialize(final IsWindowClosed.Result result) {
        return convertToPb(result).toByteArray();
    }

    @NotNull
    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public IsWindowClosed.Result deserialize(final byte[] data) {
        return convertFromPb( qlua.rpc.IsWindowClosed.Result.parseFrom(data) );
    }

    @Override
    public IsWindowClosed.Result convertFromPb(@NotNull final qlua.rpc.IsWindowClosed.Result result) {

        if (result.hasWindowClosed()) {
            final IsWindowClosed.WindowClosed windowClosed =
                    IsWindowClosed.WindowClosed.getInstance( result.getWindowClosed().getResult() );
            return IsWindowClosed.Result.getInstance(windowClosed);
        }

        return IsWindowClosed.Result.getInstance(null);
    }

    @Override
    public qlua.rpc.IsWindowClosed.Result convertToPb(@NotNull final IsWindowClosed.Result result) {

        final qlua.rpc.IsWindowClosed.Result.Builder pbResult = qlua.rpc.IsWindowClosed.Result.newBuilder();

        final IsWindowClosed.WindowClosed windowClosed = result.getWindowClosed();
        if (windowClosed != null) {
            final qlua.rpc.IsWindowClosed.WindowClosed pbWindowClosed = qlua.rpc.IsWindowClosed.WindowClosed.newBuilder()
                    .setResult( windowClosed.isResult() )
                    .build();
            pbResult.setWindowClosed(pbWindowClosed);
        }

        return pbResult.build();
    }
}
