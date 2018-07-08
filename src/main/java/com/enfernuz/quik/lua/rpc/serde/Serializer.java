package com.enfernuz.quik.lua.rpc.serde;

public interface Serializer<T> {

    byte[] serialize(T t);
}
