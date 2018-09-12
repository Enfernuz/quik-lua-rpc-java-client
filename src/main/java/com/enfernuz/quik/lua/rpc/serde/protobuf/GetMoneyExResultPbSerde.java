package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetMoneyEx;
import com.enfernuz.quik.lua.rpc.api.structures.MoneyLimit;
import com.enfernuz.quik.lua.rpc.serde.PbConverter;
import com.enfernuz.quik.lua.rpc.serde.Serde;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;

import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.convertFromPbMoneyLimit;
import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.convertToPbMoneyLimit;

enum GetMoneyExResultPbSerde implements Serde<GetMoneyEx.Result>, PbConverter<qlua.rpc.GetMoneyEx.Result, GetMoneyEx.Result> {

    INSTANCE;

    @Override
    public byte[] serialize(final GetMoneyEx.Result result) {
        return convertToPb(result).toByteArray();
    }

    @NotNull
    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public GetMoneyEx.Result deserialize(final byte[] data) {
        return convertFromPb( qlua.rpc.GetMoneyEx.Result.parseFrom(data) );
    }

    @NotNull
    @Override
    public GetMoneyEx.Result convertFromPb(@NotNull final qlua.rpc.GetMoneyEx.Result result) {

        final MoneyLimit moneyLimit = result.hasMoneyEx() ? convertFromPbMoneyLimit(result.getMoneyEx()) : null;
        return GetMoneyEx.Result.getInstance(moneyLimit);
    }

    @NotNull
    @Override
    public qlua.rpc.GetMoneyEx.Result convertToPb(@NotNull final GetMoneyEx.Result result) {

        final qlua.rpc.GetMoneyEx.Result.Builder pbResult = qlua.rpc.GetMoneyEx.Result.newBuilder();
        final MoneyLimit moneyLimit = result.getMoneyEx();
        if (moneyLimit != null) {
            pbResult.setMoneyEx( convertToPbMoneyLimit(moneyLimit) );
        }

        return pbResult.build();
    }
}
