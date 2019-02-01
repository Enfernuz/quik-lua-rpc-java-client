package com.enfernuz.quik.lua.rpc.api;

public interface RemoteProcedureCaller {

    <T extends RemoteProcedure, U extends RpcResult<T>> U makeRPC(
            Class<T> remoteProcedureClass,
            RpcArgs<T> args,
            Class<U> resultClass
    ) throws RpcException;
}
