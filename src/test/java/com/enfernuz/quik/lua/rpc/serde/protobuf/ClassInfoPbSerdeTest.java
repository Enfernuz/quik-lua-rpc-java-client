package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.structures.ClassInfo;
import com.enfernuz.quik.lua.rpc.serde.SerdeModule;
import org.junit.BeforeClass;
import org.junit.Test;
import qlua.structs.QluaStructures;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ClassInfoPbSerdeTest {

    private static SerdeModule sut;

    private static ClassInfo expectedObject;
    private static byte[] expectedPbInput;

    @BeforeClass
    public static void globalSetup() {

        sut = ProtobufSerdeModule.INSTANCE;

        expectedObject = ClassInfo.builder()
                .firmId("1")
                .name("2")
                .code("3")
                .npars(4)
                .nsecs(5)
                .build();
        expectedPbInput = QluaStructures.Klass.newBuilder()
                .setFirmid("1")
                .setName("2")
                .setCode("3")
                .setNpars(4)
                .setNsecs(5)
                .build()
                .toByteArray();
    }

    @Test
    public void testSerialize() {

        final byte[] actual = sut.serialize(expectedObject);

        assertTrue( Arrays.equals(expectedPbInput, actual) );
    }

    @Test
    public void testDeserialize() {

        final ClassInfo actualObject = sut.deserialize(ClassInfo.class, expectedPbInput);

        assertEquals(actualObject, expectedObject);
    }
}
