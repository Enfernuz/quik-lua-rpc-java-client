package com.enfernuz.quik.lua.rpc.api.io;

import java.io.IOException;

public interface Gateway extends AutoCloseable {

    void open() throws IOException;

    boolean isOpened();
}
