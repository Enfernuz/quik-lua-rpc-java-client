package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.serde.SerdeModule;
import com.google.protobuf.MessageLite;
import org.jetbrains.annotations.NotNull;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@Ignore
public abstract class AbstractPbSerdeTest<TARGET_OBJECT, PB_OBJECT extends MessageLite> {

    @NotNull
    public SerdeModule getSerdeModuleUnderTest() {
        return ProtobufSerdeModule.INSTANCE;
    }

    @NotNull
    public abstract Class<TARGET_OBJECT> getTargetObjectClass();

    @NotNull
    public abstract PB_OBJECT getTargetObjectAsPbMessage();

    @NotNull
    public abstract TARGET_OBJECT getTargetObject();

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

    private byte[] getTargetObjectPbSerializedForm() {
        return getTargetObjectAsPbMessage().toByteArray();
    }
}
