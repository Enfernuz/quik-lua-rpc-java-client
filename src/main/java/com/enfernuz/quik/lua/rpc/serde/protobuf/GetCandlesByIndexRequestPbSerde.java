package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetCandlesByIndex;
import com.enfernuz.quik.lua.rpc.serde.PbConverter;
import com.enfernuz.quik.lua.rpc.serde.Serde;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import qlua.rpc.RPC;

import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.assertEquals;

enum GetCandlesByIndexRequestPbSerde implements Serde<GetCandlesByIndex.Request>, PbConverter<qlua.rpc.GetCandlesByIndex.Request, GetCandlesByIndex.Request> {

    INSTANCE;

    private static final RPC.ProcedureType PROCEDURE_TYPE = RPC.ProcedureType.GET_CANDLES_BY_INDEX;

    @Override
    public byte[] serialize(final GetCandlesByIndex.Request request) {

        return RPC.Request.newBuilder()
                .setTypeValue( PROCEDURE_TYPE.getNumber() )
                .setArgs( convertToPb(request).toByteString() )
                .build()
                .toByteArray();
    }

    @NotNull
    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public GetCandlesByIndex.Request deserialize(final byte[] data) {

        final RPC.Request request = RPC.Request.parseFrom(data);
        assertEquals(request.getType(), PROCEDURE_TYPE);

        return convertFromPb(
                qlua.rpc.GetCandlesByIndex.Request.parseFrom( request.getArgs() )
        );
    }

    @Override
    public GetCandlesByIndex.Request convertFromPb(@NotNull final qlua.rpc.GetCandlesByIndex.Request request) {

        return GetCandlesByIndex.Request.builder()
                .tag( request.getTag() )
                .line( request.getLine() )
                .firstCandle( request.getFirstCandle() )
                .count( request.getCount() )
                .build();
    }

    @Override
    public qlua.rpc.GetCandlesByIndex.Request convertToPb(@NotNull final GetCandlesByIndex.Request request) {

        return qlua.rpc.GetCandlesByIndex.Request.newBuilder()
                .setTag( request.getTag() )
                .setLine( request.getLine() )
                .setFirstCandle( request.getFirstCandle() )
                .setCount( request.getCount() )
                .build();
    }
}
