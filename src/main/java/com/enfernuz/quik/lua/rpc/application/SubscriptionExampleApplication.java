package com.enfernuz.quik.lua.rpc.application;

import com.enfernuz.quik.lua.rpc.config.ClientConfiguration;
import com.enfernuz.quik.lua.rpc.config.JsonClientConfigurationReader;
import com.enfernuz.quik.lua.rpc.config.ObjectReader;
import com.enfernuz.quik.lua.rpc.events.api.LoggingEventHandler;
import com.enfernuz.quik.lua.rpc.events.impl.ZmqTcpQluaEventProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

public class SubscriptionExampleApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(SubscriptionExampleApplication.class);

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
        try (final ZmqTcpQluaEventProcessor eventProcessor =
                     ZmqTcpQluaEventProcessor.newInstance(config.getNetworkAddress(), config.getAuthContext())) {

            LOGGER.info("Подписка на все события...");
            eventProcessor.subscribeToEverything();

            LOGGER.info("Регистрация обработчиков событий...");
            eventProcessor.register(LoggingEventHandler.INSTANCE);

            LOGGER.info("Соединение с RPC-сервисом...");
            eventProcessor.open();

            final Scanner scanner = new Scanner(System.in);

            LOGGER.info("Начало обработки событий. Нажмите любую клавишу для остановки...");
            while ( !scanner.hasNext() ) {
                eventProcessor.process(1);
            }

            LOGGER.info("Выход из программы...");
        } catch (final Exception ex) {
            LOGGER.error("Не удалось начать обработку событий.", ex);
        }
    }
}
