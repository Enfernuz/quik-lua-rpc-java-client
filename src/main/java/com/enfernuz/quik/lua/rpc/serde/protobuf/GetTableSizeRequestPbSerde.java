package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetTableSize;
import com.enfernuz.quik.lua.rpc.serde.PbConverter;
import com.enfernuz.quik.lua.rpc.serde.Serde;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import qlua.rpc.RPC;

import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.assertEquals;

enum GetTableSizeRequestPbSerde implements Serde<GetTableSize.Request>, PbConverter<qlua.rpc.GetTableSize.Request, GetTableSize.Request> {

    INSTANCE;

    private static final RPC.ProcedureType PROCEDURE_TYPE = RPC.ProcedureType.GET_TABLE_SIZE;

    @Override
    public byte[] serialize(final GetTableSize.Request request) {

        return RPC.Request.newBuilder()
                .setTypeValue( PROCEDURE_TYPE.getNumber() )
                .setArgs( convertToPb(request).toByteString() )
                .build()
                .toByteArray();
    }

    @NotNull
    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public GetTableSize.Request deserialize(final byte[] data) {

        final RPC.Request request = RPC.Request.parseFrom(data);
        assertEquals(request.getType(), PROCEDURE_TYPE);

        return convertFromPb(
                qlua.rpc.GetTableSize.Request.parseFrom( request.getArgs() )
        );
    }

    @Override
    public GetTableSize.Request convertFromPb(@NotNull final qlua.rpc.GetTableSize.Request request) {
        return new GetTableSize.Request(request.getTId());
    }

    @Override
    public qlua.rpc.GetTableSize.Request convertToPb(@NotNull final GetTableSize.Request request) {

        return qlua.rpc.GetTableSize.Request.newBuilder()
                .setTId( request.getTId() )
                .build();
    }
}
