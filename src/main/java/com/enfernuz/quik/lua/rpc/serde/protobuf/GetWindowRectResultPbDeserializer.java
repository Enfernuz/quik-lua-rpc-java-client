package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetWindowRect;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;

enum GetWindowRectResultPbDeserializer implements Deserializer<GetWindowRect.Result>, FromPbConverter<qlua.rpc.GetWindowRect.Result, GetWindowRect.Result> {

    INSTANCE;

    @NotNull
    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public GetWindowRect.Result deserialize(final byte[] data) {
        return convert( qlua.rpc.GetWindowRect.Result.parseFrom(data) );
    }

    @Override
    public GetWindowRect.Result convert(@NotNull final qlua.rpc.GetWindowRect.Result result) {

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
}
