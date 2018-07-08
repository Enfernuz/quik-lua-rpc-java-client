package com.enfernuz.quik.lua.rpc.serde;

public interface Deserializer<T> {

    T deserialize(byte[] data);
}
