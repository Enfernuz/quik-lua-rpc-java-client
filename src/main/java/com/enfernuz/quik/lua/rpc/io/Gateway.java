package com.enfernuz.quik.lua.rpc.io;

import java.io.IOException;

public interface Gateway extends AutoCloseable {

    void open() throws IOException;

    boolean isOpened();

    @Override
    void close() throws IOException;
}
