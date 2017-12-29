package com.enfernuz.quik.lua.rpc.client.api;

import qlua.rpc.*;

public interface RpcClient  {

    /**
     *
     * @param args
     * @return
     * @throws RpcClientException if there is an error occured while making the remote procedure call
     * @throws NullPointerException if the {@code args} argument is {@code null}
     */
    AddColumn.Result AddColumn(AddColumn.Request args);

    /**
     *
     * @param args
     * @return
     * @throws RpcClientException if there is an error occured while making the remote procedure call
     * @throws NullPointerException if the {@code args} argument is {@code null}
     */
    AddLabel.Result AddLabel(AddLabel.Request args);

    /**
     *
     * @return
     * @throws RpcClientException if there is an error occured while making the remote procedure call
     */
    AllocTable.Result AllocTable();

    /**
     *
     * @param args
     * @return
     * @throws RpcClientException if there is an error occured while making the remote procedure call
     * @throws NullPointerException if the {@code args} argument is {@code null}
     */
    CalcBuySell.Result CalcBuySell(CalcBuySell.Request args);

    /**
     *
     * @param args
     * @return
     * @throws RpcClientException if there is an error occured while making the remote procedure call
     * @throws NullPointerException if the {@code args} argument is {@code null}
     */
    CancelParamRequest.Result CancelParamRequest(CancelParamRequest.Request args);

    /**
     *
     * @param args
     * @return
     * @throws RpcClientException if there is an error occured while making the remote procedure call
     * @throws NullPointerException if the {@code args} argument is {@code null}
     */
    Clear.Result Clear(Clear.Request args);

    /**
     *
     * @param args
     * @return
     * @throws RpcClientException if there is an error occured while making the remote procedure call
     * @throws NullPointerException if the {@code args} argument is {@code null}
     */
    CreateWindow.Result CreateWindow(CreateWindow.Request args);

    /**
     *
     * @param args
     * @return
     * @throws RpcClientException if there is an error occured while making the remote procedure call
     * @throws NullPointerException if the {@code args} argument is {@code null}
     */
    Message.Result message(Message.Request args);

    final class RpcClientException extends RuntimeException {

        public RpcClientException(String message) {
            super(message);
        }

        public RpcClientException(String message, Throwable cause) {
            super(message, cause);
        }

    }

}
