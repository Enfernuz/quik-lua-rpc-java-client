package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetClassesList;
import com.enfernuz.quik.lua.rpc.serde.SerdeModule;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GetClassesListResultPbSerdeTest {

    private static SerdeModule sut;

    private static GetClassesList.Result expectedObject;
    private static byte[] expectedPbInput;

    private static GetClassesList.Result expectedObjectWithOnlyRequiredFields;
    private static byte[] expectedPbInputWithOnlyRequiredFields;

    @BeforeClass
    public static void globalSetup() {

        sut = ProtobufSerdeModule.INSTANCE;

        expectedObject = new GetClassesList.Result("1");
        expectedPbInput = qlua.rpc.GetClassesList.Result.newBuilder()
                .setClassesList("1")
                .build()
                .toByteArray();

        expectedObjectWithOnlyRequiredFields = new GetClassesList.Result(null);
        expectedPbInputWithOnlyRequiredFields = qlua.rpc.GetClassesList.Result.newBuilder().build().toByteArray();
    }

    @Test
    public void testSerialize() {

        final byte[] actual = sut.serialize(expectedObject);

        assertTrue( Arrays.equals(expectedPbInput, actual) );
    }

    @Test
    public void testDeserialize() {

        final GetClassesList.Result actualObject = sut.deserialize(GetClassesList.Result.class, expectedPbInput);

        assertEquals(actualObject, expectedObject);
    }

    @Test
    public void testSerializeWithOnlyRequiredFields() {

        final byte[] actual = sut.serialize(expectedObjectWithOnlyRequiredFields);

        assertTrue( Arrays.equals(expectedPbInputWithOnlyRequiredFields, actual) );
    }

    @Test
    public void testDeserializeWithOnlyRequiredFields() {

        final GetClassesList.Result actualObject = sut.deserialize(GetClassesList.Result.class, expectedPbInputWithOnlyRequiredFields);

        assertEquals(actualObject, expectedObjectWithOnlyRequiredFields);
    }
}
