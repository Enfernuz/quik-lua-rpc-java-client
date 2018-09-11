package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.structures.Money;
import com.enfernuz.quik.lua.rpc.serde.PbConverter;
import com.enfernuz.quik.lua.rpc.serde.Serde;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;

import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.convertFromPbString;
import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.convertToPbString;

enum MoneyPbSerde implements Serde<Money>, PbConverter<qlua.rpc.GetMoney.Money, Money> {

    INSTANCE;

    @Override
    public byte[] serialize(final Money money) {
        return convertToPb(money).toByteArray();
    }

    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public Money deserialize(final byte[] data) {
        return convertFromPb(qlua.rpc.GetMoney.Money.parseFrom(data));
    }

    @Override
    public Money convertFromPb(@NotNull qlua.rpc.GetMoney.Money money) {

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

    @Override
    public qlua.rpc.GetMoney.Money convertToPb(@NotNull final Money money) {

        return qlua.rpc.GetMoney.Money.newBuilder()
                .setMoneyOpenLimit( convertToPbString(money.getMoneyOpenLimit()) )
                .setMoneyLimitLockedNonmarginalValue( convertToPbString(money.getMoneyLimitLockedNonMarginalValue()) )
                .setMoneyLimitLocked( convertToPbString(money.getMoneyLimitLocked()) )
                .setMoneyOpenBalance( convertToPbString(money.getMoneyOpenBalance()) )
                .setMoneyCurrentLimit( convertToPbString(money.getMoneyCurrentLimit()) )
                .setMoneyCurrentBalance( convertToPbString(money.getMoneyCurrentBalance()) )
                .setMoneyLimitAvailable( convertToPbString(money.getMoneyLimitAvailable()) )
                .build();
    }
}
