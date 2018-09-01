package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.google.common.base.Strings;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.Nullable;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Optional;

final class ProtobufSerdeUtils {

    static final Charset DEFAULT_PROTOBUF_CHARSET = StandardCharsets.UTF_8;

    @Contract(" -> fail")
    private ProtobufSerdeUtils() {
        throw new AssertionError("This should never be invoked.");
    }

    @Nullable
    @Contract(pure = true)
    static String convertFromPbString(final String protobufString) {
        return Strings.isNullOrEmpty(protobufString) ? null : protobufString;
    }

    @Contract("_ -> !null")
    static String convertToPbString(final String string) {
        return Optional.ofNullable(string).orElse("");
    }
}
