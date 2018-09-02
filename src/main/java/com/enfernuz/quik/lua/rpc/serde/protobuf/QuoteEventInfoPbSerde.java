package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.structures.QuoteEventInfo;
import com.enfernuz.quik.lua.rpc.serde.PbConverter;
import com.enfernuz.quik.lua.rpc.serde.Serde;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import qlua.structs.QluaStructures;

import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.convertFromPbString;
import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.convertToPbString;

enum QuoteEventInfoPbSerde implements Serde<QuoteEventInfo>, PbConverter<QluaStructures.QuoteEventInfo, QuoteEventInfo> {

    INSTANCE;

    @Override
    public byte[] serialize(final QuoteEventInfo quoteEventInfo) {
        return convertToPb(quoteEventInfo).toByteArray();
    }

    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public QuoteEventInfo deserialize(final byte[] data) {
        return convertFromPb(QluaStructures.QuoteEventInfo.parseFrom(data));
    }

    @Override
    public QuoteEventInfo convertFromPb(@NotNull QluaStructures.QuoteEventInfo quoteEventInfo) {

        return QuoteEventInfo.builder()
                .classCode( convertFromPbString(quoteEventInfo.getClassCode()) )
                .secCode( convertFromPbString(quoteEventInfo.getSecCode()) )
                .build();
    }

    @Override
    public QluaStructures.QuoteEventInfo convertToPb(@NotNull final QuoteEventInfo quoteEventInfo) {

        return QluaStructures.QuoteEventInfo.newBuilder()
                .setClassCode( convertToPbString(quoteEventInfo.getClassCode()) )
                .setSecCode( convertToPbString(quoteEventInfo.getSecCode()) )
                .build();
    }
}
