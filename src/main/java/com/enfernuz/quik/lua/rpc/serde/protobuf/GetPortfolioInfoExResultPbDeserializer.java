package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetPortfolioInfoEx;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;

import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.convertFromPbPortfolioInfo;
import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.convertFromPbString;

enum GetPortfolioInfoExResultPbDeserializer implements Deserializer<GetPortfolioInfoEx.Result>, FromPbConverter<qlua.rpc.GetPortfolioInfoEx.Result, GetPortfolioInfoEx.Result> {

    INSTANCE;

    @NotNull
    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public GetPortfolioInfoEx.Result deserialize(final byte[] data) {
        return convert( qlua.rpc.GetPortfolioInfoEx.Result.parseFrom(data) );
    }

    @NotNull
    @Override
    public GetPortfolioInfoEx.Result convert(@NotNull final qlua.rpc.GetPortfolioInfoEx.Result result) {

        if (!result.hasPortfolioInfoEx()) {
            throw new IllegalArgumentException("Экземпляр protobuf-представления qlua.rpc.GetPortfolioInfoEx.Result не содержит поля 'portfolioInfoEx'.");
        }

        final qlua.rpc.GetPortfolioInfoEx.PortfolioInfoEx portfolioInfoEx = result.getPortfolioInfoEx();
        if (!portfolioInfoEx.hasPortfolioInfo()) {
            throw new IllegalArgumentException("Экземпляр protobuf-представления qlua.rpc.GetPortfolioInfoEx.Result не содержит поля 'portfolioInfo' в поле 'portfolioInfoEx'.");
        }

        return GetPortfolioInfoEx.Result.builder()
                .portfolioInfo( convertFromPbPortfolioInfo(portfolioInfoEx.getPortfolioInfo()) )
                .initMargin( convertFromPbString(portfolioInfoEx.getInitMargin()) )
                .minMargin( convertFromPbString(portfolioInfoEx.getMinMargin()) )
                .correctedMargin( convertFromPbString(portfolioInfoEx.getCorrectedMargin()) )
                .clientType( convertFromPbString(portfolioInfoEx.getClientType()) )
                .portfolioValue( convertFromPbString(portfolioInfoEx.getPortfolioValue()) )
                .startLimitOpenPos( convertFromPbString(portfolioInfoEx.getStartLimitOpenPos()) )
                .totalLimitOpenPos( convertFromPbString(portfolioInfoEx.getTotalLimitOpenPos()) )
                .limitOpenPos( convertFromPbString(portfolioInfoEx.getLimitOpenPos()) )
                .usedLimOpenPos( convertFromPbString(portfolioInfoEx.getUsedLimOpenPos()) )
                .accVarMargin( convertFromPbString(portfolioInfoEx.getAccVarMargin()) )
                .clVarMargin( convertFromPbString(portfolioInfoEx.getClVarMargin()) )
                .optLiquidCost( convertFromPbString(portfolioInfoEx.getOptLiquidCost()) )
                .futAsset( convertFromPbString(portfolioInfoEx.getFutAsset()) )
                .futTotalAsset( convertFromPbString(portfolioInfoEx.getFutTotalAsset()) )
                .futDebt( convertFromPbString(portfolioInfoEx.getFutDebt()) )
                .futRateAsset( convertFromPbString(portfolioInfoEx.getFutRateAsset()) )
                .futRateAssetOpen( convertFromPbString(portfolioInfoEx.getFutRateAssetOpen()) )
                .futRateGo( convertFromPbString(portfolioInfoEx.getFutRateGo()) )
                .planedRateGo( convertFromPbString(portfolioInfoEx.getPlanedRateGo()) )
                .cashLeverage( convertFromPbString(portfolioInfoEx.getCashLeverage()) )
                .futPositionType( convertFromPbString(portfolioInfoEx.getFutPositionType()) )
                .futAccruedInt( convertFromPbString(portfolioInfoEx.getFutAccuredInt()) )
                .build();
    }
}
