package com.enfernuz.quik.lua.rpc.serde.json.jackson;

import com.enfernuz.quik.lua.rpc.api.messages.SendTransaction;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.util.Map;

final class SendTransactionRequestJsonSerializer extends JsonSerializer<SendTransaction.Request> {

    @Override
    public void serialize(final SendTransaction.Request value, final JsonGenerator gen, final SerializerProvider serializers) throws IOException {

        QluaJsonJacksonUtils.prepareJsonGeneratorForMethod(gen, "sendTransaction");
        gen.writeObjectFieldStart("transaction");
        for (final Map.Entry<String, String> entry : value.getTransaction().entrySet()) {
            gen.writeStringField(entry.getKey(), entry.getValue());
        }
        gen.writeEndObject();
        QluaJsonJacksonUtils.finishJsonGenerator(gen);
    }
}
