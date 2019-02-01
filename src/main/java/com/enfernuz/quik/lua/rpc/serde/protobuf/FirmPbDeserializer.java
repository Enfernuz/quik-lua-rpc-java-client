package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.structures.Firm;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import qlua.structs.QluaStructures;

import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.convertFromPbString;

enum FirmPbDeserializer implements Deserializer<Firm>, FromPbConverter<QluaStructures.Firm, Firm> {

    INSTANCE;

    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public Firm deserialize(final byte[] data) {
        return convert(QluaStructures.Firm.parseFrom(data));
    }

    @Override
    public Firm convert(@NotNull QluaStructures.Firm firm) {

        return Firm
                .builder()
                .firmId(firm.getFirmid())
                .firmName( convertFromPbString(firm.getFirmName()) )
                .status(firm.getNullStatus() ? null : firm.getValueStatus())
                .exchange( convertFromPbString(firm.getExchange()) )
                .build();
    }
}
