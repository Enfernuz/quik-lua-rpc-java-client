package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.CancelParamRequest;
import com.enfernuz.quik.lua.rpc.serde.PbConverter;
import com.enfernuz.quik.lua.rpc.serde.Serde;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import qlua.rpc.RPC;

import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.assertEquals;

enum CancelParamRequestRequestPbSerde implements Serde<CancelParamRequest.Request>, PbConverter<qlua.rpc.CancelParamRequest.Request, CancelParamRequest.Request> {

    INSTANCE;

    private static final RPC.ProcedureType PROCEDURE_TYPE = RPC.ProcedureType.CANCEL_PARAM_REQUEST;

    @Override
    public byte[] serialize(final CancelParamRequest.Request request) {

        return RPC.Request.newBuilder()
                .setTypeValue( PROCEDURE_TYPE.getNumber() )
                .setArgs( convertToPb(request).toByteString() )
                .build()
                .toByteArray();
    }

    @NotNull
    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public CancelParamRequest.Request deserialize(final byte[] data) {

        final RPC.Request request = RPC.Request.parseFrom(data);
        assertEquals(request.getType(), PROCEDURE_TYPE);

        return convertFromPb(
                qlua.rpc.CancelParamRequest.Request.parseFrom( request.getArgs() )
        );
    }

    @Override
    public CancelParamRequest.Request convertFromPb(@NotNull final qlua.rpc.CancelParamRequest.Request request) {

        return CancelParamRequest.Request.builder()
                .classCode( request.getClassCode() )
                .secCode( request.getSecCode() )
                .dbName( request.getDbName() )
                .build();
    }

    @Override
    public qlua.rpc.CancelParamRequest.Request convertToPb(@NotNull final CancelParamRequest.Request request) {

        return qlua.rpc.CancelParamRequest.Request.newBuilder()
                .setClassCode( request.getClassCode() )
                .setSecCode( request.getSecCode() )
                .setDbName( request.getDbName() )
                .build();
    }
}
