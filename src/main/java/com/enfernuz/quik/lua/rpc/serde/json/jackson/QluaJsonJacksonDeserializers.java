package com.enfernuz.quik.lua.rpc.serde.json.jackson;

import com.enfernuz.quik.lua.rpc.events.api.structures.*;
import com.fasterxml.jackson.databind.module.SimpleDeserializers;

final class QluaJsonJacksonDeserializers extends SimpleDeserializers {

    public QluaJsonJacksonDeserializers() {

        super();

        super.addDeserializer(StopEventInfo.class, new StopEventInfoJsonDeserializer());
        super.addDeserializer(ConnectedEventInfo.class, new ConnectedEventInfoJsonDeserializer());
        super.addDeserializer(Firm.class, new FirmJsonDeserializer());
        super.addDeserializer(AllTrade.class, new AllTradeJsonDeserializer());
        super.addDeserializer(Trade.class, new TradeJsonDeserializer());
        super.addDeserializer(MoneyLimit.class, new MoneyLimitJsonDeserializer());
        super.addDeserializer(DateTimeEntry.class, new DateTimeEntryJsonDeserializer());
    }
}
