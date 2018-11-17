package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetItem;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import com.google.common.collect.ImmutableMap;
import org.jetbrains.annotations.NotNull;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import java.util.Map;

@RunWith(Enclosed.class)
public class GetItemResultPbSerdeTest  {

    public static class NormalGetItemResultPbSerdeTest extends AbstractPbDeserializationTest<qlua.rpc.GetItem.Result, GetItem.Result> {

        private static final Map<String, String> TABLE_ROW = ImmutableMap.of(
                "key1", "value1",
                "key2", "value2",
                "key3", "value3"
        );

        @Override
        public @NotNull Deserializer<GetItem.Result> getDeserializerUnderTest() {
            return GetItemResultPbDeserializer.INSTANCE;
        }

        @NotNull
        @Override
        public GetItem.Result getTargetObject() {
            return GetItem.Result.getInstance(TABLE_ROW);
        }

        @NotNull
        @Override
        public qlua.rpc.GetItem.Result getTargetObjectAsPbMessage() {

            return qlua.rpc.GetItem.Result.newBuilder()
                    .putAllTableRow(TABLE_ROW)
                    .build();
        }
    }

    public static class ErrorGetItemResultPbSerdeTest extends AbstractPbDeserializationTest<qlua.rpc.GetItem.Result, GetItem.Result> {

        @Override
        public @NotNull Deserializer<GetItem.Result> getDeserializerUnderTest() {
            return GetItemResultPbDeserializer.INSTANCE;
        }

        @NotNull
        @Override
        public GetItem.Result getTargetObject() {
            return GetItem.Result.getInstance(null);
        }

        @NotNull
        @Override
        public qlua.rpc.GetItem.Result getTargetObjectAsPbMessage() {
            return qlua.rpc.GetItem.Result.newBuilder()
                    .setNullTableRow(true)
                    .build();
        }
    }
}
