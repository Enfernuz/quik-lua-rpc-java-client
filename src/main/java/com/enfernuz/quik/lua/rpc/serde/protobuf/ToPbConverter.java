package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.google.protobuf.GeneratedMessageV3;

/**
 * Интерфейс компонента для преобразования экземпляров классов классов фреймворка в экземпляры соответствующих классов,
 * сгенерированных protobuf-плагином.
 *
 * @param <PB_OBJECT>  класс, сгенерированный protobuf-плагином
 * @param <DOMAIN_OBJECT>  класс фреймворка, соответствующий классу, сгененированному protobuf-плагином
 */
public interface ToPbConverter<DOMAIN_OBJECT, PB_OBJECT extends GeneratedMessageV3> {

    /**
     * Конвертирует экземпляр класс фреймворка в экземпляр соответствующего класса, сгенерированного protobuf-плагином.
     *
     * @param domainObject  экземпляр класса фреймворка
     * @return экземпляр соответствующего класса, сгенерированного protobuf-плагином
     */
    PB_OBJECT convert(DOMAIN_OBJECT domainObject);
}
