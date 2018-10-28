package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetTableSize;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;

enum GetTableSizeResultPbDeserializer implements Deserializer<GetTableSize.Result>, FromPbConverter<qlua.rpc.GetTableSize.Result, GetTableSize.Result> {

    INSTANCE;

    @NotNull
    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public GetTableSize.Result deserialize(final byte[] data) {
        return convert( qlua.rpc.GetTableSize.Result.parseFrom(data) );
    }

    @Override
    public GetTableSize.Result convert(@NotNull final qlua.rpc.GetTableSize.Result result) {

        if (result.hasTableSize()) {
            final qlua.rpc.GetTableSize.TableSize pbTableSize = result.getTableSize();
            final GetTableSize.TableSize tableSize = GetTableSize.TableSize.builder()
                    .rows( pbTableSize.getRows() )
                    .col( pbTableSize.getCol() )
                    .build();
            return GetTableSize.Result.getInstance(tableSize);
        }

        return GetTableSize.Result.getErrorInstance();
    }
}
