package com.enfernuz.quik.lua.rpc.io.transport;

import com.google.common.base.Strings;

import java.util.Objects;

import static com.google.common.base.Preconditions.checkArgument;

/**
 * Базовая реализация сетевого адреса.
 */
public final class SimpleNetworkAddress implements NetworkAddress {

    private final String host;
    private final int port;

    /**
     * Создаёт экземпляр сетевого адреса с заданным наименованием хоста и портом.
     *
     * @param host  строковое наименование хоста, представляющее собой доменное имя или IP-адрес
     * @param port  порт
     * @throws IllegalArgumentException если указанное строковое наименование является null или пустой строкой
     * @throws IllegalArgumentException если указанный порт не лежит в диапазоне от 0 до 65535 включительно
     */
    public SimpleNetworkAddress(final String host, final int port) {

        checkArgument(
                port >= 0 && port <= 65535,
                "Порт должен быть целым числом в диапазоне от 0 до 65535 включительно."
        );

        checkArgument(
                !Strings.isNullOrEmpty(host),
                "Наименование хоста должно быть не-null непустой строкой."
        );

        this.host = host;
        this.port = port;
    }

    @Override
    public String getHost() {
        return host;
    }

    @Override
    public int getPort() {
        return port;
    }

    @Override
    public boolean equals(final Object o) {

        if (o == this) {
            return true;
        } else if ( !(o instanceof SimpleNetworkAddress) ) {
            return false;
        } else {
            final SimpleNetworkAddress other = (SimpleNetworkAddress) o;
            return Objects.equals(host, other.host) && Integer.compare(port, other.port) == 0;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(host, port);
    }

    /**
     * Возвращает строковое представление сетевого адреса.
     *
     * @return строка формата {@link SimpleNetworkAddress#getHost()}:{@link SimpleNetworkAddress#getPort()}
     */
    @Override
    public String toString() {
        return String.format("%s:%d", host, port);
    }
}
