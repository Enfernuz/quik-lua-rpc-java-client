package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.datasource.CreateDataSource;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import org.jetbrains.annotations.NotNull;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class DatasourceCreateDataSourceResultPbSerdeTest {

    private static final boolean IS_ERROR = true;
    private static final boolean IS_NOT_ERROR = false;

    // sanity check
    static {
        assert IS_ERROR == !IS_NOT_ERROR;
    }

    public static class OkCreateDataSourceResultPbSerdeTest extends AbstractPbDeserializationTest<qlua.rpc.datasource.CreateDataSource.Result, CreateDataSource.Result> {

        private static final String DATASOURCE_UUID = "1";

        @Override
        public @NotNull Deserializer<CreateDataSource.Result> getDeserializerUnderTest() {
            return DsCreateDataSourcePbResultDeserializer.INSTANCE;
        }

        @NotNull
        @Override
        public CreateDataSource.Result getTargetObject() {
            return CreateDataSource.Result.builder()
                    .datasourceUUID(DATASOURCE_UUID)
                    .error(IS_NOT_ERROR)
                    .build();
        }

        @NotNull
        @Override
        public qlua.rpc.datasource.CreateDataSource.Result getTargetObjectAsPbMessage() {

            return qlua.rpc.datasource.CreateDataSource.Result.newBuilder()
                    .setDatasourceUuid(DATASOURCE_UUID)
                    .setIsError(IS_NOT_ERROR)
                    .build();
        }
    }

    public static class ErrorCreateDataSourceResultPbSerdeTest extends AbstractPbDeserializationTest<qlua.rpc.datasource.CreateDataSource.Result, CreateDataSource.Result> {

        private static final String ERROR_DESC = "1";

        @Override
        public @NotNull Deserializer<CreateDataSource.Result> getDeserializerUnderTest() {
            return DsCreateDataSourcePbResultDeserializer.INSTANCE;
        }

        @NotNull
        @Override
        public CreateDataSource.Result getTargetObject() {

            return CreateDataSource.Result.builder()
                    .error(IS_ERROR)
                    .errorDesc(ERROR_DESC)
                    .build();
        }

        @NotNull
        @Override
        public qlua.rpc.datasource.CreateDataSource.Result getTargetObjectAsPbMessage() {

            return qlua.rpc.datasource.CreateDataSource.Result.newBuilder()
                    .setIsError(IS_ERROR)
                    .setErrorDesc(ERROR_DESC)
                    .build();
        }
    }
}
