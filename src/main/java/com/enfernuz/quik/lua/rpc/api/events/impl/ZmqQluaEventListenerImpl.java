package com.enfernuz.quik.lua.rpc.api.events.impl;

import com.enfernuz.quik.lua.rpc.api.events.QluaEvent;
import com.enfernuz.quik.lua.rpc.api.events.QluaEventListener;
import com.enfernuz.quik.lua.rpc.api.io.Gateway;
import org.zeromq.ZMQ;
import qlua.events.QluaEvents;

import java.io.IOException;

import static java.util.Objects.requireNonNull;

public final class ZmqQluaEventListenerImpl implements QluaEventListener, Gateway {

    private final ZMQ.Context context;
    private final ZMQ.Socket socket;
    private final String uri;
    private boolean isOpened;

    private ZmqQluaEventListenerImpl(
            final ZMQ.Context context,
            final ZMQ.Socket socket,
            final String uri) {

        this.context = context;
        this.socket = socket;
        this.uri = uri;
    }

    @Override
    public QluaEvent get() {
        return null;
    }

    @Override
    public void open() throws IOException {

        if (!this.isOpened) {

            final boolean _isConnected  = this.socket.connect(uri);
            if (_isConnected) {
                this.isOpened = true;
            } else {
                throw new IOException( String.format("Couldn't connect to '%s'.", uri) );
            }
        }
    }

    @Override
    public boolean isOpened() {
        return isOpened;
    }

    @Override
    public void subscribe(final QluaEvents.EventType eventType) {

        checkEventType(eventType);

        final String topic = String.valueOf(eventType.getNumber());
        socket.subscribe(topic);

        return false;
    }

    @Override
    public void unsubscribe(QluaEvents.EventType eventType) {
        return false;
    }

    @Override
    public void close() throws Exception {

        if (this.isOpened) {

            final boolean isDisconnected = this.socket.disconnect(uri);
            if (isDisconnected) {
                this.isOpened = false;
            } else {
                throw new IOException( String.format("Couldn't disconnect from '%s'.", uri) );
            }
        }
    }

    @Override
    public String getURI() {
        return uri;
    }

    private static void checkEventType(final QluaEvents.EventType eventType) {

        requireNonNull(eventType, "The argument 'eventType' must not be null.");

        if (eventType == QluaEvents.EventType.EVENT_TYPE_UNKNOWN || eventType == QluaEvents.EventType.UNRECOGNIZED) {
            throw new IllegalArgumentException("The argument 'eventType' must not be EVENT_TYPE_UNKNOWN or UNRECOGNIZED.");
        }
    }
}
