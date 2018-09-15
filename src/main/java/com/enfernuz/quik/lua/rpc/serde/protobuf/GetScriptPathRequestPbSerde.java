package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetScriptPath;
import com.enfernuz.quik.lua.rpc.serde.Serde;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import qlua.rpc.RPC;

import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.assertEquals;

enum GetScriptPathRequestPbSerde implements Serde<GetScriptPath.Request> {

    INSTANCE;

    private static final RPC.ProcedureType PROCEDURE_TYPE = RPC.ProcedureType.GET_SCRIPT_PATH;
    private static final byte[] PB_SERIALIZED_FORM = createPbSerializedForm();

    @Override
    public byte[] serialize(final GetScriptPath.Request request) {
        return PB_SERIALIZED_FORM.clone();
    }

    @NotNull
    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public GetScriptPath.Request deserialize(final byte[] data) {

        final RPC.Request request = RPC.Request.parseFrom(data);
        assertEquals(request.getType(), PROCEDURE_TYPE);

        return GetScriptPath.Request.INSTANCE;
    }

    private static byte[] createPbSerializedForm() {

        return RPC.Request.newBuilder()
                .setTypeValue( PROCEDURE_TYPE.getNumber() )
                .build()
                .toByteArray();
    }
}
