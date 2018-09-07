package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.CalcBuySell;
import com.enfernuz.quik.lua.rpc.serde.PbConverter;
import com.enfernuz.quik.lua.rpc.serde.Serde;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import qlua.rpc.RPC;

import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.assertEquals;

enum CalcBuySellRequestPbSerde implements Serde<CalcBuySell.Request>, PbConverter<qlua.rpc.CalcBuySell.Request, CalcBuySell.Request> {

    INSTANCE;

    private static final RPC.ProcedureType PROCEDURE_TYPE = RPC.ProcedureType.CALC_BUY_SELL;

    @Override
    public byte[] serialize(final CalcBuySell.Request request) {

        return RPC.Request.newBuilder()
                .setTypeValue( PROCEDURE_TYPE.getNumber() )
                .setArgs( convertToPb(request).toByteString() )
                .build()
                .toByteArray();
    }

    @NotNull
    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public CalcBuySell.Request deserialize(final byte[] data) {

        final RPC.Request request = RPC.Request.parseFrom(data);
        assertEquals(request.getType(), PROCEDURE_TYPE);

        return convertFromPb(
                qlua.rpc.CalcBuySell.Request.parseFrom( request.getArgs() )
        );
    }

    @Override
    public CalcBuySell.Request convertFromPb(@NotNull final qlua.rpc.CalcBuySell.Request request) {

        return CalcBuySell.Request.builder()
                .classCode( request.getClassCode() )
                .secCode( request.getSecCode() )
                .clientCode( request.getClientCode() )
                .account( request.getAccount() )
                .price( request.getPrice() )
                .isBuy( request.getIsBuy() )
                .isMarket( request.getIsMarket() )
                .build();
    }

    @Override
    public qlua.rpc.CalcBuySell.Request convertToPb(@NotNull final CalcBuySell.Request request) {

        return qlua.rpc.CalcBuySell.Request.newBuilder()
                .setClassCode( request.getClassCode() )
                .setSecCode( request.getSecCode() )
                .setClientCode( request.getClientCode() )
                .setAccount( request.getAccount() )
                .setPrice( request.getPrice() )
                .setIsBuy( request.isBuy() )
                .setIsMarket( request.isMarket() )
                .build();
    }
}
