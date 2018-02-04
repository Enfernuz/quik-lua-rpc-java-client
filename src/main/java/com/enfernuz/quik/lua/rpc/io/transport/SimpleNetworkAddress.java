package com.enfernuz.quik.lua.rpc.io.transport;

import java.util.Objects;

import static java.util.Objects.requireNonNull;

public final class SimpleNetworkAddress implements NetworkAddress {

    private final String host;
    private final int port;

    public SimpleNetworkAddress(final String host, final int port) {

        // TODO: add validation
        this.host = requireNonNull(host);
        this.port  = port;
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

    @Override
    public String toString() {
        return String.format("%s:%d", host, port);
    }
}
