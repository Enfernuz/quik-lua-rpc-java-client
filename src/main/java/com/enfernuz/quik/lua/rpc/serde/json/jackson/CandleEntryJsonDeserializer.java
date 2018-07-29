package com.enfernuz.quik.lua.rpc.serde.json.jackson;

import com.enfernuz.quik.lua.rpc.api.structures.CandleEntry;
import com.enfernuz.quik.lua.rpc.api.structures.DateTimeEntry;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;

import static com.enfernuz.quik.lua.rpc.serde.json.jackson.QluaJsonJacksonUtils.asText;

final class CandleEntryJsonDeserializer extends JsonDeserializer<CandleEntry> {

    @Override
    public CandleEntry deserialize(final JsonParser p, final DeserializationContext ctxt) throws IOException {

        final ObjectCodec objectCodec = p.getCodec();
        final JsonNode node = objectCodec.readTree(p);

        return CandleEntry
                .builder()
                .open( asText(node, "open") )
                .close( asText(node, "close") )
                .high( asText(node, "high") )
                .low( asText(node, "low") )
                .volume( asText(node, "volume") )
                .dateTimeEntry( node.get("datetime").traverse(objectCodec).readValueAs(DateTimeEntry.class) )
                .doesExist( node.get("does_exist").asInt() )
                .build();
    }
}
