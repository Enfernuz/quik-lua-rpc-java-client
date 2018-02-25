package com.enfernuz.quik.lua.rpc.api.security.zmq;

import com.google.common.base.MoreObjects;

import java.util.Objects;

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

    @Override
    public boolean equals(final Object o) {

        if (o == this) {
            return true;
        } else if ( !(o instanceof CurveKeyPair) ) {
            return false;
        } else {
            final CurveKeyPair other = (CurveKeyPair) o;
            return Objects.equals(publicKey, other.publicKey) && Objects.equals(secretKey, other.secretKey);
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(publicKey, secretKey);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("publicKey", publicKey)
                .add("secretKey", secretKey)
                .toString();
    }
}
