package com.enfernuz.quik.lua.rpc.api;

import com.enfernuz.quik.lua.rpc.events.api.QluaEventListener;
import com.enfernuz.quik.lua.rpc.io.Gateway;

public interface QluaGateway extends Gateway, RemoteProcedureCaller, QluaEventListener {
}
