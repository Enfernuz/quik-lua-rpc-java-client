package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetSecurityInfo;
import com.enfernuz.quik.lua.rpc.serde.PbConverter;
import com.enfernuz.quik.lua.rpc.serde.Serde;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;

import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.convertFromPbSecurity;
import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.convertToPbSecurity;

enum GetSecurityInfoResultPbSerde implements Serde<GetSecurityInfo.Result>, PbConverter<qlua.rpc.GetSecurityInfo.Result, GetSecurityInfo.Result> {

    INSTANCE;

    @Override
    public byte[] serialize(final GetSecurityInfo.Result result) {
        return convertToPb(result).toByteArray();
    }

    @NotNull
    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public GetSecurityInfo.Result deserialize(final byte[] data) {
        return convertFromPb( qlua.rpc.GetSecurityInfo.Result.parseFrom(data) );
    }

    @Override
    public GetSecurityInfo.Result convertFromPb(@NotNull final qlua.rpc.GetSecurityInfo.Result result) {

        if (!result.hasSecurityInfo()) {
            throw new IllegalArgumentException("Экземпляр protobuf-представления qlua.rpc.GetSecurityInfo.Result не содержит поля 'securityInfo'.");
        }

        return new GetSecurityInfo.Result( convertFromPbSecurity(result.getSecurityInfo()) );
    }

    @Override
    public qlua.rpc.GetSecurityInfo.Result convertToPb(@NotNull final GetSecurityInfo.Result result) {

        return qlua.rpc.GetSecurityInfo.Result.newBuilder()
                .setSecurityInfo( convertToPbSecurity(result.getSecurityInfo()) )
                .build();
    }
}
