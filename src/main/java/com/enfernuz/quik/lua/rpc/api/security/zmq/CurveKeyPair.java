package com.enfernuz.quik.lua.rpc.api.security.zmq;

import com.google.common.base.MoreObjects;

import java.util.Objects;

import static java.util.Objects.requireNonNull;

/**
 * Ключевая пара CURVE для защитного механизма ZeroMQ CURVE.
 * <p/>
 * Консистентность ключевой пары (соответствие публичной и секретной частей) не является целью данного класса, поэтому
 * наличие экземпляров с ключами из разных пар вполне возможно (хоть и не имеет особого смысла).
 *
 * @see <a href="http://curvezmq.org/page:read-the-docs">Документация механизма CURVE</a>
 * @see <a href="https://rfc.zeromq.org/spec:26/CURVEZMQ">Спецификация механизма CURVE</a>
 */
public final class CurveKeyPair {

    private final CurveKey publicKey;
    private final CurveKey secretKey;

    /**
     * Создаёт экземпляр ключевой пары CURVE.
     *
     * @param publicKey  публичный CURVE-ключ
     * @param secretKey  секретный CURVE-ключ
     * @throws NullPointerException если какой либо из аргументов является null
     */
    public CurveKeyPair(final CurveKey publicKey, final CurveKey secretKey) {

        this.publicKey = requireNonNull(publicKey, "The argument \"publicKey\" must not be null.");
        this.secretKey = requireNonNull(secretKey, "The argument \"secretKey\" must not be null.");
    }

    /**
     * Получает публичный CURVE-ключ данной ключевой пары.
     *
     * @return публичный CURVE-ключ данной ключевой пары
     */
    public CurveKey getPublicKey() {
        return publicKey;
    }

    /**
     * Получает секретный CURVE-ключ данной ключевой пары.
     *
     * @return секретный CURVE-ключ данной ключевой пары
     */
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
