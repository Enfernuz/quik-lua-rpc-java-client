package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.google.protobuf.MessageLite;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.junit.Ignore;
import qlua.rpc.RPC;

@Ignore
public abstract class AbstractRequestPbSerdeTest<TARGET_OBJECT> extends AbstractPbSerdeTest<TARGET_OBJECT, RPC.Request> {

    @NotNull
    public abstract RPC.ProcedureType getProcedureType();

    @Nullable
    public abstract MessageLite getPbRequestArgs();

    @NotNull
    @Override
    public final RPC.Request getTargetObjectAsPbMessage() {

        final RPC.Request.Builder request = RPC.Request.newBuilder();
        request.setType( getProcedureType() );
        final MessageLite requestArgs = getPbRequestArgs();
        if (requestArgs != null) {
            request.setArgs( requestArgs.toByteString() );
        }

        return request.build();
    }
}
