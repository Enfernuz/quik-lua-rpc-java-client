package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.DelAllLabels;
import com.enfernuz.quik.lua.rpc.serde.PbConverter;
import com.enfernuz.quik.lua.rpc.serde.Serde;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import qlua.rpc.RPC;

import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.assertEquals;

enum DelAllLabelsRequestPbSerde implements Serde<DelAllLabels.Request>, PbConverter<qlua.rpc.DelAllLabels.Request, DelAllLabels.Request> {

    INSTANCE;

    private static final RPC.ProcedureType PROCEDURE_TYPE = RPC.ProcedureType.DEL_ALL_LABELS;

    @Override
    public byte[] serialize(final DelAllLabels.Request request) {

        return RPC.Request.newBuilder()
                .setTypeValue( PROCEDURE_TYPE.getNumber() )
                .setArgs( convertToPb(request).toByteString() )
                .build()
                .toByteArray();
    }

    @NotNull
    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public DelAllLabels.Request deserialize(final byte[] data) {

        final RPC.Request request = RPC.Request.parseFrom(data);
        assertEquals(request.getType(), PROCEDURE_TYPE);

        return convertFromPb(
                qlua.rpc.DelAllLabels.Request.parseFrom( request.getArgs() )
        );
    }

    @Override
    public DelAllLabels.Request convertFromPb(@NotNull final qlua.rpc.DelAllLabels.Request request) {
        return new DelAllLabels.Request( request.getChartTag() );
    }

    @Override
    public qlua.rpc.DelAllLabels.Request convertToPb(@NotNull final DelAllLabels.Request request) {

        return qlua.rpc.DelAllLabels.Request.newBuilder()
                .setChartTag( request.getChartTag() )
                .build();
    }
}
