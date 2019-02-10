package com.enfernuz.quik.lua.rpc.serde.json;

import com.enfernuz.quik.lua.rpc.api.messages.SendTransaction;
import com.google.common.collect.ImmutableMap;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class SendTransactionJsonSerdeTest {

    public static class JsonRpcArgsSerializationTest extends AbstractJsonRpcArgsSerializationTest<SendTransaction.Args> {

        @Override
        public String getArgsJsonPath() {
            return "json/sendTransaction/args.json";
        }

        @Override
        public SendTransaction.Args getArgsObject() {

            return new SendTransaction.Args(
                            ImmutableMap.of(
                                    "key_1", "value_1",
                                    "key_2", "value_2",
                                    "key_3", "value_3"
                            )
                    );
        }
    }

    public static class JsonRpcResultDeserializationTest extends AbstractRpcResultJsonDeserializationTest<SendTransaction.Result> {

        @Override
        public String getJsonPath() {
            return "json/sendTransaction/result.json";
        }

        @Override
        public SendTransaction.Result getExpectedObject() {
            return new SendTransaction.Result("1");
        }
    }
}
