package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.InsertRow;
import com.enfernuz.quik.lua.rpc.serde.PbConverter;
import com.enfernuz.quik.lua.rpc.serde.Serde;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import qlua.rpc.RPC;

import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.assertEquals;

enum InsertRowRequestPbSerde implements Serde<InsertRow.Request>, PbConverter<qlua.rpc.InsertRow.Request, InsertRow.Request> {

    INSTANCE;

    private static final RPC.ProcedureType PROCEDURE_TYPE = RPC.ProcedureType.INSERT_ROW;

    @Override
    public byte[] serialize(final InsertRow.Request request) {

        return RPC.Request.newBuilder()
                .setTypeValue( PROCEDURE_TYPE.getNumber() )
                .setArgs( convertToPb(request).toByteString() )
                .build()
                .toByteArray();
    }

    @NotNull
    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public InsertRow.Request deserialize(final byte[] data) {

        final RPC.Request request = RPC.Request.parseFrom(data);
        assertEquals(request.getType(), PROCEDURE_TYPE);

        return convertFromPb(
                qlua.rpc.InsertRow.Request.parseFrom( request.getArgs() )
        );
    }

    @Override
    public InsertRow.Request convertFromPb(@NotNull final qlua.rpc.InsertRow.Request request) {

        return InsertRow.Request.builder()
                .tId( request.getTId() )
                .key( request.getKey() )
                .build();
    }

    @Override
    public qlua.rpc.InsertRow.Request convertToPb(@NotNull final InsertRow.Request request) {

        return qlua.rpc.InsertRow.Request.newBuilder()
                .setTId( request.getTId() )
                .setKey( request.getKey() )
                .build();
    }
}
