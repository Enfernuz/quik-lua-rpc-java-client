package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.SearchItems;
import com.enfernuz.quik.lua.rpc.serde.Serializer;
import org.jetbrains.annotations.NotNull;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class SearchItemsArgsPbSerdeTest {

    public static class FullSearchItemsArgsPbSerdeTest extends AbstractPbSerializationTest<SearchItems.Args, qlua.rpc.SearchItems.Args> {

        private static final String TABLE_NAME = "1";
        private static final int START_INDEX = 2;
        private static final int END_INDEX = 3;
        private static final String FN_DEF = "4";
        private static final String PARAMS = "5";

        @Override
        public @NotNull Serializer<SearchItems.Args> getSerializerUnderTest() {
            return SearchItemsArgsPbSerializer.INSTANCE;
        }

        @NotNull
        @Override
        public qlua.rpc.SearchItems.Args getTargetObjectAsPbMessage() {

            return qlua.rpc.SearchItems.Args.newBuilder()
                    .setTableName(TABLE_NAME)
                    .setStartIndex(START_INDEX)
                    .setValueEndIndex(END_INDEX)
                    .setFnDef(FN_DEF)
                    .setParams(PARAMS)
                    .build();
        }

        @NotNull
        @Override
        public SearchItems.Args getTargetObject() {

            return SearchItems.Args.builder()
                    .tableName(TABLE_NAME)
                    .startIndex(START_INDEX)
                    .endIndex(END_INDEX)
                    .fnDef(FN_DEF)
                    .params(PARAMS)
                    .build();
        }
    }

    public static class WithoutEndIndexSearchItemsArgsPbSerdeTest extends AbstractPbSerializationTest<SearchItems.Args, qlua.rpc.SearchItems.Args> {

        private static final String TABLE_NAME = "1";
        private static final int START_INDEX = 2;
        private static final String FN_DEF = "4";
        private static final String PARAMS = "5";

        @Override
        public @NotNull Serializer<SearchItems.Args> getSerializerUnderTest() {
            return SearchItemsArgsPbSerializer.INSTANCE;
        }

        @NotNull
        @Override
        public qlua.rpc.SearchItems.Args getTargetObjectAsPbMessage() {

            return qlua.rpc.SearchItems.Args.newBuilder()
                    .setTableName(TABLE_NAME)
                    .setStartIndex(START_INDEX)
                    .setNullEndIndex(true)
                    .setFnDef(FN_DEF)
                    .setParams(PARAMS)
                    .build();
        }

        @NotNull
        @Override
        public SearchItems.Args getTargetObject() {

            return SearchItems.Args.builder()
                    .tableName(TABLE_NAME)
                    .startIndex(START_INDEX)
                    .fnDef(FN_DEF)
                    .params(PARAMS)
                    .build();
        }
    }

    public static class WithoutParamsSearchItemsArgsPbSerdeTest extends AbstractPbSerializationTest<SearchItems.Args, qlua.rpc.SearchItems.Args> {

        private static final String TABLE_NAME = "1";
        private static final int START_INDEX = 2;
        private static final int END_INDEX = 3;
        private static final String FN_DEF = "4";

        @Override
        public @NotNull Serializer<SearchItems.Args> getSerializerUnderTest() {
            return SearchItemsArgsPbSerializer.INSTANCE;
        }

        @NotNull
        @Override
        public qlua.rpc.SearchItems.Args getTargetObjectAsPbMessage() {

            return qlua.rpc.SearchItems.Args.newBuilder()
                    .setTableName(TABLE_NAME)
                    .setStartIndex(START_INDEX)
                    .setValueEndIndex(END_INDEX)
                    .setFnDef(FN_DEF)
                    .build();
        }

        @NotNull
        @Override
        public SearchItems.Args getTargetObject() {

            return SearchItems.Args.builder()
                    .tableName(TABLE_NAME)
                    .startIndex(START_INDEX)
                    .endIndex(END_INDEX)
                    .fnDef(FN_DEF)
                    .build();
        }
    }
}
