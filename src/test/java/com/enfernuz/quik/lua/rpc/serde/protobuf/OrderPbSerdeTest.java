package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.structures.DateTimeEntry;
import com.enfernuz.quik.lua.rpc.api.structures.Order;
import com.enfernuz.quik.lua.rpc.serde.PbConverter;
import com.enfernuz.quik.lua.rpc.serde.SerdeModule;
import org.junit.BeforeClass;
import org.junit.Test;
import qlua.structs.QluaStructures;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class OrderPbSerdeTest {

    private static SerdeModule sut;
    private static PbConverter<QluaStructures.Order, Order> pbConverter;

    private static Order expectedObject;
    private static byte[] expectedPbInput;

    private static Order expectedObjectWithNullNonRequiredStringFileds;
    private static byte[] expectedPbInputWithEmptyNonRequiredStringFields;

    @BeforeClass
    public static void globalSetup() {

        sut = ProtobufSerdeModule.INSTANCE;
        pbConverter = OrderPbSerde.INSTANCE;

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

        expectedObject = Order.builder()
                .orderNum(1L)
                .flags(2)
                .brokerRef("3")
                .userId("4")
                .firmId("5")
                .account("6")
                .price("7")
                .qty(8)
                .balance("9")
                .value("10")
                .accruedInt("11")
                .yield("12")
                .transId("13")
                .clientCode("14")
                .price2("15")
                .settleCode("16")
                .uid("17")
                .canceledUid("18")
                .exchangeCode("19")
                .activationTime("20")
                .linkedOrder("21")
                .expiry("22")
                .secCode("23")
                .classCode("24")
                .datetime(dateTimeEntry)
                .withdrawDatetime(dateTimeEntry)
                .bankAccId("27")
                .valueEntryType(28)
                .repoTerm("29")
                .repoValue("30")
                .repo2Value("31")
                .repoValueBalance("32")
                .startDiscount("33")
                .rejectReason("34")
                .extOrderFlags("35")
                .minQty(36)
                .execType(37)
                .sideQualifier(38)
                .acntType(39)
                .capacity(40)
                .passiveOnlyOrder(41)
                .visible(42)
                .build();
        expectedPbInput = pbConverter.convertToPb(expectedObject).toByteArray();

        expectedObjectWithNullNonRequiredStringFileds = Order.builder()
                .orderNum(1L)
                .flags(2)
                .qty(8)
                .valueEntryType(28)
                .minQty(36)
                .execType(37)
                .sideQualifier(38)
                .acntType(39)
                .capacity(40)
                .passiveOnlyOrder(41)
                .visible(42)
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

        final Order actualObject = sut.deserialize(Order.class, expectedPbInput);

        assertEquals(actualObject, expectedObject);
    }

    @Test
    public void testDeserializePbInputWithEmptyNonRequiredStringFields() {

        final Order actualObject = sut.deserialize(Order.class, expectedPbInputWithEmptyNonRequiredStringFields);

        assertEquals(actualObject, expectedObjectWithNullNonRequiredStringFileds);
    }
}
