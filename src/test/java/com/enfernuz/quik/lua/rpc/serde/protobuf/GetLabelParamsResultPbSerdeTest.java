package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetLabelParams;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import com.google.common.collect.ImmutableMap;
import org.jetbrains.annotations.NotNull;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import java.util.Map;

@RunWith(Enclosed.class)
public class GetLabelParamsResultPbSerdeTest {

    public static class NormalGetLabelParamsResultPbSerdeTest extends AbstractPbDeserializationTest<qlua.rpc.GetLabelParams.Result, GetLabelParams.Result> {

        private static final Map<String, String> LABEL_PARAMS = ImmutableMap.of(
                "key1", "value1",
                "key2", "value2",
                "key3", "value3"
        );

        @Override
        public @NotNull Deserializer<GetLabelParams.Result> getDeserializerUnderTest() {
            return GetLabelParamsResultPbDeserializer.INSTANCE;
        }

        @NotNull
        @Override
        public GetLabelParams.Result getTargetObject() {
            return GetLabelParams.Result.getInstance(LABEL_PARAMS);
        }

        @NotNull
        @Override
        public qlua.rpc.GetLabelParams.Result getTargetObjectAsPbMessage() {

            return qlua.rpc.GetLabelParams.Result.newBuilder()
                    .putAllLabelParams(LABEL_PARAMS)
                    .build();
        }
    }

    public static class ErrorGetLabelParamsResultPbSerdeTest extends AbstractPbDeserializationTest<qlua.rpc.GetLabelParams.Result, GetLabelParams.Result> {

        @Override
        public @NotNull Deserializer<GetLabelParams.Result> getDeserializerUnderTest() {
            return GetLabelParamsResultPbDeserializer.INSTANCE;
        }

        @NotNull
        @Override
        public GetLabelParams.Result getTargetObject() {
            return GetLabelParams.Result.getInstance(null);
        }

        @NotNull
        @Override
        public qlua.rpc.GetLabelParams.Result getTargetObjectAsPbMessage() {
            return qlua.rpc.GetLabelParams.Result.newBuilder()
                    .setNullLabelParams(true)
                    .build();
        }
    }
}
