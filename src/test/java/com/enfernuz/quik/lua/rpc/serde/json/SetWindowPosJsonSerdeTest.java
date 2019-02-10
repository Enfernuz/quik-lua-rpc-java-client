package com.enfernuz.quik.lua.rpc.serde.json;

import com.enfernuz.quik.lua.rpc.api.messages.SetWindowPos;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class SetWindowPosJsonSerdeTest {

    public static class RpcArgsSerializationTest extends AbstractJsonRpcArgsSerializationTest<SetWindowPos.Args> {

        @Override
        public SetWindowPos.Args getArgsObject() {

            return SetWindowPos.Args.builder()
                    .tId(1)
                    .x(2)
                    .y(3)
                    .dx(4)
                    .dy(5)
                    .build();
        }

        @Override
        public String getArgsJsonPath() {
            return "json/SetWindowPos/args.json";
        }
    }

    public static class RpcTrueResultDeserializationTest extends AbstractRpcResultJsonDeserializationTest<SetWindowPos.Result> {

        @Override
        public String getJsonPath() {
            return "json/SetWindowPos/true.result.json";
        }

        @Override
        public SetWindowPos.Result getExpectedObject() {
            return SetWindowPos.Result.getInstance(true);
        }
    }

    public static class RpcFalseResultDeserializationTest extends AbstractRpcResultJsonDeserializationTest<SetWindowPos.Result> {

        @Override
        public String getJsonPath() {
            return "json/SetWindowPos/false.result.json";
        }

        @Override
        public SetWindowPos.Result getExpectedObject() {
            return SetWindowPos.Result.getInstance(false);
        }
    }
}
