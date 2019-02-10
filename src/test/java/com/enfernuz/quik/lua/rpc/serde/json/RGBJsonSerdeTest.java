package com.enfernuz.quik.lua.rpc.serde.json;

import com.enfernuz.quik.lua.rpc.api.messages.RGB;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class RGBJsonSerdeTest {

    public static class RpcArgsSerializationTest extends AbstractJsonRpcArgsSerializationTest<RGB.Args> {

        @Override
        public RGB.Args getArgsObject() {

            return RGB.Args.builder()
                    .red(1)
                    .green(2)
                    .blue(3)
                    .build();
        }

        @Override
        public String getArgsJsonPath() {
            return "json/RGB/args.json";
        }
    }

    public static class RpcResultDeserializationTest extends AbstractRpcResultJsonDeserializationTest<RGB.Result> {

        @Override
        public String getJsonPath() {
            return "json/RGB/result.json";
        }

        @Override
        public RGB.Result getExpectedObject() {
            return new RGB.Result(1);
        }
    }
}
