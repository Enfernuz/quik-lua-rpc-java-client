package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetParamEx;
import com.enfernuz.quik.lua.rpc.serde.PbConverter;
import com.enfernuz.quik.lua.rpc.serde.Serde;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import qlua.rpc.RPC;

import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.assertEquals;

enum GetParamExRequestPbSerde implements Serde<GetParamEx.Request>, PbConverter<qlua.rpc.GetParamEx.Request, GetParamEx.Request> {

    INSTANCE;

    private static final RPC.ProcedureType PROCEDURE_TYPE = RPC.ProcedureType.GET_PARAM_EX;

    @Override
    public byte[] serialize(final GetParamEx.Request request) {

        return RPC.Request.newBuilder()
                .setTypeValue( PROCEDURE_TYPE.getNumber() )
                .setArgs( convertToPb(request).toByteString() )
                .build()
                .toByteArray();
    }

    @NotNull
    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public GetParamEx.Request deserialize(final byte[] data) {

        final RPC.Request request = RPC.Request.parseFrom(data);
        assertEquals(request.getType(), PROCEDURE_TYPE);

        return convertFromPb(
                qlua.rpc.GetParamEx.Request.parseFrom( request.getArgs() )
        );
    }

    @Override
    public GetParamEx.Request convertFromPb(@NotNull final qlua.rpc.GetParamEx.Request request) {

        return GetParamEx.Request.builder()
                .classCode( request.getClassCode() )
                .secCode( request.getSecCode() )
                .paramName( request.getParamName() )
                .build();
    }

    @Override
    public qlua.rpc.GetParamEx.Request convertToPb(@NotNull final GetParamEx.Request request) {

        return qlua.rpc.GetParamEx.Request.newBuilder()
                .setClassCode( request.getClassCode() )
                .setSecCode( request.getSecCode() )
                .setParamName( request.getParamName() )
                .build();
    }
}
