package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetTableSize;
import com.enfernuz.quik.lua.rpc.serde.PbConverter;
import com.enfernuz.quik.lua.rpc.serde.Serde;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;

enum GetTableSizeResultPbSerde implements Serde<GetTableSize.Result>, PbConverter<qlua.rpc.GetTableSize.Result, GetTableSize.Result> {

    INSTANCE;

    @Override
    public byte[] serialize(final GetTableSize.Result result) {
        return convertToPb(result).toByteArray();
    }

    @NotNull
    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public GetTableSize.Result deserialize(final byte[] data) {
        return convertFromPb( qlua.rpc.GetTableSize.Result.parseFrom(data) );
    }

    @Override
    public GetTableSize.Result convertFromPb(@NotNull final qlua.rpc.GetTableSize.Result result) {

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

    @Override
    public qlua.rpc.GetTableSize.Result convertToPb(@NotNull final GetTableSize.Result result) {

        final GetTableSize.TableSize tableSize = result.getTableSize();
        if (tableSize == null) {
            return qlua.rpc.GetTableSize.Result.newBuilder().build();
        }

        final qlua.rpc.GetTableSize.TableSize pbTableSize = qlua.rpc.GetTableSize.TableSize.newBuilder()
                .setRows( tableSize.getRows() )
                .setCol( tableSize.getCol() )
                .build();
        return qlua.rpc.GetTableSize.Result.newBuilder()
                .setTableSize(pbTableSize)
                .build();
    }
}
