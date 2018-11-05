package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import com.enfernuz.quik.lua.rpc.serde.SerdeModule;
import com.google.protobuf.MessageLite;
import org.jetbrains.annotations.NotNull;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public abstract class AbstractPbDeserializationTest<PB_OBJECT extends MessageLite, TARGET_OBJECT> {

    @NotNull
    public abstract Class<TARGET_OBJECT> getTargetObjectClass();

    @NotNull
    public abstract TARGET_OBJECT getTargetObject();

    @NotNull
    public abstract PB_OBJECT getTargetObjectAsPbMessage();

    @NotNull
    public abstract Deserializer<PB_OBJECT> getDeserializerUnderTest();

    @Test
    public void shouldDeserialize_ByteArrayOf_PbTargetObject_To_TargetObject() {
        assertEquals(getTargetObject(), getDeserializerUnderTest().deserialize(getTargetObjectPbSerializedForm()));
    }

    private byte[] getTargetObjectPbSerializedForm() {
        return getTargetObjectAsPbMessage().toByteArray();
    }
}
