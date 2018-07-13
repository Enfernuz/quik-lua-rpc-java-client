package com.enfernuz.quik.lua.rpc.serde.json.jackson;

import com.enfernuz.quik.lua.rpc.events.api.structures.Firm;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;

import static com.enfernuz.quik.lua.rpc.serde.json.jackson.QluaJsonJacksonUtils.asText;

public final class FirmJsonDeserializer extends JsonDeserializer<Firm> {

    @Override
    public Firm deserialize(final JsonParser jsonParser, final DeserializationContext deserializationContext)
            throws IOException {

        final JsonNode node = jsonParser.getCodec().readTree(jsonParser);
        return Firm
                .builder()
                .firmId( node.get("firmid").asText() )
                .firmName( asText(node, "firm_name") )
                .status( node.get("status").asInt() )
                .exchange( asText(node, "exchange") )
                .build();
    }
}
