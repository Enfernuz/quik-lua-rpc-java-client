package com.enfernuz.quik.lua.rpc.config;

import com.enfernuz.quik.lua.rpc.api.security.zmq.*;
import com.enfernuz.quik.lua.rpc.io.transport.NetworkAddress;
import com.enfernuz.quik.lua.rpc.io.transport.SimpleNetworkAddress;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.base.Strings;
import org.jetbrains.annotations.NotNull;
import org.zeromq.ZMQ;

import static com.google.common.base.Preconditions.checkArgument;

/**
 * Компонент для десериализации объектов типа {@link SimpleClientConfiguration} из текста в формате JSON.
 */
final class SimpleClientConfigurationJsonDeserializer extends JsonDeserializer<SimpleClientConfiguration> {

    @Override
    public SimpleClientConfiguration deserialize(
            final JsonParser jsonParser,
            final DeserializationContext deserializationContext) throws JsonException {

        try {
            final JsonNode rootNode = jsonParser.getCodec().readTree(jsonParser);

            final NetworkAddress networkAddress = parseNetworkAddress( rootNode.get("address") );
            final AuthContext authContext = parseAuthContext( rootNode.get("auth") );
            final ClientConfiguration.SerdeProtocol serdeProtocol = parseSerdeProtocol( rootNode.get("serde_protocol") );

            return new SimpleClientConfiguration(networkAddress, authContext, serdeProtocol);
        } catch (final Exception ex) {
            throw new JsonException("Could not parse configuration object from JSON.", ex);
        }
    }

    @NotNull
    private static NetworkAddress parseNetworkAddress(@NotNull final JsonNode addressNode) {

        final String host = addressNode.get("host").asText();
        final int port = addressNode.get("port").asInt();

        return new SimpleNetworkAddress(host, port);
    }

    @NotNull
    private static AuthContext parseAuthContext(@NotNull final JsonNode authContextNode) {

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

    @NotNull
    private static ClientConfiguration.SerdeProtocol parseSerdeProtocol(@NotNull final JsonNode serdeProtocolNode) {

        final String serdeProtocolAsString = serdeProtocolNode.asText();
        final ClientConfiguration.SerdeProtocol result;
        if ("json".equalsIgnoreCase(serdeProtocolAsString)) {
            result = ClientConfiguration.SerdeProtocol.JSON;
        } else if ("protobuf".equalsIgnoreCase(serdeProtocolAsString)) {
            result = ClientConfiguration.SerdeProtocol.PROTOBUF;
        } else {
            throw new IllegalArgumentException( String.format("Unsupported serde protocol: %s.", serdeProtocolAsString));
        }

        return result;
    }

    @NotNull
    private static PlainCredentials parsePlainCredentials(@NotNull final JsonNode plainCredentialsNode) {

        final String username = plainCredentialsNode.get("username").asText();
        final String password = plainCredentialsNode.get("password").asText();

        checkArgument(
                !Strings.isNullOrEmpty(username),
                "The value of the field \"username\" must not be null or an empty string."
        );

        checkArgument(password != null, "The value of the field \"password\" must not be null.");

        return new SimplePlainCredentials(username, password);
    }

    @NotNull
    private static CurveCredentials parseCurveCredentials(@NotNull final JsonNode curveCredentialsNode) {

        final CurveKeyPair clientCurveKeyPair = parseClientCurveKeyPair( curveCredentialsNode.get("client") );
        final CurveKey serverPublicKey = parseServerCurvePublicKey( curveCredentialsNode.get("server") );

        return new SimpleCurveCredentials(serverPublicKey, clientCurveKeyPair);
    }

    @NotNull
    private static CurveKeyPair parseClientCurveKeyPair(@NotNull final JsonNode clientCurveKeyPairNode) {

        final String publicKeyAsString = clientCurveKeyPairNode.get("public").asText();
        final CurveKey publicKey = CurveKey.fromString(publicKeyAsString);

        final String secretKeyAsString = clientCurveKeyPairNode.get("secret").asText();
        final CurveKey secretKey = CurveKey.fromString(secretKeyAsString);

        return new CurveKeyPair(publicKey, secretKey);
    }

    @NotNull
    private static CurveKey parseServerCurvePublicKey(@NotNull final JsonNode serverCurvePublicKeyNode) {
        return CurveKey.fromString( serverCurvePublicKeyNode.get("public").asText() );
    }
}
