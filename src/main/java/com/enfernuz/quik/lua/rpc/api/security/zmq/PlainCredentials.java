package com.enfernuz.quik.lua.rpc.api.security.zmq;

/**
 * Учётные данные клиента для защитного механизма PLAIN.
 *
 * @see <a href="https://rfc.zeromq.org/spec:24/ZMTP-PLAIN">Спецификация механизма PLAIN</a>
 */
public interface PlainCredentials {

    /**
     * Получает имя клиента.
     *
     * @return непустая строка
     */
    String getUsername();

    /**
     * Получает пароль клиента.
     *
     * @return пароль клиента, может быть пустой строкой
     */
    String getPassword();
}
