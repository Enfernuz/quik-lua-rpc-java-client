package com.enfernuz.quik.lua.rpc.api.zmq;

import com.enfernuz.quik.lua.rpc.api.security.zmq.AuthContext;
import com.enfernuz.quik.lua.rpc.io.transport.NetworkAddress;
import com.enfernuz.quik.lua.rpc.serde.SerdeModule;

final class BlockingZmqTcpQluaEventPoller extends AbstractZmqTcpQluaEventPoller {

    /**
     * Создаёт новый экземпляр блокирующего опрашивателя очереди событий, с точкой подключения RPC-сервиса
     * на стороне терминала QUIK по заданному сетевому адресу с заданным контекстом защиты передачи данных.
     *
     * @param networkAddress  сетевой адрес точки подключения RPC-сервиса на стороне терминала QUIK
     * @param authContext  контекст защиты передачи данных
     * @param serdeModule  модуль сериализации/десериализации доменных объектов QLua
     * @return новый экземпляр компонента {@link BlockingZmqTcpQluaEventPoller}
     */
    BlockingZmqTcpQluaEventPoller(
            final NetworkAddress networkAddress,
            final AuthContext authContext,
            final SerdeModule serdeModule) {

        super(networkAddress, authContext, serdeModule);
    }

    @Override
    byte[] receiveSubscriptionKeyAsBytes() {
        return getSocket().recv(); // blocking call
    }
}
