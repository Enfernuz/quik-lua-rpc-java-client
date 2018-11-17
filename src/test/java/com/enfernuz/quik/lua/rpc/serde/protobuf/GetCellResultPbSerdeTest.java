package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetCell;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import org.jetbrains.annotations.NotNull;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class GetCellResultPbSerdeTest {

    public static class NormalGetCellResultPbSerdeTest extends AbstractPbDeserializationTest<qlua.rpc.GetCell.Result, GetCell.Result> {

        private static final String IMAGE = "1";
        private static final String VALUE = "2";

        @Override
        public @NotNull Deserializer<GetCell.Result> getDeserializerUnderTest() {
            return GetCellResultPbDeserializer.INSTANCE;
        }

        @NotNull
        @Override
        public GetCell.Result getTargetObject() {

            return GetCell.Result.builder()
                    .image(IMAGE)
                    .value(VALUE)
                    .build();
        }

        @NotNull
        @Override
        public qlua.rpc.GetCell.Result getTargetObjectAsPbMessage() {

            return qlua.rpc.GetCell.Result.newBuilder()
                    .setImage(IMAGE)
                    .setValue(VALUE)
                    .build();
        }
    }

    public static class ErrorGetCellResultPbSerdeTest extends AbstractPbDeserializationTest<qlua.rpc.GetCell.Result, GetCell.Result> {

        @Override
        public @NotNull Deserializer<GetCell.Result> getDeserializerUnderTest() {
            return GetCellResultPbDeserializer.INSTANCE;
        }

        @NotNull
        @Override
        public GetCell.Result getTargetObject() {
            return GetCell.Result.builder().build();
        }

        @NotNull
        @Override
        public qlua.rpc.GetCell.Result getTargetObjectAsPbMessage() {
            return qlua.rpc.GetCell.Result.newBuilder().build();
        }
    }
}
