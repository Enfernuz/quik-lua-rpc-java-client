package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.AddColumn;
import com.enfernuz.quik.lua.rpc.serde.SerdeException;
import com.enfernuz.quik.lua.rpc.serde.SerdeModule;
import com.google.protobuf.ByteString;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import qlua.rpc.RPC;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AddColumnRequestPbSerdeTest {

    private static SerdeModule sut;

    private static AddColumn.Request expectedObject;
    private static byte[] expectedPbInput;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @BeforeClass
    public static void globalSetup() {

        sut = ProtobufSerdeModule.INSTANCE;

        expectedObject = AddColumn.Request.builder()
                .tId(1)
                .iCode(2)
                .name("3")
                .parType(AddColumn.ColumnParameterType.QTABLE_INT64_TYPE)
                .isDefault(true)
                .width(6)
                .build();
        final ByteString pbArgs = qlua.rpc.AddColumn.Request.newBuilder()
                .setTId(1)
                .setIcode(2)
                .setName("3")
                .setParType(qlua.rpc.AddColumn.ColumnParameterType.QTABLE_INT64_TYPE) // TODO: add tests for all the enum values
                .setIsDefault(true)
                .setWidth(6)
                .build()
                .toByteString();
        expectedPbInput =
                RPC.Request.newBuilder()
                        .setType(RPC.ProcedureType.ADD_COLUMN)
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

        final AddColumn.Request actualObject = sut.deserialize(AddColumn.Request.class, expectedPbInput);

        assertEquals(actualObject, expectedObject);
    }

    @Test
    public void testDeserializeWithUndefinedColumnParameterType() {

        final ByteString pbArgs = qlua.rpc.AddColumn.Request.newBuilder()
                .setTId(1)
                .setIcode(2)
                .setName("3")
                .setParType(qlua.rpc.AddColumn.ColumnParameterType.UNDEFINED)
                .setIsDefault(true)
                .setWidth(6)
                .build()
                .toByteString();
        final byte[] pbRequestAsBytes =
                RPC.Request.newBuilder()
                        .setType(RPC.ProcedureType.ADD_COLUMN)
                        .setArgs(pbArgs)
                        .build()
                        .toByteArray();

        thrown.expect(SerdeException.class);
        thrown.expectCause( instanceOf(IllegalArgumentException.class) );

        sut.deserialize(AddColumn.Request.class, pbRequestAsBytes);
    }
}
