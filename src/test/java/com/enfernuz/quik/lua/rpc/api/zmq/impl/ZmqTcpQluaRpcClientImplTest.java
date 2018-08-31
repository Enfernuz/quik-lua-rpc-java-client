package com.enfernuz.quik.lua.rpc.api.zmq.impl;

import com.enfernuz.quik.lua.rpc.api.security.zmq.AuthContext;
import com.enfernuz.quik.lua.rpc.io.transport.NetworkAddress;
import com.enfernuz.quik.lua.rpc.io.transport.SimpleNetworkAddress;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;
import qlua.rpc.IsConnected;
import qlua.rpc.RPC;

import java.io.IOException;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

//@RunWith(PowerMockRunner.class)
//@PrepareForTest(ZmqTcpRpcGatewayImpl.class)
public class ZmqTcpQluaRpcClientImplTest {

//    private ZmqTcpQluaRpcClient sut;
//
//    @Before
//    public void setup() throws IOException {
//
//        final NetworkAddress networkAddress = new SimpleNetworkAddress("127.0.0.1", 5560);
//
//        this.sut = ZmqTcpQluaRpcClient.newInstance(null);
//    }
//
//    @After
//    public void teardown() {
//        this.sut = null;
//    }

//    @Test
//    public void test() throws Exception {
//
//        final ZmqTcpRpcGatewayImpl rpcGateway = mock(ZmqTcpRpcGatewayImpl.class);
//
//        doReturn(true).when(rpcGateway).isOpened();
//
//        Whitebox.setInternalState(sut, "rpcGateway", rpcGateway);
//
//        final RPC.ProcedureType procType = RPC.ProcedureType.IS_CONNECTED;
//        final IsConnected.Result expectedResult = IsConnected.Result.newBuilder().setIsConnected(1).build();
//        final RPC.Response expectedResponse = RPC.Response.newBuilder().setType(procType).setResult(expectedResult.toByteString()).build();
//
//        doReturn(expectedResponse).when(rpcGateway).call(RPC.ProcedureType.IS_CONNECTED);
//
//        final IsConnected.Result actualResult = sut.qlua_isConnected();
//
//        verify(rpcGateway).isOpened();
//        verify(rpcGateway).call(RPC.ProcedureType.IS_CONNECTED);
//
//        assertEquals(expectedResult.toByteString(), actualResult.toByteString());
//    }
}
