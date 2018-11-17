package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.structures.DepoLimit;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import qlua.structs.QluaStructures;

enum DepoLimitPbDeserializer implements Deserializer<DepoLimit>, FromPbConverter<QluaStructures.DepoLimit, DepoLimit> {

    INSTANCE;

    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public DepoLimit deserialize(final byte[] data) {
        return convert(QluaStructures.DepoLimit.parseFrom(data));
    }

    @Override
    public DepoLimit convert(@NotNull QluaStructures.DepoLimit depoLimit) {

        return DepoLimit.builder()
                .secCode( depoLimit.getSecCode() )
                .trdAccId( depoLimit.getTrdaccid() )
                .firmId( depoLimit.getFirmid() )
                .clientCode( depoLimit.getClientCode() )
                .openBal( depoLimit.getOpenbal() )
                .openLimit( depoLimit.getOpenlimit() )
                .currentBal( depoLimit.getCurrentbal() )
                .currentLimit( depoLimit.getCurrentlimit() )
                .lockedSell( depoLimit.getLockedSell() )
                .lockedBuy( depoLimit.getLockedBuy() )
                .lockedBuyValue( depoLimit.getLockedBuyValue() )
                .lockedSellValue( depoLimit.getLockedSellValue() )
                .waPositionPrice( depoLimit.getWaPositionPrice() )
                .limitKind( depoLimit.getLimitKind() )
                .build();
    }
}
