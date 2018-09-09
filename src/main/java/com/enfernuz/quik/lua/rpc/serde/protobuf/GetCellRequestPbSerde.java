package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetCell;
import com.enfernuz.quik.lua.rpc.serde.PbConverter;
import com.enfernuz.quik.lua.rpc.serde.Serde;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import qlua.rpc.RPC;

import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.assertEquals;

enum GetCellRequestPbSerde implements Serde<GetCell.Request>, PbConverter<qlua.rpc.GetCell.Request, GetCell.Request> {

    INSTANCE;

    private static final RPC.ProcedureType PROCEDURE_TYPE = RPC.ProcedureType.GET_CELL;

    @Override
    public byte[] serialize(final GetCell.Request request) {

        return RPC.Request.newBuilder()
                .setTypeValue( PROCEDURE_TYPE.getNumber() )
                .setArgs( convertToPb(request).toByteString() )
                .build()
                .toByteArray();
    }

    @NotNull
    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public GetCell.Request deserialize(final byte[] data) {

        final RPC.Request request = RPC.Request.parseFrom(data);
        assertEquals(request.getType(), PROCEDURE_TYPE);

        return convertFromPb(
                qlua.rpc.GetCell.Request.parseFrom( request.getArgs() )
        );
    }

    @Override
    public GetCell.Request convertFromPb(@NotNull final qlua.rpc.GetCell.Request request) {

        return GetCell.Request.builder()
                .tId( request.getTId() )
                .key( request.getKey() )
                .code( request.getCode() )
                .build();
    }

    @Override
    public qlua.rpc.GetCell.Request convertToPb(@NotNull final GetCell.Request request) {

        return qlua.rpc.GetCell.Request.newBuilder()
                .setTId( request.getTId() )
                .setKey( request.getKey() )
                .setCode( request.getCode() )
                .build();
    }
}
