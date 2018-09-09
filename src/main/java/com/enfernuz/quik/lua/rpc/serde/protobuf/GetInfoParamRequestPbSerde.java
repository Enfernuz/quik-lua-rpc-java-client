package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetInfoParam;
import com.enfernuz.quik.lua.rpc.serde.PbConverter;
import com.enfernuz.quik.lua.rpc.serde.Serde;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import qlua.rpc.RPC;

import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.assertEquals;

enum GetInfoParamRequestPbSerde implements Serde<GetInfoParam.Request>, PbConverter<qlua.rpc.GetInfoParam.Request, GetInfoParam.Request> {

    INSTANCE;

    private static final RPC.ProcedureType PROCEDURE_TYPE = RPC.ProcedureType.GET_INFO_PARAM;

    @Override
    public byte[] serialize(final GetInfoParam.Request request) {

        return RPC.Request.newBuilder()
                .setTypeValue( PROCEDURE_TYPE.getNumber() )
                .setArgs( convertToPb(request).toByteString() )
                .build()
                .toByteArray();
    }

    @NotNull
    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public GetInfoParam.Request deserialize(final byte[] data) {

        final RPC.Request request = RPC.Request.parseFrom(data);
        assertEquals(request.getType(), PROCEDURE_TYPE);

        return convertFromPb(
                qlua.rpc.GetInfoParam.Request.parseFrom( request.getArgs() )
        );
    }

    @Override
    public GetInfoParam.Request convertFromPb(@NotNull final qlua.rpc.GetInfoParam.Request request) {
        return new GetInfoParam.Request( request.getParamName() );
    }

    @Override
    public qlua.rpc.GetInfoParam.Request convertToPb(@NotNull final GetInfoParam.Request request) {

        return qlua.rpc.GetInfoParam.Request.newBuilder()
                .setParamName( request.getParamName() )
                .build();
    }
}
