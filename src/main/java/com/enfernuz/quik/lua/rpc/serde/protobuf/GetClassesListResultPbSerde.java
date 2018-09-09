package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetClassesList;
import com.enfernuz.quik.lua.rpc.serde.PbConverter;
import com.enfernuz.quik.lua.rpc.serde.Serde;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;

import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.convertFromPbString;
import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.convertToPbString;

enum GetClassesListResultPbSerde implements Serde<GetClassesList.Result>, PbConverter<qlua.rpc.GetClassesList.Result, GetClassesList.Result> {

    INSTANCE;

    @Override
    public byte[] serialize(final GetClassesList.Result result) {
        return convertToPb(result).toByteArray();
    }

    @NotNull
    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public GetClassesList.Result deserialize(final byte[] data) {
        return convertFromPb( qlua.rpc.GetClassesList.Result.parseFrom(data) );
    }

    @Override
    public GetClassesList.Result convertFromPb(@NotNull final qlua.rpc.GetClassesList.Result result) {
        return new GetClassesList.Result( convertFromPbString(result.getClassesList()) );
    }

    @Override
    public qlua.rpc.GetClassesList.Result convertToPb(@NotNull final GetClassesList.Result result) {
        return qlua.rpc.GetClassesList.Result.newBuilder()
                .setClassesList( convertToPbString(result.getClassesList()) )
                .build();
    }
}
