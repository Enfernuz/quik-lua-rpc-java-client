package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.structures.MoneyLimitDelete;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import qlua.structs.QluaStructures;

import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.convertFromPbString;

enum MoneyLimitDeletePbDeserializer implements Deserializer<MoneyLimitDelete>, FromPbConverter<QluaStructures.MoneyLimitDelete, MoneyLimitDelete> {

    INSTANCE;

    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public MoneyLimitDelete deserialize(final byte[] data) {
        return convert(QluaStructures.MoneyLimitDelete.parseFrom(data));
    }

    @Override
    public MoneyLimitDelete convert(@NotNull QluaStructures.MoneyLimitDelete moneyLimitDelete) {

        return MoneyLimitDelete.builder()
                .currCode( convertFromPbString(moneyLimitDelete.getCurrcode()) )
                .tag( convertFromPbString(moneyLimitDelete.getTag()) )
                .clientCode( convertFromPbString(moneyLimitDelete.getClientCode()) )
                .firmId( convertFromPbString(moneyLimitDelete.getFirmid()) )
                .limitKind( moneyLimitDelete.getLimitKind() )
                .build();
    }
}
