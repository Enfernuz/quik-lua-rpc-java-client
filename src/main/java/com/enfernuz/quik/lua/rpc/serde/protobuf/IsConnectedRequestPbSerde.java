package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.IsConnected;
import com.enfernuz.quik.lua.rpc.serde.Serde;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import qlua.rpc.RPC;

import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.assertEquals;

enum IsConnectedRequestPbSerde implements Serde<IsConnected.Request> {

    INSTANCE;

    private static final RPC.ProcedureType PROCEDURE_TYPE = RPC.ProcedureType.IS_CONNECTED;
    private static final byte[] PB_SERIALIZED_FORM = createPbSerializedForm();

    @Override
    public byte[] serialize(final IsConnected.Request request) {
        return PB_SERIALIZED_FORM.clone();
    }

    @NotNull
    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public IsConnected.Request deserialize(final byte[] data) {

        final RPC.Request request = RPC.Request.parseFrom(data);
        assertEquals(request.getType(), PROCEDURE_TYPE);

        return IsConnected.Request.INSTANCE;
    }

    private static byte[] createPbSerializedForm() {

        return RPC.Request.newBuilder()
                .setTypeValue( PROCEDURE_TYPE.getNumber() )
                .build()
                .toByteArray();
    }
}
