package com.enfernuz.quik.lua.rpc.application;

import com.enfernuz.quik.lua.rpc.config.ClientConfiguration;
import com.enfernuz.quik.lua.rpc.config.JsonClientConfigurationReader;
import com.enfernuz.quik.lua.rpc.events.api.LoggingEventHandler;
import com.enfernuz.quik.lua.rpc.events.api.PollingMode;
import com.enfernuz.quik.lua.rpc.events.api.QluaEvent;
import com.enfernuz.quik.lua.rpc.events.api.QluaEventProcessor;
import com.enfernuz.quik.lua.rpc.api.zmq.ZmqTcpQluaEventProcessor;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

@Slf4j
public class ProtobufSubscriptionExampleApplication {

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
        final ExecutorService stdinScannerExecutorService = Executors.newSingleThreadExecutor();
        try (final ZmqTcpQluaEventProcessor eventProcessor = ZmqTcpQluaEventProcessor.newInstance(config, PollingMode.BLOCKING)) {

            log.info("Подписка на все события...");
            //eventProcessor.subscribeToEverything();
            eventProcessor.subscribe(QluaEvent.EventType.ON_FIRM);
            eventProcessor.subscribe(QluaEvent.EventType.ON_MONEY_LIMIT);

            log.info("Регистрация обработчиков событий...");
            eventProcessor.register(LoggingEventHandler.INSTANCE);

            log.info("Соединение с RPC-сервисом...");
            eventProcessor.open();

            // monitor the Enter key pressing
            final AtomicBoolean enough = new AtomicBoolean(false);
            stdinScannerExecutorService.execute(() -> {

                try {
                    enough.set(System.in.read() > 0);
                } catch (final Exception ex) {
                    log.error("Ошибка при чтении стандартного потока ввода.", ex);
                }
            });

            log.info("Начало обработки событий. Нажмите Enter для остановки...");
            while ( !enough.get() ) {
                eventProcessor.process(1);
            }

            log.info("Выход из программы...");
        } catch (final QluaEventProcessor.QluaEventProcessingException ex) {
            log.error("Ошибка при обработке события.", ex);
        } catch (final Exception ex) {
            log.error("Не удалось начать обработку событий.", ex);
        } finally {
            stdinScannerExecutorService.shutdownNow();
        }
    }
}
