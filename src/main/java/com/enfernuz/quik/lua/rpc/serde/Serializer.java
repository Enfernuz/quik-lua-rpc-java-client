package com.enfernuz.quik.lua.rpc.serde;

@FunctionalInterface
public interface Serializer<T> {

    byte[] serialize(T t);
}
