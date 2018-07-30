package com.enfernuz.quik.lua.rpc.serde.json.jackson;

import com.enfernuz.quik.lua.rpc.api.structures.*;
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
        super.addDeserializer(Order.class, new OrderJsonDeserializer());
        super.addDeserializer(AccountBalance.class, new AccountBalanceJsonDeserializer());
        super.addDeserializer(FuturesLimit.class, new FuturesLimitJsonDeserializer());
        super.addDeserializer(FuturesLimitDelete.class, new FuturesLimitDeleteJsonDeserializer());
        super.addDeserializer(FuturesClientHolding.class, new FuturesClientHoldingJsonDeserializer());
        super.addDeserializer(MoneyLimit.class, new MoneyLimitJsonDeserializer());
        super.addDeserializer(MoneyLimitDelete.class, new MoneyLimitDeleteJsonDeserializer());
        super.addDeserializer(DepoLimit.class, new DepoLimitJsonDeserializer());
        super.addDeserializer(DepoLimitDelete.class, new DepoLimitDeleteJsonDeserializer());
        super.addDeserializer(AccountPosition.class, new AccountPositionJsonDeserializer());
        super.addDeserializer(NegDeal.class, new NegDealJsonDeserializer());
        super.addDeserializer(NegTrade.class, new NegTradeJsonDeserializer());
        super.addDeserializer(StopOrder.class, new StopOrderJsonDeserializer());
        super.addDeserializer(TransReply.class, new TransReplyJsonDeserializer());
        super.addDeserializer(ParamEventInfo.class, new ParamEventInfoJsonDeserializer());
        super.addDeserializer(QuoteEventInfo.class, new QuoteEventInfoJsonDeserializer());
        super.addDeserializer(DateTimeEntry.class, new DateTimeEntryJsonDeserializer());

        super.addDeserializer(AddColumn.Result.class, new AddColumnResultJsonDeserializer());
        super.addDeserializer(AddLabel.Result.class, new AddLabelResultJsonDeserializer());
        super.addDeserializer(AllocTable.Result.class, new AllocTableResultJsonDeserializer());
        super.addDeserializer(CalcBuySell.Result.class, new CalcBuySellResultJsonDeserializer());
        super.addDeserializer(CancelParamRequest.Result.class, new CancelParamRequestResultJsonDeserializer());
        super.addDeserializer(Clear.Result.class, new ClearResultJsonDeserializer());
        super.addDeserializer(CreateWindow.Result.class, new CreateWindowResultJsonDeserializer());
        super.addDeserializer(DelAllLabels.Result.class, new DelAllLabelsResultJsonDeserializer());
        super.addDeserializer(DeleteRow.Result.class, new DeleteRowResultJsonDeserializer());
        super.addDeserializer(DelLabel.Result.class, new DelLabelResultJsonDeserializer());
        super.addDeserializer(DestroyTable.Result.class, new DestroyTableResultJsonDeserializer());
        super.addDeserializer(GetBuySellInfo.BuySellInfo.class, new BuySellInfoJsonDeserializer());
        super.addDeserializer(GetBuySellInfo.Result.class, new GetBuySellInfoResultJsonDeserializer());
        super.addDeserializer(GetBuySellInfoEx.BuySellInfoEx.class, new BuySellInfoExJsonDeserializer());
        super.addDeserializer(GetBuySellInfoEx.Result.class, new GetBuySellInfoExResultJsonDeserializer());
        super.addDeserializer(CandleEntry.class, new CandleEntryJsonDeserializer());
        super.addDeserializer(GetCandlesByIndex.Result.class, new GetCandlesByIndexResultJsonDeserializer());
        super.addDeserializer(GetCell.Result.class, new GetCellResultJsonDeserializer());
        super.addDeserializer(GetClassesList.Result.class, new GetClassesListResultJsonDeserializer());
        super.addDeserializer(ClassInfo.class, new ClassInfoJsonDeserializer());
        super.addDeserializer(GetClassInfo.Result.class, new GetClassInfoResultJsonDeserializer());
        super.addDeserializer(GetClassSecurities.Result.class, new GetClassSecuritiesResultJsonDeserializer());
        super.addDeserializer(Depo.class, new DepoJsonDeserializer());
        super.addDeserializer(GetDepo.Result.class, new GetDepoResultJsonDeserializer());
        super.addDeserializer(GetDepoEx.Result.class, new GetDepoExResultJsonDeserializer());
        super.addDeserializer(Message.Result.class, new MessageResultJsonDeserializer());
    }
}
