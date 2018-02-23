package com.enfernuz.quik.lua.rpc.application;

import com.enfernuz.quik.lua.rpc.config.ClientConfiguration;
import com.enfernuz.quik.lua.rpc.config.JsonClientConfigurationReader;
import com.enfernuz.quik.lua.rpc.config.ObjectReader;
import com.enfernuz.quik.lua.rpc.events.api.LoggingEventHandler;
import com.enfernuz.quik.lua.rpc.events.impl.ZmqTcpQluaEventProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;

public class SubscriptionExampleApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(SubscriptionExampleApplication.class);

    public static void main(final String[] args) throws Exception {

        LOGGER.info("Reading the config file...");
        final ClientConfiguration config =
                JsonClientConfigurationReader.INSTANCE
                        .read(new File(args[0]));

        LOGGER.info("Initializing the module...");
        try (final ZmqTcpQluaEventProcessor eventProcessor =
                     ZmqTcpQluaEventProcessor.newInstance(config.getNetworkAddress(), config.getAuthContext())) {

            LOGGER.info("Subscribing to everything...");
            eventProcessor.subscribeToEverything();

            LOGGER.info("Registering event handlers...");
            eventProcessor.register(LoggingEventHandler.INSTANCE);

            LOGGER.info("Opening a connection...");
            eventProcessor.open();

            LOGGER.info("Start processing...");
            do {
                eventProcessor.process();
            } while (true);
        }
    }
}
