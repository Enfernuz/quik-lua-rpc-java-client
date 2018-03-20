package com.enfernuz.quik.lua.rpc.api.security.zmq;

import com.google.common.base.MoreObjects;
import com.google.common.base.Strings;

import java.util.Objects;

import static com.google.common.base.Preconditions.checkArgument;
import static java.util.Objects.requireNonNull;

/**
 * Базовая реализация учётных данных клиента для защитного механизма ZeroMQ PLAIN.
 */
public final class SimplePlainCredentials implements PlainCredentials {

    private final String username;
    private final String password;

    /**
     * Создать учётные данные клиента для защитного механизма ZeroMQ PLAIN.
     *
     * @param username  имя клиента
     * @param password  пароль клиента
     * @throws IllegalArgumentException если указанное имя клиента является null или пустой строкой
     * @throws NullPointerException если указанный пароль клиента является null
     */
    public SimplePlainCredentials(final String username, final String password) {

        checkArgument(
                !Strings.isNullOrEmpty(username),
                "The argument \"username\" must not be null or an empty string."
        );

        this.password = requireNonNull(password, "The argument \"password\" must not be null.");
        this.username = username;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public boolean equals(final Object o) {

        if (o == this) {
            return true;
        } else if ( !(o instanceof SimplePlainCredentials) ) {
            return false;
        } else {
            final SimplePlainCredentials other = (SimplePlainCredentials) o;
            return Objects.equals(username, other.username) && Objects.equals(password, other.password);
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("username", username)
                .add("password", password)
                .toString();
    }
}
