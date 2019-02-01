package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetClassesList;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;

import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.convertFromPbString;

enum GetClassesListResultPbDeserializer implements Deserializer<GetClassesList.Result>, FromPbConverter<qlua.rpc.GetClassesList.Result, GetClassesList.Result> {

    INSTANCE;

    @NotNull
    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public GetClassesList.Result deserialize(final byte[] data) {
        return convert( qlua.rpc.GetClassesList.Result.parseFrom(data) );
    }

    @Override
    public GetClassesList.Result convert(@NotNull final qlua.rpc.GetClassesList.Result result) {
        return new GetClassesList.Result( convertFromPbString(result.getClassesList()) );
    }
}
