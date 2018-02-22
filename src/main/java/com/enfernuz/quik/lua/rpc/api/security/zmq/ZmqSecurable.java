package com.enfernuz.quik.lua.rpc.api.security.zmq;

import com.enfernuz.quik.lua.rpc.api.security.Securable;

public interface ZmqSecurable extends Securable{

    AuthContext getAuthContext();
}
