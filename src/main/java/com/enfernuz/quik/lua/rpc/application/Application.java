package com.enfernuz.quik.lua.rpc.application;

import com.enfernuz.quik.lua.rpc.api.impl.ZmqTcpQluaRpcClient;
import qlua.rpc.Message;

public class Application {

    public static void main(String[] args) {

        // this is just for the testing purposes for now
        try (final ZmqTcpQluaRpcClient rpcClient = ZmqTcpQluaRpcClient.create("127.0.0.1", 5560)) {

            rpcClient.open();

            final Message.Request request =
                    qlua.rpc.Message.Request.newBuilder()
                            .setMessage("Hello world!")
                            .setIconType(qlua.rpc.Message.IconType.INFO)
                            .build();

            final Message.Result result = rpcClient.qlua_message(request);

            System.out.println("Result of the MESSAGE remote procedure call: " + result.getResult());
        } catch (final Exception ex) {
            ex.printStackTrace();
        }
    }
}
