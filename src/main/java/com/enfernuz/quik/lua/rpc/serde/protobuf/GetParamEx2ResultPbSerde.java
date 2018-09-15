package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetParamEx2;
import com.enfernuz.quik.lua.rpc.serde.PbConverter;
import com.enfernuz.quik.lua.rpc.serde.Serde;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;

import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.convertFromPbString;
import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.convertToPbString;

enum GetParamEx2ResultPbSerde implements Serde<GetParamEx2.Result>, PbConverter<qlua.rpc.GetParamEx2.Result, GetParamEx2.Result> {

    INSTANCE;

    @Override
    public byte[] serialize(final GetParamEx2.Result result) {
        return convertToPb(result).toByteArray();
    }

    @NotNull
    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public GetParamEx2.Result deserialize(final byte[] data) {
        return convertFromPb( qlua.rpc.GetParamEx2.Result.parseFrom(data) );
    }

    @NotNull
    @Override
    public GetParamEx2.Result convertFromPb(@NotNull final qlua.rpc.GetParamEx2.Result result) {

        if (!result.hasParamEx()) {
            throw new IllegalArgumentException("Экземпляр protobuf-представления qlua.rpc.GetParamEx2.Result не содержит поля 'paramEx'.");
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

    @NotNull
    @Override
    public qlua.rpc.GetParamEx2.Result convertToPb(@NotNull final GetParamEx2.Result result) {

        final GetParamEx2.ParamEx2 paramEx = result.getParamEx();
        final qlua.rpc.GetParamEx2.ParamEx2 pbParamEx = qlua.rpc.GetParamEx2.ParamEx2.newBuilder()
                .setParamType( convertToPbString(paramEx.getParamType()) )
                .setParamValue( convertToPbString(paramEx.getParamValue()) )
                .setParamImage( convertToPbString(paramEx.getParamImage()) )
                .setResult( convertToPbString(paramEx.getResult()) )
                .build();

        return qlua.rpc.GetParamEx2.Result.newBuilder()
                .setParamEx(pbParamEx)
                .build();
    }
}
