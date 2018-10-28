package wip;

import com.enfernuz.quik.lua.rpc.api.messages.IsConnected;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class IsConnectedJsonSerdeTests {

    public static class RpcTrueResultDeserializationTest extends AbstractRpcResultJsonDeserializationTest<IsConnected.Result> {

        @Override
        public String getJsonPath() {
            return "json/isConnected/1.result.json";
        }

        @Override
        public IsConnected.Result getExpectedObject() {
            return IsConnected.Result.getInstance(1);
        }
    }

    public static class RpcFalseResultDeserializationTest extends AbstractRpcResultJsonDeserializationTest<IsConnected.Result> {

        @Override
        public String getJsonPath() {
            return "json/isConnected/0.result.json";
        }

        @Override
        public IsConnected.Result getExpectedObject() {
            return IsConnected.Result.getInstance(0);
        }
    }

    public static class RpcOtherResultDeserializationTest extends AbstractRpcResultJsonDeserializationTest<IsConnected.Result> {

        @Override
        public String getJsonPath() {
            return "json/isConnected/other.result.json";
        }

        @Override
        public IsConnected.Result getExpectedObject() {
            return IsConnected.Result.getInstance(123);
        }
    }
}
