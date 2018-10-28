package wip;

import com.enfernuz.quik.lua.rpc.api.messages.datasource.L;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class DatasourceLJsonSerdeTests {

    public static class RpcArgsSerializationTest extends AbstractJsonRpcArgsSerializationTest<L.Args> {

        @Override
        public L.Args getArgsObject() {
            return new L.Args("1", 2);
        }

        @Override
        public String getArgsJsonPath() {
            return "json/datasource/L/args.json";
        }
    }

    public static class RpcResultDeserializationTest extends AbstractRpcResultJsonDeserializationTest<L.Result> {

        @Override
        public String getJsonPath() {
            return "json/datasource/L/result.json";
        }

        @Override
        public L.Result getExpectedObject() {
            return new L.Result("1");
        }
    }
}
