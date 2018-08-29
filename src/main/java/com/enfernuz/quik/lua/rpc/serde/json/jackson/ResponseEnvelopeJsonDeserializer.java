package com.enfernuz.quik.lua.rpc.serde.json.jackson;

import com.enfernuz.quik.lua.rpc.api.ServiceError;
import com.enfernuz.quik.lua.rpc.api.structures.ResponseEnvelope;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

final class ResponseEnvelopeJsonDeserializer extends JsonDeserializer<ResponseEnvelope> {

    @Override
    public ResponseEnvelope deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {

        final ObjectCodec objectCodec = p.getCodec();
        final JsonNode rootNode = objectCodec.readTree(p);
        final JsonNode errorNode = rootNode.get("error");
        final ResponseEnvelope result;
        if (errorNode != null) {
            result = ResponseEnvelope.withError(
                    errorNode.traverse(objectCodec).readValueAs(ServiceError.class)
            );
        } else {
            final JsonNode resultNode = rootNode.get("result");
            if (resultNode == null) {
                throw new JsonParseException(
                        p,
                        "В JSON-представлении ответа от RPC-сервиса одновременно отсутствуют узлы 'error' и 'result'."
                );
            } else {
                // Might be a possible performance issue here, as the JSON string is converted to bytes and then
                // the bytes are probably converted back to a UTF-8 string by Jackson during the further deserialization.
                result = ResponseEnvelope.withResult( resultNode.toString().getBytes(StandardCharsets.UTF_8) );
            }
        }

        return result;
    }
}
