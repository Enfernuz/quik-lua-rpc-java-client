package com.enfernuz.quik.lua.rpc.config;

import com.enfernuz.quik.lua.rpc.api.security.zmq.AuthContext;
import com.enfernuz.quik.lua.rpc.io.transport.NetworkAddress;

public interface ClientConfiguration {

    NetworkAddress getNetworkAddress();

    AuthContext getAuthContext();
}
