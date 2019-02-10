package com.enfernuz.quik.lua.rpc.serde.json;

import com.enfernuz.quik.lua.rpc.api.messages.GetWindowRect;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class GetWindowRectJsonSerdeTest {

    public static class RpcArgsSerializationTest extends AbstractJsonRpcArgsSerializationTest<GetWindowRect.Args> {

        @Override
        public GetWindowRect.Args getArgsObject() {
            return new GetWindowRect.Args(1);
        }

        @Override
        public String getArgsJsonPath() {
            return "json/GetWindowRect/args.json";
        }
    }

    public static class RpcResultDeserializationTest extends AbstractRpcResultJsonDeserializationTest<GetWindowRect.Result> {

        @Override
        public String getJsonPath() {
            return "json/GetWindowRect/result.json";
        }

        @Override
        public GetWindowRect.Result getExpectedObject() {

            final GetWindowRect.WindowRect windowRect = GetWindowRect.WindowRect.builder()
                    .top(1)
                    .left(2)
                    .bottom(3)
                    .right(4)
                    .build();

            return GetWindowRect.Result.getInstance(windowRect);
        }
    }

    public static class RpcErrorResultDeserializationTest extends AbstractRpcResultJsonDeserializationTest<GetWindowRect.Result> {

        @Override
        public String getJsonPath() {
            return "json/GetWindowRect/error.result.json";
        }

        @Override
        public GetWindowRect.Result getExpectedObject() {
            return GetWindowRect.Result.getErrorInstance();
        }
    }
}
