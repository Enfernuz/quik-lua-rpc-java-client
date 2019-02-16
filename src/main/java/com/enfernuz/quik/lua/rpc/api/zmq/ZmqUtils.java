package com.enfernuz.quik.lua.rpc.api.zmq;

import com.enfernuz.quik.lua.rpc.api.security.zmq.AuthContext;
import com.enfernuz.quik.lua.rpc.api.security.zmq.CurveCredentials;
import com.enfernuz.quik.lua.rpc.api.security.zmq.CurveKeyPair;
import com.enfernuz.quik.lua.rpc.api.security.zmq.PlainCredentials;
import org.jetbrains.annotations.NotNull;
import org.zeromq.ZFrame;
import org.zeromq.ZMQ;
import org.zeromq.ZMsg;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

final class ZmqUtils {

    private ZmqUtils() {}

    public static @NotNull byte[] convertZMsgToByteArray(@NotNull final ZMsg message) throws IOException {

        // our event data is small (at the moment, at least), so it's safe to cast the content size to int
        final ByteArrayOutputStream output = new ByteArrayOutputStream( (int) message.contentSize() );
        for (final ZFrame frame : message) {
            output.write( frame.getData() );
        }

        return output.toByteArray();
    }

    public static void setSocketSecurity(@NotNull final ZMQ.Socket socket, @NotNull final AuthContext authContext) {

        switch (authContext.getAuthMechanism()) {
            case PLAIN:
                final PlainCredentials plainCredentials = authContext.getPlainCredentials();
                socket.setPlainUsername( plainCredentials.getUsername() );
                socket.setPlainPassword( plainCredentials.getPassword() );
                break;
            case CURVE:
                final CurveCredentials curveCredentials = authContext.getCurveCredentials();
                final CurveKeyPair clientKeyPair = curveCredentials.getClientKeyPair();
                socket.setCurveServerKey( curveCredentials.getServerPublicKey().asBinary() );
                socket.setCurvePublicKey( clientKeyPair.getPublicKey().asBinary() );
                socket.setCurveSecretKey( clientKeyPair.getSecretKey().asBinary() );
                break;
            case NULL:
                break;
            default:
                throw new IllegalStateException(
                        "Неподдерживаемый механизм аутентификации: '" + authContext.getAuthMechanism() + "'."
                );
        }
    }
}
