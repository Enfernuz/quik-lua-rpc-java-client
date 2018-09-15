package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetWindowRect;
import com.enfernuz.quik.lua.rpc.serde.PbConverter;
import com.enfernuz.quik.lua.rpc.serde.Serde;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;

enum GetWindowRectResultPbSerde implements Serde<GetWindowRect.Result>, PbConverter<qlua.rpc.GetWindowRect.Result, GetWindowRect.Result> {

    INSTANCE;

    @Override
    public byte[] serialize(final GetWindowRect.Result result) {
        return convertToPb(result).toByteArray();
    }

    @NotNull
    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public GetWindowRect.Result deserialize(final byte[] data) {
        return convertFromPb( qlua.rpc.GetWindowRect.Result.parseFrom(data) );
    }

    @Override
    public GetWindowRect.Result convertFromPb(@NotNull final qlua.rpc.GetWindowRect.Result result) {

        if (result.hasWindowRect()) {
            final qlua.rpc.GetWindowRect.WindowRect pbWindowRect = result.getWindowRect();
            final GetWindowRect.WindowRect windowRect = GetWindowRect.WindowRect.builder()
                    .top( pbWindowRect.getTop() )
                    .left( pbWindowRect.getLeft() )
                    .bottom( pbWindowRect.getBottom() )
                    .right( pbWindowRect.getRight() )
                    .build();
            return GetWindowRect.Result.getInstance(windowRect);
        }

        return GetWindowRect.Result.getErrorInstance();
    }

    @Override
    public qlua.rpc.GetWindowRect.Result convertToPb(@NotNull final GetWindowRect.Result result) {

        final GetWindowRect.WindowRect windowRect = result.getWindowRect();
        if (windowRect == null) {
            return qlua.rpc.GetWindowRect.Result.newBuilder().build();
        }

        final qlua.rpc.GetWindowRect.WindowRect pbWindowRect = qlua.rpc.GetWindowRect.WindowRect.newBuilder()
                .setTop( windowRect.getTop() )
                .setLeft( windowRect.getLeft() )
                .setBottom( windowRect.getBottom() )
                .setRight( windowRect.getRight() )
                .build();
        return qlua.rpc.GetWindowRect.Result.newBuilder()
                .setWindowRect(pbWindowRect)
                .build();
    }
}
