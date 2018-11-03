package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.datasource.T;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;

enum DsTResultPbDeserializer implements Deserializer<T.Result>, FromPbConverter<qlua.rpc.datasource.T.Result, T.Result> {

    INSTANCE;

    @NotNull
    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public T.Result deserialize(@NotNull final byte[] data) {
        return convert( qlua.rpc.datasource.T.Result.parseFrom(data) );
    }

    @NotNull
    @Override
    public T.Result convert(@NotNull final qlua.rpc.datasource.T.Result result) {

        return T.Result.builder()
                .year( result.getYear() )
                .month( result.getMonth() )
                .day( result.getDay() )
                .weekDay( result.getWeekDay() )
                .hour( result.getHour() )
                .min( result.getMin() )
                .sec( result.getSec() )
                .ms( result.getMs() )
                .count( result.getCount() )
                .build();

    }
}
