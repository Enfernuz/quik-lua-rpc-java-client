package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.DelLabel;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;

enum DelLabelResultPbDeserializer implements Deserializer<DelLabel.Result>, FromPbConverter<qlua.rpc.DelLabel.Result, DelLabel.Result> {

    INSTANCE;

    @NotNull
    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public DelLabel.Result deserialize(final byte[] data) {
        return convert( qlua.rpc.DelLabel.Result.parseFrom(data) );
    }

    @Override
    public DelLabel.Result convert(@NotNull final qlua.rpc.DelLabel.Result result) {
        return DelLabel.Result.getInstance( result.getResult() );
    }
}
