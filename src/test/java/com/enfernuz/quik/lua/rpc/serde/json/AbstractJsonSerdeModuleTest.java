package com.enfernuz.quik.lua.rpc.serde.json;

import com.enfernuz.quik.lua.rpc.serde.SerdeModule;
import com.enfernuz.quik.lua.rpc.serde.json.JsonSerdeModule;

public abstract class AbstractJsonSerdeModuleTest {

    public SerdeModule getSUT() {
        return JsonSerdeModule.INSTANCE;
    }
}
