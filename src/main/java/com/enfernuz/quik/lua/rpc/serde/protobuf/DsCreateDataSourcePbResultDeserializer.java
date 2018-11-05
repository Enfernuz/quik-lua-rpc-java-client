package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.datasource.CreateDataSource;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;

enum DsCreateDataSourcePbResultDeserializer implements Deserializer<CreateDataSource.Result>, FromPbConverter<qlua.rpc.datasource.CreateDataSource.Result, CreateDataSource.Result> {

    INSTANCE;

    @NotNull
    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public CreateDataSource.Result deserialize(@NotNull final byte[] data) {
        return convert( qlua.rpc.datasource.CreateDataSource.Result.parseFrom(data) );
    }

    @NotNull
    @Override
    public CreateDataSource.Result convert(@NotNull final qlua.rpc.datasource.CreateDataSource.Result result) {

        final CreateDataSource.Result.ResultBuilder resultBuilder = CreateDataSource.Result.builder();

        final boolean error = result.getIsError();
        resultBuilder.error(error);
        if (error) {
            resultBuilder.errorDesc( result.getErrorDesc() );
        } else {
            resultBuilder.datasourceUUID( result.getDatasourceUuid() );
        }

        return resultBuilder.build();
    }
}
