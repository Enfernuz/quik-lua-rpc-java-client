package com.enfernuz.quik.lua.rpc.api.security.zmq;

/**
 * Учётные данные клиента для защитного механизма ZeroMQ CURVE.
 */
public interface CurveCredentials {

    /**
     * Получить публичный CURVE-ключ сервера для данного экземпляра учётных данных.
     * @return публичный CURVE-ключ сервера для данного экземпляра учётных данных
     */
    CurveKey getServerPublicKey();

    /**
     * Получить ключевую пару CURVE клиента для данного экземпляра учётных данных.
     * @return ключевая пара CURVE клиента для данного экземпляра учётных данных
     */
    CurveKeyPair getClientKeyPair();
}
