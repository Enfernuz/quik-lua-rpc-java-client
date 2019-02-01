package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetParamEx2;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;

import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.convertFromPbString;

enum GetParamEx2ResultPbDeserializer implements Deserializer<GetParamEx2.Result>, FromPbConverter<qlua.rpc.GetParamEx2.Result, GetParamEx2.Result> {

    INSTANCE;

    @NotNull
    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public GetParamEx2.Result deserialize(final byte[] data) {
        return convert( qlua.rpc.GetParamEx2.Result.parseFrom(data) );
    }

    @NotNull
    @Override
    public GetParamEx2.Result convert(@NotNull final qlua.rpc.GetParamEx2.Result result) {

        if (!result.hasParamEx()) {
            throw new IllegalArgumentException("Поле 'param_ex' экземпляра protobuf-представления qlua.rpc.GetParamEx2.Result не инициализировано.");
        }

        final qlua.rpc.GetParamEx2.ParamEx2 pbParamEx = result.getParamEx();
        final GetParamEx2.ParamEx2 paramEx = GetParamEx2.ParamEx2.builder()
                .paramType( convertFromPbString(pbParamEx.getParamType()) )
                .paramValue( convertFromPbString(pbParamEx.getParamValue()) )
                .paramImage( convertFromPbString(pbParamEx.getParamImage()) )
                .result( convertFromPbString(pbParamEx.getResult()) )
                .build();

        return new GetParamEx2.Result(paramEx);
    }
}
