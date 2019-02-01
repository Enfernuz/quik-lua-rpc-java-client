package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.SearchItems;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import org.jetbrains.annotations.NotNull;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;

@RunWith(Enclosed.class)
public class SearchItemsResultPbSerdeTest {

    public static class SomeIndicesSearchItemsResultPbSerdeTest extends AbstractPbDeserializationTest<qlua.rpc.SearchItems.Result, SearchItems.Result> {

        private static final int[] INDICES = {1, 2, 3, 4, 5, 9, 8, 7, 6};

        @Override
        public @NotNull Deserializer<SearchItems.Result> getDeserializerUnderTest() {
            return SearchItemsResultPbDeserializer.INSTANCE;
        }

        @NotNull
        @Override
        public SearchItems.Result getTargetObject() {
            return SearchItems.Result.getInstance(INDICES);
        }

        @NotNull
        @Override
        public qlua.rpc.SearchItems.Result getTargetObjectAsPbMessage() {

            final List<Integer> indicesList = new ArrayList<>(INDICES.length);
            for (int i : INDICES) {
                indicesList.add(i);
            }

            return qlua.rpc.SearchItems.Result.newBuilder()
                    .addAllItemsIndices(indicesList)
                    .build();
        }
    }

    public static class EmptyIndicesSearchItemsResultPbSerdeTest extends AbstractPbDeserializationTest<qlua.rpc.SearchItems.Result, SearchItems.Result> {

        private static final int[] INDICES = {};

        @Override
        public @NotNull Deserializer<SearchItems.Result> getDeserializerUnderTest() {
            return SearchItemsResultPbDeserializer.INSTANCE;
        }

        @NotNull
        @Override
        public SearchItems.Result getTargetObject() {
            return SearchItems.Result.getEmptyInstance();
        }

        @NotNull
        @Override
        public qlua.rpc.SearchItems.Result getTargetObjectAsPbMessage() {

            return qlua.rpc.SearchItems.Result.newBuilder()
                    .build();
        }
    }

    public static class ErrorSearchItemsResultPbSerdeTest extends AbstractPbDeserializationTest<qlua.rpc.SearchItems.Result, SearchItems.Result> {

        @Override
        public @NotNull Deserializer<SearchItems.Result> getDeserializerUnderTest() {
            return SearchItemsResultPbDeserializer.INSTANCE;
        }

        @NotNull
        @Override
        public SearchItems.Result getTargetObject() {
            return SearchItems.Result.getNullInstance();
        }

        @NotNull
        @Override
        public qlua.rpc.SearchItems.Result getTargetObjectAsPbMessage() {

            return qlua.rpc.SearchItems.Result.newBuilder()
                    .setNullItemsIndices(true)
                    .build();
        }
    }
}
