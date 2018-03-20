package com.enfernuz.quik.lua.rpc.io.transport;

/**
 * Сетевой адрес.
 */
public interface NetworkAddress {

    /**
     * Получает наименование хоста сетевого адреса.
     *
     * @return наименование хоста сетевого адреса, непустая строка
     */
    String getHost();

    /**
     * Получает порт сетевого адреса.
     *
     * @return порт сетевого адреса, целое число в диапазоне от 0 до 65535 включительно
     */
    int getPort();
}
