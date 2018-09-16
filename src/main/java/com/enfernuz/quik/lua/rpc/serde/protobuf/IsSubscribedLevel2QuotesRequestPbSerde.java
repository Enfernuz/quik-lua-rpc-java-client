package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.IsSubscribedLevel2Quotes;
import com.enfernuz.quik.lua.rpc.serde.PbConverter;
import com.enfernuz.quik.lua.rpc.serde.Serde;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import qlua.rpc.RPC;

import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.assertEquals;

enum IsSubscribedLevel2QuotesRequestPbSerde implements Serde<IsSubscribedLevel2Quotes.Request>, PbConverter<qlua.rpc.IsSubscribedLevelIIQuotes.Request, IsSubscribedLevel2Quotes.Request> {

    INSTANCE;

    private static final RPC.ProcedureType PROCEDURE_TYPE = RPC.ProcedureType.IS_SUBSCRIBED_LEVEL_II_QUOTES;

    @Override
    public byte[] serialize(final IsSubscribedLevel2Quotes.Request request) {

        return RPC.Request.newBuilder()
                .setTypeValue( PROCEDURE_TYPE.getNumber() )
                .setArgs( convertToPb(request).toByteString() )
                .build()
                .toByteArray();
    }

    @NotNull
    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public IsSubscribedLevel2Quotes.Request deserialize(final byte[] data) {

        final RPC.Request request = RPC.Request.parseFrom(data);
        assertEquals(request.getType(), PROCEDURE_TYPE);

        return convertFromPb(
                qlua.rpc.IsSubscribedLevelIIQuotes.Request.parseFrom( request.getArgs() )
        );
    }

    @Override
    public IsSubscribedLevel2Quotes.Request convertFromPb(@NotNull final qlua.rpc.IsSubscribedLevelIIQuotes.Request request) {

        return IsSubscribedLevel2Quotes.Request.builder()
                .classCode( request.getClassCode() )
                .secCode( request.getSecCode() )
                .build();
    }

    @Override
    public qlua.rpc.IsSubscribedLevelIIQuotes.Request convertToPb(@NotNull final IsSubscribedLevel2Quotes.Request request) {

        return qlua.rpc.IsSubscribedLevelIIQuotes.Request.newBuilder()
                .setClassCode( request.getClassCode() )
                .setSecCode( request.getSecCode() )
                .build();
    }
}
