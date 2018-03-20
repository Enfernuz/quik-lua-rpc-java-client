package com.enfernuz.quik.lua.rpc.api.security.zmq;

import com.google.common.base.MoreObjects;

import java.util.Objects;

import static java.util.Objects.requireNonNull;

/**
 * Базовая реализация учётных данных клиента для защитного механизма ZeroMQ CURVE.
 */
public final class SimpleCurveCredentials implements CurveCredentials {

    private final CurveKey serverPublicKey;
    private final CurveKeyPair clientKeyPair;

    /**
     * Создаёт учётные данные клиента для защитного механизма ZeroMQ CURVE.
     *
     * @param serverPublicKey  публичный CURVE-ключ сервера
     * @param clientKeyPair  клиентская ключевая пара CURVE
     * @throws NullPointerException если какой-либо из параметров является null
     */
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

    @Override
    public boolean equals(final Object o) {

        if (o == this) {
            return true;
        } else if ( !(o instanceof SimpleCurveCredentials) ) {
            return false;
        } else {
            final SimpleCurveCredentials other = (SimpleCurveCredentials) o;
            return Objects.equals(serverPublicKey, other.serverPublicKey)
                    && Objects.equals(clientKeyPair, other.clientKeyPair);
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(serverPublicKey, clientKeyPair);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("serverPublicKey", serverPublicKey)
                .add("clientKeyPair", clientKeyPair)
                .toString();
    }
}
