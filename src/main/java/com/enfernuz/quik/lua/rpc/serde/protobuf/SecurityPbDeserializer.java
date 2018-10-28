package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.structures.Security;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import qlua.structs.QluaStructures;

import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.convertFromPbString;

enum SecurityPbDeserializer implements Deserializer<Security>, FromPbConverter<QluaStructures.Security, Security> {

    INSTANCE;

    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public Security deserialize(final byte[] data) {
        return convert(QluaStructures.Security.parseFrom(data));
    }

    @Override
    public Security convert(@NotNull QluaStructures.Security security) {

        return Security.builder()
                .code( convertFromPbString(security.getCode()) )
                .name( convertFromPbString(security.getName()) )
                .shortName( convertFromPbString(security.getShortName()) )
                .classCode( convertFromPbString(security.getClassCode()) )
                .className( convertFromPbString(security.getClassName()) )
                .faceValue( convertFromPbString(security.getFaceValue()) )
                .faceUnit( convertFromPbString(security.getFaceUnit()) )
                .scale( convertFromPbString(security.getScale()) )
                .matDate( convertFromPbString(security.getMatDate()) )
                .lotSize( convertFromPbString(security.getLotSize()) )
                .isinCode( convertFromPbString(security.getIsinCode()) )
                .minPriceStep( convertFromPbString(security.getMinPriceStep()) )
                .build();
    }
}
