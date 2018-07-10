package com.enfernuz.quik.lua.rpc.serde.json.jackson;

import com.enfernuz.quik.lua.rpc.events.api.structures.MoneyLimit;
import com.fasterxml.jackson.databind.module.SimpleDeserializers;

public class QluaJsonJacksonDeserializers extends SimpleDeserializers {

    public QluaJsonJacksonDeserializers() {

        super();

        super.addDeserializer(MoneyLimit.class, new MoneyLimitJsonDeserializer());
    }
}
