package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.structures.DateTimeEntry;
import com.enfernuz.quik.lua.rpc.api.structures.Order;
import com.enfernuz.quik.lua.rpc.serde.SerdeModule;
import org.junit.BeforeClass;
import org.junit.Test;
import qlua.structs.QluaStructures;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class OrderPbSerdeTest {

    private static SerdeModule sut;

    private static Order expectedObject;
    private static byte[] expectedPbInput;

    private static Order expectedObjectWithOnlyRequiredFields;
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
        expectedPbInput = QluaStructures.Order.newBuilder()
                .setOrderNum(1L)
                .setFlags(2)
                .setBrokerref("3")
                .setUserid("4")
                .setFirmid("5")
                .setAccount("6")
                .setPrice("7")
                .setQty(8)
                .setBalance("9")
                .setValue("10")
                .setAccruedint("11")
                .setYield("12")
                .setTransId("13")
                .setClientCode("14")
                .setPrice2("15")
                .setSettlecode("16")
                .setUid("17")
                .setCanceledUid("18")
                .setExchangeCode("19")
                .setActivationTime("20")
                .setLinkedorder("21")
                .setExpiry("22")
                .setSecCode("23")
                .setClassCode("24")
                .setDatetime(pbDateTimeEntry)
                .setWithdrawDatetime(pbDateTimeEntry)
                .setBankAccId("27")
                .setValueEntryType(28)
                .setRepoterm("29")
                .setRepovalue("30")
                .setRepo2Value("31")
                .setRepoValueBalance("32")
                .setStartDiscount("33")
                .setRejectReason("34")
                .setExtOrderFlags("35")
                .setMinQty(36)
                .setExecType(37)
                .setSideQualifier(38)
                .setAcntType(39)
                .setCapacity(40)
                .setPassiveOnlyOrder(41)
                .setVisible(42)
                .build()
                .toByteArray();

        expectedObjectWithOnlyRequiredFields = Order.builder().build();
        expectedPbInputWithOnlyRequiredFields = QluaStructures.Order.newBuilder().build().toByteArray();
    }

    @Test
    public void testSerialize() {

        assertTrue(
                Arrays.equals(expectedPbInput, sut.serialize(expectedObject))
        );
    }

    @Test
    public void testDeserialize() {
        assertEquals(expectedObject, sut.deserialize(Order.class, expectedPbInput));
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
                sut.deserialize(Order.class, expectedPbInputWithOnlyRequiredFields)
        );
    }
}
