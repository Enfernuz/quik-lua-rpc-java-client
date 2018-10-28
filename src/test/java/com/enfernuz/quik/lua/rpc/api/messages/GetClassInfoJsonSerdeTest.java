package com.enfernuz.quik.lua.rpc.api.messages;

import com.enfernuz.quik.lua.rpc.api.structures.ClassInfo;
import com.enfernuz.quik.lua.rpc.serde.json.jackson.QluaJsonModule;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class GetClassInfoJsonSerdeTest {

    private static ObjectMapper sut;

    private static GetClassInfo.Args requestObj;
    private static String requestJson;

    private static GetClassInfo.Result resultObj;
    private static String resultJson;

    private static GetClassInfo.Result resultObjWithOnlyRequiredFields;
    private static String resultJsonWithOnlyRequiredFields;

    @BeforeClass
    public static void globalSetup() throws IOException {

        sut = new ObjectMapper();
        sut.registerModule(new QluaJsonModule());

        requestObj = new GetClassInfo.Args("1");
        requestJson =
                Resources.toString(Resources.getResource("json/getClassInfo.request.json"), Charsets.UTF_8);

        final ClassInfo classInfo = ClassInfo.builder()
                .firmId("1")
                .name("2")
                .code("3")
                .npars(4)
                .nsecs(5)
                .build();

        resultObj = new GetClassInfo.Result(classInfo);
        resultJson =
                Resources.toString(Resources.getResource("json/getClassInfo.result.json"), Charsets.UTF_8);

        resultObjWithOnlyRequiredFields = new GetClassInfo.Result(null);
        resultJsonWithOnlyRequiredFields =
                Resources.toString(Resources.getResource("json/getClassInfo.result.only_required_fields.json"), Charsets.UTF_8);
    }

    @Test
    public void testSerializeRequest() throws IOException {

        final String actualRequestJson = sut.writerWithDefaultPrettyPrinter().writeValueAsString(requestObj);

        assertEquals(requestJson, actualRequestJson);
    }

    @Test
    public void testDeserializeResult() throws IOException {

        final GetClassInfo.Result actualResultObj = sut.readValue(resultJson, GetClassInfo.Result.class);

        assertEquals(resultObj, actualResultObj);
    }

    @Test
    public void testDeserializeResultWithOnlyRequiredFields() throws IOException {

        final GetClassInfo.Result actualResultObj = sut.readValue(resultJsonWithOnlyRequiredFields, GetClassInfo.Result.class);

        assertEquals(resultObjWithOnlyRequiredFields, actualResultObj);
    }
}
