package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetBuySellInfoEx.BuySellInfoEx;
import com.enfernuz.quik.lua.rpc.serde.PbConverter;
import com.enfernuz.quik.lua.rpc.serde.Serde;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;

import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.*;

enum BuySellInfoExPbSerde implements Serde<BuySellInfoEx>, PbConverter<qlua.rpc.GetBuySellInfoEx.BuySellInfoEx, BuySellInfoEx> {

    INSTANCE;

    @Override
    public byte[] serialize(final BuySellInfoEx dateTimeEntry) {
        return convertToPb(dateTimeEntry).toByteArray();
    }

    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public BuySellInfoEx deserialize(final byte[] data) {
        return convertFromPb( qlua.rpc.GetBuySellInfoEx.BuySellInfoEx.parseFrom(data) );
    }

    @Override
    public BuySellInfoEx convertFromPb(@NotNull final qlua.rpc.GetBuySellInfoEx.BuySellInfoEx buySellInfoEx) {

        return BuySellInfoEx.builder()
                .buySellInfo( convertFromPbBuySellInfo(buySellInfoEx.getBuySellInfo()) )
                .limitKind( convertFromPbString(buySellInfoEx.getLimitKind()) )
                .dLong( convertFromPbString(buySellInfoEx.getDLong()) )
                .dMinLong( convertFromPbString(buySellInfoEx.getDMinLong()) )
                .dShort( convertFromPbString(buySellInfoEx.getDShort()) )
                .dMinShort( convertFromPbString(buySellInfoEx.getDMinShort()) )
                .clientType( convertFromPbString(buySellInfoEx.getClientType()) )
                .isLongAllowed( convertFromPbString(buySellInfoEx.getIsLongAllowed()) )
                .isShortAllowed( convertFromPbString(buySellInfoEx.getIsShortAllowed()) )
                .build();
    }

    @Override
    public qlua.rpc.GetBuySellInfoEx.BuySellInfoEx convertToPb(@NotNull final BuySellInfoEx buySellInfoEx) {

        return qlua.rpc.GetBuySellInfoEx.BuySellInfoEx.newBuilder()
                .setBuySellInfo( convertToPbBuySellInfo(buySellInfoEx.getBuySellInfo()) )
                .setLimitKind( convertToPbString(buySellInfoEx.getLimitKind()) )
                .setDLong( convertToPbString(buySellInfoEx.getDLong()) )
                .setDMinLong( convertToPbString(buySellInfoEx.getDMinLong()) )
                .setDShort( convertToPbString(buySellInfoEx.getDShort()) )
                .setDMinShort( convertToPbString(buySellInfoEx.getDMinShort()) )
                .setClientType( convertToPbString(buySellInfoEx.getClientType()) )
                .setIsLongAllowed( convertToPbString(buySellInfoEx.getIsLongAllowed()) )
                .setIsShortAllowed( convertToPbString(buySellInfoEx.getIsShortAllowed()) )
                .build();
    }
}
