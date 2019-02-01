package com.enfernuz.quik.lua.rpc.application;

import lombok.extern.slf4j.Slf4j;
import org.zeromq.ZMQ;

@Slf4j
public class CurveKeyPairGenerator {

    public static void main(final String[] args) {

        try {
            final ZMQ.Curve.KeyPair keyPair = ZMQ.Curve.generateKeyPair();
            final String msg =
                    String.format("Public key: \n%s\n\nSecret key: \n%s", keyPair.publicKey, keyPair.secretKey);
            System.out.println(msg);
            log.info(msg);
        } catch (final RuntimeException ex) {
            log.error("Ошибка при попытке сгенерировать ключевую пару CURVE.", ex);
        }
    }
}
