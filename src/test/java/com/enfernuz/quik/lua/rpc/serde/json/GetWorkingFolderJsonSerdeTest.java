package com.enfernuz.quik.lua.rpc.serde.json;

import com.enfernuz.quik.lua.rpc.api.messages.GetWorkingFolder;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class GetWorkingFolderJsonSerdeTest {

    public static class JsonRpcResultDeserializationTest extends AbstractRpcResultJsonDeserializationTest<GetWorkingFolder.Result> {

        @Override
        public String getJsonPath() {
            return "json/getWorkingFolder/result.json";
        }

        @Override
        public GetWorkingFolder.Result getExpectedObject() {
            return new GetWorkingFolder.Result("1");
        }
    }
}
