package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetWindowRect;
import com.enfernuz.quik.lua.rpc.serde.PbConverter;
import com.enfernuz.quik.lua.rpc.serde.Serde;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import qlua.rpc.RPC;

import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.assertEquals;

enum GetWindowRectRequestPbSerde implements Serde<GetWindowRect.Request>, PbConverter<qlua.rpc.GetWindowRect.Request, GetWindowRect.Request> {

    INSTANCE;

    private static final RPC.ProcedureType PROCEDURE_TYPE = RPC.ProcedureType.GET_WINDOW_RECT;

    @Override
    public byte[] serialize(final GetWindowRect.Request request) {

        return RPC.Request.newBuilder()
                .setTypeValue( PROCEDURE_TYPE.getNumber() )
                .setArgs( convertToPb(request).toByteString() )
                .build()
                .toByteArray();
    }

    @NotNull
    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public GetWindowRect.Request deserialize(final byte[] data) {

        final RPC.Request request = RPC.Request.parseFrom(data);
        assertEquals(request.getType(), PROCEDURE_TYPE);

        return convertFromPb(
                qlua.rpc.GetWindowRect.Request.parseFrom( request.getArgs() )
        );
    }

    @Override
    public GetWindowRect.Request convertFromPb(@NotNull final qlua.rpc.GetWindowRect.Request request) {
        return new GetWindowRect.Request(request.getTId());
    }

    @Override
    public qlua.rpc.GetWindowRect.Request convertToPb(@NotNull final GetWindowRect.Request request) {

        return qlua.rpc.GetWindowRect.Request.newBuilder()
                .setTId( request.getTId() )
                .build();
    }
}
