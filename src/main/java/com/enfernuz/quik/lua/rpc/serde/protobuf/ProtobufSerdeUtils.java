package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.structures.DateTimeEntry;
import com.enfernuz.quik.lua.rpc.serde.PbConverter;
import com.enfernuz.quik.lua.rpc.serde.SerdeException;
import com.google.common.base.Strings;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qlua.rpc.RPC;
import qlua.structs.QluaStructures;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import java.util.Optional;

final class ProtobufSerdeUtils {

    static final Charset DEFAULT_PROTOBUF_CHARSET = StandardCharsets.UTF_8;

    private static final PbConverter<QluaStructures.DateTimeEntry, DateTimeEntry> DATE_TIME_ENTRY_PB_CONVERTER =
            DateTimeEntryPbSerde.INSTANCE;

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
        return (string == null) ? "" : string;
    }

    @Nullable
    static DateTimeEntry convertFromPbDateTimeEntry(final QluaStructures.DateTimeEntry dateTimeEntry) {
        return Objects.equals(dateTimeEntry, QluaStructures.DateTimeEntry.getDefaultInstance()) ? null : DATE_TIME_ENTRY_PB_CONVERTER.convertFromPb(dateTimeEntry);
    }

    static QluaStructures.DateTimeEntry convertToPbDateTimeEntry(@NotNull final DateTimeEntry dateTimeEntry) {
        return DATE_TIME_ENTRY_PB_CONVERTER.convertToPb(dateTimeEntry);
    }

    static void assertEquals(@NotNull final RPC.ProcedureType actual, @NotNull final RPC.ProcedureType expected) {

        if (actual != expected) {
            throw new SerdeException(
                    String.format("Неожиданный тип процедуры. Получено: %s, ожидалось: %s.", actual, expected)
            );
        }
    }
}
