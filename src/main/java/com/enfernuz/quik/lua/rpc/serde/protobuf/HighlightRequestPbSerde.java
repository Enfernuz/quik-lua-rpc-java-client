package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.Highlight;
import com.enfernuz.quik.lua.rpc.serde.PbConverter;
import com.enfernuz.quik.lua.rpc.serde.Serde;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import qlua.rpc.RPC;

import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.assertEquals;

enum HighlightRequestPbSerde implements Serde<Highlight.Request>, PbConverter<qlua.rpc.Highlight.Request, Highlight.Request> {

    INSTANCE;

    private static final RPC.ProcedureType PROCEDURE_TYPE = RPC.ProcedureType.HIGHLIGHT;

    @Override
    public byte[] serialize(final Highlight.Request request) {

        return RPC.Request.newBuilder()
                .setTypeValue( PROCEDURE_TYPE.getNumber() )
                .setArgs( convertToPb(request).toByteString() )
                .build()
                .toByteArray();
    }

    @NotNull
    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public Highlight.Request deserialize(final byte[] data) {

        final RPC.Request request = RPC.Request.parseFrom(data);
        assertEquals(request.getType(), PROCEDURE_TYPE);

        return convertFromPb(
                qlua.rpc.Highlight.Request.parseFrom( request.getArgs() )
        );
    }

    @Override
    public Highlight.Request convertFromPb(@NotNull final qlua.rpc.Highlight.Request request) {

        return Highlight.Request.builder()
                .tId( request.getTId() )
                .row( request.getRow() )
                .col( request.getCol() )
                .bColor( request.getBColor() )
                .fColor( request.getFColor() )
                .timeout( request.getTimeout() )
                .build();
    }

    @Override
    public qlua.rpc.Highlight.Request convertToPb(@NotNull final Highlight.Request request) {

        return qlua.rpc.Highlight.Request.newBuilder()
                .setTId( request.getTId() )
                .setRow( request.getRow() )
                .setCol( request.getCol() )
                .setBColor( request.getBColor() )
                .setFColor( request.getFColor() )
                .setTimeout( request.getTimeout() )
                .build();
    }
}
