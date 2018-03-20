package com.enfernuz.quik.lua.rpc.api.security.zmq;

import com.enfernuz.quik.lua.rpc.api.security.Securable;

/**
 * Интерфейс для сущностей, находящихся в контексте защитных механизмов ZeroMQ.
 */
public interface ZmqSecurable extends Securable {

    /**
     * Получает контекст защитного механизма ZeroMQ для данного экземпляра.
     *
     * @return контекст защитного механизма ZeroMQ для данного экземпляра
     */
    AuthContext getAuthContext();
}
