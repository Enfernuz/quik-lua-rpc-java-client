package com.enfernuz.quik.lua.rpc.serde;

public interface Serde<T> {

    byte[] serialize(T t);

    T deserialize(byte[] data);

    public static class SerdeException extends RuntimeException {
        // TODO
    }
}
