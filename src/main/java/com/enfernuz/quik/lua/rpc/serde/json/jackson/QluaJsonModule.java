package com.enfernuz.quik.lua.rpc.serde.json.jackson;

import com.fasterxml.jackson.databind.module.SimpleModule;

public class QluaJsonModule extends SimpleModule {

    @Override
    public void setupModule(SetupContext context) {

        super.setupModule(context);

        context.addDeserializers( new QluaJsonJacksonDeserializers() );
    }
}
