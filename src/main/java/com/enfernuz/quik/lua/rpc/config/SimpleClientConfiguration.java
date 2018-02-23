package com.enfernuz.quik.lua.rpc.config;

import com.enfernuz.quik.lua.rpc.api.security.zmq.AuthContext;
import com.enfernuz.quik.lua.rpc.io.transport.NetworkAddress;
import com.google.common.base.MoreObjects;

import java.util.Objects;

import static java.util.Objects.requireNonNull;

final class SimpleClientConfiguration implements ClientConfiguration {

    private final NetworkAddress networkAddress;
    private final AuthContext authContext;

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
