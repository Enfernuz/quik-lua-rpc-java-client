package com.enfernuz.quik.lua.rpc.api.security.zmq;

import com.google.common.base.MoreObjects;
import org.zeromq.ZMQ;

import java.util.Objects;

import static java.util.Objects.requireNonNull;

public final class SimpleAuthContext implements AuthContext {

    private final ZMQ.Socket.Mechanism authMechanism;
    private PlainCredentials plainCredentials;
    private CurveCredentials curveCredentials;

    public SimpleAuthContext(final PlainCredentials plainCredentials) {

        this.plainCredentials =
                requireNonNull(plainCredentials, "The argument \"plainCredentials\" must not be null.");
        this.authMechanism = ZMQ.Socket.Mechanism.PLAIN;
    }

    public SimpleAuthContext(final CurveCredentials curveCredentials) {

        this.curveCredentials =
                requireNonNull(curveCredentials, "The argument \"curveCredentials\" must not be null.");
        this.authMechanism = ZMQ.Socket.Mechanism.CURVE;
    }

    public SimpleAuthContext() {
        this.authMechanism = ZMQ.Socket.Mechanism.NULL;
    }

    @Override
    public ZMQ.Socket.Mechanism getAuthMechanism() {
        return authMechanism;
    }

    @Override
    public PlainCredentials getPlainCredentials() {
        return plainCredentials;
    }

    @Override
    public CurveCredentials getCurveCredentials() {
        return curveCredentials;
    }

    @Override
    public boolean equals(final Object o) {

        if (o == this) {
            return true;
        } else if ( !(o instanceof SimpleAuthContext) ) {
            return false;
        } else {
            final SimpleAuthContext other = (SimpleAuthContext) o;
            return Objects.equals(authMechanism, other.authMechanism)
                    && Objects.equals(plainCredentials, other.plainCredentials)
                    && Objects.equals(curveCredentials, other.curveCredentials);
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(authMechanism, plainCredentials, curveCredentials);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("authMechanism", authMechanism)
                .add("plainCredentials", plainCredentials)
                .add("curveCredentials", curveCredentials)
                .toString();
    }
}
