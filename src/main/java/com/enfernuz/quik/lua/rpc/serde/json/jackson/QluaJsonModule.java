package com.enfernuz.quik.lua.rpc.serde.json.jackson;

import com.fasterxml.jackson.databind.module.SimpleModule;

public final class QluaJsonModule extends SimpleModule {

    @Override
    public void setupModule(SetupContext context) {

        super.setupModule(context);

        context.addSerializers( new QluaJsonJacksonSerializers() );
        context.addDeserializers( new QluaJsonJacksonDeserializers() );
    }
}
