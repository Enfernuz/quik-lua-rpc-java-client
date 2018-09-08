package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetBuySellInfo;
import com.enfernuz.quik.lua.rpc.serde.PbConverter;
import com.enfernuz.quik.lua.rpc.serde.Serde;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import qlua.rpc.RPC;

import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.assertEquals;

enum GetBuySellInfoRequestPbSerde implements Serde<GetBuySellInfo.Request>, PbConverter<qlua.rpc.GetBuySellInfo.Request, GetBuySellInfo.Request> {

    INSTANCE;

    private static final RPC.ProcedureType PROCEDURE_TYPE = RPC.ProcedureType.GET_BUY_SELL_INFO;

    @Override
    public byte[] serialize(final GetBuySellInfo.Request request) {

        return RPC.Request.newBuilder()
                .setTypeValue( PROCEDURE_TYPE.getNumber() )
                .setArgs( convertToPb(request).toByteString() )
                .build()
                .toByteArray();
    }

    @NotNull
    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public GetBuySellInfo.Request deserialize(final byte[] data) {

        final RPC.Request request = RPC.Request.parseFrom(data);
        assertEquals(request.getType(), PROCEDURE_TYPE);

        return convertFromPb(
                qlua.rpc.GetBuySellInfo.Request.parseFrom( request.getArgs() )
        );
    }

    @Override
    public GetBuySellInfo.Request convertFromPb(@NotNull final qlua.rpc.GetBuySellInfo.Request request) {

        return GetBuySellInfo.Request.builder()
                .firmId( request.getFirmId() )
                .clientCode( request.getClientCode() )
                .classCode( request.getClassCode() )
                .secCode( request.getSecCode() )
                .price( request.getPrice() )
                .build();

    }

    @Override
    public qlua.rpc.GetBuySellInfo.Request convertToPb(@NotNull final GetBuySellInfo.Request request) {

        return qlua.rpc.GetBuySellInfo.Request.newBuilder()
                .setFirmId( request.getFirmId() )
                .setClientCode( request.getClientCode() )
                .setClassCode( request.getClassCode() )
                .setSecCode( request.getSecCode() )
                .setPrice( request.getPrice() )
                .build();
    }
}
