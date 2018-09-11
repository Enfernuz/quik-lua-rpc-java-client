package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetLinesCount;
import com.enfernuz.quik.lua.rpc.serde.PbConverter;
import com.enfernuz.quik.lua.rpc.serde.Serde;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import qlua.rpc.RPC;

import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.assertEquals;

enum GetLinesCountRequestPbSerde implements Serde<GetLinesCount.Request>, PbConverter<qlua.rpc.GetLinesCount.Request, GetLinesCount.Request> {

    INSTANCE;

    private static final RPC.ProcedureType PROCEDURE_TYPE = RPC.ProcedureType.GET_LINES_COUNT;

    @Override
    public byte[] serialize(final GetLinesCount.Request request) {

        return RPC.Request.newBuilder()
                .setTypeValue( PROCEDURE_TYPE.getNumber() )
                .setArgs( convertToPb(request).toByteString() )
                .build()
                .toByteArray();
    }

    @NotNull
    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public GetLinesCount.Request deserialize(final byte[] data) {

        final RPC.Request request = RPC.Request.parseFrom(data);
        assertEquals(request.getType(), PROCEDURE_TYPE);

        return convertFromPb(
                qlua.rpc.GetLinesCount.Request.parseFrom( request.getArgs() )
        );
    }

    @Override
    public GetLinesCount.Request convertFromPb(@NotNull final qlua.rpc.GetLinesCount.Request request) {
        return new GetLinesCount.Request( request.getTag() );
    }

    @Override
    public qlua.rpc.GetLinesCount.Request convertToPb(@NotNull final GetLinesCount.Request request) {

        return qlua.rpc.GetLinesCount.Request.newBuilder()
                .setTag( request.getTag() )
                .build();
    }
}
