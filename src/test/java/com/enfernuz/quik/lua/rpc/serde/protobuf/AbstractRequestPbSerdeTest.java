package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLite;
import org.junit.Ignore;
import qlua.rpc.RPC;

@Ignore
public abstract class AbstractRequestPbSerdeTest<T> extends AbstractPbSerdeTest<T> {

    public abstract RPC.ProcedureType getProcedureType();

    public abstract MessageLite getPbRequestArgs();

    @Override
    public final byte[] getTargetObjectPbSerializedForm() {

        final RPC.Request.Builder request = RPC.Request.newBuilder();
        request.setType( getProcedureType() );
        final MessageLite requestArgs = getPbRequestArgs();
        if (requestArgs != null) {
            request.setArgs( requestArgs.toByteString() );
        }

        return request.build().toByteArray();
    }
}
