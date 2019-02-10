package com.enfernuz.quik.lua.rpc.serde.json;

import com.enfernuz.quik.lua.rpc.api.messages.GetSecurityInfo;
import com.enfernuz.quik.lua.rpc.api.structures.Security;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class GetSecurityInfoJsonSerdeTest {

    public static class RpcArgsSerializationTest extends AbstractJsonRpcArgsSerializationTest<GetSecurityInfo.Args> {

        @Override
        public GetSecurityInfo.Args getArgsObject() {

            return GetSecurityInfo.Args.builder()
                    .classCode("1")
                    .secCode("2")
                    .build();
        }

        @Override
        public String getArgsJsonPath() {
            return "json/getSecurityInfo/args.json";
        }
    }

    public static class RpcResultDeserializationTest extends AbstractRpcResultJsonDeserializationTest<GetSecurityInfo.Result> {

        @Override
        public String getJsonPath() {
            return "json/getSecurityInfo/result.json";
        }

        @Override
        public GetSecurityInfo.Result getExpectedObject() {

            final Security security = Security.builder()
                    .code(SecurityParameters.CODE)
                    .name(SecurityParameters.NAME)
                    .shortName(SecurityParameters.SHORT_NAME)
                    .classCode(SecurityParameters.CLASS_CODE)
                    .className(SecurityParameters.CLASS_NAME)
                    .faceValue(SecurityParameters.FACE_VALUE)
                    .faceUnit(SecurityParameters.FACE_UNIT)
                    .scale(SecurityParameters.SCALE)
                    .matDate(SecurityParameters.MAT_DATE)
                    .lotSize(SecurityParameters.LOT_SIZE)
                    .isinCode(SecurityParameters.ISIN_CODE)
                    .minPriceStep(SecurityParameters.MIN_PRICE_STEP)
                    .build();

            return GetSecurityInfo.Result.getInstance(security);
        }

        private static final class SecurityParameters {

            private static final String CODE = "1";
            private static final String NAME = "2";
            private static final String SHORT_NAME = "3";
            private static final String CLASS_CODE = "4";
            private static final String CLASS_NAME = "5";
            private static final String FACE_VALUE = "6";
            private static final String FACE_UNIT = "7";
            private static final String SCALE = "8";
            private static final String MAT_DATE = "9";
            private static final String LOT_SIZE = "10";
            private static final String ISIN_CODE = "11";
            private static final String MIN_PRICE_STEP = "12";
        }
    }

    public static class RpcErrorResultDeserializationTest extends AbstractRpcResultJsonDeserializationTest<GetSecurityInfo.Result> {

        @Override
        public String getJsonPath() {
            return "json/getSecurityInfo/error.result.json";
        }

        @Override
        public GetSecurityInfo.Result getExpectedObject() {
            return GetSecurityInfo.Result.getErrorInstance();
        }
    }
}
