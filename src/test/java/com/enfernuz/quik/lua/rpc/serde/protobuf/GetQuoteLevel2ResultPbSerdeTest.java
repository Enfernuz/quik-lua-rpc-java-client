package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetQuoteLevel2;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import com.google.common.collect.ImmutableList;
import org.jetbrains.annotations.NotNull;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

import java.util.List;

public class GetQuoteLevel2ResultPbSerdeTest extends AbstractPbDeserializationTest<qlua.rpc.GetQuoteLevel2.Result, GetQuoteLevel2.Result> {

    private static final String BID_COUNT = "4";
    private static final String OFFER_COUNT = "3";

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Override
    public @NotNull Deserializer<GetQuoteLevel2.Result> getDeserializerUnderTest() {
        return GetQuoteLevel2ResultPbDeserializer.INSTANCE;
    }

    @NotNull
    @Override
    public GetQuoteLevel2.Result getTargetObject() {

        final List<GetQuoteLevel2.QuoteEntry> bids = ImmutableList.of(
                GetQuoteLevel2.QuoteEntry.builder().price("1").quantity("100").build(),
                GetQuoteLevel2.QuoteEntry.builder().price("2").quantity("200").build(),
                GetQuoteLevel2.QuoteEntry.builder().price("3").quantity("300").build(),
                GetQuoteLevel2.QuoteEntry.builder().price("4").quantity("400").build()
        );

        final List<GetQuoteLevel2.QuoteEntry> offers = ImmutableList.of(
                GetQuoteLevel2.QuoteEntry.builder().price("5").quantity("500").build(),
                GetQuoteLevel2.QuoteEntry.builder().price("6").quantity("600").build(),
                GetQuoteLevel2.QuoteEntry.builder().price("7").quantity("700").build()
        );

        return GetQuoteLevel2.Result.builder()
                .bids(bids)
                .offers(offers)
                .bidCount(BID_COUNT)
                .offerCount(OFFER_COUNT)
                .build();
    }

    @NotNull
    @Override
    public qlua.rpc.GetQuoteLevel2.Result getTargetObjectAsPbMessage() {

        final List<qlua.rpc.GetQuoteLevel2.QuoteEntry> bids = ImmutableList.of(
                qlua.rpc.GetQuoteLevel2.QuoteEntry.newBuilder().setPrice("1").setQuantity("100").build(),
                qlua.rpc.GetQuoteLevel2.QuoteEntry.newBuilder().setPrice("2").setQuantity("200").build(),
                qlua.rpc.GetQuoteLevel2.QuoteEntry.newBuilder().setPrice("3").setQuantity("300").build(),
                qlua.rpc.GetQuoteLevel2.QuoteEntry.newBuilder().setPrice("4").setQuantity("400").build()
        );

        final List<qlua.rpc.GetQuoteLevel2.QuoteEntry> offers = ImmutableList.of(
                qlua.rpc.GetQuoteLevel2.QuoteEntry.newBuilder().setPrice("5").setQuantity("500").build(),
                qlua.rpc.GetQuoteLevel2.QuoteEntry.newBuilder().setPrice("6").setQuantity("600").build(),
                qlua.rpc.GetQuoteLevel2.QuoteEntry.newBuilder().setPrice("7").setQuantity("700").build()
        );

        return qlua.rpc.GetQuoteLevel2.Result.newBuilder()
                .addAllBids(bids)
                .addAllOffers(offers)
                .setBidCount(BID_COUNT)
                .setOfferCount(OFFER_COUNT)
                .build();
    }
}
