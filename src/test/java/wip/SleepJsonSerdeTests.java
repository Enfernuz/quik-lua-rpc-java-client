package wip;

import com.enfernuz.quik.lua.rpc.api.messages.Sleep;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class SleepJsonSerdeTests {

    public static class RpcFullArgsSerializationTest extends AbstractJsonRpcArgsSerializationTest<Sleep.Args> {

        @Override
        public Sleep.Args getArgsObject() {
            return new Sleep.Args(1);
        }

        @Override
        public String getArgsJsonPath() {
            return "json/sleep/args.json";
        }
    }

    public static class RpcResultDeserializationTest extends AbstractRpcResultJsonDeserializationTest<Sleep.Result> {

        @Override
        public String getJsonPath() {
            return "json/sleep/result.json";
        }

        @Override
        public Sleep.Result getExpectedObject() {
            return Sleep.Result.getInstance(1);
        }
    }

    public static class RpcErrorResultDeserializationTest extends AbstractRpcResultJsonDeserializationTest<Sleep.Result> {

        @Override
        public String getJsonPath() {
            return "json/sleep/error.result.json";
        }

        @Override
        public Sleep.Result getExpectedObject() {
            return Sleep.Result.getErrorInstance();
        }
    }
}
