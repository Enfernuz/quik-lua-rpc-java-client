package com.enfernuz.quik.lua.rpc.api.security.zmq;

import org.zeromq.ZMQ;

/**
 * Контекст защитного механизма ZeroMQ.
 */
public interface AuthContext {

    /**
     * Получить тип защитного механизма ZeroMQ.
     * @return тип защитного механизма ZeroMQ
     */
    ZMQ.Socket.Mechanism getAuthMechanism();

    /**
     * Получить учётные данные для механизма PLAIN в данном контексте защитного механизма.
     * @return экземпляр учётных данных для механизма PLAIN в данном контексте защитного механизма, если защитный
     * механизм имеет тип {@code ZMQ.Socket.Mechanism.PLAIN}, в противном случае возвращается {@code null}
     */
    PlainCredentials getPlainCredentials();

    /**
     * Получить учётные данные для механизма CURVE в данном контексте защитного механизма.
     * @return экземпляр учётных данных для механизма CURVE в данном контексте защитного механизма, если защитный
     * механизм имеет тип {@code ZMQ.Socket.Mechanism.CURVE}, в противном случае возвращается {@code null}
     */
    CurveCredentials getCurveCredentials();

    /**
     * Создать контекст защитного механизма, не предполагающий реализации какой-либо защиты.
     * @return экземпляр контекста защитного механизма, не предполагающего реализации какой-либо защиты
     */
    static AuthContext none() {
        return new SimpleAuthContext();
    }
}
