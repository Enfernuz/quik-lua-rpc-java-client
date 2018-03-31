package com.enfernuz.quik.lua.rpc.config;

import java.io.File;
import java.io.IOException;

/**
 * Компонент десериализации объекта заданного типа из файла.
 *
 * @param <T>  тип сериализованного в файл объекта
 */
public interface ObjectReader<T> {

    /**
     * Десериализует объект из заданного файла.
     *
     * @param file  файл, в котором сериализован объект
     * @return  десериализованный объект
     * @throws IOException  в случае ошибки при работе с файлом
     */
    T read(File file) throws IOException;
}
