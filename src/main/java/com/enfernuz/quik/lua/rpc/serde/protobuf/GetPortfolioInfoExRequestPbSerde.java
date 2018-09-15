package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetPortfolioInfoEx;
import com.enfernuz.quik.lua.rpc.serde.PbConverter;
import com.enfernuz.quik.lua.rpc.serde.Serde;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import qlua.rpc.RPC;

import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.assertEquals;

enum GetPortfolioInfoExRequestPbSerde implements Serde<GetPortfolioInfoEx.Request>, PbConverter<qlua.rpc.GetPortfolioInfoEx.Request, GetPortfolioInfoEx.Request> {

    INSTANCE;

    private static final RPC.ProcedureType PROCEDURE_TYPE = RPC.ProcedureType.GET_PORTFOLIO_INFO_EX;

    @Override
    public byte[] serialize(final GetPortfolioInfoEx.Request request) {

        return RPC.Request.newBuilder()
                .setTypeValue( PROCEDURE_TYPE.getNumber() )
                .setArgs( convertToPb(request).toByteString() )
                .build()
                .toByteArray();
    }

    @NotNull
    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public GetPortfolioInfoEx.Request deserialize(final byte[] data) {

        final RPC.Request request = RPC.Request.parseFrom(data);
        assertEquals(request.getType(), PROCEDURE_TYPE);

        return convertFromPb(
                qlua.rpc.GetPortfolioInfoEx.Request.parseFrom( request.getArgs() )
        );
    }

    @Override
    public GetPortfolioInfoEx.Request convertFromPb(@NotNull final qlua.rpc.GetPortfolioInfoEx.Request request) {

        return GetPortfolioInfoEx.Request.builder()
                .firmId( request.getFirmId() )
                .clientCode( request.getClientCode() )
                .limitKind( request.getLimitKind() )
                .build();
    }

    @Override
    public qlua.rpc.GetPortfolioInfoEx.Request convertToPb(@NotNull final GetPortfolioInfoEx.Request request) {

        return qlua.rpc.GetPortfolioInfoEx.Request.newBuilder()
                .setFirmId( request.getFirmId() )
                .setClientCode( request.getClientCode() )
                .setLimitKind( request.getLimitKind() )
                .build();
    }
}
