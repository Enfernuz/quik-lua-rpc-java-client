package com.enfernuz.quik.lua.rpc.serde.json.jackson;

import com.enfernuz.quik.lua.rpc.api.structures.GetDepo;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

final class GetDepoRequestJsonSerializer extends JsonSerializer<GetDepo.Request> {

    @Override
    public void serialize(final GetDepo.Request value, final JsonGenerator gen, final SerializerProvider serializers) throws IOException {

        QluaJsonJacksonUtils.prepareJsonGeneratorForMethod(gen, "getDepo");

        gen.writeStringField("client_code", value.getClientCode());
        gen.writeStringField("firmid", value.getFirmId());
        gen.writeStringField("sec_code", value.getSecCode());
        gen.writeStringField("trdaccid", value.getTrdAccId());

        QluaJsonJacksonUtils.finishJsonGenerator(gen);
    }
}
