package com.enfernuz.quik.lua.rpc.events.api;

import com.enfernuz.quik.lua.rpc.io.Gateway;

public interface QluaEventPoller extends QluaEventSubscription, Gateway {

    QluaEvent poll() throws PollingException;

    final class PollingException extends RuntimeException {

        public PollingException(String message) {
            super(message);
        }

        public PollingException(String message, Throwable cause) {
            super(message, cause);
        }
    }
}
