package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetSecurityInfo;
import com.enfernuz.quik.lua.rpc.api.structures.Security;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import org.jetbrains.annotations.NotNull;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import qlua.structs.QluaStructures;

@RunWith(Enclosed.class)
public class GetSecurityInfoResultPbSerdeTest  {

    public static class Ok_GetSecurityInfoResultPbSerdeTest extends AbstractPbDeserializationTest<qlua.rpc.GetSecurityInfo.Result, GetSecurityInfo.Result> {

        @Override
        public @NotNull Deserializer<GetSecurityInfo.Result> getDeserializerUnderTest() {
            return GetSecurityInfoResultPbDeserializer.INSTANCE;
        }

        @NotNull
        @Override
        public GetSecurityInfo.Result getTargetObject() {

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

        @NotNull
        @Override
        public qlua.rpc.GetSecurityInfo.Result getTargetObjectAsPbMessage() {

            final QluaStructures.Security security = QluaStructures.Security.newBuilder()
                    .setCode(SecurityParameters.CODE)
                    .setName(SecurityParameters.NAME)
                    .setShortName(SecurityParameters.SHORT_NAME)
                    .setClassCode(SecurityParameters.CLASS_CODE)
                    .setClassName(SecurityParameters.CLASS_NAME)
                    .setFaceValue(SecurityParameters.FACE_VALUE)
                    .setFaceUnit(SecurityParameters.FACE_UNIT)
                    .setScale(SecurityParameters.SCALE)
                    .setMatDate(SecurityParameters.MAT_DATE)
                    .setLotSize(SecurityParameters.LOT_SIZE)
                    .setIsinCode(SecurityParameters.ISIN_CODE)
                    .setMinPriceStep(SecurityParameters.MIN_PRICE_STEP)
                    .build();

            return qlua.rpc.GetSecurityInfo.Result.newBuilder()
                    .setSecurityInfo(security)
                    .build();
        }
    }

    public static class Error_GetSecurityInfoResultPbSerdeTest extends AbstractPbDeserializationTest<qlua.rpc.GetSecurityInfo.Result, GetSecurityInfo.Result> {

        @Override
        public @NotNull Deserializer<GetSecurityInfo.Result> getDeserializerUnderTest() {
            return GetSecurityInfoResultPbDeserializer.INSTANCE;
        }

        @NotNull
        @Override
        public GetSecurityInfo.Result getTargetObject() {
            return GetSecurityInfo.Result.getErrorInstance();
        }

        @NotNull
        @Override
        public qlua.rpc.GetSecurityInfo.Result getTargetObjectAsPbMessage() {
            return qlua.rpc.GetSecurityInfo.Result.newBuilder().build();
        }
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
