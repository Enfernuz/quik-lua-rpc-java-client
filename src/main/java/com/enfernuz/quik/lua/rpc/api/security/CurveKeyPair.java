package com.enfernuz.quik.lua.rpc.api.security;

import static java.util.Objects.requireNonNull;

public final class CurveKeyPair {

    private final CurveKey publicKey;
    private final CurveKey secretKey;

    public CurveKeyPair(final CurveKey publicKey, final CurveKey secretKey) {

        this.publicKey = requireNonNull(publicKey, "The argument \"publicKey\" must not be null.");
        this.secretKey = requireNonNull(secretKey, "The argument \"secretKey\" must not be null.");
    }

    public CurveKey getPublicKey() {
        return publicKey;
    }

    public CurveKey getSecretKey() {
        return secretKey;
    }
}
