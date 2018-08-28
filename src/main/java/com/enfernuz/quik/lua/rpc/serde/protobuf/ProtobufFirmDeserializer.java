package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.structures.Firm;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import qlua.structs.QluaStructures;

import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.nullIfNullOrEmpty;

enum ProtobufFirmDeserializer implements Deserializer<Firm> {

    INSTANCE;

    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public Firm deserialize(final byte[] data) {

        final QluaStructures.Firm firm = QluaStructures.Firm.parseFrom(data);
        return Firm
                .builder()
                .firmId(firm.getFirmid())
                .firmName( nullIfNullOrEmpty(firm.getFirmName()) )
                .status(firm.getStatus())
                .exchange( nullIfNullOrEmpty(firm.getExchange()) )
                .build();
    }
}
