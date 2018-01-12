package com.enfernuz.quik.lua.rpc.application;

import com.enfernuz.quik.lua.rpc.api.RemoteProcedureCaller;
import com.enfernuz.quik.lua.rpc.api.impl.ZmqTcpRpcGateway;

public class Application {

    public static void main(String[] args) {

        try (final RemoteProcedureCaller remoteProcedureCaller = ZmqTcpRpcGateway.create("127.0.0.1", 5560)) {

            remoteProcedureCaller.connect();


        } catch (final Exception ex) {

        }

//        try(final QluaRpcClient client = RpcClientImpl.create("127.0.0.1", 5560)) {
//
//            client.connect();
//
//            qlua.rpc.Message.Request request = qlua.rpc.Message.Request.newBuilder().setMessage("Hello world!").setIconType(qlua.rpc.Message.IconType.INFO).build();
//
//            client.message(request);
//
//            client.disconnect();
//        } catch (final Exception ex) {
//            ex.printStackTrace();
//        }


    }
}
