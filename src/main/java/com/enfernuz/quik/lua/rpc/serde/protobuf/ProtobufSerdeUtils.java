package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetBuySellInfo;
import com.enfernuz.quik.lua.rpc.api.messages.GetBuySellInfoEx;
import com.enfernuz.quik.lua.rpc.api.structures.CandleEntry;
import com.enfernuz.quik.lua.rpc.api.structures.ClassInfo;
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

final class ProtobufSerdeUtils {

    static final Charset DEFAULT_PROTOBUF_CHARSET = StandardCharsets.UTF_8;

    private static final PbConverter<QluaStructures.DateTimeEntry, DateTimeEntry> DATE_TIME_ENTRY_PB_CONVERTER =
            DateTimeEntryPbSerde.INSTANCE;

    private static final PbConverter<qlua.rpc.GetBuySellInfo.BuySellInfo, GetBuySellInfo.BuySellInfo> BUY_SELL_INFO_PB_CONVERTER =
            BuySellInfoPbSerde.INSTANCE;

    private static final PbConverter<qlua.rpc.GetBuySellInfoEx.BuySellInfoEx, GetBuySellInfoEx.BuySellInfoEx> BUY_SELL_INFO_EX_PB_CONVERTER =
            BuySellInfoExPbSerde.INSTANCE;

    private static final PbConverter<QluaStructures.CandleEntry, CandleEntry> CANDLE_ENTRY_PB_CONVERTER =
            CandleEntryPbSerde.INSTANCE;

    private static final PbConverter<QluaStructures.Klass, ClassInfo> CLASS_INFO_PB_CONVERTER =
            ClassInfoPbSerde.INSTANCE;

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

    @NotNull
    static GetBuySellInfo.BuySellInfo convertFromPbBuySellInfo(@NotNull final qlua.rpc.GetBuySellInfo.BuySellInfo buySellInfo) {
        return BUY_SELL_INFO_PB_CONVERTER.convertFromPb(buySellInfo);
    }

    @NotNull
    static qlua.rpc.GetBuySellInfo.BuySellInfo convertToPbBuySellInfo(@NotNull final GetBuySellInfo.BuySellInfo buySellInfo) {
        return BUY_SELL_INFO_PB_CONVERTER.convertToPb(buySellInfo);
    }

    @NotNull
    static GetBuySellInfoEx.BuySellInfoEx convertFromPbBuySellInfoEx(@NotNull final qlua.rpc.GetBuySellInfoEx.BuySellInfoEx buySellInfoEx) {
        return BUY_SELL_INFO_EX_PB_CONVERTER.convertFromPb(buySellInfoEx);
    }

    @NotNull
    static qlua.rpc.GetBuySellInfoEx.BuySellInfoEx convertToPbBuySellInfoEx(@NotNull final GetBuySellInfoEx.BuySellInfoEx buySellInfoEx) {
        return BUY_SELL_INFO_EX_PB_CONVERTER.convertToPb(buySellInfoEx);
    }

    @NotNull
    static QluaStructures.CandleEntry convertToPbCandleEntry(@NotNull final CandleEntry candleEntry) {
        return CANDLE_ENTRY_PB_CONVERTER.convertToPb(candleEntry);
    }

    @NotNull
    static CandleEntry convertFromPbCandleEntry(@NotNull final QluaStructures.CandleEntry candleEntry) {
        return CANDLE_ENTRY_PB_CONVERTER.convertFromPb(candleEntry);
    }

    @NotNull
    static QluaStructures.Klass convertToPbClassInfo(@NotNull final ClassInfo classInfo) {
        return CLASS_INFO_PB_CONVERTER.convertToPb(classInfo);
    }

    @NotNull
    static ClassInfo convertFromPbClassInfo(@NotNull final QluaStructures.Klass classInfo) {
        return CLASS_INFO_PB_CONVERTER.convertFromPb(classInfo);
    }

    static void assertEquals(@NotNull final RPC.ProcedureType actual, @NotNull final RPC.ProcedureType expected) {

        if (actual != expected) {
            throw new SerdeException(
                    String.format("Неожиданный тип процедуры. Получено: %s, ожидалось: %s.", actual, expected)
            );
        }
    }
}
