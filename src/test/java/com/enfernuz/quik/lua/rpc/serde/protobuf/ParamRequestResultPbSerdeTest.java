package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.ParamRequest;
import org.jetbrains.annotations.NotNull;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ParamRequestResultPbSerdeTest extends AbstractResultPbSerdeTest<ParamRequest.Result, qlua.rpc.ParamRequest.Result> {

    private static final ParamRequest.Result TRUE_RESULT = ParamRequest.Result.getInstance(true);
    private static final qlua.rpc.ParamRequest.Result TRUE_PB_RESUlT =
            qlua.rpc.ParamRequest.Result.newBuilder().setResult(true).build();

    private static final ParamRequest.Result FALSE_RESULT = ParamRequest.Result.getInstance(false);
    private static final qlua.rpc.ParamRequest.Result FALSE_PB_RESUlT =
            qlua.rpc.ParamRequest.Result.newBuilder().setResult(false).build();

    @Override
    public @NotNull Class<ParamRequest.Result> getTargetObjectClass() {
        return ParamRequest.Result.class;
    }

    @NotNull
    @Override
    public qlua.rpc.ParamRequest.Result getTargetObjectAsPbMessage() {
        return TRUE_PB_RESUlT;
    }

    @NotNull
    @Override
    public ParamRequest.Result getTargetObject() {
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
