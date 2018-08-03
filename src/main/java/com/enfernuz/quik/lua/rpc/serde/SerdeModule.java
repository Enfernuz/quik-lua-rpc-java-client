package com.enfernuz.quik.lua.rpc.serde;

public interface SerdeModule {

    <T> byte[] serialize(T t);

    <T> T deserialize(Class<T> clazz, byte[] data);
}
