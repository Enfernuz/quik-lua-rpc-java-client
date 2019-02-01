package com.enfernuz.quik.lua.rpc.serde.json;

import com.enfernuz.quik.lua.rpc.api.RpcArgs;
import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import org.junit.Test;

import java.io.IOException;
import java.nio.charset.Charset;

import static org.junit.Assert.assertEquals;

public abstract class AbstractJsonRpcArgsSerializationTest<ARGS extends RpcArgs> extends AbstractJsonSerdeModuleTest {

    private static final Charset JSON_CHARSET = Charsets.UTF_8;

    public abstract String getArgsJsonPath();

    public abstract ARGS getArgsObject();

    @Test
    public void testArgsObjectSerialization() throws IOException {

        final String expected = Resources.toString(Resources.getResource(getArgsJsonPath()), JSON_CHARSET);
        final String actual = new String(getSUT().serialize(getArgsObject()), JSON_CHARSET);

        assertEquals(expected, actual);
    }
}
