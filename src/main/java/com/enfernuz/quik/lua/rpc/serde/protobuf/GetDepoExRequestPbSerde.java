package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetDepoEx;
import com.enfernuz.quik.lua.rpc.serde.PbConverter;
import com.enfernuz.quik.lua.rpc.serde.Serde;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import qlua.rpc.RPC;

import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.assertEquals;

enum GetDepoExRequestPbSerde implements Serde<GetDepoEx.Request>, PbConverter<qlua.rpc.GetDepoEx.Request, GetDepoEx.Request> {

    INSTANCE;

    private static final RPC.ProcedureType PROCEDURE_TYPE = RPC.ProcedureType.GET_DEPO_EX;

    @Override
    public byte[] serialize(final GetDepoEx.Request request) {

        return RPC.Request.newBuilder()
                .setTypeValue( PROCEDURE_TYPE.getNumber() )
                .setArgs( convertToPb(request).toByteString() )
                .build()
                .toByteArray();
    }

    @NotNull
    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public GetDepoEx.Request deserialize(final byte[] data) {

        final RPC.Request request = RPC.Request.parseFrom(data);
        assertEquals(request.getType(), PROCEDURE_TYPE);

        return convertFromPb(
                qlua.rpc.GetDepoEx.Request.parseFrom( request.getArgs() )
        );
    }

    @Override
    public GetDepoEx.Request convertFromPb(@NotNull final qlua.rpc.GetDepoEx.Request request) {
        return GetDepoEx.Request.builder()
                .firmId( request.getFirmid() )
                .clientCode( request.getClientCode() )
                .secCode( request.getSecCode() )
                .trdAccId( request.getTrdaccid() )
                .limitKind( request.getLimitKind() )
                .build();
    }

    @Override
    public qlua.rpc.GetDepoEx.Request convertToPb(@NotNull final GetDepoEx.Request request) {

        return qlua.rpc.GetDepoEx.Request.newBuilder()
                .setFirmid( request.getFirmId() )
                .setClientCode( request.getClientCode() )
                .setSecCode( request.getSecCode() )
                .setTrdaccid( request.getTrdAccId() )
                .setLimitKind( request.getLimitKind() )
                .build();
    }
}
