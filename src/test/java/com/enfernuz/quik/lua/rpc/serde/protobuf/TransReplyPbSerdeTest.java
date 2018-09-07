package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.structures.DateTimeEntry;
import com.enfernuz.quik.lua.rpc.api.structures.TransReply;
import com.enfernuz.quik.lua.rpc.serde.SerdeModule;
import org.junit.BeforeClass;
import org.junit.Test;
import qlua.structs.QluaStructures;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TransReplyPbSerdeTest {

    private static SerdeModule sut;

    private static TransReply expectedObject;
    private static byte[] expectedPbInput;

    private static TransReply expectedObjectWithOnlyRequiredFields;
    private static byte[] expectedPbInputWithOnlyRequiredFields;

    @BeforeClass
    public static void globalSetup() {

        sut = ProtobufSerdeModule.INSTANCE;

        final DateTimeEntry dateTimeEntry = DateTimeEntry.builder()
                .mcs(1)
                .ms(2)
                .sec(3)
                .min(4)
                .hour(5)
                .day(6)
                .weekDay(7)
                .month(8)
                .year(9)
                .build();
        final QluaStructures.DateTimeEntry pbDateTimeEntry = QluaStructures.DateTimeEntry.newBuilder()
                .setMcs(1)
                .setMs(2)
                .setSec(3)
                .setMin(4)
                .setHour(5)
                .setDay(6)
                .setWeekDay(7)
                .setMonth(8)
                .setYear(9)
                .build();

        expectedObject = TransReply.builder()
                .transId(1L)
                .status(2)
                .resultMsg("3")
                .dateTime(dateTimeEntry)
                .uid("5")
                .flags(6)
                .serverTransId("7")
                .orderNum("8")
                .price("9")
                .quantity("10")
                .balance("11")
                .firmId("12")
                .account("13")
                .clientCode("14")
                .brokerRef("15")
                .classCode("16")
                .secCode("17")
                .exchangeCode("18")
                .build();
        expectedPbInput = QluaStructures.Transaction.newBuilder()
                .setTransId(1L)
                .setStatus(2)
                .setResultMsg("3")
                .setDateTime(pbDateTimeEntry)
                .setUid("5")
                .setFlags(6)
                .setServerTransId("7")
                .setOrderNum("8")
                .setPrice("9")
                .setQuantity("10")
                .setBalance("11")
                .setFirmId("12")
                .setAccount("13")
                .setClientCode("14")
                .setBrokerref("15")
                .setClassCode("16")
                .setSecCode("17")
                .setExchangeCode("18")
                .build()
                .toByteArray();

        expectedObjectWithOnlyRequiredFields = TransReply.builder()
                .transId(1L)
                .status(2)
                .flags(3)
                .build();
        expectedPbInputWithOnlyRequiredFields = QluaStructures.Transaction.newBuilder()
                .setTransId(1L)
                .setStatus(2)
                .setFlags(3)
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

        final TransReply actualObject = sut.deserialize(TransReply.class, expectedPbInput);

        assertEquals(actualObject, expectedObject);
    }

    @Test
    public void testDeserializePbInputWithEmptyNonRequiredStringFields() {

        final TransReply actualObject = sut.deserialize(TransReply.class, expectedPbInputWithOnlyRequiredFields);

        assertEquals(actualObject, expectedObjectWithOnlyRequiredFields);
    }
}
