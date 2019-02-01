package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.datasource.CreateDataSource;
import com.enfernuz.quik.lua.rpc.serde.Serializer;
import org.jetbrains.annotations.NotNull;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class DatasourceCreateDataSourceArgsPbSerdeTest  {

    private static final String CLASS_CODE = "1";
    private static final String SEC_CODE = "2";
    private static final CreateDataSource.Interval INTERVAL = CreateDataSource.Interval.INTERVAL_H1;
    private static final String PARAM = "4";

    public static class FullArgsDatasourceCreateDataSourceArgsPbSerdeTest
            extends AbstractPbSerializationTest<CreateDataSource.Args, qlua.rpc.datasource.CreateDataSource.Args> {

        @Override
        public @NotNull Serializer<CreateDataSource.Args> getSerializerUnderTest() {
            return DsCreateDataSourcePbArgsSerializer.INSTANCE;
        }

        @NotNull
        @Override
        public qlua.rpc.datasource.CreateDataSource.Args getTargetObjectAsPbMessage() {

            return qlua.rpc.datasource.CreateDataSource.Args.newBuilder()
                    .setClassCode(CLASS_CODE)
                    .setSecCode(SEC_CODE)
                    .setInterval(qlua.rpc.datasource.CreateDataSource.Interval.INTERVAL_H1)
                    .setParam(PARAM)
                    .build();
        }

        @NotNull
        @Override
        public CreateDataSource.Args getTargetObject() {

            return CreateDataSource.Args.builder()
                    .classCode(CLASS_CODE)
                    .secCode(SEC_CODE)
                    .interval(INTERVAL)
                    .param(PARAM)
                    .build();
        }
    }

    public static class WithoutParamArgDatasourceCreateDataSourceArgsPbSerdeTest
            extends AbstractPbSerializationTest<CreateDataSource.Args, qlua.rpc.datasource.CreateDataSource.Args> {

        @Override
        public @NotNull Serializer<CreateDataSource.Args> getSerializerUnderTest() {
            return DsCreateDataSourcePbArgsSerializer.INSTANCE;
        }

        @NotNull
        @Override
        public qlua.rpc.datasource.CreateDataSource.Args getTargetObjectAsPbMessage() {

            return qlua.rpc.datasource.CreateDataSource.Args.newBuilder()
                    .setClassCode(CLASS_CODE)
                    .setSecCode(SEC_CODE)
                    .setInterval(qlua.rpc.datasource.CreateDataSource.Interval.INTERVAL_H1)
                    .build();
        }

        @NotNull
        @Override
        public CreateDataSource.Args getTargetObject() {

            return CreateDataSource.Args.builder()
                    .classCode(CLASS_CODE)
                    .secCode(SEC_CODE)
                    .interval(INTERVAL)
                    .build();
        }
    }
}
