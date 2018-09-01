package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.structures.FuturesLimit;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import com.enfernuz.quik.lua.rpc.serde.PbConverter;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import qlua.structs.QluaStructures;

import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.convertFromPbString;
import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.convertToPbString;

enum FuturesLimitPbSerde implements Deserializer<FuturesLimit>, PbConverter<QluaStructures.FuturesLimit, FuturesLimit> {

    INSTANCE;

    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public FuturesLimit deserialize(final byte[] data) {
        return convertFromPb(QluaStructures.FuturesLimit.parseFrom(data));
    }

    @Override
    public FuturesLimit convertFromPb(@NotNull QluaStructures.FuturesLimit futuresLimit) {

        return FuturesLimit.builder()
                .firmId( convertFromPbString(futuresLimit.getFirmid()) )
                .trdAccId( convertFromPbString(futuresLimit.getTrdaccid()) )
                .limitType( futuresLimit.getLimitType() )
                .liquidityCoef( convertFromPbString(futuresLimit.getLiquidityCoef()) )
                .cbpPrevLimit( convertFromPbString(futuresLimit.getCbpPrevLimit()) )
                .cbpLimit( convertFromPbString(futuresLimit.getCbplimit()) )
                .cbplUsed( convertFromPbString(futuresLimit.getCbplused()) )
                .cbplPlanned( convertFromPbString(futuresLimit.getCbplplanned()) )
                .varMargin( convertFromPbString(futuresLimit.getVarmargin()) )
                .accruedInt( convertFromPbString(futuresLimit.getAccruedint()) )
                .cbplUsedForOrders( convertFromPbString(futuresLimit.getCbplusedForOrders()) )
                .cbplUsedForPositions( convertFromPbString(futuresLimit.getCbplusedForPositions()) )
                .optionsPremium( convertFromPbString(futuresLimit.getOptionsPremium()) )
                .tsComission( convertFromPbString(futuresLimit.getTsComission()) )
                .kgo( convertFromPbString(futuresLimit.getKgo()) )
                .currCode( convertFromPbString(futuresLimit.getCurrcode()) )
                .realVarMargin( convertFromPbString(futuresLimit.getRealVarmargin()) )
                .build();
    }

    @Override
    public QluaStructures.FuturesLimit convertToPb(@NotNull final FuturesLimit futuresLimit) {

        return QluaStructures.FuturesLimit.newBuilder()
                .setFirmid( convertToPbString(futuresLimit.getFirmId()) )
                .setTrdaccid( convertToPbString(futuresLimit.getTrdAccId()) )
                .setLimitType( futuresLimit.getLimitType() )
                .setLiquidityCoef( convertToPbString(futuresLimit.getLiquidityCoef()) )
                .setCbpPrevLimit( convertToPbString(futuresLimit.getCbpPrevLimit()) )
                .setCbplimit( convertToPbString(futuresLimit.getCbpLimit()) )
                .setCbplused( convertToPbString(futuresLimit.getCbplUsed()) )
                .setCbplplanned( convertToPbString(futuresLimit.getCbplPlanned()) )
                .setVarmargin( convertToPbString(futuresLimit.getVarMargin()) )
                .setAccruedint( convertToPbString(futuresLimit.getAccruedInt()) )
                .setCbplusedForOrders( convertToPbString(futuresLimit.getCbplUsedForOrders()) )
                .setCbplusedForPositions( convertToPbString(futuresLimit.getCbplUsedForPositions()) )
                .setOptionsPremium( convertToPbString(futuresLimit.getOptionsPremium()) )
                .setTsComission( convertToPbString(futuresLimit.getTsComission()) )
                .setKgo( convertToPbString(futuresLimit.getKgo()) )
                .setCurrcode( convertToPbString(futuresLimit.getCurrCode()) )
                .setRealVarmargin( convertToPbString(futuresLimit.getRealVarMargin()) )
                .build();
    }


}
