package com.enfernuz.quik.lua.rpc.events.impl;

import com.enfernuz.quik.lua.rpc.events.api.QluaEvent;
import com.enfernuz.quik.lua.rpc.events.api.QluaEventPoller;
import com.enfernuz.quik.lua.rpc.io.transport.TcpGateway;
import com.google.common.collect.ImmutableSet;
import com.google.protobuf.ByteString;
import org.zeromq.ZFrame;
import org.zeromq.ZMQ;
import org.zeromq.ZMsg;
import qlua.events.QluaEvents;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static com.google.common.base.Preconditions.*;
import static java.util.Objects.requireNonNull;

/**
 *
 * Instances of this class are not thread-safe.
 *
 */
public final class ZmqQluaEventListener {//implements QluaEventPoller, TcpGateway {

//    private final ZMQ.Socket subSocket;
//    private final String host;
//    private final int port;
//    private final String uri;
//    private boolean isOpened;
//    private final Set<QluaEvents.EventType> subscription;
//
//    public static ZmqQluaEventListener newInstance(final ZMQ.Context context, final String host, final int port) {
//
//        requireNonNull(context, "The argument 'context' must not be null.");
//        checkArgument(!context.isTerminated(), "The argument 'context' must not be in the terminated state.");
//
//        // TO-DO: add parameters validation
//
//        final ZMQ.Socket subSocket = context.socket(ZMQ.SUB);
//
//        return new ZmqQluaEventListener(subSocket, host, port);
//    }
//
//    private ZmqQluaEventListener(final ZMQ.Socket subSocket, final String host, final int port) {
//
//        this.subSocket = subSocket;
//        this.host = host;
//        this.port = port;
//        this.uri = String.format("tcp://%s:%d", host, port);
//        this.subscription = new HashSet<>();
//    }
//
//    @Override
//    public void subscribe(final QluaEvents.EventType eventType) {
//
//        checkEventType(eventType);
//        subscribeToEventType(eventType);
//    }
//
//    @Override
//    public void subscribe(final ImmutableSet<QluaEvents.EventType> eventTypes) {
//
//        requireNonNull(eventTypes, "The argument 'eventTypes' must not be null");
//
//        // need the two-pass iteration so to not to left the subscription is an inconsistent state if some of
//        // event types in the argument's set are illegal
//        for (final QluaEvents.EventType eventType : eventTypes) {
//            checkEventType(eventType);
//        }
//
//        for (final QluaEvents.EventType eventType : eventTypes) {
//            subscribeToEventType(eventType);
//        }
//    }
//
//    @Override
//    public void unsubscribe(final QluaEvents.EventType eventType) {
//
//        checkEventType(eventType);
//        unsubscribeFromEventType(eventType);
//    }
//
//    @Override
//    public void unsubscribe(final ImmutableSet<QluaEvents.EventType> eventTypes) {
//
//        requireNonNull(eventTypes, "The argument 'eventTypes' must not be null");
//
//        // need the two-pass iteration so to not to left the subscription is an inconsistent state if some of
//        // event types in the argument's set are illegal
//        for (final QluaEvents.EventType eventType : eventTypes) {
//            checkEventType(eventType);
//        }
//
//        for (final QluaEvents.EventType eventType : eventTypes) {
//            unsubscribeFromEventType(eventType);
//        }
//    }
//
//    @Override
//    public Optional<QluaEvent> poll() throws PollingException {
//
//        try {
//
//            final QluaEvent result;
//
//            final byte[] subscriptionKeyAsBytes = subSocket.recv();
//            if (subscriptionKeyAsBytes == null) {
//                result = null;
//            } else {
//
//                final String subscriptionKeyAsString = new String(subscriptionKeyAsBytes, StandardCharsets.UTF_8);
//                final int subscriptionKey = Integer.parseInt(subscriptionKeyAsString);
//                final QluaEvents.EventType eventType = QluaEvents.EventType.forNumber(subscriptionKey);
//
//                if (eventType == null) {
//                    throw new PollingException( String.format("Unknown subscription key: %d.", subscriptionKey) );
//                }
//
//                final boolean hasReceiveMore = subSocket.hasReceiveMore();
//
//                if (hasReceiveMore) {
//
//                    final ZMsg eventDataAsMsg = ZMsg.recvMsg(subSocket);
//                    if (eventDataAsMsg == null) {
//                        throw new PollingException(
//                                String.format("No event data has been received for the event '%s'.", eventType)
//                        );
//                    }
//
//                    final ByteString eventData = convertZMsgToByteString(eventDataAsMsg);
//                    result = QluaEvent.newInstance(eventType, eventData);
//                } else {
//                    result = QluaEvent.newInstance(eventType);
//                }
//            }
//
//            return Optional.of(result);
//        } catch (final PollingException ex) {
//            throw ex;
//        } catch (final Exception ex) {
//            throw new PollingException("Error while polling for events.", ex);
//        }
//    }
//
//    @Override
//    public ImmutableSet<QluaEvents.EventType> getCurrentSubscription() {
//        return ImmutableSet.copyOf(subscription);
//    }
//
//    @Override
//    public void open() throws IOException {
//
//        checkState(isOpened, "The gate is opened.");
//
//        final boolean _isConnected = subSocket.connect(uri);
//        if (_isConnected) {
//            isOpened = true;
//        } else {
//            throw new IOException( String.format("Couldn't connect to '%s'.", uri) );
//        }
//    }
//
//    @Override
//    public boolean isOpened() {
//        return isOpened;
//    }
//
//    @Override
//    public void close() throws Exception {
//
//        checkState(!isOpened, "The gate is closed.");
//
//        final boolean isDisconnected = subSocket.disconnect(uri);
//        if (isDisconnected) {
//            isOpened = false;
//        } else {
//            throw new IOException( String.format("Couldn't disconnect from '%s'.", uri) );
//        }
//    }
//
//    @Override
//    public String getHost() {
//        return host;
//    }
//
//    @Override
//    public int getPort() {
//        return port;
//    }
//
//    private void subscribeToEventType(final QluaEvents.EventType eventType) {
//
//        if ( !subscription.contains(eventType) ) {
//
//            final String topic = eventTypeToTopic(eventType);
//            subSocket.subscribe(topic);
//            subscription.add(eventType);
//        }
//    }
//
//    private void unsubscribeFromEventType(final QluaEvents.EventType eventType) {
//
//        if (subscription.contains(eventType)) {
//
//            final String topic = eventTypeToTopic(eventType);
//            subSocket.unsubscribe(topic);
//            subscription.remove(eventType);
//        }
//    }
//
//    private static void checkEventType(final QluaEvents.EventType eventType) {
//
//        requireNonNull(eventType, "The argument 'eventType' must not be null.");
//
//        checkArgument(
//                eventType != QluaEvents.EventType.EVENT_TYPE_UNKNOWN
//                        && eventType != QluaEvents.EventType.UNRECOGNIZED,
//                String.format(
//                        "The argument 'eventType' must not be %s or %s.",
//                        QluaEvents.EventType.EVENT_TYPE_UNKNOWN,
//                        QluaEvents.EventType.UNRECOGNIZED
//                )
//        );
//    }
//
//    private static String eventTypeToTopic(final QluaEvents.EventType eventType) {
//        return String.valueOf( eventType.getNumber() );
//    }
//
//    private static ByteString convertZMsgToByteString(final ZMsg message) throws IOException {
//
//        // our event data is small (at the moment, at least), so it's safe to cast the content size to a long
//        final ByteArrayOutputStream output = new ByteArrayOutputStream( (int) message.contentSize() );
//        for (final ZFrame frame : message) {
//            output.write( frame.getData() );
//        }
//
//        return ByteString.copyFrom( output.toByteArray() );
//    }
}
