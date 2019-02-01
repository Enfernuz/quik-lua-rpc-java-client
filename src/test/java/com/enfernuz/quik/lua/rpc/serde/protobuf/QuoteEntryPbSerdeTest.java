package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetQuoteLevel2;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import org.jetbrains.annotations.NotNull;

public class QuoteEntryPbSerdeTest extends AbstractPbDeserializationTest<qlua.rpc.GetQuoteLevel2.QuoteEntry, GetQuoteLevel2.QuoteEntry> {

    private static final String PRICE = "1";
    private static final String QUANTITY = "2";

    @Override
    public @NotNull Deserializer<GetQuoteLevel2.QuoteEntry> getDeserializerUnderTest() {
        return QuoteEntryPbDeserializer.INSTANCE;
    }

    @NotNull
    @Override
    public GetQuoteLevel2.QuoteEntry getTargetObject() {

        return GetQuoteLevel2.QuoteEntry.builder()
                .price(PRICE)
                .quantity(QUANTITY)
                .build();
    }

    @NotNull
    @Override
    public qlua.rpc.GetQuoteLevel2.QuoteEntry getTargetObjectAsPbMessage() {

        return qlua.rpc.GetQuoteLevel2.QuoteEntry.newBuilder()
                .setPrice(PRICE)
                .setQuantity(QUANTITY)
                .build();
    }
}
