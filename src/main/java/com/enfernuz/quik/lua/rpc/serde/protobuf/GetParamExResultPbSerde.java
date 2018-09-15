package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetParamEx;
import com.enfernuz.quik.lua.rpc.serde.PbConverter;
import com.enfernuz.quik.lua.rpc.serde.Serde;
import com.enfernuz.quik.lua.rpc.serde.SerdeException;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;

import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.convertFromPbString;
import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.convertToPbString;

enum GetParamExResultPbSerde implements Serde<GetParamEx.Result>, PbConverter<qlua.rpc.GetParamEx.Result, GetParamEx.Result> {

    INSTANCE;

    @Override
    public byte[] serialize(final GetParamEx.Result result) {
        return convertToPb(result).toByteArray();
    }

    @NotNull
    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public GetParamEx.Result deserialize(final byte[] data) {
        return convertFromPb( qlua.rpc.GetParamEx.Result.parseFrom(data) );
    }

    @NotNull
    @Override
    public GetParamEx.Result convertFromPb(@NotNull final qlua.rpc.GetParamEx.Result result) {

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

    @NotNull
    @Override
    public qlua.rpc.GetParamEx.Result convertToPb(@NotNull final GetParamEx.Result result) {

        final GetParamEx.ParamEx paramEx = result.getParamEx();
        final qlua.rpc.GetParamEx.ParamEx pbParamEx = qlua.rpc.GetParamEx.ParamEx.newBuilder()
                .setParamType( convertToPbString(paramEx.getParamType()) )
                .setParamValue( convertToPbString(paramEx.getParamValue()) )
                .setParamImage( convertToPbString(paramEx.getParamImage()) )
                .setResult( convertToPbString(paramEx.getResult()) )
                .build();

        return qlua.rpc.GetParamEx.Result.newBuilder()
                .setParamEx(pbParamEx)
                .build();
    }
}
