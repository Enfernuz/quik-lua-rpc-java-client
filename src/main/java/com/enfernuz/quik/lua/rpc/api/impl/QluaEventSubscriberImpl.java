package com.enfernuz.quik.lua.rpc.api.impl;

import com.enfernuz.quik.lua.rpc.events.api.QluaEventSubscription;
import org.zeromq.ZMQ;
import qlua.events.QluaEvents;

import java.io.IOException;

import static java.util.Objects.requireNonNull;

final class QluaEventSubscriberImpl implements QluaEventSubscription {

    private final MessageGateway zmgSubGateway;

    /**
     *
     * @param zmqContext
     * @return
     * @throws NullPointerException if any of the arguments are {@code null}
     * @throws IllegalArgumentException if the argument {@code 'zmqContext'} is in the terminated state
     */
    static QluaEventSubscriberImpl create(final ZMQ.Context zmqContext, final String host, final int port) {

        requireNonNull(zmqContext, "The argument 'zmqContext' must not be null.");
        if ( zmqContext.isTerminated() ) {
            throw new IllegalArgumentException("The argument 'zmqContext' must not be in the terminated state.");
        }

        // TO-DO: add URI validation
        final String uri = String.format("tcp://%s:%d", host, port);

        final MessageGateway zmgSubGateway = ZmqGatewayImpl.create(zmqContext, ZMQ.SUB, host, port);

        return new QluaEventSubscriberImpl(zmgSubGateway);
    }

    private QluaEventSubscriberImpl(final MessageGateway zmgSubGateway) {
        this.zmgSubGateway = zmgSubGateway;
    }

    @Override
    public boolean subscribe(final QluaEvents.EventType eventType) {

        checkEventType(eventType);

        return subSocket.subscribe( String.valueOf( eventType.getNumber() ) );
    }

    @Override
    public boolean unsubscribe(final QluaEvents.EventType eventType) {

        checkEventType(eventType);

        return subSocket.unsubscribe( String.valueOf( eventType.getNumber() ) );
    }

    @Override
    public void open() throws IOException {
        zmgSubGateway.open();
    }

    @Override
    public void close() throws Exception {
        zmgSubGateway.close();
    }

    public String getUri() {
        return zmgSubGateway.getUri();
    }

    private static void checkEventType(final QluaEvents.EventType eventType) {

        requireNonNull(eventType, "The argument 'eventType' must not be null.");

        if (eventType == QluaEvents.EventType.EVENT_TYPE_UNKNOWN || eventType == QluaEvents.EventType.UNRECOGNIZED) {
            throw new IllegalArgumentException("The argument 'eventType' must not be EVENT_TYPE_UNKNOWN or UNRECOGNIZED.");
        }
    }
}
