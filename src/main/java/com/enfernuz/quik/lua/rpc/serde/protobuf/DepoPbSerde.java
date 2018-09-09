package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.structures.Depo;
import com.enfernuz.quik.lua.rpc.serde.PbConverter;
import com.enfernuz.quik.lua.rpc.serde.Serde;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;

import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.convertFromPbString;
import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.convertToPbString;

enum DepoPbSerde implements Serde<Depo>, PbConverter<qlua.rpc.GetDepo.Depo, Depo> {

    INSTANCE;

    @Override
    public byte[] serialize(final Depo depo) {
        return convertToPb(depo).toByteArray();
    }

    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public Depo deserialize(final byte[] data) {
        return convertFromPb(qlua.rpc.GetDepo.Depo.parseFrom(data));
    }

    @Override
    public Depo convertFromPb(@NotNull qlua.rpc.GetDepo.Depo depo) {

        return Depo
                .builder()
                .depoLimitLockedBuyValue( convertFromPbString(depo.getDepoLimitLockedBuyValue()) )
                .depoCurrentBalance( convertFromPbString(depo.getDepoCurrentBalance()) )
                .depoLimitLockedBuy( convertFromPbString(depo.getDepoLimitLockedBuy()) )
                .depoLimitLocked( convertFromPbString(depo.getDepoLimitLocked()) )
                .depoLimitAvailable( convertFromPbString(depo.getDepoLimitAvailable()) )
                .depoCurrentLimit( convertFromPbString(depo.getDepoCurrentLimit()) )
                .depoOpenBalance( convertFromPbString(depo.getDepoOpenBalance()) )
                .depoOpenLimit( convertFromPbString(depo.getDepoOpenLimit()) )
                .build();
    }

    @Override
    public qlua.rpc.GetDepo.Depo convertToPb(@NotNull final Depo depo) {

        return qlua.rpc.GetDepo.Depo.newBuilder()
                .setDepoLimitLockedBuyValue( convertToPbString(depo.getDepoLimitLockedBuyValue()) )
                .setDepoCurrentBalance( convertToPbString(depo.getDepoCurrentBalance()) )
                .setDepoLimitLockedBuy( convertToPbString(depo.getDepoLimitLockedBuy()) )
                .setDepoLimitLocked( convertToPbString(depo.getDepoLimitLocked()) )
                .setDepoLimitAvailable( convertToPbString(depo.getDepoLimitAvailable()) )
                .setDepoCurrentLimit( convertToPbString(depo.getDepoCurrentLimit()) )
                .setDepoOpenBalance( convertToPbString(depo.getDepoOpenBalance()) )
                .setDepoOpenLimit( convertToPbString(depo.getDepoOpenLimit()) )
                .build();
    }
}
