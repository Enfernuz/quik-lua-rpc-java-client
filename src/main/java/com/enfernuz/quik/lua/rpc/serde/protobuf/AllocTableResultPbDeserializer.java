package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.AllocTable;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;

enum AllocTableResultPbDeserializer implements Deserializer<AllocTable.Result>, FromPbConverter<qlua.rpc.AllocTable.Result, AllocTable.Result> {

    INSTANCE;

    @NotNull
    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public AllocTable.Result deserialize(final byte[] data) {
        return convert( qlua.rpc.AllocTable.Result.parseFrom(data) );
    }

    @Override
    public AllocTable.Result convert(@NotNull final qlua.rpc.AllocTable.Result result) {
        return new AllocTable.Result( result.getTId() );
    }
}
