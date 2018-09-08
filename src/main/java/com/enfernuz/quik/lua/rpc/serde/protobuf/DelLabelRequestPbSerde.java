package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.DelLabel;
import com.enfernuz.quik.lua.rpc.serde.PbConverter;
import com.enfernuz.quik.lua.rpc.serde.Serde;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import qlua.rpc.RPC;

import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.assertEquals;

enum DelLabelRequestPbSerde implements Serde<DelLabel.Request>, PbConverter<qlua.rpc.DelLabel.Request, DelLabel.Request> {

    INSTANCE;

    private static final RPC.ProcedureType PROCEDURE_TYPE = RPC.ProcedureType.DEL_LABEL;

    @Override
    public byte[] serialize(final DelLabel.Request request) {

        return RPC.Request.newBuilder()
                .setTypeValue( PROCEDURE_TYPE.getNumber() )
                .setArgs( convertToPb(request).toByteString() )
                .build()
                .toByteArray();
    }

    @NotNull
    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public DelLabel.Request deserialize(final byte[] data) {

        final RPC.Request request = RPC.Request.parseFrom(data);
        assertEquals(request.getType(), PROCEDURE_TYPE);

        return convertFromPb(
                qlua.rpc.DelLabel.Request.parseFrom( request.getArgs() )
        );
    }

    @Override
    public DelLabel.Request convertFromPb(@NotNull final qlua.rpc.DelLabel.Request request) {
        return new DelLabel.Request(request.getChartTag(), request.getLabelId());
    }

    @Override
    public qlua.rpc.DelLabel.Request convertToPb(@NotNull final DelLabel.Request request) {

        return qlua.rpc.DelLabel.Request.newBuilder()
                .setChartTag( request.getChartTag() )
                .setLabelId( request.getLabelId() )
                .build();
    }
}
