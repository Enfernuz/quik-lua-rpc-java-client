package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.ServiceError;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import qlua.rpc.RPC;

import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.convertFromPbString;

enum ServiceErrorPbDeserializer implements Deserializer<ServiceError>, FromPbConverter<RPC.Error, ServiceError> {

    INSTANCE;

    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public ServiceError deserialize(final byte[] data) {
        return convert(qlua.rpc.RPC.Error.parseFrom(data));
    }

    @Override
    public ServiceError convert(@NotNull qlua.rpc.RPC.Error error) {
        return new ServiceError(error.getCode(), convertFromPbString(error.getMessage()));
    }
}
