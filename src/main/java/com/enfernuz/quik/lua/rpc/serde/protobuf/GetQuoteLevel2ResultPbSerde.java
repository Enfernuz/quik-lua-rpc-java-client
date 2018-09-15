package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetQuoteLevel2;
import com.enfernuz.quik.lua.rpc.serde.PbConverter;
import com.enfernuz.quik.lua.rpc.serde.Serde;
import com.google.common.collect.ImmutableList;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;

import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.convertFromPbQuoteEntry;
import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.convertToPbQuoteEntry;

enum GetQuoteLevel2ResultPbSerde implements Serde<GetQuoteLevel2.Result>, PbConverter<qlua.rpc.GetQuoteLevel2.Result, GetQuoteLevel2.Result> {

    INSTANCE;

    @Override
    public byte[] serialize(final GetQuoteLevel2.Result result) {
        return convertToPb(result).toByteArray();
    }

    @NotNull
    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public GetQuoteLevel2.Result deserialize(final byte[] data) {
        return convertFromPb( qlua.rpc.GetQuoteLevel2.Result.parseFrom(data) );
    }

    @Override
    public GetQuoteLevel2.Result convertFromPb(@NotNull final qlua.rpc.GetQuoteLevel2.Result result) {

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

    @Override
    public qlua.rpc.GetQuoteLevel2.Result convertToPb(@NotNull final GetQuoteLevel2.Result result) {

        final qlua.rpc.GetQuoteLevel2.Result.Builder pbResult = qlua.rpc.GetQuoteLevel2.Result.newBuilder();

        for (final GetQuoteLevel2.QuoteEntry bid : result.getBids()) {
            pbResult.addBids( convertToPbQuoteEntry(bid) );
        }

        for (final GetQuoteLevel2.QuoteEntry offer : result.getOffers()) {
            pbResult.addOffers( convertToPbQuoteEntry(offer) );
        }

        return pbResult
                .setBidCount( result.getBidCount() )
                .setOfferCount( result.getOfferCount() )
                .build();
    }
}
