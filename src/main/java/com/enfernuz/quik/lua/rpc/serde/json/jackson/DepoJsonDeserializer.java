package com.enfernuz.quik.lua.rpc.serde.json.jackson;

import com.enfernuz.quik.lua.rpc.api.structures.Depo;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;

import static com.enfernuz.quik.lua.rpc.serde.json.jackson.QluaJsonJacksonUtils.asText;

final class DepoJsonDeserializer extends JsonDeserializer<Depo> {

    @Override
    public Depo deserialize(final JsonParser p, final DeserializationContext ctxt) throws IOException {

        final JsonNode node = p.getCodec().readTree(p);
        return Depo
                .builder()
                .depoLimitLockedBuyValue( asText(node, "depo_limit_locked_buy_value") )
                .depoCurrentBalance( asText(node, "depo_current_balance") )
                .depoLimitLockedBuy( asText(node, "depo_limit_locked_buy") )
                .depoLimitLocked( asText(node, "depo_limit_locked") )
                .depoLimitAvailable( asText(node, "depo_limit_available") )
                .depoCurrentLimit( asText(node, "depo_current_limit") )
                .depoOpenBalance( asText(node, "depo_open_balance") )
                .depoOpenLimit( asText(node, "depo_open_limit") )
                .build();
    }
}
