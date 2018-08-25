package com.enfernuz.quik.lua.rpc.serde.json.jackson;

import com.enfernuz.quik.lua.rpc.api.messages.*;
import com.enfernuz.quik.lua.rpc.api.messages.GetCandlesByIndex;
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
        super.addSerializer(GetInfoParam.Request.class, new GetInfoParamRequestJsonSerializer());
        super.addSerializer(GetItem.Request.class, new GetItemRequestJsonSerializer());
        super.addSerializer(GetLabelParams.Request.class, new GetLabelParamsRequestJsonSerializer());
        super.addSerializer(GetLinesCount.Request.class, new GetLinesCountRequestJsonSerializer());
        super.addSerializer(GetMoney.Request.class, new GetMoneyRequestJsonSerializer());
        super.addSerializer(GetMoneyEx.Request.class, new GetMoneyExRequestJsonSerializer());
        super.addSerializer(GetNumberOf.Request.class, new GetNumberOfRequestJsonSerializer());
        super.addSerializer(GetNumCandles.Request.class, new GetNumCandlesRequestJsonSerializer());
        super.addSerializer(GetOrderByNumber.Request.class, new GetOrderByNumberRequestJsonSerializer());
        super.addSerializer(GetPortfolioInfo.Request.class, new GetPortfolioInfoRequestJsonSerializer());
        super.addSerializer(GetPortfolioInfoEx.Request.class, new GetPortfolioInfoExRequestJsonSerializer());
        super.addSerializer(GetQuoteLevel2.Request.class, new GetQuoteLevel2RequestJsonSerializer());
        super.addSerializer(GetScriptPath.Request.class, new GetScriptPathRequestJsonSerializer());
        super.addSerializer(GetSecurityInfo.Request.class, new GetSecurityInfoRequestJsonSerializer());
        super.addSerializer(GetTableSize.Request.class, new GetTableSizeRequestJsonSerializer());
        super.addSerializer(GetTradeDate.Request.class, new GetTradeDateRequestJsonSerializer());
        super.addSerializer(GetWindowCaption.Request.class, new GetWindowCaptionRequestJsonSerializer());
        super.addSerializer(GetWindowRect.Request.class, new GetWindowRectRequestJsonSerializer());
        super.addSerializer(Message.Request.class, new MessageRequestJsonSerializer());
    }
}
