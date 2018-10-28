package wip;

import com.enfernuz.quik.lua.rpc.api.messages.datasource.SetEmptyCallback;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class DatasourceSetEmptyCallbackJsonSerdeTests {

    public static class RpcArgsSerializationTest extends AbstractJsonRpcArgsSerializationTest<SetEmptyCallback.Args> {

        @Override
        public SetEmptyCallback.Args getArgsObject() {
            return new SetEmptyCallback.Args("1");
        }

        @Override
        public String getArgsJsonPath() {
            return "json/datasource/SetEmptyCallback/args.json";
        }
    }

    public static class RpcTrueResultDeserializationTest extends AbstractRpcResultJsonDeserializationTest<SetEmptyCallback.Result> {

        @Override
        public String getJsonPath() {
            return "json/datasource/SetEmptyCallback/true.result.json";
        }

        @Override
        public SetEmptyCallback.Result getExpectedObject() {
            return SetEmptyCallback.Result.getInstance(true);
        }
    }

    public static class RpcFalseResultDeserializationTest extends AbstractRpcResultJsonDeserializationTest<SetEmptyCallback.Result> {

        @Override
        public String getJsonPath() {
            return "json/datasource/SetEmptyCallback/false.result.json";
        }

        @Override
        public SetEmptyCallback.Result getExpectedObject() {
            return SetEmptyCallback.Result.getInstance(false);
        }
    }
}
