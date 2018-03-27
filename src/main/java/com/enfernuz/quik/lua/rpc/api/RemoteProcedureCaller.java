package com.enfernuz.quik.lua.rpc.api;

import com.google.protobuf.MessageLite;
import qlua.rpc.RPC;

import java.io.IOException;

/**
 * Интерфейс компонента, выполняющего удалённый вызов процедур к API QLua терминала QUIK в формате удалённого вызова
 * процедур.
 */
public interface RemoteProcedureCaller {

    /**
     * Выполняет удалённый вызов процедуры API QLua терминала QUIK без передачи аргументов.
     *
     * @param procedureType  тип вызываемой процедуры
     * @return результат вызова процедуры
     * @throws RpcException в случае возникновения ошибки при вызове процедуры
     */
    RPC.Response call(RPC.ProcedureType procedureType) throws RpcException;

    /**
     * Выполняет удалённый вызов процедуры API QLua терминала QUIK с передачей аргументов.
     *
     * @param procedureType  тип вызываемой процедуры
     * @param args  аргументы вызываемой процедуры
     * @return результат вызова процедуры
     * @throws RpcException в случае возникновения ошибки при вызове процедуры
     */
    RPC.Response call(RPC.ProcedureType procedureType, MessageLite args) throws RpcException;

    /**
     * Исключение, бросаемое в случае возникновения ошибки при удалённом вызове процедуры к API QLua терминала QUIK.
     */
    final class RpcException extends IOException {

        /**
         * Создаёт экземпляр исключения с указанным сообщением.
         *
         * @param message  сообщение
         */
        public RpcException(String message) {
            super(message);
        }

        /**
         * Создаёт экземпляр исключения с указанными сообщением и причиной.
         *
         * @param message  сообщение
         * @param cause  причина
         */
        public RpcException(String message, Throwable cause) {
            super(message, cause);
        }
    }
}
