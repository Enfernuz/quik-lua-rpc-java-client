package com.enfernuz.quik.lua.rpc.client.api;

import java.io.IOException;

public interface RpcClient extends AutoCloseable {

    void connect() throws IOException;

    void disconnect() throws IOException;

    qlua.rpc.Message.Result message(qlua.rpc.Message.Request request);

}
