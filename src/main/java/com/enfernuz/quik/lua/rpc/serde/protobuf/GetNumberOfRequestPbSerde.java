package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetNumberOf;
import com.enfernuz.quik.lua.rpc.serde.PbConverter;
import com.enfernuz.quik.lua.rpc.serde.Serde;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import qlua.rpc.RPC;

import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.assertEquals;

enum GetNumberOfRequestPbSerde implements Serde<GetNumberOf.Request>, PbConverter<qlua.rpc.GetNumberOf.Request, GetNumberOf.Request> {

    INSTANCE;

    private static final RPC.ProcedureType PROCEDURE_TYPE = RPC.ProcedureType.GET_NUMBER_OF;

    @Override
    public byte[] serialize(final GetNumberOf.Request request) {

        return RPC.Request.newBuilder()
                .setTypeValue( PROCEDURE_TYPE.getNumber() )
                .setArgs( convertToPb(request).toByteString() )
                .build()
                .toByteArray();
    }

    @NotNull
    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public GetNumberOf.Request deserialize(final byte[] data) {

        final RPC.Request request = RPC.Request.parseFrom(data);
        assertEquals(request.getType(), PROCEDURE_TYPE);

        return convertFromPb(
                qlua.rpc.GetNumberOf.Request.parseFrom( request.getArgs() )
        );
    }

    @Override
    public GetNumberOf.Request convertFromPb(@NotNull final qlua.rpc.GetNumberOf.Request request) {
        return new GetNumberOf.Request( request.getTableName() );
    }

    @Override
    public qlua.rpc.GetNumberOf.Request convertToPb(@NotNull final GetNumberOf.Request request) {

        return qlua.rpc.GetNumberOf.Request.newBuilder()
                .setTableName( request.getTableName() )
                .build();
    }
}
