package com.enfernuz.quik.lua.rpc.api.security.zmq;

public interface CurveCredentials {

    CurveKey getServerPublicKey();

    CurveKeyPair getClientKeyPair();
}
