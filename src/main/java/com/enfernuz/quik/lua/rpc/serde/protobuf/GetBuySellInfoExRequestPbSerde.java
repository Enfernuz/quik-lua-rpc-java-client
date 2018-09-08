package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetBuySellInfoEx;
import com.enfernuz.quik.lua.rpc.serde.PbConverter;
import com.enfernuz.quik.lua.rpc.serde.Serde;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import qlua.rpc.RPC;

import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.assertEquals;

enum GetBuySellInfoExRequestPbSerde implements Serde<GetBuySellInfoEx.Request>, PbConverter<qlua.rpc.GetBuySellInfoEx.Request, GetBuySellInfoEx.Request> {

    INSTANCE;

    private static final RPC.ProcedureType PROCEDURE_TYPE = RPC.ProcedureType.GET_BUY_SELL_INFO_EX;

    @Override
    public byte[] serialize(final GetBuySellInfoEx.Request request) {

        return RPC.Request.newBuilder()
                .setTypeValue( PROCEDURE_TYPE.getNumber() )
                .setArgs( convertToPb(request).toByteString() )
                .build()
                .toByteArray();
    }

    @NotNull
    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public GetBuySellInfoEx.Request deserialize(final byte[] data) {

        final RPC.Request request = RPC.Request.parseFrom(data);
        assertEquals(request.getType(), PROCEDURE_TYPE);

        return convertFromPb(
                qlua.rpc.GetBuySellInfoEx.Request.parseFrom( request.getArgs() )
        );
    }

    @Override
    public GetBuySellInfoEx.Request convertFromPb(@NotNull final qlua.rpc.GetBuySellInfoEx.Request request) {

        return GetBuySellInfoEx.Request.builder()
                .firmId( request.getFirmId() )
                .clientCode( request.getClientCode() )
                .classCode( request.getClassCode() )
                .secCode( request.getSecCode() )
                .price( request.getPrice() )
                .build();

    }

    @Override
    public qlua.rpc.GetBuySellInfoEx.Request convertToPb(@NotNull final GetBuySellInfoEx.Request request) {

        return qlua.rpc.GetBuySellInfoEx.Request.newBuilder()
                .setFirmId( request.getFirmId() )
                .setClientCode( request.getClientCode() )
                .setClassCode( request.getClassCode() )
                .setSecCode( request.getSecCode() )
                .setPrice( request.getPrice() )
                .build();
    }
}
