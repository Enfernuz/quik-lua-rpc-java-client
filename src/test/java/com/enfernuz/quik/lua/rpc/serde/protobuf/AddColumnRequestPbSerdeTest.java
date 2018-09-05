package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.AddColumn;
import com.enfernuz.quik.lua.rpc.serde.PbConverter;
import com.enfernuz.quik.lua.rpc.serde.SerdeModule;
import org.junit.BeforeClass;
import org.junit.Test;
import qlua.rpc.RPC;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AddColumnRequestPbSerdeTest {

    private static SerdeModule sut;
    private static PbConverter<qlua.rpc.AddColumn.Request, AddColumn.Request> pbConverter;

    private static AddColumn.Request expectedObject;
    private static byte[] expectedPbInput;

    private static AddColumn.Request expectedObjectWithNullNonRequiredStringFileds;
    private static byte[] expectedPbInputWithEmptyNonRequiredStringFields;

    @BeforeClass
    public static void globalSetup() {

        sut = ProtobufSerdeModule.INSTANCE;
        pbConverter = AddColumnRequestPbSerde.INSTANCE;

        expectedObject = AddColumn.Request.builder()
                .tId(1)
                .iCode(2)
                .name("3")
                .parType(AddColumn.ColumnParameterType.QTABLE_INT64_TYPE)
                .isDefault(true)
                .width(6)
                .build();
        expectedPbInput =
                RPC.Request.newBuilder()
                        .setType(RPC.ProcedureType.ADD_COLUMN)
                        .setArgs(pbConverter.convertToPb(expectedObject).toByteString())
                        .build()
                        .toByteArray();

        expectedObjectWithNullNonRequiredStringFileds = AddColumn.Request.builder()
                .tId(1)
                .iCode(2)
                .name("3")
                .isDefault(true)
                .width(5)
                .build();
        expectedPbInputWithEmptyNonRequiredStringFields =
                RPC.Request.newBuilder()
                        .setType(RPC.ProcedureType.ADD_COLUMN)
                        .setArgs(pbConverter.convertToPb(expectedObjectWithNullNonRequiredStringFileds).toByteString())
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

        final byte[] actual = sut.serialize(expectedObjectWithNullNonRequiredStringFileds);

        assertTrue( Arrays.equals(expectedPbInputWithEmptyNonRequiredStringFields, actual) );
    }

    @Test
    public void testDeserialize() {

        final AddColumn.Request actualObject = sut.deserialize(AddColumn.Request.class, expectedPbInput);

        assertEquals(actualObject, expectedObject);
    }

    @Test
    public void testDeserializePbInputWithEmptyNonRequiredStringFields() {

        final AddColumn.Request actualObject =
                sut.deserialize(AddColumn.Request.class, expectedPbInputWithEmptyNonRequiredStringFields);

        assertEquals(actualObject, expectedObjectWithNullNonRequiredStringFileds);
    }
}
