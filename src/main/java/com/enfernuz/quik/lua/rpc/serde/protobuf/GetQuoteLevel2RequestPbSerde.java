package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetQuoteLevel2;
import com.enfernuz.quik.lua.rpc.serde.PbConverter;
import com.enfernuz.quik.lua.rpc.serde.Serde;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import qlua.rpc.RPC;

import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.assertEquals;

enum GetQuoteLevel2RequestPbSerde implements Serde<GetQuoteLevel2.Request>, PbConverter<qlua.rpc.GetQuoteLevel2.Request, GetQuoteLevel2.Request> {

    INSTANCE;

    private static final RPC.ProcedureType PROCEDURE_TYPE = RPC.ProcedureType.GET_QUOTE_LEVEL2;

    @Override
    public byte[] serialize(final GetQuoteLevel2.Request request) {

        return RPC.Request.newBuilder()
                .setTypeValue( PROCEDURE_TYPE.getNumber() )
                .setArgs( convertToPb(request).toByteString() )
                .build()
                .toByteArray();
    }

    @NotNull
    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public GetQuoteLevel2.Request deserialize(final byte[] data) {

        final RPC.Request request = RPC.Request.parseFrom(data);
        assertEquals(request.getType(), PROCEDURE_TYPE);

        return convertFromPb(
                qlua.rpc.GetQuoteLevel2.Request.parseFrom( request.getArgs() )
        );
    }

    @Override
    public GetQuoteLevel2.Request convertFromPb(@NotNull final qlua.rpc.GetQuoteLevel2.Request request) {

        return GetQuoteLevel2.Request.builder()
                .classCode( request.getClassCode() )
                .secCode( request.getSecCode() )
                .build();
    }

    @Override
    public qlua.rpc.GetQuoteLevel2.Request convertToPb(@NotNull final GetQuoteLevel2.Request request) {

        return qlua.rpc.GetQuoteLevel2.Request.newBuilder()
                .setClassCode( request.getClassCode() )
                .setSecCode( request.getSecCode() )
                .build();
    }
}
