package com.enfernuz.quik.lua.rpc.serde.json;

import com.enfernuz.quik.lua.rpc.api.messages.PrintDbgStr;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class PrintDbgStrJsonSerdeTest {

    public static class RpcArgsSerializationTest extends AbstractJsonRpcArgsSerializationTest<PrintDbgStr.Args> {

        @Override
        public PrintDbgStr.Args getArgsObject() {
            return new PrintDbgStr.Args("1");
        }

        @Override
        public String getArgsJsonPath() {
            return "json/PrintDbgStr/args.json";
        }
    }
}
