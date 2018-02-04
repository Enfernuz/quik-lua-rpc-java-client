package com.enfernuz.quik.lua.rpc.api.impl;

import com.enfernuz.quik.lua.rpc.api.security.AuthContext;
import com.enfernuz.quik.lua.rpc.io.transport.NetworkAddress;
import com.enfernuz.quik.lua.rpc.io.transport.SimpleNetworkAddress;
import com.google.protobuf.ByteString;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Captor;
import org.mockito.Mockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;
import qlua.rpc.IsConnected;
import qlua.rpc.RPC;

import java.io.IOException;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(PowerMockRunner.class)
@PrepareForTest(ZmqTcpRpcGateway.class)
public class ZmqTcpQluaRpcClientTest {

    private ZmqTcpQluaRpcClient sut;

    @Before
    public void setup() throws IOException {

        final NetworkAddress networkAddress = new SimpleNetworkAddress("127.0.0.1", 5560);

        this.sut = ZmqTcpQluaRpcClient.create(networkAddress, AuthContext.none());
    }

    @After
    public void teardown() {
        this.sut = null;
    }

    @Test
    public void test() throws Exception {

        final ZmqTcpRpcGateway rpcGateway = mock(ZmqTcpRpcGateway.class);

        doReturn(true).when(rpcGateway).isOpened();

        Whitebox.setInternalState(sut, "rpcGateway", rpcGateway);

        final RPC.ProcedureType procType = RPC.ProcedureType.IS_CONNECTED;
        final IsConnected.Result expectedResult = IsConnected.Result.newBuilder().setIsConnected(1).build();
        final RPC.Response expectedResponse = RPC.Response.newBuilder().setType(procType).setResult(expectedResult.toByteString()).build();

        doReturn(expectedResponse).when(rpcGateway).call(RPC.ProcedureType.IS_CONNECTED);

        final IsConnected.Result actualResult = sut.qlua_isConnected();

        verify(rpcGateway).isOpened();
        verify(rpcGateway).call(RPC.ProcedureType.IS_CONNECTED);

        assertEquals(expectedResult.toByteString(), actualResult.toByteString());
    }
}
