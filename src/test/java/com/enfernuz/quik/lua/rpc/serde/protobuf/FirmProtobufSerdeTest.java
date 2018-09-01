package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.structures.Firm;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import org.jetbrains.annotations.NotNull;
import org.junit.BeforeClass;
import org.junit.Test;
import qlua.structs.QluaStructures;

import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.convertToPbString;
import static org.junit.Assert.assertEquals;

public class FirmProtobufSerdeTest {

    private static Deserializer<Firm> sut;

    private static Firm expectedObject;
    private static byte[] expectedPbInput;

    private static Firm expectedObjectWithNullNonRequiredStringFileds;
    private static byte[] expectedPbInputWithEmptyNonRequiredStringFields;

    @BeforeClass
    public static void globalSetup() {

        sut = FirmPbDeserializer.INSTANCE;

        expectedObject = Firm.builder()
                .firmId("1")
                .firmName("2")
                .status(3)
                .exchange("4")
                .build();
        expectedPbInput = convertToPbByteArray(expectedObject);

        expectedObjectWithNullNonRequiredStringFileds = Firm.builder()
                .firmId("1")
                .status(2)
                .build();
        expectedPbInputWithEmptyNonRequiredStringFields = convertToPbByteArray(expectedObjectWithNullNonRequiredStringFileds);
    }

    @Test
    public void testDeserialize() {

        final Firm actualObject = sut.deserialize(expectedPbInput);

        assertEquals(actualObject, expectedObject);
    }

    @Test
    public void testDeserializePbInputWithEmptyNonRequiredStringFields() {

        final Firm actualObject = sut.deserialize(expectedPbInputWithEmptyNonRequiredStringFields);

        assertEquals(actualObject, expectedObjectWithNullNonRequiredStringFileds);
    }

    private static byte[] convertToPbByteArray(@NotNull final Firm firm) {

        return QluaStructures.Firm.newBuilder()
                .setFirmid( firm.getFirmId() )
                .setFirmName( convertToPbString(firm.getFirmName()) )
                .setStatus( firm.getStatus() )
                .setExchange( convertToPbString(firm.getExchange()) )
                .build()
                .toByteArray();
    }
}
