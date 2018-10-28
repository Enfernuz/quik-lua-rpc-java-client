package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.structures.ClassInfo;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import qlua.structs.QluaStructures;

import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.convertFromPbString;

enum ClassInfoPbDeserializer implements Deserializer<ClassInfo>, FromPbConverter<QluaStructures.Klass, ClassInfo> {

    INSTANCE;

    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public ClassInfo deserialize(final byte[] data) {
        return convert( QluaStructures.Klass.parseFrom(data) );
    }

    @Override
    public ClassInfo convert(@NotNull final QluaStructures.Klass classInfo) {

        return ClassInfo.builder()
                .firmId( convertFromPbString(classInfo.getFirmid()) )
                .name( convertFromPbString(classInfo.getName()) )
                .code( convertFromPbString(classInfo.getCode()) )
                .npars( classInfo.getNpars() )
                .nsecs( classInfo.getNsecs() )
                .build();
    }
}
