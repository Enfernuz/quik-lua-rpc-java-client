package com.enfernuz.quik.lua.rpc.api;

import com.enfernuz.quik.lua.rpc.api.events.QluaEventListener;
import com.enfernuz.quik.lua.rpc.api.io.Gateway;

public interface QluaGateway extends Gateway, RemoteProcedureCaller, QluaEventListener {
}
