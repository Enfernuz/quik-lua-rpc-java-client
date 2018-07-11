package com.enfernuz.quik.lua.rpc.serde;

import com.enfernuz.quik.lua.rpc.events.api.QluaEvent;
import com.enfernuz.quik.lua.rpc.events.api.structures.Firm;
import com.enfernuz.quik.lua.rpc.events.api.structures.MoneyLimit;

public interface SerdeModule {

    <T> byte[] serialize(T t);

    <T> T deserialize(Class<T> clazz, byte[] data);
}
