package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.AddLabel;
import com.enfernuz.quik.lua.rpc.serde.PbConverter;
import com.enfernuz.quik.lua.rpc.serde.Serde;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import qlua.rpc.RPC;

import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.*;

enum AddLabelRequestPbSerde implements Serde<AddLabel.Request>, PbConverter<qlua.rpc.AddLabel.Request, AddLabel.Request> {

    INSTANCE;

    @Override
    public byte[] serialize(final AddLabel.Request request) {

        return RPC.Request.newBuilder()
                .setTypeValue( RPC.ProcedureType.ADD_LABEL.getNumber() )
                .setArgs( convertToPb(request).toByteString() )
                .build()
                .toByteArray();
    }

    @NotNull
    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public AddLabel.Request deserialize(final byte[] data) {

        final RPC.Request request = RPC.Request.parseFrom(data);
        assertEquals(request.getType(), RPC.ProcedureType.ADD_LABEL);

        return convertFromPb(
                qlua.rpc.AddLabel.Request.parseFrom( request.getArgs() )
        );
    }

    @Override
    public AddLabel.Request convertFromPb(@NotNull final qlua.rpc.AddLabel.Request request) {

        return AddLabel.Request.builder()
                .chartTag( request.getChartTag() )
                .labelParams( request.getLabelParamsMap() )
                .build();
    }

    @Override
    public qlua.rpc.AddLabel.Request convertToPb(@NotNull final AddLabel.Request request) {

        return qlua.rpc.AddLabel.Request.newBuilder()
                .setChartTag( request.getChartTag() )
                .putAllLabelParams( request.getLabelParams() )
                .build();
    }
}
