package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.structures.MoneyLimit;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import qlua.structs.QluaStructures;

import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.convertFromPbString;

enum MoneyLimitPbDeserializer implements Deserializer<MoneyLimit>, FromPbConverter<QluaStructures.MoneyLimit, MoneyLimit> {

    INSTANCE;

    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public MoneyLimit deserialize(final byte[] data) {
        return convert( QluaStructures.MoneyLimit.parseFrom(data) );
    }

    @Override
    public MoneyLimit convert(@NotNull QluaStructures.MoneyLimit moneyLimit) {

        return MoneyLimit
                .builder()
                .currCode( convertFromPbString(moneyLimit.getCurrcode()) )
                .tag( convertFromPbString(moneyLimit.getTag()) )
                .firmId( convertFromPbString(moneyLimit.getFirmid()) )
                .clientCode( convertFromPbString(moneyLimit.getClientCode()) )
                .openBal( convertFromPbString(moneyLimit.getOpenbal()) )
                .openLimit( convertFromPbString(moneyLimit.getOpenlimit()) )
                .currentBal( convertFromPbString(moneyLimit.getCurrentbal()) )
                .currentLimit( convertFromPbString(moneyLimit.getCurrentlimit()) )
                .locked( convertFromPbString(moneyLimit.getLocked()) )
                .lockedValueCoef( convertFromPbString(moneyLimit.getLockedValueCoef()) )
                .lockedMarginValue( convertFromPbString(moneyLimit.getLockedMarginValue()) )
                .leverage( convertFromPbString(moneyLimit.getLeverage()) )
                .limitKind( moneyLimit.getLimitKind() )
                .waPositionPrice( convertFromPbString(moneyLimit.getWaPositionPrice()) )
                .ordersCollateral( convertFromPbString(moneyLimit.getOrdersCollateral()) )
                .positionsCollateral( convertFromPbString(moneyLimit.getPositionsCollateral()) )
                .build();
    }
}
