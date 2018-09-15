package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetTableSize;
import org.jetbrains.annotations.NotNull;
import org.junit.Test;

public class GetTableSizeResultPbSerdeTest extends AbstractResultPbSerdeTest<GetTableSize.Result, qlua.rpc.GetTableSize.Result> {

    @Override
    public @NotNull Class<GetTableSize.Result> getTargetObjectClass() {
        return GetTableSize.Result.class;
    }

    @NotNull
    @Override
    public qlua.rpc.GetTableSize.Result getTargetObjectAsPbMessage() {

        final qlua.rpc.GetTableSize.TableSize tableSize = qlua.rpc.GetTableSize.TableSize.newBuilder()
                .setRows(TableSizeParameters.ROWS)
                .setCol(TableSizeParameters.COL)
                .build();

        return qlua.rpc.GetTableSize.Result.newBuilder()
                .setTableSize(tableSize)
                .build();
    }

    @NotNull
    @Override
    public GetTableSize.Result getTargetObject() {

        final GetTableSize.TableSize tableSize = GetTableSize.TableSize.builder()
                .rows(TableSizeParameters.ROWS)
                .col(TableSizeParameters.COL)
                .build();

        return GetTableSize.Result.getInstance(tableSize);
    }

    @Test
    @Override
    public void testSerializeErrorObject() {
        super.testSerializeErrorObject();
    }

    @Test
    @Override
    public void testDeserializeErrorObject() {
        super.testDeserializeErrorObject();
    }

    @NotNull
    @Override
    public qlua.rpc.GetTableSize.Result getErrorObject_AsPbMessage() {
        return qlua.rpc.GetTableSize.Result.newBuilder().build();
    }

    @NotNull
    @Override
    public GetTableSize.Result getErrorObject() {
        return GetTableSize.Result.getErrorInstance();
    }

    private static final class TableSizeParameters {

        private static final int ROWS = 1;
        private static final int COL = 2;
    }
}
