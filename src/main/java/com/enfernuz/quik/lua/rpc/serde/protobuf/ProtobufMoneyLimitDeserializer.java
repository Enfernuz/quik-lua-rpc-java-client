package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.events.api.structures.MoneyLimit;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import com.enfernuz.quik.lua.rpc.serde.SerdeException;
import qlua.structs.QluaStructures;

import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.nullIfNullOrEmpty;

enum ProtobufMoneyLimitDeserializer implements Deserializer<MoneyLimit> {

    INSTANCE;

    @Override
    public MoneyLimit deserialize(final byte[] data) {

        try {
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
        } catch (final Exception ex) {
            throw new SerdeException(
                    String.format("Ошибка при десериализации экземпляра %s из protobuf-представления.", MoneyLimit.class.getName()),
                    ex
            );
        }
    }
}
