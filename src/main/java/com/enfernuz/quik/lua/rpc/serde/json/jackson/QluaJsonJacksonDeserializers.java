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
        super.addDeserializer(Message.Result.class, new MessageResultJsonDeserializer());
    }
}
