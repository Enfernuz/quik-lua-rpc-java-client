package com.enfernuz.quik.lua.rpc.application;

import com.enfernuz.quik.lua.rpc.api.messages.Message;
import com.enfernuz.quik.lua.rpc.api.zmq.ZmqTcpQluaRpcClient;
import com.enfernuz.quik.lua.rpc.config.ClientConfiguration;
import com.enfernuz.quik.lua.rpc.config.JsonClientConfigurationReader;
import lombok.extern.slf4j.Slf4j;

import java.io.File;

@Slf4j
public class RpcExampleApplication {

    public static void main(final String[] args) {

        final String filePath = args[0];
        if (filePath == null) {
            log.error("Не задан путь до файла конфигурации.");
            return;
        }

        File configFile;
        try {
            configFile = new File(filePath);
        } catch (final Exception ex) {
            log.error(String.format("Не удалось прочитать файл '%s'.", filePath), ex);
            return;
        }

        log.info("Чтение файла конфигурации...");
        ClientConfiguration config;
        try {
            config = JsonClientConfigurationReader.INSTANCE.read(configFile);
        } catch (final Exception ex) {
            log.error(String.format("Не удалось получить объект конфигурации из файла '%s'.", filePath), ex);
            return;
        }

        log.info("Инициализация клиента...");
        try (final ZmqTcpQluaRpcClient rpcClient = ZmqTcpQluaRpcClient.newInstance(config)) {

            log.info("Соединение с RPC-сервисом...");
            rpcClient.open();


            log.info("Выполнение удалённой процедуры 'message' на терминале QUIK...");
            final Integer result = rpcClient.qlua_message("Hello, world!", Message.IconType.WARNING);
            if (result == null) {
                log.error("Удалённая процедура 'message' выполнилась с ошибкой.");
            } else {
                log.info("Результат выполнения удалённой процедуры 'message': {}.", result);
            }

            log.info("Выход из программы...");
        } catch (final Exception ex) {
            log.error("Не удалось выполнить удалённый вызов процедуры.", ex);
        }
    }
}
