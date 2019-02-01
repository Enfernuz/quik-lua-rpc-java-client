package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.google.protobuf.GeneratedMessageV3;

/**
 * Интерфейс компонента для преобразования экземпляров классов, сгенерированных protobuf-плагином, в экземпляры
 * соответствующих классов фреймворка.
 *
 * @param <PB_OBJECT>  класс, сгенерированный protobuf-плагином
 * @param <DOMAIN_OBJECT>  класс фреймворка, соответствующий классу, сгененированному protobuf-плагином
 */
public interface FromPbConverter<PB_OBJECT extends GeneratedMessageV3, DOMAIN_OBJECT> {

    /**
     * Конвертирует экземпляр класса, сгенерированного protobuf-плагином, в экземпляр соответствующего класса фреймворка.
     *
     * @param pbObject  экземпляр класса, сгенерированного protobuf плагином
     * @return экземпляр класса фреймворка, соответствующего классу заданного объекта
     */
    DOMAIN_OBJECT convert(PB_OBJECT pbObject);
}
