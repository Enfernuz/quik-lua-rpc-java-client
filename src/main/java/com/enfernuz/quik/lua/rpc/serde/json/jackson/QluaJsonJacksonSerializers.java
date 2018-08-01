package com.enfernuz.quik.lua.rpc.serde.json.jackson;

import com.enfernuz.quik.lua.rpc.api.structures.*;
import com.enfernuz.quik.lua.rpc.api.structures.GetCandlesByIndex;
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
        super.addSerializer(GetCandlesByIndex.Request.class, new GetCandlesByIndexRequestJsonSerializer());
        super.addSerializer(GetCell.Request.class, new GetCellRequestJsonSerializer());
        super.addSerializer(GetClassesList.Request.class, new GetClassesListRequestJsonSerializer());
        super.addSerializer(GetClassInfo.Request.class, new GetClassInfoRequestJsonSerializer());
        super.addSerializer(GetClassSecurities.Request.class, new GetClassSecuritiesRequestJsonSerializer());
        super.addSerializer(GetDepo.Request.class, new GetDepoRequestJsonSerializer());
        super.addSerializer(GetDepoEx.Request.class, new GetDepoExRequestJsonSerializer());
        super.addSerializer(GetFuturesHolding.Request.class, new GetFuturesHoldingRequestJsonSerializer());
        super.addSerializer(GetFuturesLimit.Request.class, new GetFuturesLimitRequestJsonSerializer());
        super.addSerializer(Message.Request.class, new MessageRequestJsonSerializer());
    }
}
