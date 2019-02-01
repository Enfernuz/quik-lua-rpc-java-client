package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetQuoteLevel2;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import com.google.common.collect.ImmutableList;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;

import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.convertFromPbQuoteEntry;

enum GetQuoteLevel2ResultPbDeserializer implements Deserializer<GetQuoteLevel2.Result>, FromPbConverter<qlua.rpc.GetQuoteLevel2.Result, GetQuoteLevel2.Result> {

    INSTANCE;

    @NotNull
    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public GetQuoteLevel2.Result deserialize(final byte[] data) {
        return convert( qlua.rpc.GetQuoteLevel2.Result.parseFrom(data) );
    }

    @Override
    public GetQuoteLevel2.Result convert(@NotNull final qlua.rpc.GetQuoteLevel2.Result result) {

        final ImmutableList.Builder<GetQuoteLevel2.QuoteEntry> bids = ImmutableList.builder();
        for (final qlua.rpc.GetQuoteLevel2.QuoteEntry bid : result.getBidsList()) {
            bids.add( convertFromPbQuoteEntry(bid) );
        }

        final ImmutableList.Builder<GetQuoteLevel2.QuoteEntry> offers = ImmutableList.builder();
        for (final qlua.rpc.GetQuoteLevel2.QuoteEntry offer : result.getOffersList()) {
            offers.add( convertFromPbQuoteEntry(offer) );
        }

        return GetQuoteLevel2.Result.builder()
                .bidCount( result.getBidCount() )
                .offerCount( result.getOfferCount() )
                .bids( bids.build() )
                .offers( offers.build() )
                .build();
    }
}
