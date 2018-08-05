package com.enfernuz.quik.lua.rpc.api.messages;

import com.enfernuz.quik.lua.rpc.api.structures.DateTimeEntry;
import com.enfernuz.quik.lua.rpc.api.structures.Order;
import com.enfernuz.quik.lua.rpc.serde.json.jackson.QluaJsonModule;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class GetOrderByNumberJsonSerdeTest {

    private static ObjectMapper sut;

    private static GetOrderByNumber.Request requestObj;
    private static GetOrderByNumber.Result resultObj;
    private static String requestJson;
    private static String resultJson;

    @BeforeClass
    public static void globalSetup() throws IOException {

        sut = new ObjectMapper();
        sut.registerModule(new QluaJsonModule());

        requestObj = new GetOrderByNumber.Request("1", 12345678909876577L);

        final DateTimeEntry datetime = DateTimeEntry.builder()
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

        final DateTimeEntry withdrawDatetime = DateTimeEntry.builder()
                .mcs(9)
                .ms(8)
                .sec(7)
                .min(6)
                .hour(5)
                .day(4)
                .weekDay(3)
                .month(2)
                .year(1)
                .build();

        final Order order = Order.builder()
                .orderNum(12345678909876577L)
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
                .datetime(datetime)
                .withdrawDatetime(withdrawDatetime)
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

        resultObj = new GetOrderByNumber.Result(order, 2);

        requestJson =
                Resources.toString(Resources.getResource("json/getOrderByNumber.request.json"), Charsets.UTF_8);
        resultJson =
                Resources.toString(Resources.getResource("json/getOrderByNumber.result.json"), Charsets.UTF_8);
    }

    @Test
    public void testRequestSerialize() throws IOException {

        final String actualRequestJson = sut.writerWithDefaultPrettyPrinter().writeValueAsString(requestObj);

        assertEquals(requestJson, actualRequestJson);
    }

    @Test
    public void testResultDeserialize() throws IOException {

        final GetOrderByNumber.Result actualResultObj = sut.readValue(resultJson, GetOrderByNumber.Result.class);

        assertEquals(resultObj, actualResultObj);
    }
}
