package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.serde.SerdeModule;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@Ignore
public abstract class AbstractPbSerdeTest<T> {

    public SerdeModule getSUT() {
        return ProtobufSerdeModule.INSTANCE;
    }

    public abstract Class<T> getTargetClass();

    public abstract byte[] getExpectedPbSerializedForm();

    public abstract T getExpectedDeserializedObject();

    @Test
    public void testSerialize() {

        assertTrue(
                Arrays.equals(getExpectedPbSerializedForm(), getSUT().serialize(getExpectedDeserializedObject()))
        );
    }

    @Test
    public void testDeserialize() {
        assertEquals(getExpectedDeserializedObject(), getSUT().deserialize(getTargetClass(), getExpectedPbSerializedForm()));
    }
}
