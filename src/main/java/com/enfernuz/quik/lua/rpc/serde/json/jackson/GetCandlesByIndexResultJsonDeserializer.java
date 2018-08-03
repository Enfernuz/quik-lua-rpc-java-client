package com.enfernuz.quik.lua.rpc.serde.json.jackson;

import com.enfernuz.quik.lua.rpc.api.structures.CandleEntry;
import com.enfernuz.quik.lua.rpc.api.messages.GetCandlesByIndex;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.collect.ImmutableList;

import java.io.IOException;
import java.util.Iterator;

import static com.enfernuz.quik.lua.rpc.serde.json.jackson.QluaJsonJacksonUtils.asText;

final class GetCandlesByIndexResultJsonDeserializer extends JsonDeserializer<GetCandlesByIndex.Result> {

    @Override
    public GetCandlesByIndex.Result deserialize(final JsonParser p, final DeserializationContext ctxt) throws IOException {

        final ObjectCodec objectCodec = p.getCodec();
        final JsonNode node = objectCodec.readTree(p);

        final ImmutableList.Builder<CandleEntry> candleEntries = ImmutableList.builder();
        final Iterator<JsonNode> candleEntryIterator = node.get("t").elements();
        while ( candleEntryIterator.hasNext() ) {
            final CandleEntry candleEntry =
                    candleEntryIterator.next()
                            .traverse(objectCodec)
                            .readValueAs(CandleEntry.class);
            candleEntries.add(candleEntry);
        }

        final int n = node.get("n").asInt();
        final String l = asText(node, "l");

        return new GetCandlesByIndex.Result(candleEntries.build(), n, l);
    }
}
