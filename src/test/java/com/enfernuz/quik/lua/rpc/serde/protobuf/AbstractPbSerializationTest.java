package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.serde.Serializer;
import com.google.protobuf.MessageLite;
import org.jetbrains.annotations.NotNull;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;

abstract class AbstractPbSerializationTest<TARGET_OBJECT, PB_OBJECT extends MessageLite> {

    @NotNull
    public abstract PB_OBJECT getTargetObjectAsPbMessage();

    public abstract TARGET_OBJECT getTargetObject();

    @NotNull
    public abstract Serializer<TARGET_OBJECT> getSerializerUnderTest();

    @Test
    public void shouldSerialize_TargetObject_To_ByteArrayOf_PbTargetObject() {

        assertTrue(
                Arrays.equals(getTargetObjectPbSerializedForm(), getSerializerUnderTest().serialize(getTargetObject()))
        );
    }

    private byte[] getTargetObjectPbSerializedForm() {
        return getTargetObjectAsPbMessage().toByteArray();
    }
}
