package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetItem;
import com.enfernuz.quik.lua.rpc.serde.PbConverter;
import com.enfernuz.quik.lua.rpc.serde.Serde;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import qlua.rpc.RPC;

import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.assertEquals;

enum GetItemRequestPbSerde implements Serde<GetItem.Request>, PbConverter<qlua.rpc.GetItem.Request, GetItem.Request> {

    INSTANCE;

    private static final RPC.ProcedureType PROCEDURE_TYPE = RPC.ProcedureType.GET_ITEM;

    @Override
    public byte[] serialize(final GetItem.Request request) {

        return RPC.Request.newBuilder()
                .setTypeValue( PROCEDURE_TYPE.getNumber() )
                .setArgs( convertToPb(request).toByteString() )
                .build()
                .toByteArray();
    }

    @NotNull
    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public GetItem.Request deserialize(final byte[] data) {

        final RPC.Request request = RPC.Request.parseFrom(data);
        assertEquals(request.getType(), PROCEDURE_TYPE);

        return convertFromPb(
                qlua.rpc.GetItem.Request.parseFrom( request.getArgs() )
        );
    }

    @Override
    public GetItem.Request convertFromPb(@NotNull final qlua.rpc.GetItem.Request request) {
        return new GetItem.Request(request.getTableName(), request.getIndex());
    }

    @Override
    public qlua.rpc.GetItem.Request convertToPb(@NotNull final GetItem.Request request) {

        return qlua.rpc.GetItem.Request.newBuilder()
                .setTableName( request.getTableName() )
                .setIndex( request.getIndex() )
                .build();
    }
}
