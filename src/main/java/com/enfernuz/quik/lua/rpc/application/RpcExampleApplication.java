package com.enfernuz.quik.lua.rpc.application;

import com.enfernuz.quik.lua.rpc.api.zmq.ZmqTcpQluaRpcClient;
import com.enfernuz.quik.lua.rpc.api.zmq.impl.ZmqTcpQluaRpcClientImpl;
import com.enfernuz.quik.lua.rpc.config.ClientConfiguration;
import com.enfernuz.quik.lua.rpc.config.JsonClientConfigurationReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import qlua.rpc.Message;

import java.io.File;

public class RpcExampleApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(RpcExampleApplication.class);

    public static void main(final String[] args) throws Exception {

        LOGGER.info("Reading the config file...");
        final ClientConfiguration config = JsonClientConfigurationReader.INSTANCE.read(new File(args[0]));

        LOGGER.info("Initializing the module...");
        try (final ZmqTcpQluaRpcClient rpcClient =
                     ZmqTcpQluaRpcClientImpl.newInstance(config.getNetworkAddress(), config.getAuthContext())) {

            LOGGER.info("Opening a connection...");
            rpcClient.open();

            final Message.Request request =
                    qlua.rpc.Message.Request.newBuilder()
                            .setMessage("Hello world!")
                            .setIconType(qlua.rpc.Message.IconType.INFO)
                            .build();

            LOGGER.info("Making a 'message' remote procedure call to QUIK...");
            final Message.Result result = rpcClient.qlua_message(request);

            LOGGER.info("Result of the 'message' remote procedure call: {}.", result.getResult());
            LOGGER.info("Exiting...");
        }
    }
}
