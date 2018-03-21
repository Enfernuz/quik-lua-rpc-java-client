package com.enfernuz.quik.lua.rpc.io.transport;

import com.enfernuz.quik.lua.rpc.io.Gateway;

/**
 * Интерфейс сущностей типа TCP-шлюз.
 * <p/>
 * TCP-шлюз инкапсулирует работу с TCP-соединением, относящимся к определённому сетевому адресу.
 */
public interface TcpGateway extends Gateway {

    /**
     * Получает сетевой адрес TCP-шлюза.
     *
     * @return сетевой адрес TCP-шлюза
     */
    NetworkAddress getNetworkAddress();
}
