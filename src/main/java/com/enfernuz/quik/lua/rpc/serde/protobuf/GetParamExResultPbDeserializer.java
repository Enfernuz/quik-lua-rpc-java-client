package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetParamEx;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;

import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.convertFromPbString;

enum GetParamExResultPbDeserializer implements Deserializer<GetParamEx.Result>, FromPbConverter<qlua.rpc.GetParamEx.Result, GetParamEx.Result> {

    INSTANCE;

    @NotNull
    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public GetParamEx.Result deserialize(final byte[] data) {
        return convert( qlua.rpc.GetParamEx.Result.parseFrom(data) );
    }

    @NotNull
    @Override
    public GetParamEx.Result convert(@NotNull final qlua.rpc.GetParamEx.Result result) {

        if (!result.hasParamEx()) {
            throw new IllegalArgumentException("Поле 'param_ex' экземпляра protobuf-представления qlua.rpc.GetParamEx.Result не инициализировано.");
        }

        final qlua.rpc.GetParamEx.ParamEx pbParamEx = result.getParamEx();
        final GetParamEx.ParamEx paramEx = GetParamEx.ParamEx.builder()
                .paramType( convertFromPbString(pbParamEx.getParamType()) )
                .paramValue( convertFromPbString(pbParamEx.getParamValue()) )
                .paramImage( convertFromPbString(pbParamEx.getParamImage()) )
                .result( convertFromPbString(pbParamEx.getResult()) )
                .build();

        return new GetParamEx.Result(paramEx);
    }
}
