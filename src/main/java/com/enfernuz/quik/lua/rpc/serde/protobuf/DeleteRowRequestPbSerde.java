package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.DeleteRow;
import com.enfernuz.quik.lua.rpc.serde.PbConverter;
import com.enfernuz.quik.lua.rpc.serde.Serde;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import qlua.rpc.RPC;

import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.assertEquals;

enum DeleteRowRequestPbSerde implements Serde<DeleteRow.Request>, PbConverter<qlua.rpc.DeleteRow.Request, DeleteRow.Request> {

    INSTANCE;

    private static final RPC.ProcedureType PROCEDURE_TYPE = RPC.ProcedureType.DELETE_ROW;

    @Override
    public byte[] serialize(final DeleteRow.Request request) {

        return RPC.Request.newBuilder()
                .setTypeValue( PROCEDURE_TYPE.getNumber() )
                .setArgs( convertToPb(request).toByteString() )
                .build()
                .toByteArray();
    }

    @NotNull
    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public DeleteRow.Request deserialize(final byte[] data) {

        final RPC.Request request = RPC.Request.parseFrom(data);
        assertEquals(request.getType(), PROCEDURE_TYPE);

        return convertFromPb(
                qlua.rpc.DeleteRow.Request.parseFrom( request.getArgs() )
        );
    }

    @Override
    public DeleteRow.Request convertFromPb(@NotNull final qlua.rpc.DeleteRow.Request request) {
        return new DeleteRow.Request(request.getTId(), request.getKey());
    }

    @Override
    public qlua.rpc.DeleteRow.Request convertToPb(@NotNull final DeleteRow.Request request) {

        return qlua.rpc.DeleteRow.Request.newBuilder()
                .setTId( request.getTId() )
                .setKey( request.getKey() )
                .build();
    }
}
