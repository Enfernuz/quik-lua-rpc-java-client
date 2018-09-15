package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetPortfolioInfo;
import com.enfernuz.quik.lua.rpc.serde.PbConverter;
import com.enfernuz.quik.lua.rpc.serde.Serde;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import qlua.rpc.RPC;

import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.assertEquals;

enum GetPortfolioInfoRequestPbSerde implements Serde<GetPortfolioInfo.Request>, PbConverter<qlua.rpc.GetPortfolioInfo.Request, GetPortfolioInfo.Request> {

    INSTANCE;

    private static final RPC.ProcedureType PROCEDURE_TYPE = RPC.ProcedureType.GET_PORTFOLIO_INFO;

    @Override
    public byte[] serialize(final GetPortfolioInfo.Request request) {

        return RPC.Request.newBuilder()
                .setTypeValue( PROCEDURE_TYPE.getNumber() )
                .setArgs( convertToPb(request).toByteString() )
                .build()
                .toByteArray();
    }

    @NotNull
    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public GetPortfolioInfo.Request deserialize(final byte[] data) {

        final RPC.Request request = RPC.Request.parseFrom(data);
        assertEquals(request.getType(), PROCEDURE_TYPE);

        return convertFromPb(
                qlua.rpc.GetPortfolioInfo.Request.parseFrom( request.getArgs() )
        );
    }

    @Override
    public GetPortfolioInfo.Request convertFromPb(@NotNull final qlua.rpc.GetPortfolioInfo.Request request) {

        return GetPortfolioInfo.Request.builder()
                .firmId( request.getFirmId() )
                .clientCode( request.getClientCode() )
                .build();
    }

    @Override
    public qlua.rpc.GetPortfolioInfo.Request convertToPb(@NotNull final GetPortfolioInfo.Request request) {

        return qlua.rpc.GetPortfolioInfo.Request.newBuilder()
                .setFirmId( request.getFirmId() )
                .setClientCode( request.getClientCode() )
                .build();
    }
}
