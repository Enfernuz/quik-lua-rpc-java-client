package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.serde.SerdeModule;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@Ignore
public abstract class AbstractPbSerdeTest<T> {

    public SerdeModule getSerdeModuleUnderTest() {
        return ProtobufSerdeModule.INSTANCE;
    }

    public abstract Class<T> getTargetObjectClass();

    public abstract byte[] getTargetObjectPbSerializedForm();

    public abstract T getTargetObject();

    @Test
    public void testSerialize() {

        assertTrue(
                Arrays.equals(getTargetObjectPbSerializedForm(), getSerdeModuleUnderTest().serialize(getTargetObject()))
        );
    }

    @Test
    public void testDeserialize() {
        assertEquals(getTargetObject(), getSerdeModuleUnderTest().deserialize(getTargetObjectClass(), getTargetObjectPbSerializedForm()));
    }
}
