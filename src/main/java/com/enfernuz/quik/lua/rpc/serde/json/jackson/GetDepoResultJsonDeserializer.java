package com.enfernuz.quik.lua.rpc.serde.json.jackson;

import com.enfernuz.quik.lua.rpc.api.structures.Depo;
import com.enfernuz.quik.lua.rpc.api.messages.GetDepo;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;

final class GetDepoResultJsonDeserializer extends JsonDeserializer<GetDepo.Result> {

    @Override
    public GetDepo.Result deserialize(final JsonParser p, final DeserializationContext ctxt) throws IOException {

        final ObjectCodec objectCodec = p.getCodec();
        final JsonNode node = objectCodec.readTree(p);
        final Depo depo = node.get("depo").traverse(objectCodec).readValueAs(Depo.class);
        return new GetDepo.Result(depo);
    }
}