package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetMoneyEx;
import com.enfernuz.quik.lua.rpc.api.structures.MoneyLimit;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;

import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.convertFromPbMoneyLimit;

enum GetMoneyExResultPbDeserializer implements Deserializer<GetMoneyEx.Result>, FromPbConverter<qlua.rpc.GetMoneyEx.Result, GetMoneyEx.Result> {

    INSTANCE;

    @NotNull
    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public GetMoneyEx.Result deserialize(final byte[] data) {
        return convert( qlua.rpc.GetMoneyEx.Result.parseFrom(data) );
    }

    @NotNull
    @Override
    public GetMoneyEx.Result convert(@NotNull final qlua.rpc.GetMoneyEx.Result result) {

        final MoneyLimit moneyLimit = result.hasMoneyEx() ? convertFromPbMoneyLimit(result.getMoneyEx()) : null;
        return GetMoneyEx.Result.getInstance(moneyLimit);
    }
}
