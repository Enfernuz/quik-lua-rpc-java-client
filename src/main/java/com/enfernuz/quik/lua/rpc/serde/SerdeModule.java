package com.enfernuz.quik.lua.rpc.serde;

import com.enfernuz.quik.lua.rpc.events.api.QluaEvent;
import com.enfernuz.quik.lua.rpc.events.api.structures.Firm;
import com.enfernuz.quik.lua.rpc.events.api.structures.MoneyLimit;

public interface SerdeModule {

    Serde<QluaEvent.EventType> getQluaEventTypeSerde();

    Deserializer<Firm> getFirmDeserializer();

    Deserializer<MoneyLimit> getMoneyLimitDeserializer();
}
