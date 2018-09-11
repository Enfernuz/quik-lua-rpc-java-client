package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetMoney;
import com.enfernuz.quik.lua.rpc.serde.PbConverter;
import com.enfernuz.quik.lua.rpc.serde.Serde;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;

import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.convertFromPbMoney;
import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.convertToPbMoney;

enum GetMoneyResultPbSerde implements Serde<GetMoney.Result>, PbConverter<qlua.rpc.GetMoney.Result, GetMoney.Result> {

    INSTANCE;

    @Override
    public byte[] serialize(final GetMoney.Result result) {
        return convertToPb(result).toByteArray();
    }

    @NotNull
    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public GetMoney.Result deserialize(final byte[] data) {
        return convertFromPb( qlua.rpc.GetMoney.Result.parseFrom(data) );
    }

    @Override
    public GetMoney.Result convertFromPb(@NotNull final qlua.rpc.GetMoney.Result result) {
        return new GetMoney.Result( convertFromPbMoney(result.getMoney()) );
    }

    @Override
    public qlua.rpc.GetMoney.Result convertToPb(@NotNull final GetMoney.Result result) {

        return qlua.rpc.GetMoney.Result.newBuilder()
                .setMoney( convertToPbMoney(result.getMoney()) )
                .build();
    }
}
