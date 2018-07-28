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
        super.addSerializer(Clear.Request.class, new ClearRequestJsonSerializer());
        super.addSerializer(CreateWindow.Request.class, new CreateWindowRequestJsonSerializer());
        super.addSerializer(DelAllLabels.Request.class, new DelAllLabelsRequestJsonSerializer());
        super.addSerializer(DeleteRow.Request.class, new DeleteRowRequestJsonSerializer());
        super.addSerializer(DelLabel.Request.class, new DelLabelRequestJsonSerializer());
        super.addSerializer(DestroyTable.Request.class, new DestroyTableRequestJsonSerializer());
        super.addSerializer(GetBuySellInfo.Request.class, new GetBuySellInfoRequestJsonSerializer());
        super.addSerializer(GetBuySellInfoEx.Request.class, new GetBuySellInfoExRequestJsonSerializer());
        super.addSerializer(Message.Request.class, new MessageRequestJsonSerializer());
    }
}
