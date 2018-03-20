package com.enfernuz.quik.lua.rpc.api.security.zmq;

import org.zeromq.ZMQ;

/**
 * Контекст защитного механизма ZeroMQ.
 */
public interface AuthContext {

    /**
     * Получает тип защитного механизма ZeroMQ.
     *
     * @return тип защитного механизма ZeroMQ
     */
    ZMQ.Socket.Mechanism getAuthMechanism();

    /**
     * Получает учётные данные для механизма PLAIN в данном контексте защитного механизма.
     *
     * @return экземпляр учётных данных для механизма PLAIN в данном контексте защитного механизма, если защитный
     * механизм имеет тип {@link ZMQ.Socket.Mechanism#PLAIN}, в противном случае возвращается null
     * @see <a href="https://rfc.zeromq.org/spec:24/ZMTP-PLAIN">Спецификация механизма PLAIN</a>
     */
    PlainCredentials getPlainCredentials();

    /**
     * Получает учётные данные для механизма CURVE в данном контексте защитного механизма.
     *
     * @return экземпляр учётных данных для механизма CURVE в данном контексте защитного механизма, если защитный
     * механизм имеет тип {@link ZMQ.Socket.Mechanism#CURVE}, в противном случае возвращается null
     * @see <a href="http://curvezmq.org/page:read-the-docs">Документация механизма CURVE</a>
     * @see <a href="https://rfc.zeromq.org/spec:26/CURVEZMQ">Спецификация механизма CURVE</a>
     */
    CurveCredentials getCurveCredentials();

    /**
     * Создаёт контекст защитного механизма, не предполагающий реализации какой-либо защиты.
     *
     * @return экземпляр контекста защитного механизма {@link ZMQ.Socket.Mechanism#NULL}
     */
    static AuthContext none() {
        return new SimpleAuthContext();
    }
}
