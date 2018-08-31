package com.enfernuz.quik.lua.rpc.application;

import com.enfernuz.quik.lua.rpc.api.messages.Message;
import com.enfernuz.quik.lua.rpc.api.zmq.ZmqTcpQluaRpcClient;
import com.enfernuz.quik.lua.rpc.config.ClientConfiguration;
import com.enfernuz.quik.lua.rpc.config.JsonClientConfigurationReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

public class RpcExampleApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(RpcExampleApplication.class);

    public static void main(final String[] args) {

        final String filePath = args[0];
        if (filePath == null) {
            LOGGER.error("Не задан путь до файла конфигурации.");
            return;
        }

        File configFile;
        try {
            configFile = new File(filePath);
        } catch (final Exception ex) {
            LOGGER.error(String.format("Не удалось прочитать файл '%s'.", filePath), ex);
            return;
        }

        LOGGER.info("Чтение файла конфигурации...");
        ClientConfiguration config;
        try {
            config = JsonClientConfigurationReader.INSTANCE.read(configFile);
        } catch (final Exception ex) {
            LOGGER.error(String.format("Не удалось получить объект конфигурации из файла '%s'.", filePath), ex);
            return;
        }

        LOGGER.info("Инициализация клиента...");
        try (final ZmqTcpQluaRpcClient rpcClient = ZmqTcpQluaRpcClient.newInstance(config)) {

            LOGGER.info("Соединение с RPC-сервисом...");
            rpcClient.open();

            final Message.Request request = new Message.Request("Hello, world!", Message.IconType.WARNING);

            LOGGER.info("Выполнение удалённой процедуры 'message' на терминале QUIK...");
            final Message.Result result = rpcClient.qlua_message(request);

            LOGGER.info("Результат выполнения удалённой процедуры 'message': {}.", result.getResult());
            LOGGER.info("Выход из программы...");
        } catch (final Exception ex) {
            LOGGER.error("Не удалось выполнить удалённый вызов процедуры.", ex);
        }
    }
}
