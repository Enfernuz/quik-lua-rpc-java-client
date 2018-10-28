package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetBuySellInfoEx.BuySellInfoEx;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import qlua.rpc.GetBuySellInfoEx;

import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.convertFromPbBuySellInfo;
import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.convertFromPbString;

enum BuySellInfoExPbDeserializer implements Deserializer<BuySellInfoEx>, FromPbConverter<GetBuySellInfoEx.BuySellInfoEx, BuySellInfoEx> {

    INSTANCE;

    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public BuySellInfoEx deserialize(final byte[] data) {
        return convert( qlua.rpc.GetBuySellInfoEx.BuySellInfoEx.parseFrom(data) );
    }

    @Override
    public BuySellInfoEx convert(@NotNull final qlua.rpc.GetBuySellInfoEx.BuySellInfoEx buySellInfoEx) {

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
}
