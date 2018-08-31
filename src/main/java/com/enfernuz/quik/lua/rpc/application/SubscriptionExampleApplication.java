package com.enfernuz.quik.lua.rpc.application;

import com.enfernuz.quik.lua.rpc.config.ClientConfiguration;
import com.enfernuz.quik.lua.rpc.config.JsonClientConfigurationReader;
import com.enfernuz.quik.lua.rpc.events.api.LoggingEventHandler;
import com.enfernuz.quik.lua.rpc.events.api.PollingMode;
import com.enfernuz.quik.lua.rpc.events.api.QluaEventProcessor;
import com.enfernuz.quik.lua.rpc.api.zmq.ZmqTcpQluaEventProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
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
        final ExecutorService stdinScannerExecutorService = Executors.newSingleThreadExecutor();
        try (final ZmqTcpQluaEventProcessor eventProcessor = ZmqTcpQluaEventProcessor.newInstance(config, PollingMode.BLOCKING)) {

            LOGGER.info("Подписка на все события...");
            eventProcessor.subscribeToEverything();

            LOGGER.info("Регистрация обработчиков событий...");
            eventProcessor.register(LoggingEventHandler.INSTANCE);

            LOGGER.info("Соединение с RPC-сервисом...");
            eventProcessor.open();

            // monitor the Enter key pressing
            final AtomicBoolean enough = new AtomicBoolean(false);
            stdinScannerExecutorService.execute(() -> {

                try {
                    enough.set(System.in.read() > 0);
                } catch (final Exception ex) {
                    LOGGER.error("Ошибка при чтении стандартного потока ввода.", ex);
                }
            });

            LOGGER.info("Начало обработки событий. Нажмите Enter для остановки...");
            while ( !enough.get() ) {
                eventProcessor.process(1);
            }

            LOGGER.info("Выход из программы...");
        } catch (final QluaEventProcessor.QluaEventProcessingException ex) {
            LOGGER.error("Ошибка при обработке события.", ex);
        } catch (final Exception ex) {
            LOGGER.error("Не удалось начать обработку событий.", ex);
        } finally {
            stdinScannerExecutorService.shutdownNow();
        }
    }
}
