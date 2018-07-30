package com.enfernuz.quik.lua.rpc.serde.json.jackson;

import com.enfernuz.quik.lua.rpc.api.structures.DepoLimit;
import com.enfernuz.quik.lua.rpc.api.structures.GetDepoEx;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;

final class GetDepoExResultJsonDeserializer extends JsonDeserializer<GetDepoEx.Result> {

    @Override
    public GetDepoEx.Result deserialize(final JsonParser p, final DeserializationContext ctxt) throws IOException {

        final ObjectCodec objectCodec = p.getCodec();
        final JsonNode node = objectCodec.readTree(p);
        final DepoLimit depoEx = node.get("depo_ex").traverse(objectCodec).readValueAs(DepoLimit.class);

        return new GetDepoEx.Result(depoEx);
    }
}
