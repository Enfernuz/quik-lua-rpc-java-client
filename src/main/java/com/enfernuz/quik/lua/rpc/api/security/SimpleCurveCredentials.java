package com.enfernuz.quik.lua.rpc.api.security;

import static java.util.Objects.requireNonNull;

public final class SimpleCurveCredentials implements CurveCredentials {

    private final CurveKey serverPublicKey;
    private final CurveKeyPair clientKeyPair;

    public SimpleCurveCredentials(final CurveKey serverPublicKey, final CurveKeyPair clientKeyPair) {

        this.serverPublicKey = requireNonNull(serverPublicKey, "The argument \"serverPublicKey\" must not be null.");
        this.clientKeyPair = requireNonNull(clientKeyPair, "The argument \"clientKeyPair\" must not be null.");
    }

    @Override
    public CurveKey getServerPublicKey() {
        return serverPublicKey;
    }

    @Override
    public CurveKeyPair getClientKeyPair() {
        return clientKeyPair;
    }
}
