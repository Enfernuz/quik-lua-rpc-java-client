package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.structures.ClassInfo;
import com.enfernuz.quik.lua.rpc.serde.PbConverter;
import com.enfernuz.quik.lua.rpc.serde.Serde;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import qlua.structs.QluaStructures;

import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.convertFromPbString;
import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.convertToPbString;

enum ClassInfoPbSerde implements Serde<ClassInfo>, PbConverter<QluaStructures.Klass, ClassInfo> {

    INSTANCE;

    @Override
    public byte[] serialize(final ClassInfo classInfo) {
        return convertToPb(classInfo).toByteArray();
    }

    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public ClassInfo deserialize(final byte[] data) {
        return convertFromPb( QluaStructures.Klass.parseFrom(data) );
    }

    @Override
    public ClassInfo convertFromPb(@NotNull final QluaStructures.Klass classInfo) {

        return ClassInfo.builder()
                .firmId( convertFromPbString(classInfo.getFirmid()) )
                .name( convertFromPbString(classInfo.getName()) )
                .code( convertFromPbString(classInfo.getCode()) )
                .npars( classInfo.getNpars() )
                .nsecs( classInfo.getNsecs() )
                .build();
    }

    @Override
    public QluaStructures.Klass convertToPb(@NotNull final ClassInfo classInfo) {

        return QluaStructures.Klass.newBuilder()
                .setFirmid( convertToPbString(classInfo.getFirmId()) )
                .setName( convertToPbString(classInfo.getName()) )
                .setCode( convertToPbString(classInfo.getCode()) )
                .setNpars( classInfo.getNpars() )
                .setNsecs( classInfo.getNsecs() )
                .build();
    }
}
