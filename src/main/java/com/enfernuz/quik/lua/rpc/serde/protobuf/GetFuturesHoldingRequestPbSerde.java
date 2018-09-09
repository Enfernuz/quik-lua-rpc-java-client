package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetFuturesHolding;
import com.enfernuz.quik.lua.rpc.serde.PbConverter;
import com.enfernuz.quik.lua.rpc.serde.Serde;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import qlua.rpc.RPC;

import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.assertEquals;

enum GetFuturesHoldingRequestPbSerde implements Serde<GetFuturesHolding.Request>, PbConverter<qlua.rpc.GetFuturesHolding.Request, GetFuturesHolding.Request> {

    INSTANCE;

    private static final RPC.ProcedureType PROCEDURE_TYPE = RPC.ProcedureType.GET_FUTURES_HOLDING;

    @Override
    public byte[] serialize(final GetFuturesHolding.Request request) {

        return RPC.Request.newBuilder()
                .setTypeValue( PROCEDURE_TYPE.getNumber() )
                .setArgs( convertToPb(request).toByteString() )
                .build()
                .toByteArray();
    }

    @NotNull
    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public GetFuturesHolding.Request deserialize(final byte[] data) {

        final RPC.Request request = RPC.Request.parseFrom(data);
        assertEquals(request.getType(), PROCEDURE_TYPE);

        return convertFromPb(
                qlua.rpc.GetFuturesHolding.Request.parseFrom( request.getArgs() )
        );
    }

    @Override
    public GetFuturesHolding.Request convertFromPb(@NotNull final qlua.rpc.GetFuturesHolding.Request request) {
        return GetFuturesHolding.Request.builder()
                .firmId( request.getFirmid() )
                .trdAccId( request.getTrdaccid() )
                .secCode( request.getSecCode() )
                .type( request.getType() )
                .build();
    }

    @Override
    public qlua.rpc.GetFuturesHolding.Request convertToPb(@NotNull final GetFuturesHolding.Request request) {

        return qlua.rpc.GetFuturesHolding.Request.newBuilder()
                .setFirmid( request.getFirmId() )
                .setTrdaccid( request.getTrdAccId() )
                .setSecCode( request.getSecCode() )
                .setType( request.getType() )
                .build();
    }
}
