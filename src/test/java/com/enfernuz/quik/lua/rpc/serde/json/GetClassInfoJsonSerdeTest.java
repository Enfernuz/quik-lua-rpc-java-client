package com.enfernuz.quik.lua.rpc.serde.json;

import com.enfernuz.quik.lua.rpc.api.messages.GetClassInfo;
import com.enfernuz.quik.lua.rpc.api.structures.ClassInfo;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class GetClassInfoJsonSerdeTest {

    public static class RpcArgsSerializationTest extends AbstractJsonRpcArgsSerializationTest<GetClassInfo.Args> {

        @Override
        public GetClassInfo.Args getArgsObject() {
            return new GetClassInfo.Args("1");
        }

        @Override
        public String getArgsJsonPath() {
            return "json/getClassInfo/args.json";
        }
    }

    public static class RpcResultDeserializationTest extends AbstractRpcResultJsonDeserializationTest<GetClassInfo.Result> {

        @Override
        public String getJsonPath() {
            return "json/getClassInfo/result.json";
        }

        @Override
        public GetClassInfo.Result getExpectedObject() {

            final ClassInfo classInfo = ClassInfo.builder()
                    .firmId("1")
                    .name("2")
                    .code("3")
                    .npars(4)
                    .nsecs(5)
                    .build();

            return new GetClassInfo.Result(classInfo);
        }
    }
}
