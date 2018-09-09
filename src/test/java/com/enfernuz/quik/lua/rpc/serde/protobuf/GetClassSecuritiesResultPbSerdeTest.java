package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetClassSecurities;
import com.enfernuz.quik.lua.rpc.serde.SerdeModule;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GetClassSecuritiesResultPbSerdeTest {

    private static SerdeModule sut;

    private static GetClassSecurities.Result expectedObject;
    private static byte[] expectedPbInput;

    private static GetClassSecurities.Result expectedObjectWithOnlyRequiredFields;
    private static byte[] expectedPbInputWithOnlyRequiredFields;

    @BeforeClass
    public static void globalSetup() {

        sut = ProtobufSerdeModule.INSTANCE;

        expectedObject = new GetClassSecurities.Result("1");
        expectedPbInput = qlua.rpc.GetClassesList.Result.newBuilder()
                .setClassesList("1")
                .build()
                .toByteArray();

        expectedObjectWithOnlyRequiredFields = new GetClassSecurities.Result(null);
        expectedPbInputWithOnlyRequiredFields = qlua.rpc.GetClassesList.Result.newBuilder().build().toByteArray();
    }

    @Test
    public void testSerialize() {

        assertTrue(
                Arrays.equals(expectedPbInput, sut.serialize(expectedObject))
        );
    }

    @Test
    public void testDeserialize() {
        assertEquals(expectedObject, sut.deserialize(GetClassSecurities.Result.class, expectedPbInput));
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
                sut.deserialize(GetClassSecurities.Result.class, expectedPbInputWithOnlyRequiredFields)
        );
    }
}
