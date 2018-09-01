package com.enfernuz.quik.lua.rpc.serde;

import com.google.protobuf.GeneratedMessageV3;

/**
 * Интерфейс компонента для преобразования экземпляров классов, сгенерированных protobuf-плагином, в экземпляры
 * соответствующих классов фреймворка, и обратно.
 *
 * @param <PB_OBJECT>  класс, сгенерированный protobuf-плагином
 * @param <DOMAIN_OBJECT>  класс фреймворка, соответствующий классу, сгененированному protobuf-плагином
 */
public interface PbConverter<PB_OBJECT extends GeneratedMessageV3, DOMAIN_OBJECT> {

    /**
     * Конвертирует экземпляр класса, сгенерированного protobuf-плагином, в экземпляр соответствующего класса фреймворка.
     *
     * @param pbObject  экземпляр класса, сгенерированного protobuf плагином
     * @return экземпляр класса фреймворка, соответствующего классу заданного объекта
     */
    DOMAIN_OBJECT convertFromPb(PB_OBJECT pbObject);

    /**
     * Конвертирует экземпляр класс фреймворка в экземпляр соответствующего класса, сгенерированного protobuf-плагином.
     *
     * @param domainObject  экземпляр класса фреймворка
     * @return экземпляр соответствующего класса, сгенерированного protobuf-плагином
     */
    PB_OBJECT convertToPb(DOMAIN_OBJECT domainObject);
}
