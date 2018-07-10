package com.enfernuz.quik.lua.rpc.serde.json;

import com.enfernuz.quik.lua.rpc.events.api.QluaEvent;
import com.enfernuz.quik.lua.rpc.events.api.structures.Firm;
import com.enfernuz.quik.lua.rpc.events.api.structures.MoneyLimit;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import com.enfernuz.quik.lua.rpc.serde.Serde;
import com.enfernuz.quik.lua.rpc.serde.SerdeModule;
import com.enfernuz.quik.lua.rpc.serde.json.jackson.QluaJsonModule;
import com.fasterxml.jackson.databind.ObjectMapper;

public enum JsonSerdeModule implements SerdeModule {

    INSTANCE;

    private final Deserializer<MoneyLimit> moneyLimitDeserializer;

    private JsonSerdeModule() {

        final ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule( new QluaJsonModule() );

        this.moneyLimitDeserializer =  new JsonMoneyLimitDeserializer(objectMapper);
    }

    @Override
    public Serde<QluaEvent.EventType> getQluaEventTypeSerde() {
        return JsonQluaEventTypeSerde.INSTANCE;
    }

    @Override
    public Deserializer<Firm> getFirmDeserializer() {
        return null;
    }

    @Override
    public Deserializer<MoneyLimit> getMoneyLimitDeserializer() {
        return moneyLimitDeserializer;
    }
}
