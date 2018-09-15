package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.structures.Security;
import org.jetbrains.annotations.NotNull;
import org.junit.Test;
import qlua.structs.QluaStructures;

public class SecurityPbSerdeTest extends AbstractPbSerdeTest<Security, QluaStructures.Security> {

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

    @Override
    public @NotNull Class<Security> getTargetObjectClass() {
        return Security.class;
    }

    @NotNull
    @Override
    public QluaStructures.Security getTargetObjectAsPbMessage() {
        return QluaStructures.Security.newBuilder()
                .setCode(CODE)
                .setName(NAME)
                .setShortName(SHORT_NAME)
                .setClassCode(CLASS_CODE)
                .setClassName(CLASS_NAME)
                .setFaceValue(FACE_VALUE)
                .setFaceUnit(FACE_UNIT)
                .setScale(SCALE)
                .setMatDate(MAT_DATE)
                .setLotSize(LOT_SIZE)
                .setIsinCode(ISIN_CODE)
                .setMinPriceStep(MIN_PRICE_STEP)
                .build();
    }

    @NotNull
    @Override
    public Security getTargetObject() {
        return Security.builder()
                .code(CODE)
                .name(NAME)
                .shortName(SHORT_NAME)
                .classCode(CLASS_CODE)
                .className(CLASS_NAME)
                .faceValue(FACE_VALUE)
                .faceUnit(FACE_UNIT)
                .scale(SCALE)
                .matDate(MAT_DATE)
                .lotSize(LOT_SIZE)
                .isinCode(ISIN_CODE)
                .minPriceStep(MIN_PRICE_STEP)
                .build();
    }

    @Test
    @Override
    public void testSerializeErrorObject() {
        super.testSerializeErrorObject();
    }

    @Test
    @Override
    public void testDeserializeErrorObject() {
        super.testDeserializeErrorObject();
    }

    @NotNull
    @Override
    public QluaStructures.Security getErrorObject_AsPbMessage() {
        return QluaStructures.Security.newBuilder().build();
    }

    @NotNull
    @Override
    public Security getErrorObject() {
        return Security.builder().build();
    }
}
