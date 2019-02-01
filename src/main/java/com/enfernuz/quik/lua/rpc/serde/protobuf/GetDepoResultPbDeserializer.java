package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetDepo;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;

import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.convertFromPbDepo;

enum GetDepoResultPbDeserializer implements Deserializer<GetDepo.Result>, FromPbConverter<qlua.rpc.GetDepo.Result, GetDepo.Result> {

    INSTANCE;

    @NotNull
    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public GetDepo.Result deserialize(final byte[] data) {
        return convert( qlua.rpc.GetDepo.Result.parseFrom(data) );
    }

    @Override
    public GetDepo.Result convert(@NotNull final qlua.rpc.GetDepo.Result result) {
        return new GetDepo.Result( convertFromPbDepo(result.getDepo()) );
    }
}
