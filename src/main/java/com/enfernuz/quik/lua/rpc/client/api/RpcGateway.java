package com.enfernuz.quik.lua.rpc.client.api;

import com.enfernuz.quik.lua.rpc.client.api.exception.RpcGatewayException;
import com.google.protobuf.MessageLite;
import qlua.rpc.RPC;

import java.io.IOException;

public interface RpcGateway extends AutoCloseable {

    void connect() throws IOException;

    void disconnect() throws IOException;

    RPC.Response call(RPC.ProcedureType procedureType) throws RpcGatewayException;

    RPC.Response callWithArguments(RPC.ProcedureType procedureType, MessageLite args) throws RpcGatewayException;
}
