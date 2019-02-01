package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetTableSize;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import org.jetbrains.annotations.NotNull;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class GetTableSizeResultPbSerdeTest {

    private static final int ROWS = 1;
    private static final int COL = 2;
    private static final GetTableSize.TableSize TABLE_SIZE =
            GetTableSize.TableSize.builder()
                .rows(ROWS)
                .col(COL)
                .build();

    public static class NormalGetTableSizeResultPbSerdeTest extends AbstractPbDeserializationTest<qlua.rpc.GetTableSize.Result, GetTableSize.Result> {

        @Override
        public @NotNull Deserializer<GetTableSize.Result> getDeserializerUnderTest() {
            return GetTableSizeResultPbDeserializer.INSTANCE;
        }

        @NotNull
        @Override
        public GetTableSize.Result getTargetObject() {
            return GetTableSize.Result.getInstance(TABLE_SIZE);
        }

        @NotNull
        @Override
        public qlua.rpc.GetTableSize.Result getTargetObjectAsPbMessage() {

            final qlua.rpc.GetTableSize.TableSize pbTableSize = qlua.rpc.GetTableSize.TableSize.newBuilder()
                    .setRows(ROWS)
                    .setCol(COL)
                    .build();

            return qlua.rpc.GetTableSize.Result.newBuilder()
                    .setTableSize(pbTableSize)
                    .build();
        }
    }

    public static class ErrorGetTableSizeResultPbSerdeTest extends AbstractPbDeserializationTest<qlua.rpc.GetTableSize.Result, GetTableSize.Result> {

        @Override
        public @NotNull Deserializer<GetTableSize.Result> getDeserializerUnderTest() {
            return GetTableSizeResultPbDeserializer.INSTANCE;
        }

        @NotNull
        @Override
        public GetTableSize.Result getTargetObject() {
            return GetTableSize.Result.getErrorInstance();
        }

        @NotNull
        @Override
        public qlua.rpc.GetTableSize.Result getTargetObjectAsPbMessage() {
            return qlua.rpc.GetTableSize.Result.newBuilder().build();
        }
    }
}
