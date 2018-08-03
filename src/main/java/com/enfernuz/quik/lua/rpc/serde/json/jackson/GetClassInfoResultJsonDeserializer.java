package com.enfernuz.quik.lua.rpc.serde.json.jackson;

import com.enfernuz.quik.lua.rpc.api.structures.ClassInfo;
import com.enfernuz.quik.lua.rpc.api.messages.GetClassInfo;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;

final class GetClassInfoResultJsonDeserializer extends JsonDeserializer<GetClassInfo.Result> {

    @Override
    public GetClassInfo.Result deserialize(final JsonParser p, final DeserializationContext ctxt) throws IOException {

        final ObjectCodec objectCodec = p.getCodec();
        final JsonNode node = objectCodec.readTree(p);

        final ClassInfo classInfo =
                node.get("class_info")
                        .traverse(objectCodec)
                        .readValueAs(ClassInfo.class);

        return new GetClassInfo.Result(classInfo);
    }
}
