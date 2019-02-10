package com.enfernuz.quik.lua.rpc.serde.json;

import com.enfernuz.quik.lua.rpc.api.messages.GetScriptPath;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class GetScriptPathJsonSerdeTest {

    public static class JsonRpcResultDeserializationTest extends AbstractRpcResultJsonDeserializationTest<GetScriptPath.Result> {

        @Override
        public String getJsonPath() {
            return "json/getScriptPath/result.json";
        }

        @Override
        public GetScriptPath.Result getExpectedObject() {
            return new GetScriptPath.Result("1");
        }
    }
}
