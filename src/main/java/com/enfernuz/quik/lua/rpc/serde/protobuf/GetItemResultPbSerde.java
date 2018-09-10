package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetItem;
import com.enfernuz.quik.lua.rpc.serde.PbConverter;
import com.enfernuz.quik.lua.rpc.serde.Serde;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

enum GetItemResultPbSerde implements Serde<GetItem.Result>, PbConverter<qlua.rpc.GetItem.Result, GetItem.Result> {

    INSTANCE;

    @Override
    public byte[] serialize(final GetItem.Result result) {
        return convertToPb(result).toByteArray();
    }

    @NotNull
    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public GetItem.Result deserialize(final byte[] data) {
        return convertFromPb( qlua.rpc.GetItem.Result.parseFrom(data) );
    }

    @NotNull
    @Override
    public GetItem.Result convertFromPb(@NotNull final qlua.rpc.GetItem.Result result) {
        return GetItem.Result.getInstance( result.getTableRowMap() );
    }

    @NotNull
    @Override
    public qlua.rpc.GetItem.Result convertToPb(@NotNull final GetItem.Result result) {

        final qlua.rpc.GetItem.Result.Builder pbResult = qlua.rpc.GetItem.Result.newBuilder();
        final Map<String, String> tableRow = result.getTableRow();
        if (tableRow != null) {
            pbResult.putAllTableRow(tableRow);
        }

        return pbResult.build();
    }
}
