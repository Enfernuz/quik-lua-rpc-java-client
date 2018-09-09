package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetFuturesLimit;
import com.enfernuz.quik.lua.rpc.serde.PbConverter;
import com.enfernuz.quik.lua.rpc.serde.Serde;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import qlua.rpc.RPC;

import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.assertEquals;

enum GetFuturesLimitRequestPbSerde implements Serde<GetFuturesLimit.Request>, PbConverter<qlua.rpc.GetFuturesLimit.Request, GetFuturesLimit.Request> {

    INSTANCE;

    private static final RPC.ProcedureType PROCEDURE_TYPE = RPC.ProcedureType.GET_FUTURES_LIMIT;

    @Override
    public byte[] serialize(final GetFuturesLimit.Request request) {

        return RPC.Request.newBuilder()
                .setTypeValue( PROCEDURE_TYPE.getNumber() )
                .setArgs( convertToPb(request).toByteString() )
                .build()
                .toByteArray();
    }

    @NotNull
    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public GetFuturesLimit.Request deserialize(final byte[] data) {

        final RPC.Request request = RPC.Request.parseFrom(data);
        assertEquals(request.getType(), PROCEDURE_TYPE);

        return convertFromPb(
                qlua.rpc.GetFuturesLimit.Request.parseFrom( request.getArgs() )
        );
    }

    @Override
    public GetFuturesLimit.Request convertFromPb(@NotNull final qlua.rpc.GetFuturesLimit.Request request) {
        return GetFuturesLimit.Request.builder()
                .firmId( request.getFirmid() )
                .trdAccId( request.getTrdaccid() )
                .limitType( request.getLimitType() )
                .currCode( request.getCurrcode() )
                .build();
    }

    @Override
    public qlua.rpc.GetFuturesLimit.Request convertToPb(@NotNull final GetFuturesLimit.Request request) {

        return qlua.rpc.GetFuturesLimit.Request.newBuilder()
                .setFirmid( request.getFirmId() )
                .setTrdaccid( request.getTrdAccId() )
                .setLimitType( request.getLimitType() )
                .setCurrcode( request.getCurrCode() )
                .build();
    }
}
