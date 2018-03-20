package com.enfernuz.quik.lua.rpc.api.security.zmq;

/**
 * Учётные данные клиента для защитного механизма ZeroMQ CURVE.
 *
 * @see <a href="http://curvezmq.org/page:read-the-docs">Документация механизма CURVE</a>
 * @see <a href="https://rfc.zeromq.org/spec:26/CURVEZMQ">Спецификация механизма CURVE</a>
 */
public interface CurveCredentials {

    /**
     * Получает публичный CURVE-ключ сервера для данного экземпляра учётных данных.
     *
     * @return публичный CURVE-ключ сервера для данного экземпляра учётных данных
     */
    CurveKey getServerPublicKey();

    /**
     * Получает ключевую пару CURVE клиента для данного экземпляра учётных данных.
     *
     * @return ключевая пара CURVE клиента для данного экземпляра учётных данных
     */
    CurveKeyPair getClientKeyPair();
}
