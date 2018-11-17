package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetCell;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;

import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.convertFromPbString;

enum GetCellResultPbDeserializer implements Deserializer<GetCell.Result>, FromPbConverter<qlua.rpc.GetCell.Result, GetCell.Result> {

    INSTANCE;

    @NotNull
    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public GetCell.Result deserialize(final byte[] data) {
        return convert( qlua.rpc.GetCell.Result.parseFrom(data) );
    }

    @Override
    public GetCell.Result convert(@NotNull final qlua.rpc.GetCell.Result result) {
        return GetCell.Result.builder()
                .image( convertFromPbString(result.getImage()) )
                .value( convertFromPbString(result.getValue()) )
                .build();
    }
}
