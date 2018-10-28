package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetOrderByNumber;
import com.enfernuz.quik.lua.rpc.api.structures.Order;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;

import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.convertFromPbOrder;

enum GetOrderByNumberResultPbDeserializer implements Deserializer<GetOrderByNumber.Result>, FromPbConverter<qlua.rpc.GetOrderByNumber.Result, GetOrderByNumber.Result> {

    INSTANCE;

    @NotNull
    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public GetOrderByNumber.Result deserialize(final byte[] data) {
        return convert( qlua.rpc.GetOrderByNumber.Result.parseFrom(data) );
    }

    @NotNull
    @Override
    public GetOrderByNumber.Result convert(@NotNull final qlua.rpc.GetOrderByNumber.Result result) {

        final Order order = result.hasOrder() ? convertFromPbOrder(result.getOrder()) : null;
        final Integer indx = result.getNullIndx() ? null : result.getValueIndx();
        return GetOrderByNumber.Result.getInstance(order, indx);
    }
}
