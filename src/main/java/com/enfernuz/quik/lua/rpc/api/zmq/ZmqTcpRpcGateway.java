package com.enfernuz.quik.lua.rpc.api.zmq;

import com.enfernuz.quik.lua.rpc.io.transport.TcpGateway;

/**
 * Компонент <b>TCP-шлюз удалённого вызова процедур на базе ZeroMQ</b>, удовлетворяющий следующим критериям:
 * <ul>
 *     <li>1. является {@link ZmqRpcGateway шлюзом удалённого вызова процедур на базе ZeroMQ}</li>
 *     <li>2. является {@link TcpGateway TCP-шлюзом}</li>
 * </ul>
 */
public interface ZmqTcpRpcGateway extends ZmqRpcGateway, TcpGateway {
}
