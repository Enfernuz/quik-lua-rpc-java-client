package com.enfernuz.quik.lua.rpc.events.api;

import com.enfernuz.quik.lua.rpc.io.Gateway;

public interface QluaEventProcessor extends QluaEventHandlerRegistry, QluaEventSubscription, Gateway {

    // until there's no events left to process
    void process() throws QluaEventProcessingException;

    // process up to maxEvents events
    void process(int maxEvents) throws QluaEventProcessingException;

    public static final class QluaEventProcessingException extends RuntimeException {

        public QluaEventProcessingException(final String message, final Throwable cause) {
            super(message, cause);
        }

        public QluaEventProcessingException(final String message) {
            super(message);
        }
    }
}
