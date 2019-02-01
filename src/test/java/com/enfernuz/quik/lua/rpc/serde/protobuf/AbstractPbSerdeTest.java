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
    public abstract Class<TARGET_OBJECT> getTargetObjectClass();

    @NotNull
    public abstract PB_OBJECT getTargetObjectAsPbMessage();

    @NotNull
    public abstract TARGET_OBJECT getTargetObject();

    @Test
    public void shouldSerialize_TargetObject_To_ByteArrayOf_PbTargetObject() {

        assertTrue(
                Arrays.equals(getTargetObjectPbSerializedForm(), getSerdeModuleUnderTest().serialize(getTargetObject()))
        );
    }

    @Test
    public void shouldDeserialize_ByteArrayOf_PbTargetObject_To_TargetObject() {
        assertEquals(getTargetObject(), getSerdeModuleUnderTest().deserialize(getTargetObjectClass(), getTargetObjectPbSerializedForm()));
    }

    /**
     * Where applicable, this method must be overridden with the @Test annotation on it.
     */
    public void shouldSerialize_ErrorObject_To_ByteArrayOf_PbErrorObject() {

        assertTrue(
                Arrays.equals(
                        getErrorObject_PbSerializedForm(),
                        getSerdeModuleUnderTest().serialize(getErrorObject())
                )
        );
    }

    /**
     * Where applicable, this method must be overridden with the @Test annotation on it.
     */
    public void shouldDeserialize_ByteArrayOf_PbErrorObject_To_ErrorObject() {

        assertEquals(
                getErrorObject(),
                getSerdeModuleUnderTest().deserialize(getTargetObjectClass(), getErrorObject_PbSerializedForm())
        );
    }

    @NotNull
    public SerdeModule getSerdeModuleUnderTest() {
        return ProtobufSerdeModule.INSTANCE;
    }

    /**
     * This method must be overridden with a proper implementation if either of the test methods
     * {@link #shouldSerialize_ErrorObject_To_ByteArrayOf_PbErrorObject()} or {@link #shouldDeserialize_ByteArrayOf_PbErrorObject_To_ErrorObject()}
     * is overridden with the @Test annotation on it.
     */
    @NotNull
    public PB_OBJECT getErrorObject_AsPbMessage() {
        throw new UnsupportedOperationException();
    }

    /**
     * This method must be overridden with a proper implementation if either of the test methods
     * {@link #shouldSerialize_ErrorObject_To_ByteArrayOf_PbErrorObject()} or {@link #shouldDeserialize_ByteArrayOf_PbErrorObject_To_ErrorObject()}
     * is overridden with the @Test annotation on it.
     */
    @NotNull
    public TARGET_OBJECT getErrorObject() {
        throw new UnsupportedOperationException();
    }

    private byte[] getTargetObjectPbSerializedForm() {
        return getTargetObjectAsPbMessage().toByteArray();
    }

    private byte[] getErrorObject_PbSerializedForm() {
        return getErrorObject_AsPbMessage().toByteArray();
    }
}
