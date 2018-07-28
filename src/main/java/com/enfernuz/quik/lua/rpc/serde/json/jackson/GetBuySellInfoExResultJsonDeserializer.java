package com.enfernuz.quik.lua.rpc.serde.json.jackson;

import com.enfernuz.quik.lua.rpc.api.structures.GetBuySellInfo;
import com.enfernuz.quik.lua.rpc.api.structures.GetBuySellInfoEx;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;

final class GetBuySellInfoExResultJsonDeserializer extends JsonDeserializer<GetBuySellInfoEx.Result> {

    @Override
    public GetBuySellInfoEx.Result deserialize(final JsonParser p, final DeserializationContext ctxt) throws IOException {

        final ObjectCodec objectCodec = p.getCodec();
        final JsonNode node = objectCodec.readTree(p);

        final GetBuySellInfoEx.BuySellInfoEx buySellInfoEx =
                node.get("buy_sell_info_ex").traverse(objectCodec).readValueAs(GetBuySellInfoEx.BuySellInfoEx.class);

        return new GetBuySellInfoEx.Result(buySellInfoEx);
    }
}
