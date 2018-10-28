package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetSecurityInfo;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;

import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.convertFromPbSecurity;

enum GetSecurityInfoResultPbDeserializer implements Deserializer<GetSecurityInfo.Result>, FromPbConverter<qlua.rpc.GetSecurityInfo.Result, GetSecurityInfo.Result> {

    INSTANCE;

    @NotNull
    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public GetSecurityInfo.Result deserialize(final byte[] data) {
        return convert( qlua.rpc.GetSecurityInfo.Result.parseFrom(data) );
    }

    @Override
    public GetSecurityInfo.Result convert(@NotNull final qlua.rpc.GetSecurityInfo.Result result) {

        return result.hasSecurityInfo() ?
                GetSecurityInfo.Result.getInstance( convertFromPbSecurity(result.getSecurityInfo()) )
                :
                GetSecurityInfo.Result.getInstance(null);
    }
}
