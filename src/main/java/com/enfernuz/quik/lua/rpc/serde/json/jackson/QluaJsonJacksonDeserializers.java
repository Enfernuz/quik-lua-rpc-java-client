package com.enfernuz.quik.lua.rpc.serde.json.jackson;

import com.enfernuz.quik.lua.rpc.events.api.structures.AllTrade;
import com.enfernuz.quik.lua.rpc.events.api.structures.DateTimeEntry;
import com.enfernuz.quik.lua.rpc.events.api.structures.Firm;
import com.enfernuz.quik.lua.rpc.events.api.structures.MoneyLimit;
import com.fasterxml.jackson.databind.module.SimpleDeserializers;

final class QluaJsonJacksonDeserializers extends SimpleDeserializers {

    public QluaJsonJacksonDeserializers() {

        super();

        super.addDeserializer(Firm.class, new FirmJsonDeserializer());
        super.addDeserializer(AllTrade.class, new AllTradeJsonDeserializer());
        super.addDeserializer(MoneyLimit.class, new MoneyLimitJsonDeserializer());
        super.addDeserializer(DateTimeEntry.class, new DateTimeEntryJsonDeserializer());
    }
}
