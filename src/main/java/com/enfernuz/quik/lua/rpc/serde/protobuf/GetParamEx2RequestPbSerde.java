package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetParamEx2;
import com.enfernuz.quik.lua.rpc.serde.PbConverter;
import com.enfernuz.quik.lua.rpc.serde.Serde;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import qlua.rpc.RPC;

import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.assertEquals;

enum GetParamEx2RequestPbSerde implements Serde<GetParamEx2.Request>, PbConverter<qlua.rpc.GetParamEx2.Request, GetParamEx2.Request> {

    INSTANCE;

    private static final RPC.ProcedureType PROCEDURE_TYPE = RPC.ProcedureType.GET_PARAM_EX_2;

    @Override
    public byte[] serialize(final GetParamEx2.Request request) {

        return RPC.Request.newBuilder()
                .setTypeValue( PROCEDURE_TYPE.getNumber() )
                .setArgs( convertToPb(request).toByteString() )
                .build()
                .toByteArray();
    }

    @NotNull
    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public GetParamEx2.Request deserialize(final byte[] data) {

        final RPC.Request request = RPC.Request.parseFrom(data);
        assertEquals(request.getType(), PROCEDURE_TYPE);

        return convertFromPb(
                qlua.rpc.GetParamEx2.Request.parseFrom( request.getArgs() )
        );
    }

    @Override
    public GetParamEx2.Request convertFromPb(@NotNull final qlua.rpc.GetParamEx2.Request request) {

        return GetParamEx2.Request.builder()
                .classCode( request.getClassCode() )
                .secCode( request.getSecCode() )
                .paramName( request.getParamName() )
                .build();
    }

    @Override
    public qlua.rpc.GetParamEx2.Request convertToPb(@NotNull final GetParamEx2.Request request) {

        return qlua.rpc.GetParamEx2.Request.newBuilder()
                .setClassCode( request.getClassCode() )
                .setSecCode( request.getSecCode() )
                .setParamName( request.getParamName() )
                .build();
    }
}
