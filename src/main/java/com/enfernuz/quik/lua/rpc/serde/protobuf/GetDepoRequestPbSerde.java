package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetDepo;
import com.enfernuz.quik.lua.rpc.serde.PbConverter;
import com.enfernuz.quik.lua.rpc.serde.Serde;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import qlua.rpc.RPC;

import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.assertEquals;

enum GetDepoRequestPbSerde implements Serde<GetDepo.Request>, PbConverter<qlua.rpc.GetDepo.Request, GetDepo.Request> {

    INSTANCE;

    private static final RPC.ProcedureType PROCEDURE_TYPE = RPC.ProcedureType.GET_DEPO;

    @Override
    public byte[] serialize(final GetDepo.Request request) {

        return RPC.Request.newBuilder()
                .setTypeValue( PROCEDURE_TYPE.getNumber() )
                .setArgs( convertToPb(request).toByteString() )
                .build()
                .toByteArray();
    }

    @NotNull
    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public GetDepo.Request deserialize(final byte[] data) {

        final RPC.Request request = RPC.Request.parseFrom(data);
        assertEquals(request.getType(), PROCEDURE_TYPE);

        return convertFromPb(
                qlua.rpc.GetDepo.Request.parseFrom( request.getArgs() )
        );
    }

    @Override
    public GetDepo.Request convertFromPb(@NotNull final qlua.rpc.GetDepo.Request request) {

        return GetDepo.Request.builder()
                .clientCode( request.getClientCode() )
                .firmId( request.getFirmid() )
                .secCode( request.getSecCode() )
                .trdAccId( request.getTrdaccid() )
                .build();
    }

    @Override
    public qlua.rpc.GetDepo.Request convertToPb(@NotNull final GetDepo.Request request) {

        return qlua.rpc.GetDepo.Request.newBuilder()
                .setClientCode( request.getClientCode() )
                .setFirmid( request.getFirmId() )
                .setSecCode( request.getSecCode() )
                .setTrdaccid( request.getTrdAccId() )
                .build();
    }
}
