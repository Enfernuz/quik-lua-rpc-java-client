package com.enfernuz.quik.lua.rpc.serde.json.jackson;

import com.enfernuz.quik.lua.rpc.api.structures.*;
import com.fasterxml.jackson.databind.module.SimpleSerializers;

final class QluaJsonJacksonSerializers extends SimpleSerializers {

    public QluaJsonJacksonSerializers() {

        super();

        super.addSerializer(AddColumn.Request.class, new AddColumnRequestJsonSerializer());
        super.addSerializer(AddLabel.Request.class, new AddLabelRequestJsonSerializer());
        super.addSerializer(AllocTable.Request.class, new AllocTableRequestJsonSerializer());
        super.addSerializer(CalcBuySell.Request.class, new CalcBuySellRequestJsonSerializer());
        super.addSerializer(CancelParamRequest.Request.class, new CancelParamRequestRequestJsonSerializer());
        super.addSerializer(Message.Request.class, new MessageRequestJsonSerializer());
    }
}
