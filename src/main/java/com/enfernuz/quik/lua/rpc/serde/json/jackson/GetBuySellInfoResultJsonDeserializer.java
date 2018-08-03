package com.enfernuz.quik.lua.rpc.serde.json.jackson;

import com.enfernuz.quik.lua.rpc.api.messages.GetBuySellInfo;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;

final class GetBuySellInfoResultJsonDeserializer extends JsonDeserializer<GetBuySellInfo.Result> {

    @Override
    public GetBuySellInfo.Result deserialize(final JsonParser p, final DeserializationContext ctxt) throws IOException {

        final ObjectCodec objectCodec = p.getCodec();
        final JsonNode node = objectCodec.readTree(p);

        final GetBuySellInfo.BuySellInfo buySellInfo =
                node.get("buy_sell_info").traverse(objectCodec).readValueAs(GetBuySellInfo.BuySellInfo.class);

        return new GetBuySellInfo.Result(buySellInfo);
    }
}
