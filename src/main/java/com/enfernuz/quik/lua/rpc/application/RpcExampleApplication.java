package com.enfernuz.quik.lua.rpc.application;

import com.enfernuz.quik.lua.rpc.api.zmq.ZmqTcpQluaRpcClient;
import com.enfernuz.quik.lua.rpc.api.zmq.impl.ZmqTcpQluaRpcClientImpl;
import com.enfernuz.quik.lua.rpc.api.security.zmq.*;
import com.enfernuz.quik.lua.rpc.io.transport.NetworkAddress;
import com.enfernuz.quik.lua.rpc.io.transport.SimpleNetworkAddress;
import qlua.rpc.Message;

public class RpcExampleApplication {

    public static void main(final String[] args) throws Exception {

        // this is just for the testing purposes for now

        final NetworkAddress networkAddress = new SimpleNetworkAddress("127.0.0.1", 5560);

        final CurveKey serverPublicKey = CurveKey.fromString("rq:rM>}U?@Lns47E1%kR.o@n%FcmmsL/@{H8]yf7");
        final CurveKey clientPublicKey = CurveKey.fromString("Yne@$w-vo<fVvi]a<NY6T1ed:M$fCG*[IaLV{hID");
        final CurveKey clientSecretKey = CurveKey.fromString("D:)Q[IlAW!ahhC2ac:9*A}h:p?([4%wOTJ%JR%cs");
        final CurveKeyPair clientKeyPair = new CurveKeyPair(clientPublicKey, clientSecretKey);
        final CurveCredentials curveCredentials = new SimpleCurveCredentials(serverPublicKey, clientKeyPair);

        final AuthContext authContext = AuthContext.none();//new SimpleAuthContext(curveCredentials);

        try (final ZmqTcpQluaRpcClient rpcClient = ZmqTcpQluaRpcClientImpl.newInstance(networkAddress, authContext)) {

            rpcClient.open();

            final Message.Request request =
                    qlua.rpc.Message.Request.newBuilder()
                            .setMessage("Hello world!")
                            .setIconType(qlua.rpc.Message.IconType.INFO)
                            .build();

            final Message.Result result = rpcClient.qlua_message(request);

            System.out.println("Result of the MESSAGE remote procedure call: " + result.getResult());
        }
    }
}
