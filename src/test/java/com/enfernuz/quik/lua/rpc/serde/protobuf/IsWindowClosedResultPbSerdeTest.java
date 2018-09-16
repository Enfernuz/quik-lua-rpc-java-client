package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.IsWindowClosed;
import org.jetbrains.annotations.NotNull;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class IsWindowClosedResultPbSerdeTest extends AbstractResultPbSerdeTest<IsWindowClosed.Result, qlua.rpc.IsWindowClosed.Result> {

    private static final IsWindowClosed.Result TRUE_RESULT = getResult(true);
    private static final qlua.rpc.IsWindowClosed.Result TRUE_PB_RESUlT = getPbResult(true);

    private static final IsWindowClosed.Result FALSE_RESULT = getResult(false);
    private static final qlua.rpc.IsWindowClosed.Result FALSE_PB_RESUlT = getPbResult(false);

    private static final IsWindowClosed.Result ERROR_RESULT = IsWindowClosed.Result.getErrorInstance();
    private static final qlua.rpc.IsWindowClosed.Result ERROR_PB_RESULT = qlua.rpc.IsWindowClosed.Result.getDefaultInstance();


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

    @Test
    public void shouldDeserialize_ByteArrayOf_PbObjectOf_ErrorResult_To_ObjectOf_ErrorResult() {
        assertEquals(ERROR_RESULT, getSerdeModuleUnderTest().deserialize(getTargetObjectClass(), ERROR_PB_RESULT.toByteArray()));
    }

    private static IsWindowClosed.Result getResult(final boolean result) {
        return IsWindowClosed.Result.getInstance(IsWindowClosed.WindowClosed.getInstance(result));
    }

    private static qlua.rpc.IsWindowClosed.Result getPbResult(boolean result) {
        return qlua.rpc.IsWindowClosed.Result.newBuilder()
                .setWindowClosed(qlua.rpc.IsWindowClosed.WindowClosed.newBuilder().setResult(result).build())
                .build();
    }
}
