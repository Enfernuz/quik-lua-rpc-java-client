package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetQuoteLevel2.QuoteEntry;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import qlua.rpc.GetQuoteLevel2;

enum QuoteEntryPbDeserializer implements Deserializer<QuoteEntry>, FromPbConverter<GetQuoteLevel2.QuoteEntry, QuoteEntry> {

    INSTANCE;

    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public QuoteEntry deserialize(final byte[] data) {
        return convert(qlua.rpc.GetQuoteLevel2.QuoteEntry.parseFrom(data));
    }

    @Override
    public QuoteEntry convert(@NotNull qlua.rpc.GetQuoteLevel2.QuoteEntry quoteEntry) {

        return QuoteEntry.builder()
                .price( quoteEntry.getPrice() )
                .quantity( quoteEntry.getQuantity() )
                .build();
    }
}
