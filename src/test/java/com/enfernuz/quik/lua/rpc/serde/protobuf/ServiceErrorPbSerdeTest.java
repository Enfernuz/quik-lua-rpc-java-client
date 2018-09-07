package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.ServiceError;
import com.enfernuz.quik.lua.rpc.serde.SerdeModule;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ServiceErrorPbSerdeTest {

    private static SerdeModule sut;

    private static ServiceError expectedObject;
    private static byte[] expectedPbInput;

    private static ServiceError expectedObjectWithOnlyRequiredFields;
    private static byte[] expectedPbInputWithOnlyRequiredFields;

    @BeforeClass
    public static void globalSetup() {

        sut = ProtobufSerdeModule.INSTANCE;

        expectedObject = new ServiceError(500, "Ошибочка вышла.");
        expectedPbInput = qlua.rpc.RPC.Error.newBuilder()
                .setCode(500)
                .setMessage("Ошибочка вышла.")
                .build()
                .toByteArray();

        expectedObjectWithOnlyRequiredFields = new ServiceError(404, null);
        expectedPbInputWithOnlyRequiredFields = qlua.rpc.RPC.Error.newBuilder()
                .setCode(404)
                .build()
                .toByteArray();
    }

    @Test
    public void testSerialize() {

        final byte[] actual = sut.serialize(expectedObject);

        assertTrue( Arrays.equals(expectedPbInput, actual) );
    }

    @Test
    public void testSerializePbInputWithEmptyNonRequiredStringFields() {

        final byte[] actual = sut.serialize(expectedObjectWithOnlyRequiredFields);

        assertTrue( Arrays.equals(expectedPbInputWithOnlyRequiredFields, actual) );
    }

    @Test
    public void testDeserialize() {

        final ServiceError actualObject = sut.deserialize(ServiceError.class, expectedPbInput);

        assertEquals(actualObject, expectedObject);
    }

    @Test
    public void testDeserializePbInputWithEmptyNonRequiredStringFields() {

        final ServiceError actualObject = sut.deserialize(ServiceError.class, expectedPbInputWithOnlyRequiredFields);

        assertEquals(actualObject, expectedObjectWithOnlyRequiredFields);
    }
}
