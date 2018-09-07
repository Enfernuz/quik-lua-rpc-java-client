package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.AddLabel;
import com.enfernuz.quik.lua.rpc.serde.SerdeModule;
import com.google.common.collect.ImmutableMap;
import com.google.protobuf.ByteString;
import org.junit.BeforeClass;
import org.junit.Test;
import qlua.rpc.RPC;

import java.util.Arrays;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AddLabelRequestPbSerdeTest {

    private static SerdeModule sut;

    private static AddLabel.Request expectedObject;
    private static byte[] expectedPbInput;

    @BeforeClass
    public static void globalSetup() {

        sut = ProtobufSerdeModule.INSTANCE;

        final Map<String, String> labelParams =
                ImmutableMap.of(
                "key1", "value1",
                "key2", "value2",
                "key3", "value3"
                );
        expectedObject = AddLabel.Request.builder()
                .chartTag("1")
                .labelParams(labelParams)
                .build();
        final ByteString pbArgs = qlua.rpc.AddLabel.Request.newBuilder()
                .setChartTag("1")
                .putAllLabelParams(labelParams)
                .build()
                .toByteString();
        expectedPbInput =
                RPC.Request.newBuilder()
                        .setType(RPC.ProcedureType.ADD_LABEL)
                        .setArgs(pbArgs)
                        .build()
                        .toByteArray();
    }

    @Test
    public void testSerialize() {

        final byte[] actual = sut.serialize(expectedObject);

        assertTrue( Arrays.equals(expectedPbInput, actual) );
    }

    @Test
    public void testDeserialize() {

        final AddLabel.Request actualObject = sut.deserialize(AddLabel.Request.class, expectedPbInput);

        assertEquals(actualObject, expectedObject);
    }
}
