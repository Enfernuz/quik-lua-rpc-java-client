package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetPortfolioInfo;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;

import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.convertFromPbPortfolioInfo;

enum GetPortfolioInfoResultPbDeserializer implements Deserializer<GetPortfolioInfo.Result>, FromPbConverter<qlua.rpc.GetPortfolioInfo.Result, GetPortfolioInfo.Result> {

    INSTANCE;

    @NotNull
    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public GetPortfolioInfo.Result deserialize(final byte[] data) {
        return convert( qlua.rpc.GetPortfolioInfo.Result.parseFrom(data) );
    }

    @NotNull
    @Override
    public GetPortfolioInfo.Result convert(@NotNull final qlua.rpc.GetPortfolioInfo.Result result) {

        if (!result.hasPortfolioInfo()) {
            throw new IllegalArgumentException("Экземпляр protobuf-представления qlua.rpc.GetPortfolioInfo.Result не содержит поля 'portfolioInfo'.");
        }

        return new GetPortfolioInfo.Result( convertFromPbPortfolioInfo(result.getPortfolioInfo()) );
    }
}
