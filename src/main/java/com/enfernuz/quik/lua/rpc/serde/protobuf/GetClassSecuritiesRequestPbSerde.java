package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetClassSecurities;
import com.enfernuz.quik.lua.rpc.serde.PbConverter;
import com.enfernuz.quik.lua.rpc.serde.Serde;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import qlua.rpc.RPC;

import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.assertEquals;

enum GetClassSecuritiesRequestPbSerde implements Serde<GetClassSecurities.Request>, PbConverter<qlua.rpc.GetClassSecurities.Request, GetClassSecurities.Request> {

    INSTANCE;

    private static final RPC.ProcedureType PROCEDURE_TYPE = RPC.ProcedureType.GET_CLASS_SECURITIES;

    @Override
    public byte[] serialize(final GetClassSecurities.Request request) {

        return RPC.Request.newBuilder()
                .setTypeValue( PROCEDURE_TYPE.getNumber() )
                .setArgs( convertToPb(request).toByteString() )
                .build()
                .toByteArray();
    }

    @NotNull
    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public GetClassSecurities.Request deserialize(final byte[] data) {

        final RPC.Request request = RPC.Request.parseFrom(data);
        assertEquals(request.getType(), PROCEDURE_TYPE);

        return convertFromPb(
                qlua.rpc.GetClassSecurities.Request.parseFrom( request.getArgs() )
        );
    }

    @Override
    public GetClassSecurities.Request convertFromPb(@NotNull final qlua.rpc.GetClassSecurities.Request request) {
        return new GetClassSecurities.Request( request.getClassCode() );
    }

    @Override
    public qlua.rpc.GetClassSecurities.Request convertToPb(@NotNull final GetClassSecurities.Request request) {

        return qlua.rpc.GetClassSecurities.Request.newBuilder()
                .setClassCode( request.getClassCode() )
                .build();
    }
}
