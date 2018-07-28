package com.enfernuz.quik.lua.rpc.serde.json.jackson;

import com.enfernuz.quik.lua.rpc.api.structures.GetBuySellInfo;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;

import static com.enfernuz.quik.lua.rpc.serde.json.jackson.QluaJsonJacksonUtils.asText;

final class BuySellInfoJsonDeserializer extends JsonDeserializer<GetBuySellInfo.BuySellInfo> {

    @Override
    public GetBuySellInfo.BuySellInfo deserialize(final JsonParser p, final DeserializationContext ctxt) throws IOException {

        final JsonNode node = p.getCodec().readTree(p);

        return GetBuySellInfo.BuySellInfo
                .builder()
                .isMarginSec( asText(node, "is_margin_sec") )
                .isAssetSec( asText(node, "is_asset_sec") )
                .balance( asText(node, "balance") )
                .canBuy( asText(node, "can_buy") )
                .canSell( asText(node, "can_sell") )
                .positionValuation( asText(node, "position_valuation") )
                .value( asText(node, "value") )
                .openValue( asText(node, "open_value") )
                .limLong( asText(node, "lim_long") )
                .longCoef( asText(node, "long_coef") )
                .limShort( asText(node, "lim_short") )
                .shortCoef( asText(node, "short_coef") )
                .valueCoef( asText(node, "value_coef") )
                .openValueCoef( asText(node, "open_value_coef") )
                .share( asText(node, "share") )
                .shortWaPrice( asText(node, "short_wa_price") )
                .longWaPrice( asText(node, "long_wa_price") )
                .profitLoss( asText(node, "profit_loss") )
                .spreadHc( asText(node, "spread_hc") )
                .canBuyOwn( asText(node, "can_buy_own") )
                .canSellOwn( asText(node, "can_sell_own") )
                .build();
    }
}
