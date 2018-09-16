package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.Message;
import org.jetbrains.annotations.NotNull;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MessageResultPbSerdeTest extends AbstractResultPbSerdeTest<Message.Result, qlua.rpc.Message.Result> {

    private static final Message.Result OK_RESULT = getResult(1);
    private static final qlua.rpc.Message.Result OK_PB_RESUlT = getPbResult(1);

    private static final Message.Result NOT_OK_RESULT = getResult(42);
    private static final qlua.rpc.Message.Result NOT_OK_PB_RESUlT = getPbResult(42);

    private static final Message.Result ERROR_RESULT = Message.Result.getErrorInstance();
    private static final qlua.rpc.Message.Result ERROR_PB_RESULT = qlua.rpc.Message.Result.newBuilder()
            .setNullResult(true)
            .build();


    @Override
    public @NotNull Class<Message.Result> getTargetObjectClass() {
        return Message.Result.class;
    }

    @NotNull
    @Override
    public qlua.rpc.Message.Result getTargetObjectAsPbMessage() {
        return OK_PB_RESUlT;
    }

    @NotNull
    @Override
    public Message.Result getTargetObject() {
        return OK_RESULT;
    }

    @Test
    public void shouldSerialize_ObjectOf_NotOkResult_To_ByteArrayOf_PbObjectOf_NotOkResult() {

        assertTrue(
                Arrays.equals(NOT_OK_PB_RESUlT.toByteArray(), getSerdeModuleUnderTest().serialize(NOT_OK_RESULT))
        );
    }

    @Test
    public void shouldDeserialize_ByteArrayOf_PbObjectOf_NotOkResult_To_ObjectOf_NotOkResult() {
        assertEquals(NOT_OK_RESULT, getSerdeModuleUnderTest().deserialize(getTargetObjectClass(), NOT_OK_PB_RESUlT.toByteArray()));
    }

    @Test
    public void shouldDeserialize_ByteArrayOf_PbObjectOf_ErrorResult_To_ObjectOf_ErrorResult() {
        assertEquals(ERROR_RESULT, getSerdeModuleUnderTest().deserialize(getTargetObjectClass(), ERROR_PB_RESULT.toByteArray()));
    }

    private static Message.Result getResult(final int result) {
        return Message.Result.getInstance(Message.MessageResult.getInstance(result));
    }

    private static qlua.rpc.Message.Result getPbResult(int result) {
        return qlua.rpc.Message.Result.newBuilder()
                .setValueResult(result)
                .build();
    }
}
