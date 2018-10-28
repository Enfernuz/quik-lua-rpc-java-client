package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetMoney;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;

import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.convertFromPbMoney;

enum GetMoneyResultPbDeserializer implements Deserializer<GetMoney.Result>, FromPbConverter<qlua.rpc.GetMoney.Result, GetMoney.Result> {

    INSTANCE;

    @NotNull
    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public GetMoney.Result deserialize(final byte[] data) {
        return convert( qlua.rpc.GetMoney.Result.parseFrom(data) );
    }

    @Override
    public GetMoney.Result convert(@NotNull final qlua.rpc.GetMoney.Result result) {
        return new GetMoney.Result( convertFromPbMoney(result.getMoney()) );
    }
}
