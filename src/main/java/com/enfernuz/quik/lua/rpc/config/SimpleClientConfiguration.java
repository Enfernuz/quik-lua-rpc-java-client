package com.enfernuz.quik.lua.rpc.config;

import com.enfernuz.quik.lua.rpc.api.security.zmq.AuthContext;
import com.enfernuz.quik.lua.rpc.io.transport.NetworkAddress;
import com.google.common.base.MoreObjects;

import java.util.Objects;

import static java.util.Objects.requireNonNull;

/**
 * Базовая реализация конфигурации клиента RPC-сервиса <b>quik-lua-rpc</b>.
 *
 * @see <a href="https://github.com/Enfernuz/quik-lua-rpc">quik-lua-rpc</a>
 */
final class SimpleClientConfiguration implements ClientConfiguration {

    private final NetworkAddress networkAddress;
    private final AuthContext authContext;

    /**
     * Создаёт новый экземпляр базовая реализации конфигурации клиента RPC-сервиса <b>quik-lua-rpc</b> с точкой
     * подключения по заданному сетевому адресу и заданным контекстом защиты передачи данных.
     *
     * @param networkAddress  сетевой адрес точки подключения RPC-сервиса на стороне терминала QUIK
     * @param authContext  контекст защиты передачи данных
     */
    public SimpleClientConfiguration(final NetworkAddress networkAddress, final AuthContext authContext) {
        this.networkAddress = requireNonNull(networkAddress, "The argument \"networkAddress\" must not be null.");
        this.authContext = requireNonNull(authContext, "The argument \"authContext\" must not be null.");
    }

    @Override
    public NetworkAddress getNetworkAddress() {
        return networkAddress;
    }

    @Override
    public AuthContext getAuthContext() {
        return authContext;
    }

    @Override
    public boolean equals(Object o) {

        if (o == this) {
            return true;
        } else if ( !(o instanceof SimpleClientConfiguration) ) {
            return false;
        } else {
            final SimpleClientConfiguration other = (SimpleClientConfiguration) o;
            return Objects.equals(networkAddress, other.networkAddress)
                    && Objects.equals(authContext, other.authContext);
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(networkAddress, authContext);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("networkAddress", networkAddress)
                .add("authContext", authContext)
                .toString();
    }
}
