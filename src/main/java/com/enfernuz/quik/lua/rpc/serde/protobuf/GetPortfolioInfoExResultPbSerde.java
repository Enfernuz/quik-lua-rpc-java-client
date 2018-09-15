package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetPortfolioInfoEx;
import com.enfernuz.quik.lua.rpc.serde.PbConverter;
import com.enfernuz.quik.lua.rpc.serde.Serde;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;

import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.*;

enum GetPortfolioInfoExResultPbSerde implements Serde<GetPortfolioInfoEx.Result>, PbConverter<qlua.rpc.GetPortfolioInfoEx.Result, GetPortfolioInfoEx.Result> {

    INSTANCE;

    @Override
    public byte[] serialize(final GetPortfolioInfoEx.Result result) {
        return convertToPb(result).toByteArray();
    }

    @NotNull
    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public GetPortfolioInfoEx.Result deserialize(final byte[] data) {
        return convertFromPb( qlua.rpc.GetPortfolioInfoEx.Result.parseFrom(data) );
    }

    @NotNull
    @Override
    public GetPortfolioInfoEx.Result convertFromPb(@NotNull final qlua.rpc.GetPortfolioInfoEx.Result result) {

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

    @NotNull
    @Override
    public qlua.rpc.GetPortfolioInfoEx.Result convertToPb(@NotNull final GetPortfolioInfoEx.Result result) {

        final qlua.rpc.GetPortfolioInfoEx.PortfolioInfoEx portfolioInfoEx = qlua.rpc.GetPortfolioInfoEx.PortfolioInfoEx.newBuilder()
                .setPortfolioInfo( convertToPbPortfolioInfo(result.getPortfolioInfo()) )
                .setInitMargin( convertToPbString(result.getInitMargin()) )
                .setMinMargin( convertToPbString(result.getMinMargin()) )
                .setCorrectedMargin( convertToPbString(result.getCorrectedMargin()) )
                .setClientType( convertToPbString(result.getClientType()) )
                .setPortfolioValue( convertToPbString(result.getPortfolioValue()) )
                .setStartLimitOpenPos( convertToPbString(result.getStartLimitOpenPos()) )
                .setTotalLimitOpenPos( convertToPbString(result.getTotalLimitOpenPos()) )
                .setLimitOpenPos( convertToPbString(result.getLimitOpenPos()) )
                .setUsedLimOpenPos( convertToPbString(result.getUsedLimOpenPos()) )
                .setAccVarMargin( convertToPbString(result.getAccVarMargin()) )
                .setClVarMargin( convertToPbString(result.getClVarMargin()) )
                .setOptLiquidCost( convertToPbString(result.getOptLiquidCost()) )
                .setFutAsset( convertToPbString(result.getFutAsset()) )
                .setFutTotalAsset( convertToPbString(result.getFutTotalAsset()) )
                .setFutDebt( convertToPbString(result.getFutDebt()) )
                .setFutRateAsset( convertToPbString(result.getFutRateAsset()) )
                .setFutRateAssetOpen( convertToPbString(result.getFutRateAssetOpen()) )
                .setFutRateGo( convertToPbString(result.getFutRateGo()) )
                .setPlanedRateGo( convertToPbString(result.getPlanedRateGo()) )
                .setCashLeverage( convertToPbString(result.getCashLeverage()) )
                .setFutPositionType( convertToPbString(result.getFutPositionType()) )
                .setFutAccuredInt( convertToPbString(result.getFutAccruedInt()) )
                .build();

        return qlua.rpc.GetPortfolioInfoEx.Result.newBuilder()
                .setPortfolioInfoEx(portfolioInfoEx)
                .build();
    }
}
