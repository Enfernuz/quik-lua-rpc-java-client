package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.AddLabel;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;

enum AddLabelResultPbDeserializer implements Deserializer<AddLabel.Result>, FromPbConverter<qlua.rpc.AddLabel.Result, AddLabel.Result> {

    INSTANCE;

    @NotNull
    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public AddLabel.Result deserialize(final byte[] data) {
        return convert( qlua.rpc.AddLabel.Result.parseFrom(data) );
    }

    @Override
    public AddLabel.Result convert(@NotNull final qlua.rpc.AddLabel.Result result) {
        return new AddLabel.Result(result.getNullResult() ? null : result.getLabelId());
    }
}
