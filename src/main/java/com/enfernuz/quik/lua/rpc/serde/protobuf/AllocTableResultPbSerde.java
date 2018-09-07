package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.AllocTable;
import com.enfernuz.quik.lua.rpc.serde.PbConverter;
import com.enfernuz.quik.lua.rpc.serde.Serde;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;

enum AllocTableResultPbSerde implements Serde<AllocTable.Result>, PbConverter<qlua.rpc.AllocTable.Result, AllocTable.Result> {

    INSTANCE;

    @Override
    public byte[] serialize(final AllocTable.Result result) {
        return convertToPb(result).toByteArray();
    }

    @NotNull
    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public AllocTable.Result deserialize(final byte[] data) {
        return convertFromPb( qlua.rpc.AllocTable.Result.parseFrom(data) );
    }

    @Override
    public AllocTable.Result convertFromPb(@NotNull final qlua.rpc.AllocTable.Result result) {
        return new AllocTable.Result( result.getTId() );
    }

    @Override
    public qlua.rpc.AllocTable.Result convertToPb(@NotNull final AllocTable.Result result) {
        return qlua.rpc.AllocTable.Result.newBuilder()
                .setTId( result.getTId() )
                .build();
    }
}
