package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetMoneyEx;
import com.enfernuz.quik.lua.rpc.serde.PbConverter;
import com.enfernuz.quik.lua.rpc.serde.Serde;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import qlua.rpc.RPC;

import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.assertEquals;

enum GetMoneyExRequestPbSerde implements Serde<GetMoneyEx.Request>, PbConverter<qlua.rpc.GetMoneyEx.Request, GetMoneyEx.Request> {

    INSTANCE;

    private static final RPC.ProcedureType PROCEDURE_TYPE = RPC.ProcedureType.GET_MONEY_EX;

    @Override
    public byte[] serialize(final GetMoneyEx.Request request) {

        return RPC.Request.newBuilder()
                .setTypeValue( PROCEDURE_TYPE.getNumber() )
                .setArgs( convertToPb(request).toByteString() )
                .build()
                .toByteArray();
    }

    @NotNull
    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public GetMoneyEx.Request deserialize(final byte[] data) {

        final RPC.Request request = RPC.Request.parseFrom(data);
        assertEquals(request.getType(), PROCEDURE_TYPE);

        return convertFromPb(
                qlua.rpc.GetMoneyEx.Request.parseFrom( request.getArgs() )
        );
    }

    @Override
    public GetMoneyEx.Request convertFromPb(@NotNull final qlua.rpc.GetMoneyEx.Request request) {

        return GetMoneyEx.Request.builder()
                .firmId( request.getFirmid() )
                .clientCode( request.getClientCode() )
                .tag( request.getTag() )
                .currCode( request.getCurrcode() )
                .limitKind( request.getLimitKind() )
                .build();
    }

    @Override
    public qlua.rpc.GetMoneyEx.Request convertToPb(@NotNull final GetMoneyEx.Request request) {

        return qlua.rpc.GetMoneyEx.Request.newBuilder()
                .setFirmid( request.getFirmId() )
                .setClientCode( request.getClientCode() )
                .setTag( request.getTag() )
                .setCurrcode( request.getCurrCode() )
                .setLimitKind( request.getLimitKind() )
                .build();
    }
}
