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
    public void testSerialize() {

        assertTrue(
                Arrays.equals(getTargetObjectPbSerializedForm(), getSerdeModuleUnderTest().serialize(getTargetObject()))
        );
    }

    @Test
    public void testDeserialize() {
        assertEquals(getTargetObject(), getSerdeModuleUnderTest().deserialize(getTargetObjectClass(), getTargetObjectPbSerializedForm()));
    }

    /**
     * Where applicable, this method must be overridden with the @Test annotation on it.
     */
    public void testSerialize_WithNonEssentialFieldsInitializedByDefault() {

        assertTrue(
                Arrays.equals(
                        getTargetObject_WithNonEssentialFieldsInitializedByDefault_PbSerializedForm(),
                        getSerdeModuleUnderTest().serialize(getTargetObject_WithNonEssentialFieldsInitializedByDefault())
                )
        );
    }

    /**
     * Where applicable, this method must be overridden with the @Test annotation on it.
     */
    public void testDeserialize_WithNonEssentialFieldsInitializedByDefault() {

        assertEquals(
                getTargetObject_WithNonEssentialFieldsInitializedByDefault(),
                getSerdeModuleUnderTest().deserialize(getTargetObjectClass(), getTargetObject_WithNonEssentialFieldsInitializedByDefault_PbSerializedForm())
        );
    }

    @NotNull
    public SerdeModule getSerdeModuleUnderTest() {
        return ProtobufSerdeModule.INSTANCE;
    }

    /**
     * This method must be overridden with a proper implementation if either of the test methods
     * {@link #testSerialize_WithNonEssentialFieldsInitializedByDefault()} or {@link #testDeserialize_WithNonEssentialFieldsInitializedByDefault()}
     * is overridden with the @Test annotation on it.
     */
    @NotNull
    public PB_OBJECT getTargetObject_WithNonEssentialFieldsInitializedByDefault_AsPbMessage() {
        throw new UnsupportedOperationException();
    }

    /**
     * This method must be overridden with a proper implementation if either of the test methods
     * {@link #testSerialize_WithNonEssentialFieldsInitializedByDefault()} or {@link #testDeserialize_WithNonEssentialFieldsInitializedByDefault()}
     * is overridden with the @Test annotation on it.
     */
    @NotNull
    public TARGET_OBJECT getTargetObject_WithNonEssentialFieldsInitializedByDefault() {
        throw new UnsupportedOperationException();
    }

    private byte[] getTargetObjectPbSerializedForm() {
        return getTargetObjectAsPbMessage().toByteArray();
    }

    private byte[] getTargetObject_WithNonEssentialFieldsInitializedByDefault_PbSerializedForm() {
        return getTargetObject_WithNonEssentialFieldsInitializedByDefault_AsPbMessage().toByteArray();
    }
}
