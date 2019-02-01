package com.enfernuz.quik.lua.rpc.config;

import com.enfernuz.quik.lua.rpc.api.security.zmq.AuthContext;
import com.enfernuz.quik.lua.rpc.io.transport.NetworkAddress;

/**
 * Конфигурация клиента RPC-сервиса <b>quik-lua-rpc</b>.
 *
 * @see <a href="https://github.com/Enfernuz/quik-lua-rpc">quik-lua-rpc</a>
 */
public interface ClientConfiguration {

    /**
     * Получает сетевой адрес точки подключения RPC-сервиса <b>quik-lua-rpc</b>.
     *
     * @return  сетевой адрес точки подключения RPC-сервиса <b>quik-lua-rpc</b>
     */
    NetworkAddress getNetworkAddress();

    /**
     * Получает контекст защиты передачи данных для точки подключения RPC-сервиса <b>quik-lua-rpc</b>.
     *
     * @return  контекст защиты передачи данных для точки подключения RPC-сервиса <b>quik-lua-rpc</b>
     */
    AuthContext getAuthContext();

    /**
     * Получает протокол сериализации/десериализации сообщений к/от RPC-сервису <b>quik-lua-rpc</b>.
     *
     * @return  протокол сериализации/десериализации сообщений к/от RPC-сервису <b>quik-lua-rpc</b>
     */
    SerdeProtocol getSerdeProtocol();

    enum SerdeProtocol { JSON, PROTOBUF }
}
