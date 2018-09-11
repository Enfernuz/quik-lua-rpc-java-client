package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetLabelParams;
import com.enfernuz.quik.lua.rpc.serde.SerdeModule;
import com.google.common.collect.ImmutableMap;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GetLabelParamsResultPbSerdeTest {

    private static SerdeModule sut;

    private static GetLabelParams.Result expectedObject;
    private static byte[] expectedPbInput;

    private static GetLabelParams.Result expectedObjectWithOnlyRequiredFields;
    private static byte[] expectedPbInputWithOnlyRequiredFields;

    @BeforeClass
    public static void globalSetup() {

        sut = ProtobufSerdeModule.INSTANCE;

        final Map<String, String> labelParams = ImmutableMap.of(
                "key1", "value1",
                "key2", "value2",
                "key3", "value3"
        );

        expectedObject = GetLabelParams.Result.getInstance(labelParams);
        expectedPbInput = qlua.rpc.GetLabelParams.Result.newBuilder()
                .putAllLabelParams(labelParams)
                .build()
                .toByteArray();

        expectedObjectWithOnlyRequiredFields = GetLabelParams.Result.getInstance(null);
        expectedPbInputWithOnlyRequiredFields = qlua.rpc.GetLabelParams.Result.newBuilder().build().toByteArray();
    }

    @Test
    public void testSerialize() {

        assertTrue(
                Arrays.equals(expectedPbInput, sut.serialize(expectedObject))
        );
    }

    @Test
    public void testDeserialize() {
        assertEquals(expectedObject, sut.deserialize(GetLabelParams.Result.class, expectedPbInput));
    }

    @Test
    public void testSerialize_WithOnlyRequiredFields() {

        assertTrue(
                Arrays.equals(
                        expectedPbInputWithOnlyRequiredFields,
                        sut.serialize(expectedObjectWithOnlyRequiredFields)
                )
        );
    }

    @Test
    public void testDeserialize_WithOnlyRequiredFields() {

        assertEquals(
                expectedObjectWithOnlyRequiredFields,
                sut.deserialize(GetLabelParams.Result.class, expectedPbInputWithOnlyRequiredFields)
        );
    }
}
