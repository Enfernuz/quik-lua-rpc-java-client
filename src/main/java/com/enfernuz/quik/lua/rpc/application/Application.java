package com.enfernuz.quik.lua.rpc.application;

import com.enfernuz.quik.lua.rpc.api.RemoteProcedureCaller;
import com.enfernuz.quik.lua.rpc.api.impl.ZmqTcpQluaRpcClient;
import com.enfernuz.quik.lua.rpc.api.impl.ZmqTcpRpcGateway;
import qlua.rpc.Message;

public class Application {

    public static void main(String[] args) {

        // this is just for the testing purposes for now
        try (final ZmqTcpQluaRpcClient rpcClient = ZmqTcpQluaRpcClient.create("127.0.0.1", 5560)) {

            final Message.Request request =
                    qlua.rpc.Message.Request.newBuilder()
                            .setMessage("Hello world!")
                            .setIconType(qlua.rpc.Message.IconType.INFO)
                            .build();

            final Message.Result result = rpcClient.message(request);

            System.out.println("Result of the MESSAGE remote procedure call: " + result.getResult());
        } catch (final Exception ex) {
            ex.printStackTrace();
        }

//        try (final RemoteProcedureCaller remoteProcedureCaller = ZmqTcpRpcGateway.create("127.0.0.1", 5560)) {
//
//            remoteProcedureCaller.connect();
//
//
//        } catch (final Exception ex) {
//
//        }

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
