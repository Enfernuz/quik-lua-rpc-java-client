package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetPortfolioInfo;
import com.enfernuz.quik.lua.rpc.serde.PbConverter;
import com.enfernuz.quik.lua.rpc.serde.Serde;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;

import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.convertFromPbPortfolioInfo;
import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.convertToPbPortfolioInfo;

enum GetPortfolioInfoResultPbSerde implements Serde<GetPortfolioInfo.Result>, PbConverter<qlua.rpc.GetPortfolioInfo.Result, GetPortfolioInfo.Result> {

    INSTANCE;

    @Override
    public byte[] serialize(final GetPortfolioInfo.Result result) {
        return convertToPb(result).toByteArray();
    }

    @NotNull
    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public GetPortfolioInfo.Result deserialize(final byte[] data) {
        return convertFromPb( qlua.rpc.GetPortfolioInfo.Result.parseFrom(data) );
    }

    @NotNull
    @Override
    public GetPortfolioInfo.Result convertFromPb(@NotNull final qlua.rpc.GetPortfolioInfo.Result result) {

        if (!result.hasPortfolioInfo()) {
            throw new IllegalArgumentException("Экземпляр protobuf-представления qlua.rpc.GetPortfolioInfo.Result не содержит поля 'portfolioInfo'.");
        }

        return new GetPortfolioInfo.Result( convertFromPbPortfolioInfo(result.getPortfolioInfo()) );
    }

    @NotNull
    @Override
    public qlua.rpc.GetPortfolioInfo.Result convertToPb(@NotNull final GetPortfolioInfo.Result result) {
        return qlua.rpc.GetPortfolioInfo.Result.newBuilder()
                .setPortfolioInfo( convertToPbPortfolioInfo(result.getPortfolioInfo()) )
                .build();
    }
}
