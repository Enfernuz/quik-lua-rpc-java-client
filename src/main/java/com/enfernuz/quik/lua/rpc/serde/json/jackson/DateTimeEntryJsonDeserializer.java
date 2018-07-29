package com.enfernuz.quik.lua.rpc.serde.json.jackson;

import com.enfernuz.quik.lua.rpc.api.structures.DateTimeEntry;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;

final class DateTimeEntryJsonDeserializer extends JsonDeserializer<DateTimeEntry> {

    @Override
    public DateTimeEntry deserialize(final JsonParser jsonParser, final DeserializationContext deserializationContext)
            throws IOException {

        final JsonNode node = jsonParser.getCodec().readTree(jsonParser);

        return DateTimeEntry
                .builder()
                .mcs( node.get("mcs").asInt() )
                .ms( node.get("ms").asInt() )
                .sec( node.get("sec").asInt() )
                .min( node.get("min").asInt() )
                .hour( node.get("hour").asInt() )
                .day( node.get("day").asInt() )
                .weekDay( node.get("week_day").asInt() )
                .month( node.get("month").asInt() )
                .year( node.get("year").asInt() )
                .build();
    }
}
