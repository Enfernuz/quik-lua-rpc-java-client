package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.SearchItems;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;

enum SearchItemsResultPbDeserializer implements Deserializer<SearchItems.Result>, FromPbConverter<qlua.rpc.SearchItems.Result, SearchItems.Result>{

    INSTANCE;

    @NotNull
    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public SearchItems.Result deserialize(final byte[] data) {
        return convert( qlua.rpc.SearchItems.Result.parseFrom(data) );
    }

    @NotNull
    @Override
    public SearchItems.Result convert(@NotNull final qlua.rpc.SearchItems.Result result) {

        if (result.getNullItemsIndices()) {
            return SearchItems.Result.getNullInstance();
        } else {

            if ( result.getItemsIndicesList().isEmpty() ) {
                return SearchItems.Result.getEmptyInstance();
            }

            return SearchItems.Result.getInstance(
                    result.getItemsIndicesList().stream()
                            .mapToInt(Integer::intValue)
                            .toArray()
            );
        }
    }
}
