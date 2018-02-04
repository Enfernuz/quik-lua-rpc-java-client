package com.enfernuz.quik.lua.rpc.api.security;

import org.zeromq.ZMQ;

public interface CurveCredentials {

    CurveKey getServerPublicKey();

    CurveKeyPair getClientKeyPair();
}
