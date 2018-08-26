package com.enfernuz.quik.lua.rpc.serde.json.jackson;

import com.enfernuz.quik.lua.rpc.api.messages.SearchItems;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.google.common.base.Strings;

import java.io.IOException;

final class SearchItemsRequestJsonSerializer extends JsonSerializer<SearchItems.Request> {

    @Override
    public void serialize(final SearchItems.Request value, final JsonGenerator gen, final SerializerProvider serializers) throws IOException {

        QluaJsonJacksonUtils.prepareJsonGeneratorForMethod(gen, "SearchItems");
        gen.writeStringField("table_name", value.getTableName());
        gen.writeNumberField("start_index", value.getStartIndex());
        gen.writeNumberField("end_index", value.getEndIndex());
        gen.writeStringField("fn_def", value.getFnDef());
        final String params = value.getParams();
        if ( !Strings.isNullOrEmpty(params) ) {
            gen.writeStringField("params", params);
        }
        QluaJsonJacksonUtils.finishJsonGenerator(gen);
    }
}
