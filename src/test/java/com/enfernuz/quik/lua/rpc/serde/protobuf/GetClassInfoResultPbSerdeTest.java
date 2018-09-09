package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetClassInfo;
import com.enfernuz.quik.lua.rpc.api.structures.ClassInfo;
import com.enfernuz.quik.lua.rpc.serde.SerdeModule;
import org.junit.BeforeClass;
import org.junit.Test;
import qlua.structs.QluaStructures;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GetClassInfoResultPbSerdeTest {

    private static SerdeModule sut;

    private static GetClassInfo.Result expectedObject;
    private static byte[] expectedPbInput;

    private static GetClassInfo.Result expectedObjectWithOnlyRequiredFields;
    private static byte[] expectedPbInputWithOnlyRequiredFields;

    @BeforeClass
    public static void globalSetup() {

        sut = ProtobufSerdeModule.INSTANCE;

        final ClassInfo classInfo = ClassInfo.builder()
                .firmId("1")
                .name("2")
                .code("3")
                .npars(4)
                .nsecs(5)
                .build();
        final QluaStructures.Klass pbClassInfo = QluaStructures.Klass.newBuilder()
                .setFirmid("1")
                .setName("2")
                .setCode("3")
                .setNpars(4)
                .setNsecs(5)
                .build();

        expectedObject = new GetClassInfo.Result(classInfo);
        expectedPbInput = qlua.rpc.GetClassInfo.Result.newBuilder()
                .setClassInfo(pbClassInfo)
                .build()
                .toByteArray();

        expectedObjectWithOnlyRequiredFields = new GetClassInfo.Result(null);
        expectedPbInputWithOnlyRequiredFields = qlua.rpc.GetClassInfo.Result.newBuilder().build().toByteArray();
    }

    @Test
    public void testSerialize() {

        final byte[] actual = sut.serialize(expectedObject);

        assertTrue( Arrays.equals(expectedPbInput, actual) );
    }

    @Test
    public void testDeserialize() {

        final GetClassInfo.Result actualObject = sut.deserialize(GetClassInfo.Result.class, expectedPbInput);

        assertEquals(actualObject, expectedObject);
    }

    @Test
    public void testSerializeWithOnlyRequiredFields() {

        final byte[] actual = sut.serialize(expectedObjectWithOnlyRequiredFields);

        assertTrue( Arrays.equals(expectedPbInputWithOnlyRequiredFields, actual) );
    }

    @Test
    public void testDeserializeWithOnlyRequiredFields() {

        final GetClassInfo.Result actualObject = sut.deserialize(GetClassInfo.Result.class, expectedPbInputWithOnlyRequiredFields);

        assertEquals(actualObject, expectedObjectWithOnlyRequiredFields);
    }
}
