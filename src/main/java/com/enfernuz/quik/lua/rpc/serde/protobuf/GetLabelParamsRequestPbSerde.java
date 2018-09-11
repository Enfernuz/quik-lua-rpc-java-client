package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetLabelParams;
import com.enfernuz.quik.lua.rpc.serde.PbConverter;
import com.enfernuz.quik.lua.rpc.serde.Serde;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import qlua.rpc.RPC;

import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.assertEquals;

enum GetLabelParamsRequestPbSerde implements Serde<GetLabelParams.Request>, PbConverter<qlua.rpc.GetLabelParams.Request, GetLabelParams.Request> {

    INSTANCE;

    private static final RPC.ProcedureType PROCEDURE_TYPE = RPC.ProcedureType.GET_LABEL_PARAMS;

    @Override
    public byte[] serialize(final GetLabelParams.Request request) {

        return RPC.Request.newBuilder()
                .setTypeValue( PROCEDURE_TYPE.getNumber() )
                .setArgs( convertToPb(request).toByteString() )
                .build()
                .toByteArray();
    }

    @NotNull
    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public GetLabelParams.Request deserialize(final byte[] data) {

        final RPC.Request request = RPC.Request.parseFrom(data);
        assertEquals(request.getType(), PROCEDURE_TYPE);

        return convertFromPb(
                qlua.rpc.GetLabelParams.Request.parseFrom( request.getArgs() )
        );
    }

    @Override
    public GetLabelParams.Request convertFromPb(@NotNull final qlua.rpc.GetLabelParams.Request request) {
        return new GetLabelParams.Request(request.getChartTag(), request.getLabelId());
    }

    @Override
    public qlua.rpc.GetLabelParams.Request convertToPb(@NotNull final GetLabelParams.Request request) {

        return qlua.rpc.GetLabelParams.Request.newBuilder()
                .setChartTag( request.getChartTag() )
                .setLabelId( request.getLabelId() )
                .build();
    }
}
