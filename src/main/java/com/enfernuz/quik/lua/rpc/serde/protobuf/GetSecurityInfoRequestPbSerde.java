package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetSecurityInfo;
import com.enfernuz.quik.lua.rpc.serde.PbConverter;
import com.enfernuz.quik.lua.rpc.serde.Serde;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import qlua.rpc.RPC;

import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.assertEquals;

enum GetSecurityInfoRequestPbSerde implements Serde<GetSecurityInfo.Request>, PbConverter<qlua.rpc.GetSecurityInfo.Request, GetSecurityInfo.Request> {

    INSTANCE;

    private static final RPC.ProcedureType PROCEDURE_TYPE = RPC.ProcedureType.GET_SECURITY_INFO;

    @Override
    public byte[] serialize(final GetSecurityInfo.Request request) {

        return RPC.Request.newBuilder()
                .setTypeValue( PROCEDURE_TYPE.getNumber() )
                .setArgs( convertToPb(request).toByteString() )
                .build()
                .toByteArray();
    }

    @NotNull
    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public GetSecurityInfo.Request deserialize(final byte[] data) {

        final RPC.Request request = RPC.Request.parseFrom(data);
        assertEquals(request.getType(), PROCEDURE_TYPE);

        return convertFromPb(
                qlua.rpc.GetSecurityInfo.Request.parseFrom( request.getArgs() )
        );
    }

    @Override
    public GetSecurityInfo.Request convertFromPb(@NotNull final qlua.rpc.GetSecurityInfo.Request request) {

        return GetSecurityInfo.Request.builder()
                .classCode( request.getClassCode() )
                .secCode( request.getSecCode() )
                .build();
    }

    @Override
    public qlua.rpc.GetSecurityInfo.Request convertToPb(@NotNull final GetSecurityInfo.Request request) {

        return qlua.rpc.GetSecurityInfo.Request.newBuilder()
                .setClassCode( request.getClassCode() )
                .setSecCode( request.getSecCode() )
                .build();
    }
}