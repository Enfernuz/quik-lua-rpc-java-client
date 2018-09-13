package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetOrderByNumber;
import com.enfernuz.quik.lua.rpc.serde.PbConverter;
import com.enfernuz.quik.lua.rpc.serde.Serde;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import qlua.rpc.RPC;

import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.assertEquals;

enum GetOrderByNumberRequestPbSerde implements Serde<GetOrderByNumber.Request>, PbConverter<qlua.rpc.GetOrderByNumber.Request, GetOrderByNumber.Request> {

    INSTANCE;

    private static final RPC.ProcedureType PROCEDURE_TYPE = RPC.ProcedureType.GET_ORDER_BY_NUMBER;

    @Override
    public byte[] serialize(final GetOrderByNumber.Request request) {

        return RPC.Request.newBuilder()
                .setTypeValue( PROCEDURE_TYPE.getNumber() )
                .setArgs( convertToPb(request).toByteString() )
                .build()
                .toByteArray();
    }

    @NotNull
    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public GetOrderByNumber.Request deserialize(final byte[] data) {

        final RPC.Request request = RPC.Request.parseFrom(data);
        assertEquals(request.getType(), PROCEDURE_TYPE);

        return convertFromPb(
                qlua.rpc.GetOrderByNumber.Request.parseFrom( request.getArgs() )
        );
    }

    @Override
    public GetOrderByNumber.Request convertFromPb(@NotNull final qlua.rpc.GetOrderByNumber.Request request) {
        return new GetOrderByNumber.Request(request.getClassCode(), request.getOrderId());
    }

    @Override
    public qlua.rpc.GetOrderByNumber.Request convertToPb(@NotNull final GetOrderByNumber.Request request) {

        return qlua.rpc.GetOrderByNumber.Request.newBuilder()
                .setClassCode( request.getClassCode() )
                .setOrderId( request.getOrderId() )
                .build();
    }
}
