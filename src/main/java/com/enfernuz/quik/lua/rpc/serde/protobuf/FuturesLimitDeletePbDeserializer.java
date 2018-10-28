package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.structures.FuturesLimitDelete;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import qlua.structs.QluaStructures;

import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.convertFromPbString;

enum FuturesLimitDeletePbDeserializer implements Deserializer<FuturesLimitDelete>, FromPbConverter<QluaStructures.FuturesLimitDelete, FuturesLimitDelete> {

    INSTANCE;

    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public FuturesLimitDelete deserialize(final byte[] data) {
        return convert(QluaStructures.FuturesLimitDelete.parseFrom(data));
    }

    @Override
    public FuturesLimitDelete convert(@NotNull QluaStructures.FuturesLimitDelete futuresLimitDelete) {

        return FuturesLimitDelete.builder()
                .firmId( convertFromPbString(futuresLimitDelete.getFirmid()) )
                .limitType( futuresLimitDelete.getLimitType() )
                .build();
    }
}
