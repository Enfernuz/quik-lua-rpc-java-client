package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetQuoteLevel2;
import org.jetbrains.annotations.NotNull;

public class QuoteEntryPbSerdeTest extends AbstractPbSerdeTest<GetQuoteLevel2.QuoteEntry, qlua.rpc.GetQuoteLevel2.QuoteEntry> {

    private static final String PRICE = "1";
    private static final String QUANTITY = "2";

    @Override
    public @NotNull Class<GetQuoteLevel2.QuoteEntry> getTargetObjectClass() {
        return GetQuoteLevel2.QuoteEntry.class;
    }

    @NotNull
    @Override
    public qlua.rpc.GetQuoteLevel2.QuoteEntry getTargetObjectAsPbMessage() {
        return qlua.rpc.GetQuoteLevel2.QuoteEntry.newBuilder()
                .setPrice(PRICE)
                .setQuantity(QUANTITY)
                .build();
    }

    @NotNull
    @Override
    public GetQuoteLevel2.QuoteEntry getTargetObject() {
        return GetQuoteLevel2.QuoteEntry.builder()
                .price(PRICE)
                .quantity(QUANTITY)
                .build();
    }
}
