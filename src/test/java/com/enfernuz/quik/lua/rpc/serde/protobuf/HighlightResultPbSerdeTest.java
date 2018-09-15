package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.Highlight;
import org.jetbrains.annotations.NotNull;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class HighlightResultPbSerdeTest extends AbstractResultPbSerdeTest<Highlight.Result, qlua.rpc.Highlight.Result> {

    private static final Highlight.Result TRUE_RESULT = Highlight.Result.getInstance(true);
    private static final qlua.rpc.Highlight.Result TRUE_PB_RESUlT =
            qlua.rpc.Highlight.Result.newBuilder().setResult(true).build();

    private static final Highlight.Result FALSE_RESULT = Highlight.Result.getInstance(false);
    private static final qlua.rpc.Highlight.Result FALSE_PB_RESUlT =
            qlua.rpc.Highlight.Result.newBuilder().setResult(false).build();

    @Override
    public @NotNull Class<Highlight.Result> getTargetObjectClass() {
        return Highlight.Result.class;
    }

    @NotNull
    @Override
    public qlua.rpc.Highlight.Result getTargetObjectAsPbMessage() {
        return TRUE_PB_RESUlT;
    }

    @NotNull
    @Override
    public Highlight.Result getTargetObject() {
        return TRUE_RESULT;
    }

    @Test
    public void testSerialize_FalseResult() {

        assertTrue(
                Arrays.equals(FALSE_PB_RESUlT.toByteArray(), getSerdeModuleUnderTest().serialize(FALSE_RESULT))
        );
    }

    @Test
    public void testDeserialize_FalseResult() {
        assertEquals(FALSE_RESULT, getSerdeModuleUnderTest().deserialize(getTargetObjectClass(), FALSE_PB_RESUlT.toByteArray()));
    }
}
