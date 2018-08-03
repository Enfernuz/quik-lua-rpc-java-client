package com.enfernuz.quik.lua.rpc.serde.json.jackson;

import com.enfernuz.quik.lua.rpc.api.messages.GetBuySellInfo;
import com.enfernuz.quik.lua.rpc.api.messages.GetBuySellInfoEx;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;

import static com.enfernuz.quik.lua.rpc.serde.json.jackson.QluaJsonJacksonUtils.asText;

final class BuySellInfoExJsonDeserializer extends JsonDeserializer<GetBuySellInfoEx.BuySellInfoEx> {

    @Override
    public GetBuySellInfoEx.BuySellInfoEx deserialize(final JsonParser p, final DeserializationContext ctxt) throws IOException {

        final ObjectCodec objectCodec = p.getCodec();
        final JsonNode node = objectCodec.readTree(p);

        final GetBuySellInfo.BuySellInfo buySellInfo =
                node.get("buy_sell_info").traverse(objectCodec).readValueAs(GetBuySellInfo.BuySellInfo.class);

        return GetBuySellInfoEx.BuySellInfoEx
                .builder()
                .buySellInfo(buySellInfo)
                .limitKind( asText(node, "limit_kind") )
                .dLong( asText(node, "d_long") )
                .dMinLong( asText(node, "d_min_long") )
                .dShort( asText(node, "d_short") )
                .dMinShort( asText(node, "d_min_short") )
                .clientType( asText(node, "client_type") )
                .isLongAllowed( asText(node, "is_long_allowed") )
                .isShortAllowed( asText(node, "is_short_allowed") )
                .build();
    }
}
