package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.structures.DepoLimit;
import com.enfernuz.quik.lua.rpc.serde.PbConverter;
import com.enfernuz.quik.lua.rpc.serde.Serde;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import qlua.structs.QluaStructures;

import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.convertFromPbString;
import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.convertToPbString;

enum DepoLimitPbSerde implements Serde<DepoLimit>, PbConverter<QluaStructures.DepoLimit, DepoLimit> {

    INSTANCE;

    @Override
    public byte[] serialize(final DepoLimit depoLimit) {
        return convertToPb(depoLimit).toByteArray();
    }

    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public DepoLimit deserialize(final byte[] data) {
        return convertFromPb(QluaStructures.DepoLimit.parseFrom(data));
    }

    @Override
    public DepoLimit convertFromPb(@NotNull QluaStructures.DepoLimit depoLimit) {

        return DepoLimit.builder()
                .secCode( convertFromPbString(depoLimit.getSecCode()) )
                .trdAccId( convertFromPbString(depoLimit.getTrdaccid()) )
                .firmId( convertFromPbString(depoLimit.getFirmid()) )
                .clientCode( convertFromPbString(depoLimit.getClientCode()) )
                .openBal( depoLimit.getOpenbal() )
                .openLimit( depoLimit.getOpenlimit() )
                .currentBal( depoLimit.getCurrentbal() )
                .currentLimit( depoLimit.getCurrentlimit() )
                .lockedSell( depoLimit.getLockedSell() )
                .lockedBuy( depoLimit.getLockedBuy() )
                .lockedBuyValue( convertFromPbString(depoLimit.getLockedBuyValue()) )
                .lockedSellValue( convertFromPbString(depoLimit.getLockedSellValue()) )
                .awgPositionPrice( convertFromPbString(depoLimit.getAwgPositionPrice()) )
                .limitKind( depoLimit.getLimitKind() )
                .build();
    }

    @Override
    public QluaStructures.DepoLimit convertToPb(@NotNull final DepoLimit depoLimit) {

        return QluaStructures.DepoLimit.newBuilder()
                .setSecCode( convertToPbString(depoLimit.getSecCode()) )
                .setTrdaccid( convertToPbString(depoLimit.getTrdAccId()) )
                .setFirmid( convertToPbString(depoLimit.getFirmId()) )
                .setClientCode( convertToPbString(depoLimit.getClientCode()) )
                .setOpenbal( depoLimit.getOpenBal() )
                .setOpenlimit( depoLimit.getOpenLimit() )
                .setCurrentbal( depoLimit.getCurrentBal() )
                .setCurrentlimit( depoLimit.getCurrentLimit() )
                .setLockedSell( depoLimit.getLockedSell() )
                .setLockedBuy( depoLimit.getLockedBuy() )
                .setLockedBuyValue( convertToPbString(depoLimit.getLockedBuyValue()) )
                .setLockedSellValue( convertToPbString(depoLimit.getLockedSellValue()) )
                .setAwgPositionPrice( convertToPbString(depoLimit.getAwgPositionPrice()) )
                .setLimitKind( depoLimit.getLimitKind() )
                .build();
    }
}
