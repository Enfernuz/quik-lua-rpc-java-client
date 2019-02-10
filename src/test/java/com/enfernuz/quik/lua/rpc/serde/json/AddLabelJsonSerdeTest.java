package com.enfernuz.quik.lua.rpc.serde.json;

import com.enfernuz.quik.lua.rpc.api.messages.AddLabel;
import com.google.common.collect.ImmutableMap;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class AddLabelJsonSerdeTest {

    public static class JsonRpcArgsSerializationTest extends AbstractJsonRpcArgsSerializationTest<AddLabel.Args> {

        @Override
        public String getArgsJsonPath() {
            return "json/AddLabel/args.json";
        }

        @Override
        public AddLabel.Args getArgsObject() {

            return AddLabel.Args.builder()
                    .chartTag("1")
                    .labelParams(
                            ImmutableMap.of(
                                    "k1", "v1",
                                    "k2", "v2",
                                    "k3", "v3"
                            )
                    ).build();
        }
    }

    public static class JsonRpcResultDeserializationTest extends AbstractRpcResultJsonDeserializationTest<AddLabel.Result> {

        @Override
        public String getJsonPath() {
            return "json/AddLabel/result.json";
        }

        @Override
        public AddLabel.Result getExpectedObject() {
            return new AddLabel.Result(1);
        }
    }
}
