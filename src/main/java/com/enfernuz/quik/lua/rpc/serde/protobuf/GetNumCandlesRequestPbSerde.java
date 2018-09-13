package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetNumCandles;
import com.enfernuz.quik.lua.rpc.serde.PbConverter;
import com.enfernuz.quik.lua.rpc.serde.Serde;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import qlua.rpc.RPC;

import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.assertEquals;

enum GetNumCandlesRequestPbSerde implements Serde<GetNumCandles.Request>, PbConverter<qlua.rpc.GetNumCandles.Request, GetNumCandles.Request> {

    INSTANCE;

    private static final RPC.ProcedureType PROCEDURE_TYPE = RPC.ProcedureType.GET_NUM_CANDLES;

    @Override
    public byte[] serialize(final GetNumCandles.Request request) {

        return RPC.Request.newBuilder()
                .setTypeValue( PROCEDURE_TYPE.getNumber() )
                .setArgs( convertToPb(request).toByteString() )
                .build()
                .toByteArray();
    }

    @NotNull
    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public GetNumCandles.Request deserialize(final byte[] data) {

        final RPC.Request request = RPC.Request.parseFrom(data);
        assertEquals(request.getType(), PROCEDURE_TYPE);

        return convertFromPb(
                qlua.rpc.GetNumCandles.Request.parseFrom( request.getArgs() )
        );
    }

    @Override
    public GetNumCandles.Request convertFromPb(@NotNull final qlua.rpc.GetNumCandles.Request request) {
        return new GetNumCandles.Request( request.getTag() );
    }

    @Override
    public qlua.rpc.GetNumCandles.Request convertToPb(@NotNull final GetNumCandles.Request request) {

        return qlua.rpc.GetNumCandles.Request.newBuilder()
                .setTag( request.getTag() )
                .build();
    }
}
