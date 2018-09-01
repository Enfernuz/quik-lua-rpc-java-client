package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.structures.FuturesClientHolding;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import com.enfernuz.quik.lua.rpc.serde.PbConverter;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import qlua.structs.QluaStructures;

import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.convertFromPbString;
import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.convertToPbString;

enum FuturesClientHoldingPbSerde implements Deserializer<FuturesClientHolding>, PbConverter<QluaStructures.FuturesClientHolding, FuturesClientHolding> {

    INSTANCE;

    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public FuturesClientHolding deserialize(final byte[] data) {
        return convertFromPb(QluaStructures.FuturesClientHolding.parseFrom(data));
    }

    @Override
    public FuturesClientHolding convertFromPb(@NotNull QluaStructures.FuturesClientHolding futuresClientHolding) {

        return FuturesClientHolding.builder()
                .firmId( convertFromPbString(futuresClientHolding.getFirmid()) )
                .trdAccId( convertFromPbString(futuresClientHolding.getTrdaccid()) )
                .secCode( convertFromPbString(futuresClientHolding.getSecCode()) )
                .type( futuresClientHolding.getType() )
                .startBuy( convertFromPbString(futuresClientHolding.getStartbuy()) )
                .startSell( convertFromPbString(futuresClientHolding.getStartsell()) )
                .todayBuy( convertFromPbString(futuresClientHolding.getTodaybuy()) )
                .todaySell( convertFromPbString(futuresClientHolding.getTodaysell()) )
                .totalNet( convertFromPbString(futuresClientHolding.getTotalnet()) )
                .openBuys( futuresClientHolding.getOpenbuys() )
                .openSells( futuresClientHolding.getOpensells() )
                .cbplUsed( convertFromPbString(futuresClientHolding.getCbplused()) )
                .cbplPlanned( convertFromPbString(futuresClientHolding.getCbplplanned()) )
                .varMargin( convertFromPbString(futuresClientHolding.getVarmargin()) )
                .avrPosnPrice( convertFromPbString(futuresClientHolding.getAvrposnprice()) )
                .positionValue( convertFromPbString(futuresClientHolding.getPositionvalue()) )
                .realVarMargin( convertFromPbString(futuresClientHolding.getRealVarmargin()) )
                .totalVarMargin( convertFromPbString(futuresClientHolding.getTotalVarmargin()) )
                .sessionStatus( futuresClientHolding.getSessionStatus())
                .build();
    }

    @Override
    public QluaStructures.FuturesClientHolding convertToPb(@NotNull final FuturesClientHolding futuresClientHolding) {

        return QluaStructures.FuturesClientHolding.newBuilder()
                .setFirmid( convertToPbString(futuresClientHolding.getFirmId()) )
                .setTrdaccid( convertToPbString(futuresClientHolding.getTrdAccId()) )
                .setSecCode( convertToPbString(futuresClientHolding.getSecCode()) )
                .setType( futuresClientHolding.getType() )
                .setStartbuy( convertToPbString(futuresClientHolding.getStartBuy()) )
                .setStartsell( convertToPbString(futuresClientHolding.getStartSell()) )
                .setTodaybuy( convertToPbString(futuresClientHolding.getTodayBuy()) )
                .setTodaysell( convertToPbString(futuresClientHolding.getTodaySell()) )
                .setTotalnet( convertToPbString(futuresClientHolding.getTotalNet()) )
                .setOpenbuys( futuresClientHolding.getOpenBuys() )
                .setOpensells( futuresClientHolding.getOpenSells() )
                .setCbplused( convertToPbString(futuresClientHolding.getCbplUsed()) )
                .setCbplplanned( convertToPbString(futuresClientHolding.getCbplPlanned()) )
                .setVarmargin( convertToPbString(futuresClientHolding.getVarMargin()) )
                .setAvrposnprice( convertToPbString(futuresClientHolding.getAvrPosnPrice()) )
                .setPositionvalue( convertToPbString(futuresClientHolding.getPositionValue()) )
                .setRealVarmargin( convertToPbString(futuresClientHolding.getRealVarMargin()) )
                .setTotalVarmargin( convertToPbString(futuresClientHolding.getTotalVarMargin()) )
                .setSessionStatus( futuresClientHolding.getSessionStatus() )
                .build();
    }
}
