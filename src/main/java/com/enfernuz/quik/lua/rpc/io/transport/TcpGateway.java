package com.enfernuz.quik.lua.rpc.io.transport;

import com.enfernuz.quik.lua.rpc.io.Gateway;

public interface TcpGateway extends Gateway {

    NetworkAddress getNetworkAddress();
}
