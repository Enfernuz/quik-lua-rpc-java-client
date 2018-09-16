package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.IsWindowClosed;
import org.jetbrains.annotations.NotNull;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class IsWindowClosedResultPbSerdeTest extends AbstractResultPbSerdeTest<IsWindowClosed.Result, qlua.rpc.IsWindowClosed.Result> {

    private static final IsWindowClosed.Result TRUE_RESULT = IsWindowClosed.Result.getInstance(true);
    private static final qlua.rpc.IsWindowClosed.Result TRUE_PB_RESUlT =
            qlua.rpc.IsWindowClosed.Result.newBuilder().setResult(true).build();

    private static final IsWindowClosed.Result FALSE_RESULT = IsWindowClosed.Result.getInstance(false);
    private static final qlua.rpc.IsWindowClosed.Result FALSE_PB_RESUlT =
            qlua.rpc.IsWindowClosed.Result.newBuilder().setResult(false).build();

    @Override
    public @NotNull Class<IsWindowClosed.Result> getTargetObjectClass() {
        return IsWindowClosed.Result.class;
    }

    @NotNull
    @Override
    public qlua.rpc.IsWindowClosed.Result getTargetObjectAsPbMessage() {
        return TRUE_PB_RESUlT;
    }

    @NotNull
    @Override
    public IsWindowClosed.Result getTargetObject() {
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
