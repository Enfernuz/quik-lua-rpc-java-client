package com.enfernuz.quik.lua.rpc.serde;

@FunctionalInterface
public interface Deserializer<T> {

    T deserialize(byte[] data);
}
