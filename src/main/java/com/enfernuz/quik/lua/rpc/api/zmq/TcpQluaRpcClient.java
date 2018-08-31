package com.enfernuz.quik.lua.rpc.api.zmq;

import com.enfernuz.quik.lua.rpc.api.QluaRpcClient;
import com.enfernuz.quik.lua.rpc.io.transport.TcpGateway;

public interface TcpQluaRpcClient extends QluaRpcClient, TcpGateway {
}
