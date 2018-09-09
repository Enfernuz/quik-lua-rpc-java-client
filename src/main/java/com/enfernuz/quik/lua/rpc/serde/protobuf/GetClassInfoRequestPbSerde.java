package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetClassInfo;
import com.enfernuz.quik.lua.rpc.serde.PbConverter;
import com.enfernuz.quik.lua.rpc.serde.Serde;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import qlua.rpc.RPC;

import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.assertEquals;

enum GetClassInfoRequestPbSerde implements Serde<GetClassInfo.Request>, PbConverter<qlua.rpc.GetClassInfo.Request, GetClassInfo.Request> {

    INSTANCE;

    private static final RPC.ProcedureType PROCEDURE_TYPE = RPC.ProcedureType.GET_CLASS_INFO;

    @Override
    public byte[] serialize(final GetClassInfo.Request request) {

        return RPC.Request.newBuilder()
                .setTypeValue( PROCEDURE_TYPE.getNumber() )
                .setArgs( convertToPb(request).toByteString() )
                .build()
                .toByteArray();
    }

    @NotNull
    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public GetClassInfo.Request deserialize(final byte[] data) {

        final RPC.Request request = RPC.Request.parseFrom(data);
        assertEquals(request.getType(), PROCEDURE_TYPE);

        return convertFromPb(
                qlua.rpc.GetClassInfo.Request.parseFrom( request.getArgs() )
        );
    }

    @Override
    public GetClassInfo.Request convertFromPb(@NotNull final qlua.rpc.GetClassInfo.Request request) {
        return new GetClassInfo.Request( request.getClassCode() );
    }

    @Override
    public qlua.rpc.GetClassInfo.Request convertToPb(@NotNull final GetClassInfo.Request request) {

        return qlua.rpc.GetClassInfo.Request.newBuilder()
                .setClassCode( request.getClassCode() )
                .build();
    }
}
