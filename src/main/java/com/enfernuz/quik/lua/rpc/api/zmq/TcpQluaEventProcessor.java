package com.enfernuz.quik.lua.rpc.api.zmq;

import com.enfernuz.quik.lua.rpc.events.api.QluaEventProcessor;
import com.enfernuz.quik.lua.rpc.io.transport.TcpGateway;

/**
 * Обработчик очереди событий API QLua терминала QUIK, полученных из удалённого RPC-сервиса <b>quik-lua-rpc</b>.
 * <br/>
 * Связь с <b>quik-lua-rpc</b> происходит по протоколу TCP.
 * @see <a href="https://github.com/Enfernuz/quik-lua-rpc">quik-lua-rpc</a>
 */
public interface TcpQluaEventProcessor extends QluaEventProcessor, TcpGateway {
}
