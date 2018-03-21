package com.enfernuz.quik.lua.rpc.api.zmq;

import com.enfernuz.quik.lua.rpc.api.RpcGateway;
import com.enfernuz.quik.lua.rpc.api.security.zmq.ZmqSecurable;

/**
 * Компонент <b>Шлюз удалённого вызова процедур на базе ZeroMQ</b>, удовлетворяющий следующим критериям:
 * <ul>
 *     <li>1. является {@link RpcGateway шлюзом удалённого вызова процедур}</li>
 *     <li>2. поддерживает механизмы защиты передачи данных, реализованные в ZeroMQ</li>
 * </ul>
 */
public interface ZmqRpcGateway extends RpcGateway, ZmqSecurable {
}
