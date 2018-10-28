package wip;

import com.enfernuz.quik.lua.rpc.api.messages.datasource.O;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class DatasourceOJsonSerdeTests {

    public static class RpcArgsSerializationTest extends AbstractJsonRpcArgsSerializationTest<O.Args> {

        @Override
        public O.Args getArgsObject() {
            return new O.Args("1", 2);
        }

        @Override
        public String getArgsJsonPath() {
            return "json/datasource/O/args.json";
        }
    }

    public static class RpcResultDeserializationTest extends AbstractRpcResultJsonDeserializationTest<O.Result> {

        @Override
        public String getJsonPath() {
            return "json/datasource/O/result.json";
        }

        @Override
        public O.Result getExpectedObject() {
            return new O.Result("1");
        }
    }
}
