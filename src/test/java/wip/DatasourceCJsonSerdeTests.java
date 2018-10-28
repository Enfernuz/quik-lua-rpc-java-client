package wip;

import com.enfernuz.quik.lua.rpc.api.messages.datasource.C;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class DatasourceCJsonSerdeTests {

    public static class RpcArgsSerializationTest extends AbstractJsonRpcArgsSerializationTest<C.Args> {

        @Override
        public C.Args getArgsObject() {
            return new C.Args("1", 2);
        }

        @Override
        public String getArgsJsonPath() {
            return "json/datasource/C/args.json";
        }
    }

    public static class RpcResultDeserializationTest extends AbstractRpcResultJsonDeserializationTest<C.Result> {

        @Override
        public String getJsonPath() {
            return "json/datasource/C/result.json";
        }

        @Override
        public C.Result getExpectedObject() {
            return new C.Result("1");
        }
    }
}
