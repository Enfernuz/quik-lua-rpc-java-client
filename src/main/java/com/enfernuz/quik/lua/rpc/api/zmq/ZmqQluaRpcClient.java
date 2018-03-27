package com.enfernuz.quik.lua.rpc.api.zmq;

import com.enfernuz.quik.lua.rpc.api.QluaRpcClient;
import com.enfernuz.quik.lua.rpc.api.security.zmq.ZmqSecurable;

/**
 * Компонент, представляющий собой Java-обёртку над API QLua терминала QUIK и поддерживающий защищённую передачу данных
 * с помощью ZeroMQ.
 *
 * @see <a href="http://zeromq.org/">ZeroMQ - Distributed Messaging</a>
 */
public interface ZmqQluaRpcClient extends QluaRpcClient, ZmqSecurable {
}
