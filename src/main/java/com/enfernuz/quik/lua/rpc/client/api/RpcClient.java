package com.enfernuz.quik.lua.rpc.client.api;

import qlua.rpc.*;

public interface RpcClient  {

    /**
     *
     * @param args
     * @return
     * @throws RpcClientException if there is an error occurred while making the remote procedure call
     * @throws NullPointerException if the {@code args} argument is {@code null}
     */
    AddColumn.Result AddColumn(AddColumn.Request args);

    /**
     *
     * @param args
     * @return
     * @throws RpcClientException if there is an error occurred while making the remote procedure call
     * @throws NullPointerException if the {@code args} argument is {@code null}
     */
    AddLabel.Result AddLabel(AddLabel.Request args);

    /**
     *
     * @return
     * @throws RpcClientException if there is an error occurred while making the remote procedure call
     */
    AllocTable.Result AllocTable();

    /**
     *
     * @param args
     * @return
     * @throws RpcClientException if there is an error occurred while making the remote procedure call
     * @throws NullPointerException if the {@code args} argument is {@code null}
     */
    CalcBuySell.Result CalcBuySell(CalcBuySell.Request args);

    /**
     *
     * @param args
     * @return
     * @throws RpcClientException if there is an error occurred while making the remote procedure call
     * @throws NullPointerException if the {@code args} argument is {@code null}
     */
    CancelParamRequest.Result CancelParamRequest(CancelParamRequest.Request args);

    /**
     *
     * @param args
     * @return
     * @throws RpcClientException if there is an error occurred while making the remote procedure call
     * @throws NullPointerException if the {@code args} argument is {@code null}
     */
    Clear.Result Clear(Clear.Request args);

    /**
     *
     * @param args
     * @return
     * @throws RpcClientException if there is an error occurred while making the remote procedure call
     * @throws NullPointerException if the {@code args} argument is {@code null}
     */
    CreateWindow.Result CreateWindow(CreateWindow.Request args);

    /**
     *
     * @param args
     * @return
     * @throws RpcClientException if there is an error occurred while making the remote procedure call
     * @throws NullPointerException if the {@code args} argument is {@code null}
     */
    DelAllLabels.Result DelAllLabels(DelAllLabels.Request args);

    /**
     *
     * @param args
     * @return
     * @throws RpcClientException if there is an error occurred while making the remote procedure call
     * @throws NullPointerException if the {@code args} argument is {@code null}
     */
    DeleteRow.Result DeleteRow(DeleteRow.Request args);

    /**
     *
     * @param args
     * @return
     * @throws RpcClientException if there is an error occurred while making the remote procedure call
     * @throws NullPointerException if the {@code args} argument is {@code null}
     */
    DelLabel.Result DelLabel(DelLabel.Request args);

    /**
     *
     * @param args
     * @return
     * @throws RpcClientException if there is an error occurred while making the remote procedure call
     * @throws NullPointerException if the {@code args} argument is {@code null}
     */
    DestroyTable.Result DestroyTable(DestroyTable.Request args);

    /**
     *
     * @param args
     * @return
     * @throws RpcClientException if there is an error occurred while making the remote procedure call
     * @throws NullPointerException if the {@code args} argument is {@code null}
     */
    GetBuySellInfo.Result getBuySellInfo(GetBuySellInfo.Request args);

    /**
     *
     * @param args
     * @return
     * @throws RpcClientException if there is an error occurred while making the remote procedure call
     * @throws NullPointerException if the {@code args} argument is {@code null}
     */
    GetBuySellInfoEx.Result getBuySellInfoEx(GetBuySellInfoEx.Request args);

    /**
     *
     * @param args
     * @return
     * @throws RpcClientException if there is an error occurred while making the remote procedure call
     * @throws NullPointerException if the {@code args} argument is {@code null}
     */
    GetCandlesByIndex.Result getCandlesByIndex(GetCandlesByIndex.Result args);

    /**
     *
     * @param args
     * @return
     * @throws RpcClientException if there is an error occurred while making the remote procedure call
     * @throws NullPointerException if the {@code args} argument is {@code null}
     */
    GetCell.Result GetCell(GetCell.Result args);

    /**
     *
     * @return
     * @throws RpcClientException if there is an error occurred while making the remote procedure call
     */
    GetClassesList.Result getClassesList();

    /**
     *
     * @param args
     * @return
     * @throws RpcClientException if there is an error occurred while making the remote procedure call
     * @throws NullPointerException if the {@code args} argument is {@code null}
     */
    GetClassInfo.Result getClassInfo(GetClassInfo.Request args);

    /**
     *
     * @param args
     * @return
     * @throws RpcClientException if there is an error occurred while making the remote procedure call
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
