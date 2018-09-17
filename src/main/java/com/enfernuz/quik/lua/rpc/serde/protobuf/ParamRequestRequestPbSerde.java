package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.ParamRequest;
import com.enfernuz.quik.lua.rpc.serde.PbConverter;
import com.enfernuz.quik.lua.rpc.serde.Serde;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import qlua.rpc.RPC;

import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.assertEquals;

enum ParamRequestRequestPbSerde implements Serde<ParamRequest.Request>, PbConverter<qlua.rpc.ParamRequest.Request, ParamRequest.Request> {

    INSTANCE;

    private static final RPC.ProcedureType PROCEDURE_TYPE = RPC.ProcedureType.PARAM_REQUEST;

    @Override
    public byte[] serialize(final ParamRequest.Request request) {

        return RPC.Request.newBuilder()
                .setTypeValue( PROCEDURE_TYPE.getNumber() )
                .setArgs( convertToPb(request).toByteString() )
                .build()
                .toByteArray();
    }

    @NotNull
    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public ParamRequest.Request deserialize(final byte[] data) {

        final RPC.Request request = RPC.Request.parseFrom(data);
        assertEquals(request.getType(), PROCEDURE_TYPE);

        return convertFromPb(
                qlua.rpc.ParamRequest.Request.parseFrom( request.getArgs() )
        );
    }

    @Override
    public ParamRequest.Request convertFromPb(@NotNull final qlua.rpc.ParamRequest.Request request) {

        return ParamRequest.Request.builder()
                .classCode( request.getClassCode() )
                .secCode( request.getSecCode() )
                .dbName( request.getDbName() )
                .build();
    }

    @Override
    public qlua.rpc.ParamRequest.Request convertToPb(@NotNull final ParamRequest.Request request) {

        return qlua.rpc.ParamRequest.Request.newBuilder()
                .setClassCode( request.getClassCode() )
                .setSecCode( request.getSecCode() )
                .setDbName( request.getDbName() )
                .build();
    }
}
