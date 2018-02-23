package com.enfernuz.quik.lua.rpc.config;

import java.io.File;
import java.io.IOException;

public interface ObjectReader<T> {

    T read(File file) throws IOException;
}
