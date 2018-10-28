package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetClassSecurities;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;

import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.convertFromPbString;

enum GetClassSecuritiesResultPbDeserializer implements Deserializer<GetClassSecurities.Result>, FromPbConverter<qlua.rpc.GetClassSecurities.Result, GetClassSecurities.Result> {

    INSTANCE;

    @NotNull
    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public GetClassSecurities.Result deserialize(final byte[] data) {
        return convert( qlua.rpc.GetClassSecurities.Result.parseFrom(data) );
    }

    @Override
    public GetClassSecurities.Result convert(@NotNull final qlua.rpc.GetClassSecurities.Result result) {
        return new GetClassSecurities.Result( convertFromPbString(result.getClassSecurities()) );
    }
}
