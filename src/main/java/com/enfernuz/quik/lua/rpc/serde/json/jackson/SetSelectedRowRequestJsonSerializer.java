package com.enfernuz.quik.lua.rpc.serde.json.jackson;

import com.enfernuz.quik.lua.rpc.api.messages.SetSelectedRow;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

final class SetSelectedRowRequestJsonSerializer extends JsonSerializer<SetSelectedRow.Request> {

    @Override
    public void serialize(final SetSelectedRow.Request value, final JsonGenerator gen, final SerializerProvider serializers) throws IOException {

        QluaJsonJacksonUtils.prepareJsonGeneratorForMethod(gen, "SetSelectedRow");
        gen.writeNumberField("table_id", value.getTableId());
        gen.writeNumberField("row", value.getRow());
        QluaJsonJacksonUtils.finishJsonGenerator(gen);
    }
}
