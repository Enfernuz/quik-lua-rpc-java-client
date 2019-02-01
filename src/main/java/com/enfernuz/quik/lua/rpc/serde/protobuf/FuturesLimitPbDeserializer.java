package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.structures.FuturesLimit;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import qlua.structs.QluaStructures;

import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.convertFromPbString;

enum FuturesLimitPbDeserializer implements Deserializer<FuturesLimit>, FromPbConverter<QluaStructures.FuturesLimit, FuturesLimit> {

    INSTANCE;

    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public FuturesLimit deserialize(final byte[] data) {
        return convert(QluaStructures.FuturesLimit.parseFrom(data));
    }

    @Override
    public FuturesLimit convert(@NotNull QluaStructures.FuturesLimit futuresLimit) {

        return FuturesLimit.builder()
                .firmId( futuresLimit.getFirmid() )
                .trdAccId( futuresLimit.getTrdaccid() )
                .limitType( futuresLimit.getLimitType() )
                .liquidityCoef( convertFromPbString(futuresLimit.getLiquidityCoef()) )
                .cbpPrevLimit( convertFromPbString(futuresLimit.getCbpPrevLimit()) )
                .cbpLimit( convertFromPbString(futuresLimit.getCbplimit()) )
                .cbplUsed( convertFromPbString(futuresLimit.getCbplused()) )
                .cbplPlanned( convertFromPbString(futuresLimit.getCbplplanned()) )
                .varMargin( convertFromPbString(futuresLimit.getVarmargin()) )
                .accruedInt( convertFromPbString(futuresLimit.getAccruedint()) )
                .cbplUsedForOrders( convertFromPbString(futuresLimit.getCbplusedForOrders()) )
                .cbplUsedForPositions( convertFromPbString(futuresLimit.getCbplusedForPositions()) )
                .optionsPremium( convertFromPbString(futuresLimit.getOptionsPremium()) )
                .tsComission( convertFromPbString(futuresLimit.getTsComission()) )
                .kgo( convertFromPbString(futuresLimit.getKgo()) )
                .currCode( futuresLimit.getCurrcode() )
                .realVarMargin( convertFromPbString(futuresLimit.getRealVarmargin()) )
                .build();
    }
}
