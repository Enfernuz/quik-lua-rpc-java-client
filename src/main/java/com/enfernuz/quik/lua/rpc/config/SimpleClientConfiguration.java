package com.enfernuz.quik.lua.rpc.config;

import com.enfernuz.quik.lua.rpc.api.security.zmq.AuthContext;
import com.enfernuz.quik.lua.rpc.io.transport.NetworkAddress;
import com.google.common.base.MoreObjects;
import lombok.NonNull;
import lombok.Value;

/**
 * Базовая реализация конфигурации клиента RPC-сервиса <b>quik-lua-rpc</b>.
 *
 * @see <a href="https://github.com/Enfernuz/quik-lua-rpc">quik-lua-rpc</a>
 */

@Value
class SimpleClientConfiguration implements ClientConfiguration {

    @NonNull NetworkAddress networkAddress;
    @NonNull AuthContext authContext;
    @NonNull SerdeProtocol serdeProtocol;

    /**
     * Создаёт новый экземпляр базовая реализации конфигурации клиента RPC-сервиса <b>quik-lua-rpc</b> с точкой
     * подключения по заданному сетевому адресу и заданным контекстом защиты передачи данных.
     *
     * @param networkAddress  сетевой адрес точки подключения RPC-сервиса на стороне терминала QUIK
     * @param authContext  контекст защиты передачи данных
     * @param serdeProtocol  прокол сериализации/десериализации сообщений
     */
    public SimpleClientConfiguration(
            final NetworkAddress networkAddress,
            final AuthContext authContext,
            final SerdeProtocol serdeProtocol) {

        this.networkAddress = networkAddress;
        this.authContext = authContext;
        this.serdeProtocol = serdeProtocol;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("networkAddress", networkAddress)
                .add("authContext", authContext)
                .add("serdeProtocol", serdeProtocol)
                .toString();
    }
}
