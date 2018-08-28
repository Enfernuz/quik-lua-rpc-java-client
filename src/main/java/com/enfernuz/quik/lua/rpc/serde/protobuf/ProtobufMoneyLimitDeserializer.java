package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.structures.MoneyLimit;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import qlua.structs.QluaStructures;

import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.nullIfNullOrEmpty;

enum ProtobufMoneyLimitDeserializer implements Deserializer<MoneyLimit> {

    INSTANCE;

    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public MoneyLimit deserialize(final byte[] data) {

        final QluaStructures.MoneyLimit moneyLimit = QluaStructures.MoneyLimit.parseFrom(data);
        return MoneyLimit
                .builder()
                .currCode( nullIfNullOrEmpty(moneyLimit.getCurrcode()) )
                .tag( nullIfNullOrEmpty(moneyLimit.getTag()) )
                .firmId( nullIfNullOrEmpty(moneyLimit.getFirmid()) )
                .clientCode( nullIfNullOrEmpty(moneyLimit.getClientCode()) )
                .openBal( nullIfNullOrEmpty(moneyLimit.getOpenbal()) )
                .openLimit( nullIfNullOrEmpty(moneyLimit.getOpenlimit()) )
                .currentBal( nullIfNullOrEmpty(moneyLimit.getCurrentbal()) )
                .currentLimit( nullIfNullOrEmpty(moneyLimit.getCurrentlimit()) )
                .locked( nullIfNullOrEmpty(moneyLimit.getLocked()) )
                .lockedValueCoef( nullIfNullOrEmpty(moneyLimit.getLockedValueCoef()) )
                .lockedMarginValue( nullIfNullOrEmpty(moneyLimit.getLockedMarginValue()) )
                .leverage( nullIfNullOrEmpty(moneyLimit.getLeverage()) )
                .limitKind( moneyLimit.getLimitKind() )
                .build();
    }
}
