package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.structures.Depo;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import qlua.rpc.GetDepo;

import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.convertFromPbString;

enum DepoPbDeserializer implements Deserializer<Depo>, FromPbConverter<GetDepo.Depo, Depo> {

    INSTANCE;

    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public Depo deserialize(final byte[] data) {
        return convert(qlua.rpc.GetDepo.Depo.parseFrom(data));
    }

    @Override
    public Depo convert(@NotNull qlua.rpc.GetDepo.Depo depo) {

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
}
