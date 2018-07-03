package com.enfernuz.quik.lua.rpc.serde;

import com.enfernuz.quik.lua.rpc.events.api.QluaEvent;
import com.enfernuz.quik.lua.rpc.events.api.structures.Firm;

public interface SerdeModule {

    Serde<QluaEvent.EventType> getQluaEventTypeSerde();

    Serde<Firm> getFirmSerde();
}
