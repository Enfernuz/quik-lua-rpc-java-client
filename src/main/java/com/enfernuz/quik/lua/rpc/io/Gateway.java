package com.enfernuz.quik.lua.rpc.io;

import java.io.IOException;

/**
 * Интерфейс сущностей типа Шлюз, для которых допустимы действия "открыть" и "закрыть".
 */
public interface Gateway extends AutoCloseable {

    /**
     * Открывает шлюз.
     *
     * @throws IOException в случае ошибки ввода/вывода при открытии шлюза
     */
    void open() throws IOException;

    /**
     * Определяет, открыт ли шлюз.
     *
     * @return true, если шлюз открыт; в противном случае -- false
     */
    boolean isOpened();

    /**
     * Закрывает шлюз.
     *
     * @throws IOException в случае ошибки ввода/вывода при закрытии шлюза
     */
    @Override
    void close() throws IOException;
}
