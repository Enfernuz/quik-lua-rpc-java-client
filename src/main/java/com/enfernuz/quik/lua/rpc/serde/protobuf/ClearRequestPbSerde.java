package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.Clear;
import com.enfernuz.quik.lua.rpc.serde.PbConverter;
import com.enfernuz.quik.lua.rpc.serde.Serde;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import qlua.rpc.RPC;

import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.assertEquals;

enum ClearRequestPbSerde implements Serde<Clear.Request>, PbConverter<qlua.rpc.Clear.Request, Clear.Request> {

    INSTANCE;

    private static final RPC.ProcedureType PROCEDURE_TYPE = RPC.ProcedureType.CLEAR;

    @Override
    public byte[] serialize(final Clear.Request request) {

        return RPC.Request.newBuilder()
                .setTypeValue( PROCEDURE_TYPE.getNumber() )
                .setArgs( convertToPb(request).toByteString() )
                .build()
                .toByteArray();
    }

    @NotNull
    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public Clear.Request deserialize(final byte[] data) {

        final RPC.Request request = RPC.Request.parseFrom(data);
        assertEquals(request.getType(), PROCEDURE_TYPE);

        return convertFromPb(
                qlua.rpc.Clear.Request.parseFrom( request.getArgs() )
        );
    }

    @Override
    public Clear.Request convertFromPb(@NotNull final qlua.rpc.Clear.Request request) {
        return new Clear.Request( request.getTId() );
    }

    @Override
    public qlua.rpc.Clear.Request convertToPb(@NotNull final Clear.Request request) {

        return qlua.rpc.Clear.Request.newBuilder()
                .setTId( request.getTId() )
                .build();
    }
}
