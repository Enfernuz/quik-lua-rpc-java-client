package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.IsSubscribedLevel2Quotes;
import org.jetbrains.annotations.NotNull;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class IsSubscribedLevel2QuotesResultPbSerdeTest extends AbstractResultPbSerdeTest<IsSubscribedLevel2Quotes.Result, qlua.rpc.IsSubscribedLevelIIQuotes.Result> {

    private static final IsSubscribedLevel2Quotes.Result TRUE_RESULT = IsSubscribedLevel2Quotes.Result.getInstance(true);
    private static final qlua.rpc.IsSubscribedLevelIIQuotes.Result TRUE_PB_RESUlT =
            qlua.rpc.IsSubscribedLevelIIQuotes.Result.newBuilder().setResult(true).build();

    private static final IsSubscribedLevel2Quotes.Result FALSE_RESULT = IsSubscribedLevel2Quotes.Result.getInstance(false);
    private static final qlua.rpc.IsSubscribedLevelIIQuotes.Result FALSE_PB_RESUlT =
            qlua.rpc.IsSubscribedLevelIIQuotes.Result.newBuilder().setResult(false).build();

    @Override
    public @NotNull Class<IsSubscribedLevel2Quotes.Result> getTargetObjectClass() {
        return IsSubscribedLevel2Quotes.Result.class;
    }

    @NotNull
    @Override
    public qlua.rpc.IsSubscribedLevelIIQuotes.Result getTargetObjectAsPbMessage() {
        return TRUE_PB_RESUlT;
    }

    @NotNull
    @Override
    public IsSubscribedLevel2Quotes.Result getTargetObject() {
        return TRUE_RESULT;
    }

    @Test
    public void shouldSerialize_ObjectOf_FalseResult_To_ByteArrayOf_PbObjectOf_FalseResult() {

        assertTrue(
                Arrays.equals(FALSE_PB_RESUlT.toByteArray(), getSerdeModuleUnderTest().serialize(FALSE_RESULT))
        );
    }

    @Test
    public void shouldDeserialize_ByteArrayOf_PbObjectOf_FalseResult_To_ObjectOf_FalseResult() {
        assertEquals(FALSE_RESULT, getSerdeModuleUnderTest().deserialize(getTargetObjectClass(), FALSE_PB_RESUlT.toByteArray()));
    }
}
