package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.events.api.structures.MoneyLimit;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import com.enfernuz.quik.lua.rpc.serde.SerdeException;
import qlua.structs.QluaStructures;

public enum ProtobufMoneyLimitDeserializer implements Deserializer<MoneyLimit> {

    INSTANCE;

    @Override
    public MoneyLimit deserialize(final byte[] data) {
        try {
            final QluaStructures.MoneyLimit moneyLimit = QluaStructures.MoneyLimit.parseFrom(data);

            return MoneyLimit
                    .builder()
                    .currCode( moneyLimit.getCurrcode() )
                    .tag( moneyLimit.getTag() )
                    .firmId( moneyLimit.getFirmid() )
                    .clientCode( moneyLimit.getClientCode() )
                    .openBal( moneyLimit.getOpenbal() )
                    .openLimit( moneyLimit.getOpenlimit() )
                    .currentBal( moneyLimit.getCurrentbal() )
                    .currentLimit( moneyLimit.getCurrentlimit() )
                    .locked( moneyLimit.getLocked() )
                    .lockedValueCoef( moneyLimit.getLockedValueCoef() )
                    .lockedMarginValue( moneyLimit.getLockedMarginValue() )
                    .leverage( moneyLimit.getLeverage() )
                    .limitKind( moneyLimit.getLimitKind() )
                    .build();
        } catch (final Exception ex) {
            throw new SerdeException(); // TODO
        }
    }
}
