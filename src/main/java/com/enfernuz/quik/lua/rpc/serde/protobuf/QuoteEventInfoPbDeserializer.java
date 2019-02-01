package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.structures.QuoteEventInfo;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import qlua.structs.QluaStructures;

import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.convertFromPbString;

enum QuoteEventInfoPbDeserializer implements Deserializer<QuoteEventInfo>, FromPbConverter<QluaStructures.QuoteEventInfo, QuoteEventInfo> {

    INSTANCE;

    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public QuoteEventInfo deserialize(final byte[] data) {
        return convert(QluaStructures.QuoteEventInfo.parseFrom(data));
    }

    @Override
    public QuoteEventInfo convert(@NotNull QluaStructures.QuoteEventInfo quoteEventInfo) {

        return QuoteEventInfo.builder()
                .classCode( convertFromPbString(quoteEventInfo.getClassCode()) )
                .secCode( convertFromPbString(quoteEventInfo.getSecCode()) )
                .build();
    }
}
