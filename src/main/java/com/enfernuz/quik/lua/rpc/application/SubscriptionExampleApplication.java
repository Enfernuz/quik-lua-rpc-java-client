package com.enfernuz.quik.lua.rpc.application;

import com.enfernuz.quik.lua.rpc.api.security.zmq.*;
import com.enfernuz.quik.lua.rpc.events.api.LoggingEventHandler;
import com.enfernuz.quik.lua.rpc.events.impl.ZmqTcpQluaEventProcessor;
import com.enfernuz.quik.lua.rpc.io.transport.NetworkAddress;
import com.enfernuz.quik.lua.rpc.io.transport.SimpleNetworkAddress;

import java.util.concurrent.atomic.AtomicBoolean;

public class SubscriptionExampleApplication {

    public static void main(final String[] args) throws Exception {

        // TO-DO: read from config file

        final NetworkAddress networkAddress = new SimpleNetworkAddress("127.0.0.1", 5561);

        final CurveKey serverPublicKey = CurveKey.fromString("rq:rM>}U?@Lns47E1%kR.o@n%FcmmsL/@{H8]yf7");
        final CurveKey clientPublicKey = CurveKey.fromString("Yne@$w-vo<fVvi]a<NY6T1ed:M$fCG*[IaLV{hID");
        final CurveKey clientSecretKey = CurveKey.fromString("D:)Q[IlAW!ahhC2ac:9*A}h:p?([4%wOTJ%JR%cs");
        final CurveKeyPair clientKeyPair = new CurveKeyPair(clientPublicKey, clientSecretKey);
        final CurveCredentials curveCredentials = new SimpleCurveCredentials(serverPublicKey, clientKeyPair);

        final AuthContext authContext = AuthContext.none();//new SimpleAuthContext(curveCredentials);

        try (final ZmqTcpQluaEventProcessor eventProcessor = ZmqTcpQluaEventProcessor.newInstance(networkAddress, authContext)) {

            final AtomicBoolean isServiceStopped = new AtomicBoolean(false);

            eventProcessor.subscribeToEverything();
            eventProcessor.register(LoggingEventHandler.INSTANCE);

            eventProcessor.open();

            while ( !isServiceStopped.get() ) {
                eventProcessor.process();
            }
        }
    }
}
