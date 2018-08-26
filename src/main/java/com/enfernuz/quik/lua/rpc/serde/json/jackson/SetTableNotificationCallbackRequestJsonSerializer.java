package com.enfernuz.quik.lua.rpc.serde.json.jackson;

import com.enfernuz.quik.lua.rpc.api.messages.SetTableNotificationCallback;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

final class SetTableNotificationCallbackRequestJsonSerializer extends JsonSerializer<SetTableNotificationCallback.Request> {

    @Override
    public void serialize(final SetTableNotificationCallback.Request value, final JsonGenerator gen, final SerializerProvider serializers) throws IOException {

        QluaJsonJacksonUtils.prepareJsonGeneratorForMethod(gen, "SetTableNotificationCallback");
        gen.writeNumberField("t_id", value.getTId());
        gen.writeStringField("f_cb_def", value.getFCbDef());
        QluaJsonJacksonUtils.finishJsonGenerator(gen);
    }
}
