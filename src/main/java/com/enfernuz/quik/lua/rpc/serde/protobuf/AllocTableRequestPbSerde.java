package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.AllocTable;
import com.enfernuz.quik.lua.rpc.serde.Serde;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import qlua.rpc.RPC;

import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.assertEquals;

enum AllocTableRequestPbSerde implements Serde<AllocTable.Request> {

    INSTANCE;

    private static final byte[] PB_SERIALIZED_FORM = createPbSerializedForm();

    @Override
    public byte[] serialize(final AllocTable.Request request) {
        return PB_SERIALIZED_FORM.clone();
    }

    @NotNull
    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public AllocTable.Request deserialize(final byte[] data) {

        final RPC.Request request = RPC.Request.parseFrom(data);
        assertEquals(request.getType(), RPC.ProcedureType.ALLOC_TABLE);

        return AllocTable.Request.INSTANCE;
    }

    private static byte[] createPbSerializedForm() {

        return RPC.Request.newBuilder()
                .setTypeValue( RPC.ProcedureType.ALLOC_TABLE.getNumber() )
                .build()
                .toByteArray();
    }
}
