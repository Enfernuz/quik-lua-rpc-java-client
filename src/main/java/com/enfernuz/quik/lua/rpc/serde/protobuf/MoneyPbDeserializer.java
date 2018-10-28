package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.structures.Money;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import qlua.rpc.GetMoney;

import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.convertFromPbString;

enum MoneyPbDeserializer implements Deserializer<Money>, FromPbConverter<GetMoney.Money, Money> {

    INSTANCE;

    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public Money deserialize(final byte[] data) {
        return convert(qlua.rpc.GetMoney.Money.parseFrom(data));
    }

    @Override
    public Money convert(@NotNull qlua.rpc.GetMoney.Money money) {

        return Money.builder()
                .moneyOpenLimit( convertFromPbString(money.getMoneyOpenLimit()) )
                .moneyLimitLockedNonMarginalValue( convertFromPbString(money.getMoneyLimitLockedNonmarginalValue()) )
                .moneyLimitLocked( convertFromPbString(money.getMoneyLimitLocked()) )
                .moneyOpenBalance( convertFromPbString(money.getMoneyOpenBalance()) )
                .moneyCurrentLimit( convertFromPbString(money.getMoneyCurrentLimit()) )
                .moneyCurrentBalance( convertFromPbString(money.getMoneyCurrentBalance()) )
                .moneyLimitAvailable( convertFromPbString(money.getMoneyLimitAvailable()) )
                .build();
    }
}
