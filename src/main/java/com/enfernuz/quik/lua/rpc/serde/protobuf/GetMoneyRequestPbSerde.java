package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetMoney;
import com.enfernuz.quik.lua.rpc.serde.PbConverter;
import com.enfernuz.quik.lua.rpc.serde.Serde;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import qlua.rpc.RPC;

import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.assertEquals;

enum GetMoneyRequestPbSerde implements Serde<GetMoney.Request>, PbConverter<qlua.rpc.GetMoney.Request, GetMoney.Request> {

    INSTANCE;

    private static final RPC.ProcedureType PROCEDURE_TYPE = RPC.ProcedureType.GET_MONEY;

    @Override
    public byte[] serialize(final GetMoney.Request request) {

        return RPC.Request.newBuilder()
                .setTypeValue( PROCEDURE_TYPE.getNumber() )
                .setArgs( convertToPb(request).toByteString() )
                .build()
                .toByteArray();
    }

    @NotNull
    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public GetMoney.Request deserialize(final byte[] data) {

        final RPC.Request request = RPC.Request.parseFrom(data);
        assertEquals(request.getType(), PROCEDURE_TYPE);

        return convertFromPb(
                qlua.rpc.GetMoney.Request.parseFrom( request.getArgs() )
        );
    }

    @Override
    public GetMoney.Request convertFromPb(@NotNull final qlua.rpc.GetMoney.Request request) {

        return GetMoney.Request.builder()
                .clientCode( request.getClientCode() )
                .firmId( request.getFirmid() )
                .tag( request.getTag() )
                .currCode( request.getCurrcode() )
                .build();
    }

    @Override
    public qlua.rpc.GetMoney.Request convertToPb(@NotNull final GetMoney.Request request) {

        return qlua.rpc.GetMoney.Request.newBuilder()
                .setClientCode( request.getClientCode() )
                .setFirmid( request.getFirmId() )
                .setTag( request.getTag() )
                .setCurrcode( request.getCurrCode() )
                .build();
    }
}
