package com.enfernuz.quik.lua.rpc.serde.protobuf;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

final class ProtobufSerdeUtils {

    static final Charset DEFAULT_PROTOBUF_CHARSET = StandardCharsets.UTF_8;

    private ProtobufSerdeUtils() {
        throw new AssertionError("This should never be invoked.");
    }

    static String asNonNullString(final String str) {
        return (str == null) ? "" : str;
    }
}
