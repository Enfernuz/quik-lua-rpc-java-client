package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.structures.DepoLimitDelete;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import qlua.structs.QluaStructures;

import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.convertFromPbString;

enum DepoLimitDeletePbDeserializer implements Deserializer<DepoLimitDelete>, FromPbConverter<QluaStructures.DepoLimitDelete, DepoLimitDelete> {

    INSTANCE;

    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public DepoLimitDelete deserialize(final byte[] data) {
        return convert(QluaStructures.DepoLimitDelete.parseFrom(data));
    }

    @Override
    public DepoLimitDelete convert(@NotNull QluaStructures.DepoLimitDelete depoLimitDelete) {

        return DepoLimitDelete.builder()
                .secCode( convertFromPbString(depoLimitDelete.getSecCode()) )
                .trdAccId( convertFromPbString(depoLimitDelete.getTrdaccid()) )
                .firmId( convertFromPbString(depoLimitDelete.getFirmid()) )
                .clientCode( convertFromPbString(depoLimitDelete.getClientCode()) )
                .limitKind( depoLimitDelete.getLimitKind() )
                .build();
    }
}
