package com.enfernuz.quik.lua.rpc.serde.json.jackson;

import com.enfernuz.quik.lua.rpc.api.structures.ClassInfo;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;

import static com.enfernuz.quik.lua.rpc.serde.json.jackson.QluaJsonJacksonUtils.asText;

final class ClassInfoJsonDeserializer extends JsonDeserializer<ClassInfo> {

    @Override
    public ClassInfo deserialize(final JsonParser p, final DeserializationContext ctxt) throws IOException {

        final JsonNode node = p.getCodec().readTree(p);
        return ClassInfo
                .builder()
                .firmId( asText(node, "firmid") )
                .name( asText(node, "name") )
                .code( asText(node, "code") )
                .npars( node.get("npars").asInt() )
                .nsecs( node.get("nsecs").asInt() )
                .build();
    }
}
