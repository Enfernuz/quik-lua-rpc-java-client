package wip;

import com.enfernuz.quik.lua.rpc.api.messages.GetClassesList;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class GetClassesListJsonSerdeTests {

    public static class JsonRpcResultDeserializationTest extends AbstractRpcResultJsonDeserializationTest<GetClassesList.Result> {

        @Override
        public String getJsonPath() {
            return "json/getClassesList/result.json";
        }

        @Override
        public GetClassesList.Result getExpectedObject() {
            return new GetClassesList.Result("1");
        }
    }
}
