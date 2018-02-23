package com.enfernuz.quik.lua.rpc.config;

import com.enfernuz.quik.lua.rpc.api.security.zmq.*;
import com.enfernuz.quik.lua.rpc.io.transport.NetworkAddress;
import com.enfernuz.quik.lua.rpc.io.transport.SimpleNetworkAddress;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.base.Strings;
import org.zeromq.ZMQ;

import static com.google.common.base.Preconditions.checkArgument;

final class SimpleClientConfigurationJsonDeserializer extends JsonDeserializer<SimpleClientConfiguration> {

    @Override
    public SimpleClientConfiguration deserialize(
            final JsonParser jsonParser,
            final DeserializationContext deserializationContext) throws JsonException {

        try {
            final JsonNode rootNode = jsonParser.getCodec().readTree(jsonParser);

            final NetworkAddress networkAddress = parseNetworkAddress( rootNode.get("address") );
            final AuthContext authContext = parseAuthContext( rootNode.get("auth") );

            return new SimpleClientConfiguration(networkAddress, authContext);
        } catch (final Exception ex) {
            throw new JsonException("Could not parse configuration object from JSON.", ex);
        }

    }

    private static NetworkAddress parseNetworkAddress(final JsonNode addressNode) {

        final String host = addressNode.get("host").asText();
        final int port = addressNode.get("port").asInt();

        return new SimpleNetworkAddress(host, port);
    }

    private static AuthContext parseAuthContext(final JsonNode authContextNode) {

        final String mechanismAsString = authContextNode.get("mechanism").asText();
        final ZMQ.Socket.Mechanism mechanism = ZMQ.Socket.Mechanism.valueOf(mechanismAsString);

        final AuthContext result;
        switch (mechanism) {
            case NULL:
                result = AuthContext.none();
                break;
            case PLAIN:
                final PlainCredentials plainCredentials = parsePlainCredentials( authContextNode.get("plain") );
                result = new SimpleAuthContext(plainCredentials);
                break;
            case CURVE:
                final CurveCredentials curveCredentials = parseCurveCredentials( authContextNode.get("curve") );
                result = new SimpleAuthContext(curveCredentials);
                break;
            default:
                throw new IllegalArgumentException( String.format("Unsupported auth mechanism: %s.", mechanism) );
        }

        return result;
    }

    private static PlainCredentials parsePlainCredentials(final JsonNode plainCredentialsNode) {

        final String username = plainCredentialsNode.get("username").asText();
        final String password = plainCredentialsNode.get("password").asText();

        checkArgument(
                !Strings.isNullOrEmpty(username),
                "The value of the field \"username\" must not be null or an empty string."
        );

        checkArgument(password != null, "The value of the field \"password\" must not be null.");

        return new SimplePlainCredentials(username, password);
    }

    private static CurveCredentials parseCurveCredentials(final JsonNode curveCredentialsNode) {

        final CurveKeyPair clientCurveKeyPair = parseClientCurveKeyPair( curveCredentialsNode.get("client") );
        final CurveKey serverPublicKey = parseServerCurvePublicKey( curveCredentialsNode.get("server") );

        return new SimpleCurveCredentials(serverPublicKey, clientCurveKeyPair);
    }

    private static CurveKeyPair parseClientCurveKeyPair(final JsonNode clientCurveKeyPairNode) {

        final String publicKeyAsString = clientCurveKeyPairNode.get("public").asText();
        final CurveKey publicKey = CurveKey.fromString(publicKeyAsString);

        final String secretKeyAsString = clientCurveKeyPairNode.get("secret").asText();
        final CurveKey secretKey = CurveKey.fromString(secretKeyAsString);

        return new CurveKeyPair(publicKey, secretKey);
    }

    private static CurveKey parseServerCurvePublicKey(final JsonNode serverCurvePublicKeyNode) {
        return CurveKey.fromString( serverCurvePublicKeyNode.get("public").asText() );
    }
}
