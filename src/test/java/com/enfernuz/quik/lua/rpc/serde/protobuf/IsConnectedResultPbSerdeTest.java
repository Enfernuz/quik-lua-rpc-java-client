package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.IsConnected;
import org.jetbrains.annotations.NotNull;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class IsConnectedResultPbSerdeTest extends AbstractResultPbSerdeTest<IsConnected.Result, qlua.rpc.IsConnected.Result> {

    private static final IsConnected.Result TRUE_RESULT = IsConnected.Result.getInstance(1);
    private static final qlua.rpc.IsConnected.Result TRUE_PB_RESUlT =
            qlua.rpc.IsConnected.Result.newBuilder().setIsConnected(1).build();

    private static final IsConnected.Result FALSE_RESULT = IsConnected.Result.getInstance(0);
    private static final qlua.rpc.IsConnected.Result FALSE_PB_RESUlT =
            qlua.rpc.IsConnected.Result.newBuilder().setIsConnected(0).build();

    @Override
    public @NotNull Class<IsConnected.Result> getTargetObjectClass() {
        return IsConnected.Result.class;
    }

    @NotNull
    @Override
    public qlua.rpc.IsConnected.Result getTargetObjectAsPbMessage() {
        return TRUE_PB_RESUlT;
    }

    @NotNull
    @Override
    public IsConnected.Result getTargetObject() {
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
