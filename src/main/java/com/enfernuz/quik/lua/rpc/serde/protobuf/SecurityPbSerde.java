package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.structures.Security;
import com.enfernuz.quik.lua.rpc.serde.PbConverter;
import com.enfernuz.quik.lua.rpc.serde.Serde;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import qlua.structs.QluaStructures;

import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.convertFromPbString;
import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.convertToPbString;

enum SecurityPbSerde implements Serde<Security>, PbConverter<QluaStructures.Security, Security> {

    INSTANCE;

    @Override
    public byte[] serialize(final Security security) {
        return convertToPb(security).toByteArray();
    }

    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public Security deserialize(final byte[] data) {
        return convertFromPb(QluaStructures.Security.parseFrom(data));
    }

    @Override
    public Security convertFromPb(@NotNull QluaStructures.Security security) {

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

    @Override
    public QluaStructures.Security convertToPb(@NotNull final Security security) {

        return QluaStructures.Security.newBuilder()
                .setCode( convertToPbString(security.getCode()) )
                .setName( convertToPbString(security.getName()) )
                .setShortName( convertToPbString(security.getShortName()) )
                .setClassCode( convertToPbString(security.getClassCode()) )
                .setClassName( convertToPbString(security.getClassName()) )
                .setFaceValue( convertToPbString(security.getFaceValue()) )
                .setFaceUnit( convertToPbString(security.getFaceUnit()) )
                .setScale( convertToPbString(security.getScale()) )
                .setMatDate( convertToPbString(security.getMatDate()) )
                .setLotSize( convertToPbString(security.getLotSize()) )
                .setIsinCode( convertToPbString(security.getIsinCode()) )
                .setMinPriceStep( convertToPbString(security.getMinPriceStep()) )
                .build();
    }
}
