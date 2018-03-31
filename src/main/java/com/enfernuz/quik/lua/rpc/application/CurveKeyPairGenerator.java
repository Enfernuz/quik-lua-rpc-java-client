package com.enfernuz.quik.lua.rpc.application;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zeromq.ZMQ;

public class CurveKeyPairGenerator {

    private static final Logger LOGGER = LoggerFactory.getLogger(CurveKeyPairGenerator.class);

    public static void main(final String[] args) {

        try {
            final ZMQ.Curve.KeyPair keyPair = ZMQ.Curve.generateKeyPair();
            System.out.println(
                    String.format("Public key: \n%s\n\nSecret key: \n%s", keyPair.publicKey, keyPair.secretKey)
            );
        } catch (final RuntimeException ex) {
            LOGGER.error("Ошибка при попытке сгенерировать ключевую пару CURVE.", ex);
        }
    }
}
