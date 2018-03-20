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
     * Создаёт контекст защитного механизма ZeroMQ PLAIN.
     *
     * @param plainCredentials  учётные данные клиента для защитного механизма {@link ZMQ.Socket.Mechanism#PLAIN}
     * @throws NullPointerException если указанные учётные данные являются null
     */
    public SimpleAuthContext(final PlainCredentials plainCredentials) {

        this.plainCredentials =
                requireNonNull(plainCredentials, "The argument \"plainCredentials\" must not be null.");
        this.authMechanism = ZMQ.Socket.Mechanism.PLAIN;
        this.curveCredentials = null;
    }

    /**
     * Создаёт контекст защитного механизма ZeroMQ CURVE.
     *
     * @param curveCredentials  учётные данные клиента для защитного механизма {@link ZMQ.Socket.Mechanism#CURVE}
     * @throws NullPointerException если указанные учётные данные являются null
     */
    public SimpleAuthContext(final CurveCredentials curveCredentials) {

        this.curveCredentials =
                requireNonNull(curveCredentials, "The argument \"curveCredentials\" must not be null.");
        this.authMechanism = ZMQ.Socket.Mechanism.CURVE;
        this.plainCredentials = null;
    }

    /**
     * Создаёт контекст защитного механизма, не предполагающий какой-либо защиты.
     * <p/>
     * Защитным механизмом данного контекста выступает механизм {@link ZMQ.Socket.Mechanism#NULL}.
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
