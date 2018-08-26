package com.enfernuz.quik.lua.rpc.api.messages.os;

import com.enfernuz.quik.lua.rpc.api.structures.DateTimeEntry;
import com.enfernuz.quik.lua.rpc.serde.json.jackson.QluaJsonModule;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import org.junit.BeforeClass;
import org.junit.Test;
import qlua.structs.QluaStructures;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class SysDateJsonSerdeTest {

    private static ObjectMapper sut;

    private static SysDate.Request requestObj;
    private static SysDate.Result resultObj;
    private static String requestJson;
    private static String resultJson;

    @BeforeClass
    public static void globalSetup() throws IOException {

        sut = new ObjectMapper();
        sut.registerModule(new QluaJsonModule());

        requestObj = SysDate.Request.INSTANCE;

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

        resultObj = new SysDate.Result(dateTimeEntry);

        requestJson =
                Resources.toString(Resources.getResource("json/os.sysdate.request.json"), Charsets.UTF_8);
        resultJson =
                Resources.toString(Resources.getResource("json/os.sysdate.result.json"), Charsets.UTF_8);
    }

    @Test
    public void testRequestSerialize() throws IOException {

        final String actualRequestJson = sut.writerWithDefaultPrettyPrinter().writeValueAsString(requestObj);

        assertEquals(requestJson, actualRequestJson);
    }

    @Test
    public void testResultDeserialize() throws IOException {

        final SysDate.Result actualResultObj = sut.readValue(resultJson, SysDate.Result.class);

        assertEquals(resultObj, actualResultObj);
    }
}
