package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.CreateWindow;
import com.enfernuz.quik.lua.rpc.serde.PbConverter;
import com.enfernuz.quik.lua.rpc.serde.Serde;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import qlua.rpc.RPC;

import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.assertEquals;

enum CreateWindowRequestPbSerde implements Serde<CreateWindow.Request>, PbConverter<qlua.rpc.CreateWindow.Request, CreateWindow.Request> {

    INSTANCE;

    private static final RPC.ProcedureType PROCEDURE_TYPE = RPC.ProcedureType.CREATE_WINDOW;

    @Override
    public byte[] serialize(final CreateWindow.Request request) {

        return RPC.Request.newBuilder()
                .setTypeValue( PROCEDURE_TYPE.getNumber() )
                .setArgs( convertToPb(request).toByteString() )
                .build()
                .toByteArray();
    }

    @NotNull
    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public CreateWindow.Request deserialize(final byte[] data) {

        final RPC.Request request = RPC.Request.parseFrom(data);
        assertEquals(request.getType(), PROCEDURE_TYPE);

        return convertFromPb(
                qlua.rpc.CreateWindow.Request.parseFrom( request.getArgs() )
        );
    }

    @Override
    public CreateWindow.Request convertFromPb(@NotNull final qlua.rpc.CreateWindow.Request request) {
        return new CreateWindow.Request( request.getTId() );
    }

    @Override
    public qlua.rpc.CreateWindow.Request convertToPb(@NotNull final CreateWindow.Request request) {

        return qlua.rpc.CreateWindow.Request.newBuilder()
                .setTId( request.getTId() )
                .build();
    }
}
