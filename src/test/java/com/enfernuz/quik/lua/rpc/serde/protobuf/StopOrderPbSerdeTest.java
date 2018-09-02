package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.structures.DateTimeEntry;
import com.enfernuz.quik.lua.rpc.api.structures.StopOrder;
import com.enfernuz.quik.lua.rpc.serde.PbConverter;
import com.enfernuz.quik.lua.rpc.serde.SerdeModule;
import org.junit.BeforeClass;
import org.junit.Test;
import qlua.structs.QluaStructures;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class StopOrderPbSerdeTest {

    private static SerdeModule sut;
    private static PbConverter<QluaStructures.StopOrder, StopOrder> pbConverter;

    private static StopOrder expectedObject;
    private static byte[] expectedPbInput;

    private static StopOrder expectedObjectWithNullNonRequiredStringFileds;
    private static byte[] expectedPbInputWithEmptyNonRequiredStringFields;

    @BeforeClass
    public static void globalSetup() {

        sut = ProtobufSerdeModule.INSTANCE;
        pbConverter = StopOrderPbSerde.INSTANCE;

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
        expectedPbInput = pbConverter.convertToPb(expectedObject).toByteArray();

        expectedObjectWithNullNonRequiredStringFileds = StopOrder.builder()
                .orderNum(1L)
                .flags(2)
                .condition(3)
                .qty(4)
                .stopOrderType(5)
                .stopFlags(6)
                .filledQty(7)
                .build();
        expectedPbInputWithEmptyNonRequiredStringFields =
                pbConverter.convertToPb(expectedObjectWithNullNonRequiredStringFileds).toByteArray();
    }

    @Test
    public void testSerialize() {

        final byte[] actual = sut.serialize(expectedObject);

        assertTrue( Arrays.equals(expectedPbInput, actual) );
    }

    @Test
    public void testSerializePbInputWithEmptyNonRequiredStringFields() {

        final byte[] actual = sut.serialize(expectedObjectWithNullNonRequiredStringFileds);

        assertTrue( Arrays.equals(expectedPbInputWithEmptyNonRequiredStringFields, actual) );
    }

    @Test
    public void testDeserialize() {

        final StopOrder actualObject = sut.deserialize(StopOrder.class, expectedPbInput);

        assertEquals(actualObject, expectedObject);
    }

    @Test
    public void testDeserializePbInputWithEmptyNonRequiredStringFields() {

        final StopOrder actualObject = sut.deserialize(StopOrder.class, expectedPbInputWithEmptyNonRequiredStringFields);

        assertEquals(actualObject, expectedObjectWithNullNonRequiredStringFileds);
    }
}
