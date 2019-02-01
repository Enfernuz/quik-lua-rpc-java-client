package com.enfernuz.quik.lua.rpc.serde.json;

import com.enfernuz.quik.lua.rpc.api.RpcResult;
import com.google.common.io.Resources;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public abstract class AbstractRpcResultJsonDeserializationTest<RESULT extends RpcResult> extends AbstractJsonDeserializationTest<RESULT> {

    @Override
    public abstract RESULT getExpectedObject();

    @Test
    public void testResultObjectDeserialization() throws IOException {

        final RESULT expected = getExpectedObject();
        final RpcResult<?> actual = getSUT().deserialize(
                expected.getClass(),
                Resources.toByteArray(Resources.getResource(getJsonPath()))
        );

        assertEquals(expected, actual);
    }
}
