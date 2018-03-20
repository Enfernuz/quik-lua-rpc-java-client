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
     * @see <a href="https://rfc.zeromq.org/spec:24/ZMTP-PLAIN">Спецификация механизма PLAIN</a>
     */
    PlainCredentials getPlainCredentials();

    /**
     * Получить учётные данные для механизма CURVE в данном контексте защитного механизма.
     * @return экземпляр учётных данных для механизма CURVE в данном контексте защитного механизма, если защитный
     * механизм имеет тип {@code ZMQ.Socket.Mechanism.CURVE}, в противном случае возвращается {@code null}
     * @see <a href="http://curvezmq.org/page:read-the-docs">Документация механизма CURVE</a>
     * @see <br/><a href="https://rfc.zeromq.org/spec:26/CURVEZMQ">Спецификация механизма CURVE</a>
     */
    CurveCredentials getCurveCredentials();

    /**
     * Создать контекст защитного механизма {@link ZMQ.Socket.Mechanism#NULL}, не предполагающий реализации какой-либо
     * защиты.
     * @return экземпляр контекста защитного механизма {@link ZMQ.Socket.Mechanism#NULL}, не предполагающего реализации
     * какой-либо защиты
     */
    static AuthContext none() {
        return new SimpleAuthContext();
    }
}
