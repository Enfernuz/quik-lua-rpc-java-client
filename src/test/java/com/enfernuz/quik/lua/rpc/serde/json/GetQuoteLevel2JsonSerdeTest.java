package com.enfernuz.quik.lua.rpc.serde.json;

import com.enfernuz.quik.lua.rpc.api.messages.GetQuoteLevel2;
import com.google.common.collect.ImmutableList;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import java.util.List;

@RunWith(Enclosed.class)
public class GetQuoteLevel2JsonSerdeTest {

    public static class RpcArgsSerializationTest extends AbstractJsonRpcArgsSerializationTest<GetQuoteLevel2.Args> {

        @Override
        public GetQuoteLevel2.Args getArgsObject() {

            return GetQuoteLevel2.Args.builder()
                    .classCode("1")
                    .secCode("2")
                    .build();
        }

        @Override
        public String getArgsJsonPath() {
            return "json/getQuoteLevel2/args.json";
        }
    }

    public static class RpcResultDeserializationTest extends AbstractRpcResultJsonDeserializationTest<GetQuoteLevel2.Result> {

        @Override
        public String getJsonPath() {
            return "json/getQuoteLevel2/result.json";
        }

        @Override
        public GetQuoteLevel2.Result getExpectedObject() {

            final List<GetQuoteLevel2.QuoteEntry> bids = ImmutableList.of(
                    GetQuoteLevel2.QuoteEntry.builder().price("1").quantity("100").build(),
                    GetQuoteLevel2.QuoteEntry.builder().price("2").quantity("200").build(),
                    GetQuoteLevel2.QuoteEntry.builder().price("3").quantity("300").build(),
                    GetQuoteLevel2.QuoteEntry.builder().price("4").quantity("400").build()
            );

            final List<GetQuoteLevel2.QuoteEntry> offers = ImmutableList.of(
                    GetQuoteLevel2.QuoteEntry.builder().price("5").quantity("500").build(),
                    GetQuoteLevel2.QuoteEntry.builder().price("6").quantity("600").build(),
                    GetQuoteLevel2.QuoteEntry.builder().price("7").quantity("700").build()
            );

            return GetQuoteLevel2.Result.builder()
                    .bids(bids)
                    .offers(offers)
                    .bidCount("4")
                    .offerCount("3")
                    .build();
        }
    }
}
