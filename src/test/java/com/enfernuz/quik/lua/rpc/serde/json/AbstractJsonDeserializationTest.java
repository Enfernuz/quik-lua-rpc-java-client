package com.enfernuz.quik.lua.rpc.serde.json;

import com.google.common.io.Resources;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public abstract class AbstractJsonDeserializationTest<T> extends AbstractJsonSerdeModuleTest {

    public abstract String getJsonPath();

    public abstract T getExpectedObject();

    @Test
    public void testJsonDeserialization() throws IOException {

        final T expected = getExpectedObject();
        final Object actual = getSUT().deserialize(
                expected.getClass(),
                Resources.toByteArray(Resources.getResource(getJsonPath()))
        );

        assertEquals(expected, actual);
    }
}
