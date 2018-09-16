package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.IsWindowClosed;
import com.enfernuz.quik.lua.rpc.serde.PbConverter;
import com.enfernuz.quik.lua.rpc.serde.Serde;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import qlua.rpc.RPC;

import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.assertEquals;

enum IsWindowClosedRequestPbSerde implements Serde<IsWindowClosed.Request>, PbConverter<qlua.rpc.IsWindowClosed.Request, IsWindowClosed.Request> {

    INSTANCE;

    private static final RPC.ProcedureType PROCEDURE_TYPE = RPC.ProcedureType.IS_WINDOW_CLOSED;

    @Override
    public byte[] serialize(final IsWindowClosed.Request request) {

        return RPC.Request.newBuilder()
                .setTypeValue( PROCEDURE_TYPE.getNumber() )
                .setArgs( convertToPb(request).toByteString() )
                .build()
                .toByteArray();
    }

    @NotNull
    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public IsWindowClosed.Request deserialize(final byte[] data) {

        final RPC.Request request = RPC.Request.parseFrom(data);
        assertEquals(request.getType(), PROCEDURE_TYPE);

        return convertFromPb(
                qlua.rpc.IsWindowClosed.Request.parseFrom( request.getArgs() )
        );
    }

    @Override
    public IsWindowClosed.Request convertFromPb(@NotNull final qlua.rpc.IsWindowClosed.Request request) {
        return new IsWindowClosed.Request(request.getTId());
    }

    @Override
    public qlua.rpc.IsWindowClosed.Request convertToPb(@NotNull final IsWindowClosed.Request request) {

        return qlua.rpc.IsWindowClosed.Request.newBuilder()
                .setTId( request.getTId() )
                .build();
    }
}
