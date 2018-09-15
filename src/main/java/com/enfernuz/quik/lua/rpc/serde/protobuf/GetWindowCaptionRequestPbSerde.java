package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetWindowCaption;
import com.enfernuz.quik.lua.rpc.serde.PbConverter;
import com.enfernuz.quik.lua.rpc.serde.Serde;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import qlua.rpc.RPC;

import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.assertEquals;

enum GetWindowCaptionRequestPbSerde implements Serde<GetWindowCaption.Request>, PbConverter<qlua.rpc.GetWindowCaption.Request, GetWindowCaption.Request> {

    INSTANCE;

    private static final RPC.ProcedureType PROCEDURE_TYPE = RPC.ProcedureType.GET_WINDOW_CAPTION;

    @Override
    public byte[] serialize(final GetWindowCaption.Request request) {

        return RPC.Request.newBuilder()
                .setTypeValue( PROCEDURE_TYPE.getNumber() )
                .setArgs( convertToPb(request).toByteString() )
                .build()
                .toByteArray();
    }

    @NotNull
    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public GetWindowCaption.Request deserialize(final byte[] data) {

        final RPC.Request request = RPC.Request.parseFrom(data);
        assertEquals(request.getType(), PROCEDURE_TYPE);

        return convertFromPb(
                qlua.rpc.GetWindowCaption.Request.parseFrom( request.getArgs() )
        );
    }

    @Override
    public GetWindowCaption.Request convertFromPb(@NotNull final qlua.rpc.GetWindowCaption.Request request) {
        return new GetWindowCaption.Request(request.getTId());
    }

    @Override
    public qlua.rpc.GetWindowCaption.Request convertToPb(@NotNull final GetWindowCaption.Request request) {

        return qlua.rpc.GetWindowCaption.Request.newBuilder()
                .setTId( request.getTId() )
                .build();
    }
}
