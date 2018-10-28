package wip;

import com.enfernuz.quik.lua.rpc.api.messages.datasource.Size;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class DatasourceSizeJsonSerdeTests {

    public static class RpcArgsSerializationTest extends AbstractJsonRpcArgsSerializationTest<Size.Args> {

        @Override
        public Size.Args getArgsObject() {
            return new Size.Args("1");
        }

        @Override
        public String getArgsJsonPath() {
            return "json/datasource/Size/args.json";
        }
    }

    public static class RpcResultDeserializationTest extends AbstractRpcResultJsonDeserializationTest<Size.Result> {

        @Override
        public String getJsonPath() {
            return "json/datasource/Size/result.json";
        }

        @Override
        public Size.Result getExpectedObject() {
            return new Size.Result(1);
        }
    }
}
