package com.enfernuz.quik.lua.rpc.api.impl;

import com.enfernuz.quik.lua.rpc.api.QluaGateway;
import com.enfernuz.quik.lua.rpc.api.RemoteProcedureCaller;
import com.enfernuz.quik.lua.rpc.api.events.QluaEvent;
import com.google.common.collect.ImmutableSet;
import com.google.protobuf.MessageLite;
import qlua.events.QluaEvents;
import qlua.rpc.RPC;

import java.io.IOException;
import java.util.Optional;

public class QluaGatewayImpl implements QluaGateway {

    @Override
    public RPC.Response call(RPC.ProcedureType procedureType) throws RpcException {
        return null;
    }

    @Override
    public RPC.Response callWithArguments(RPC.ProcedureType procedureType, MessageLite args) throws RpcException {
        return null;
    }

    @Override
    public Optional<QluaEvent> poll() {
        return Optional.empty();
    }

    @Override
    public void subscribe(QluaEvents.EventType eventType) {

    }

    @Override
    public void unsubscribe(QluaEvents.EventType eventType) {

    }

    @Override
    public ImmutableSet<QluaEvents.EventType> getCurrentSubscription() {
        return null;
    }

    @Override
    public void open() throws IOException {

    }

    @Override
    public boolean isOpened() {
        return false;
    }

    @Override
    public void close() throws Exception {

    }
}
