package wip;

import com.enfernuz.quik.lua.rpc.api.messages.datasource.V;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class DatasourceVJsonSerdeTests {

    public static class RpcArgsSerializationTest extends AbstractJsonRpcArgsSerializationTest<V.Args> {

        @Override
        public V.Args getArgsObject() {
            return new V.Args("1", 2);
        }

        @Override
        public String getArgsJsonPath() {
            return "json/datasource/V/args.json";
        }
    }

    public static class RpcResultDeserializationTest extends AbstractRpcResultJsonDeserializationTest<V.Result> {

        @Override
        public String getJsonPath() {
            return "json/datasource/V/result.json";
        }

        @Override
        public V.Result getExpectedObject() {
            return new V.Result("1");
        }
    }
}
