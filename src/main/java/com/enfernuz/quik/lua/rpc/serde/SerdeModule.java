package com.enfernuz.quik.lua.rpc.serde;

import org.jetbrains.annotations.NotNull;

public interface SerdeModule {

    <T> @NotNull byte[] serialize(@NotNull T t);

    <T> @NotNull T deserialize(@NotNull Class<T> clazz, @NotNull byte[] data);
}
