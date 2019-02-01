package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.SearchItems;
import com.enfernuz.quik.lua.rpc.serde.Serializer;
import org.jetbrains.annotations.NotNull;

enum SearchItemsArgsPbSerializer implements Serializer<SearchItems.Args>, ToPbConverter<SearchItems.Args, qlua.rpc.SearchItems.Args> {

    INSTANCE;

    @Override
    public @NotNull byte[] serialize(@NotNull final SearchItems.Args args) {
        return convert(args).toByteArray();
    }

    @Override
    public @NotNull qlua.rpc.SearchItems.Args convert(@NotNull final SearchItems.Args args) {

        final qlua.rpc.SearchItems.Args.Builder result =
                qlua.rpc.SearchItems.Args.newBuilder()
                        .setTableName( args.getTableName() )
                        .setStartIndex( args.getStartIndex() )
                        .setFnDef( args.getFnDef() );

        final Integer endIndex = args.getEndIndex();
        if (endIndex == null) {
            result.setNullEndIndex(true);
        } else {
            result.setValueEndIndex(endIndex);
        }

        final String params = args.getParams();
        if (params != null) {
            result.setParams(params);
        }

        return result.build();
    }
}
