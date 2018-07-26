package com.enfernuz.quik.lua.rpc.serde.json.jackson;

import com.enfernuz.quik.lua.rpc.api.structures.AddColumn;
import com.fasterxml.jackson.databind.module.SimpleSerializers;

final class QluaJsonJacksonSerializers extends SimpleSerializers {

    public QluaJsonJacksonSerializers() {

        super();

        super.addSerializer(AddColumn.Request.class, new AddColumnRequestJsonSerializer());
    }
}
