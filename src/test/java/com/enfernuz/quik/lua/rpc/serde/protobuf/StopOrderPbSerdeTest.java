package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.structures.DateTimeEntry;
import com.enfernuz.quik.lua.rpc.api.structures.StopOrder;
import com.enfernuz.quik.lua.rpc.serde.SerdeModule;
import org.junit.BeforeClass;
import org.junit.Test;
import qlua.structs.QluaStructures;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class StopOrderPbSerdeTest {

    private static SerdeModule sut;

    private static StopOrder expectedObject;
    private static byte[] expectedPbInput;

    private static StopOrder expectedObjectWithOnlyRequiredFields;
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

        expectedObject = StopOrder.builder()
                .orderNum(1L)
                .orderTime("2")
                .flags(3)
                .brokerRef("4")
                .firmId("5")
                .account("6")
                .condition(7)
                .conditionPrice("8")
                .price("9")
                .qty(10)
                .linkedOrder("11")
                .expiry("12")
                .transId("13")
                .clientCode("14")
                .coOrderNum("15")
                .coOrderPrice("16")
                .stopOrderType(17)
                .orderDate("18")
                .allTradeNum("19")
                .stopFlags(20)
                .offset("21")
                .spread("22")
                .balance("23")
                .uid("24")
                .filledQty(25)
                .withdrawTime("26")
                .conditionPrice2("27")
                .activeFromTime("28")
                .activeToTime("29")
                .secCode("30")
                .classCode("31")
                .conditionSecCode("32")
                .conditionClassCode("33")
                .canceledUid("34")
                .orderDateTime(dateTimeEntry)
                .withdrawDateTime(dateTimeEntry)
                .build();
        expectedPbInput = QluaStructures.StopOrder.newBuilder()
                .setOrderNum(1L)
                .setOrdertime("2")
                .setFlags(3)
                .setBrokerref("4")
                .setFirmid("5")
                .setAccount("6")
                .setCondition(7)
                .setConditionPrice("8")
                .setPrice("9")
                .setQty(10)
                .setLinkedorder("11")
                .setExpiry("12")
                .setTransId("13")
                .setClientCode("14")
                .setCoOrderNum("15")
                .setCoOrderPrice("16")
                .setStopOrderType(17)
                .setOrderdate("18")
                .setAlltradeNum("19")
                .setStopflags(20)
                .setOffset("21")
                .setSpread("22")
                .setBalance("23")
                .setUid("24")
                .setFilledQty(25)
                .setWithdrawTime("26")
                .setConditionPrice2("27")
                .setActiveFromTime("28")
                .setActiveToTime("29")
                .setSecCode("30")
                .setClassCode("31")
                .setConditionSecCode("32")
                .setConditionClassCode("33")
                .setCanceledUid("34")
                .setOrderDateTime(pbDateTimeEntry)
                .setWithdrawDatetime(pbDateTimeEntry)
                .build()
                .toByteArray();

        expectedObjectWithOnlyRequiredFields = StopOrder.builder()
                .orderNum(1L)
                .flags(2)
                .condition(3)
                .qty(4)
                .stopOrderType(5)
                .stopFlags(6)
                .filledQty(7)
                .build();
        expectedPbInputWithOnlyRequiredFields = QluaStructures.StopOrder.newBuilder()
                .setOrderNum(1L)
                .setFlags(2)
                .setCondition(3)
                .setQty(4)
                .setStopOrderType(5)
                .setStopflags(6)
                .setFilledQty(7)
                .build()
                .toByteArray();
    }

    @Test
    public void testSerialize() {

        assertTrue(
                Arrays.equals(expectedPbInput, sut.serialize(expectedObject))
        );
    }

    @Test
    public void testDeserialize() {
        assertEquals(expectedObject, sut.deserialize(StopOrder.class, expectedPbInput));
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
                sut.deserialize(StopOrder.class, expectedPbInputWithOnlyRequiredFields)
        );
    }
}
