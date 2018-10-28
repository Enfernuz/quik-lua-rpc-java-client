package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.ServiceError;
import com.enfernuz.quik.lua.rpc.api.structures.ResponseEnvelope;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import qlua.rpc.RPC;

import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.convertFromPbString;

enum ResponseEnvelopePbDeserializer implements Deserializer<ResponseEnvelope>, FromPbConverter<RPC.Response, ResponseEnvelope> {

    INSTANCE;

    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public ResponseEnvelope deserialize(final byte[] data) {
        return convert(qlua.rpc.RPC.Response.parseFrom(data));
    }

    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public ResponseEnvelope convert(@NotNull qlua.rpc.RPC.Response response) {

        if (response.getIsError()) {
            final qlua.rpc.RPC.Error pbError = qlua.rpc.RPC.Error.parseFrom(response.getResult());
            return ResponseEnvelope.withError(
                    new ServiceError(pbError.getCode(), convertFromPbString(pbError.getMessage()))
            );
        } else {
            return ResponseEnvelope.withResult( response.getResult().toByteArray() );
        }
    }
}
