package com.enfernuz.quik.lua.rpc.api.security.zmq;

import com.google.common.base.MoreObjects;
import org.zeromq.ZMQ;

import java.util.Objects;

import static java.util.Objects.requireNonNull;

/**
 * Базовая реализация контекста защитного механизма ZeroMQ.
 */
public final class SimpleAuthContext implements AuthContext {

    private final ZMQ.Socket.Mechanism authMechanism;
    private final PlainCredentials plainCredentials;
    private final CurveCredentials curveCredentials;

    /**
     * Создать контекст защитного механизма {@link ZMQ.Socket.Mechanism#PLAIN}.
     * @param plainCredentials учётные данные клиента для защитного механизма ZeroMQ PLAIN
     * @throws NullPointerException если указанные учётные данные являются {@code null}
     */
    public SimpleAuthContext(final PlainCredentials plainCredentials) {

        this.plainCredentials =
                requireNonNull(plainCredentials, "The argument \"plainCredentials\" must not be null.");
        this.authMechanism = ZMQ.Socket.Mechanism.PLAIN;
        this.curveCredentials = null;
    }

    /**
     * Создать контекст защитного механизма {@link ZMQ.Socket.Mechanism#CURVE}.
     * @param curveCredentials учётные данные клиента для защитного механизма ZeroMQ CURVE
     * @throws NullPointerException если указанные учётные данные являются {@code null}
     */
    public SimpleAuthContext(final CurveCredentials curveCredentials) {

        this.curveCredentials =
                requireNonNull(curveCredentials, "The argument \"curveCredentials\" must not be null.");
        this.authMechanism = ZMQ.Socket.Mechanism.CURVE;
        this.plainCredentials = null;
    }

    /**
     * Создать контекст защитного механизма {@link ZMQ.Socket.Mechanism#NULL}.
     */
    public SimpleAuthContext() {
        this.authMechanism = ZMQ.Socket.Mechanism.NULL;
        this.curveCredentials = null;
        this.plainCredentials = null;
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
