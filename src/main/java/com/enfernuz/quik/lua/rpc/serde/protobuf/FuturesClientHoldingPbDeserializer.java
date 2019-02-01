package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.structures.FuturesClientHolding;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import qlua.structs.QluaStructures;

import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.convertFromPbString;

enum FuturesClientHoldingPbDeserializer implements Deserializer<FuturesClientHolding>, FromPbConverter<QluaStructures.FuturesClientHolding, FuturesClientHolding> {

    INSTANCE;

    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public FuturesClientHolding deserialize(final byte[] data) {
        return convert(QluaStructures.FuturesClientHolding.parseFrom(data));
    }

    @Override
    public FuturesClientHolding convert(@NotNull QluaStructures.FuturesClientHolding futuresClientHolding) {

        return FuturesClientHolding.builder()
                .firmId( futuresClientHolding.getFirmid() )
                .trdAccId( futuresClientHolding.getTrdaccid() )
                .secCode( futuresClientHolding.getSecCode() )
                .type( futuresClientHolding.getType() )
                .startBuy( convertFromPbString(futuresClientHolding.getStartbuy()) )
                .startSell( convertFromPbString(futuresClientHolding.getStartsell()) )
                .startNet( convertFromPbString(futuresClientHolding.getStartnet()) )
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
}
