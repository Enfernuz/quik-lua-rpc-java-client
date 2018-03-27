package com.enfernuz.quik.lua.rpc.api.zmq;

import com.enfernuz.quik.lua.rpc.io.transport.TcpGateway;

/**
 * Компонент <b>Java-обёртка над API QLua терминала QUIK</b>, удовлетворяющий следующим критериям:
 * <ul>
 *     <li>1. передача данных с помощью ZeroMQ</li>
 *     <li>2. использование протокола TCP на транспортном уровне для осуществления межпроцессного взаимодействия</li>
 *     <li>3. поддержка защиты передачи данных с помощью механизмов ZeroMQ</li>
 * </ul>
 *
 * @see <a href="http://zeromq.org/">ZeroMQ - Distributed Messaging</a>
 */
public interface ZmqTcpQluaRpcClient extends ZmqQluaRpcClient, TcpGateway {
}
