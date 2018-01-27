package com.enfernuz.quik.lua.rpc.api;

import com.google.protobuf.MessageLite;
import qlua.rpc.RPC;

import java.io.IOException;

public interface RemoteProcedureCaller {

    RPC.Response call(RPC.ProcedureType procedureType) throws RpcException;

    RPC.Response call(RPC.ProcedureType procedureType, MessageLite args) throws RpcException;

    final class RpcException extends IOException {

        public RpcException(String message) {
            super(message);
        }

        public RpcException(String message, Throwable cause) {
            super(message, cause);
        }
    }
}
