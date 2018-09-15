package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetQuoteLevel2.QuoteEntry;
import com.enfernuz.quik.lua.rpc.serde.PbConverter;
import com.enfernuz.quik.lua.rpc.serde.Serde;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;

enum QuoteEntryPbSerde implements Serde<QuoteEntry>, PbConverter<qlua.rpc.GetQuoteLevel2.QuoteEntry, QuoteEntry> {

    INSTANCE;

    @Override
    public byte[] serialize(final QuoteEntry quoteEntry) {
        return convertToPb(quoteEntry).toByteArray();
    }

    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public QuoteEntry deserialize(final byte[] data) {
        return convertFromPb(qlua.rpc.GetQuoteLevel2.QuoteEntry.parseFrom(data));
    }

    @Override
    public QuoteEntry convertFromPb(@NotNull qlua.rpc.GetQuoteLevel2.QuoteEntry quoteEntry) {

        return QuoteEntry.builder()
                .price( quoteEntry.getPrice() )
                .quantity( quoteEntry.getQuantity() )
                .build();
    }

    @Override
    public qlua.rpc.GetQuoteLevel2.QuoteEntry convertToPb(@NotNull final QuoteEntry quoteEntry) {

        return qlua.rpc.GetQuoteLevel2.QuoteEntry.newBuilder()
                .setPrice( quoteEntry.getPrice() )
                .setQuantity( quoteEntry.getQuantity() )
                .build();
    }
}
