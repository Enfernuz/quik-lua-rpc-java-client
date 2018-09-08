package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.DestroyTable;
import com.enfernuz.quik.lua.rpc.serde.PbConverter;
import com.enfernuz.quik.lua.rpc.serde.Serde;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import qlua.rpc.RPC;

import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.assertEquals;

enum DestroyTableRequestPbSerde implements Serde<DestroyTable.Request>, PbConverter<qlua.rpc.DestroyTable.Request, DestroyTable.Request> {

    INSTANCE;

    private static final RPC.ProcedureType PROCEDURE_TYPE = RPC.ProcedureType.DESTROY_TABLE;

    @Override
    public byte[] serialize(final DestroyTable.Request request) {

        return RPC.Request.newBuilder()
                .setTypeValue( PROCEDURE_TYPE.getNumber() )
                .setArgs( convertToPb(request).toByteString() )
                .build()
                .toByteArray();
    }

    @NotNull
    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public DestroyTable.Request deserialize(final byte[] data) {

        final RPC.Request request = RPC.Request.parseFrom(data);
        assertEquals(request.getType(), PROCEDURE_TYPE);

        return convertFromPb(
                qlua.rpc.DestroyTable.Request.parseFrom( request.getArgs() )
        );
    }

    @Override
    public DestroyTable.Request convertFromPb(@NotNull final qlua.rpc.DestroyTable.Request request) {
        return new DestroyTable.Request( request.getTId() );
    }

    @Override
    public qlua.rpc.DestroyTable.Request convertToPb(@NotNull final DestroyTable.Request request) {

        return qlua.rpc.DestroyTable.Request.newBuilder()
                .setTId( request.getTId() )
                .build();
    }
}
