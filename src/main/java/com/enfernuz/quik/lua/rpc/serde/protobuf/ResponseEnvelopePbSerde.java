package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.ServiceError;
import com.enfernuz.quik.lua.rpc.api.structures.ResponseEnvelope;
import com.enfernuz.quik.lua.rpc.serde.PbConverter;
import com.enfernuz.quik.lua.rpc.serde.Serde;
import com.google.protobuf.ByteString;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;

import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.convertFromPbString;
import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.convertToPbString;

enum ResponseEnvelopePbSerde implements Serde<ResponseEnvelope>, PbConverter<qlua.rpc.RPC.Response, ResponseEnvelope> {

    INSTANCE;

    @Override
    public byte[] serialize(final ResponseEnvelope responseEnvelope) {
        return convertToPb(responseEnvelope).toByteArray();
    }

    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public ResponseEnvelope deserialize(final byte[] data) {
        return convertFromPb(qlua.rpc.RPC.Response.parseFrom(data));
    }

    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public ResponseEnvelope convertFromPb(@NotNull qlua.rpc.RPC.Response response) {

        if (response.getIsError()) {
            final qlua.rpc.RPC.Error pbError = qlua.rpc.RPC.Error.parseFrom(response.getResult());
            return ResponseEnvelope.withError(
                    new ServiceError(pbError.getCode(), convertFromPbString(pbError.getMessage()))
            );
        } else {
            return ResponseEnvelope.withResult( response.getResult().toByteArray() );
        }
    }

    @Override
    public qlua.rpc.RPC.Response convertToPb(@NotNull final ResponseEnvelope responseEnvelope) {

        final ServiceError serviceError = responseEnvelope.getError();
        final ByteString result;
        boolean isError = false;
        if (serviceError == null) {
            result = ByteString.copyFrom(responseEnvelope.getResult());
        } else {
            isError = true;
            result = qlua.rpc.RPC.Error.newBuilder()
                        .setCode( serviceError.getCode() )
                        .setMessage( convertToPbString(serviceError.getMessage()) )
                        .build()
                        .toByteString();
        }

        return qlua.rpc.RPC.Response.newBuilder()
                .setIsError(isError)
                .setResult(result)
                .build();
    }
}
