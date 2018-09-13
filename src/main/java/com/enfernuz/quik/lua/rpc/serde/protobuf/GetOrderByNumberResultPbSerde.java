package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetOrderByNumber;
import com.enfernuz.quik.lua.rpc.api.structures.Order;
import com.enfernuz.quik.lua.rpc.serde.PbConverter;
import com.enfernuz.quik.lua.rpc.serde.Serde;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;

import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.*;

enum GetOrderByNumberResultPbSerde implements Serde<GetOrderByNumber.Result>, PbConverter<qlua.rpc.GetOrderByNumber.Result, GetOrderByNumber.Result> {

    INSTANCE;

    @Override
    public byte[] serialize(final GetOrderByNumber.Result result) {
        return convertToPb(result).toByteArray();
    }

    @NotNull
    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public GetOrderByNumber.Result deserialize(final byte[] data) {
        return convertFromPb( qlua.rpc.GetOrderByNumber.Result.parseFrom(data) );
    }

    @NotNull
    @Override
    public GetOrderByNumber.Result convertFromPb(@NotNull final qlua.rpc.GetOrderByNumber.Result result) {

        final Order order = result.hasOrder() ? convertFromPbOrder(result.getOrder()) : null;
        return GetOrderByNumber.Result.getInstance(order, result.getIndx());
    }

    @NotNull
    @Override
    public qlua.rpc.GetOrderByNumber.Result convertToPb(@NotNull final GetOrderByNumber.Result result) {

        final qlua.rpc.GetOrderByNumber.Result.Builder pbResult = qlua.rpc.GetOrderByNumber.Result.newBuilder();
        final Order order = result.getOrder();
        if (order != null) {
            pbResult.setOrder( convertToPbOrder(order) );
            pbResult.setIndx( result.getIndx() );
        }

        return pbResult.build();
    }
}
