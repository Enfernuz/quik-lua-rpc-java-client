package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.ServiceError;
import com.enfernuz.quik.lua.rpc.serde.PbConverter;
import com.enfernuz.quik.lua.rpc.serde.Serde;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;

import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.convertFromPbString;
import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.convertToPbString;

enum ServiceErrorPbSerde implements Serde<ServiceError>, PbConverter<qlua.rpc.RPC.Error, ServiceError> {

    INSTANCE;

    @Override
    public byte[] serialize(final ServiceError serviceError) {
        return convertToPb(serviceError).toByteArray();
    }

    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public ServiceError deserialize(final byte[] data) {
        return convertFromPb(qlua.rpc.RPC.Error.parseFrom(data));
    }

    @Override
    public ServiceError convertFromPb(@NotNull qlua.rpc.RPC.Error error) {
        return new ServiceError(error.getCode(), convertFromPbString(error.getMessage()));
    }

    @Override
    public qlua.rpc.RPC.Error convertToPb(@NotNull final ServiceError serviceError) {
        return qlua.rpc.RPC.Error.newBuilder()
                .setCode( serviceError.getCode() )
                .setMessage( convertToPbString(serviceError.getMessage()) )
                .build();
    }
}
