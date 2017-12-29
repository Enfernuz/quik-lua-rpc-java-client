package com.enfernuz.quik.lua.rpc.client.api.com.enfernuz.quik.lua.rpc.client.impl;

import com.enfernuz.quik.lua.rpc.client.api.RpcClient;
import com.enfernuz.quik.lua.rpc.client.api.exception.RpcClientException;
import com.google.protobuf.MessageLite;
import qlua.rpc.*;

import java.io.IOException;

import static java.util.Objects.requireNonNull;

public class RpcClientImpl implements RpcClient {

    private final RpcGatewayImpl rpcGateway;

    public RpcClientImpl(final RpcGatewayImpl rpcGateway) {
        this.rpcGateway = rpcGateway;
    }

    /**
     *
     * @param args
     * @return
     * @throws RpcClientException if there is an error occured while making the remote procedure call
     * @throws NullPointerException if the {@code args} argument is {@code null}
     */
    @Override
    public AddColumn.Result AddColumn(AddColumn.Request args) {

        requireNonNull(args, "The 'args' parameter must not be null.");

        try {

            final RPC.Response rpcResponse = rpcGateway.callWithArguments(RPC.ProcedureType.ADD_COLUMN, args);
            final AddColumn.Result result = AddColumn.Result.parseFrom( rpcResponse.getResult() );

            return result;
        } catch (final Exception e) {
            throw new RpcClientException("An error occured while making the remote procedure call.", e);
        }
    }

    /**
     *
     * @param args
     * @return
     * @throws RpcClientException if there is an error occured while making the remote procedure call
     * @throws NullPointerException if the {@code args} argument is {@code null}
     */
    @Override
    public AddLabel.Result AddLabel(AddLabel.Request args) {

        requireNonNull(args, "The 'args' parameter must not be null.");

        try {

            final RPC.Response rpcResponse = rpcGateway.callWithArguments(RPC.ProcedureType.ADD_LABEL, args);
            final AddLabel.Result result = AddLabel.Result.parseFrom( rpcResponse.getResult() );

            return result;
        } catch (final Exception e) {
            throw new RpcClientException("An error occured while making the remote procedure call.", e);
        }
    }

    /**
     *
     * @return
     * @throws RpcClientException if there is an error occured while making the remote procedure call
     */
    @Override
    public AllocTable.Result AllocTable() {

        try {

            final RPC.Response rpcResponse = rpcGateway.call(RPC.ProcedureType.ALLOC_TABLE);
            final AllocTable.Result result = AllocTable.Result.parseFrom( rpcResponse.getResult() );

            return result;
        } catch (final Exception e) {
            throw new RpcClientException("An error occured while making the remote procedure call.", e);
        }
    }

    /**
     *
     * @param args
     * @return
     * @throws RpcClientException if there is an error occured while making the remote procedure call
     * @throws NullPointerException if the {@code args} argument is {@code null}
     */
    @Override
    public CalcBuySell.Result CalcBuySell(CalcBuySell.Request args) {

        requireNonNull(args, "The 'args' parameter must not be null.");

        try {

            final RPC.Response rpcResponse = rpcGateway.callWithArguments(RPC.ProcedureType.CALC_BUY_SELL, args);
            final CalcBuySell.Result result = CalcBuySell.Result.parseFrom( rpcResponse.getResult() );

            return result;
        } catch (final Exception e) {
            throw new RpcClientException("An error occured while making the remote procedure call.", e);
        }
    }

    /**
     *
     * @param args
     * @return
     * @throws RpcClientException if there is an error occured while making the remote procedure call
     * @throws NullPointerException if the {@code args} argument is {@code null}
     */
    @Override
    public CancelParamRequest.Result CancelParamRequest(CancelParamRequest.Request args) {

        requireNonNull(args, "The 'args' parameter must not be null.");

        try {

            final RPC.Response rpcResponse = rpcGateway.callWithArguments(RPC.ProcedureType.CANCEL_PARAM_REQUEST, args);
            final CancelParamRequest.Result result = CancelParamRequest.Result.parseFrom( rpcResponse.getResult() );

            return result;
        } catch (final Exception e) {
            throw new RpcClientException("An error occured while making the remote procedure call.", e);
        }
    }

    /**
     *
     * @param args
     * @return
     * @throws RpcClientException if there is an error occured while making the remote procedure call
     * @throws NullPointerException if the {@code args} argument is {@code null}
     */
    @Override
    public Clear.Result Clear(Clear.Request args) {

        requireNonNull(args, "The 'args' parameter must not be null.");

        try {

            final RPC.Response rpcResponse = rpcGateway.callWithArguments(RPC.ProcedureType.CLEAR, args);
            final Clear.Result result = Clear.Result.parseFrom( rpcResponse.getResult() );

            return result;
        } catch (final Exception e) {
            throw new RpcClientException("An error occured while making the remote procedure call.", e);
        }
    }

    /**
     *
     * @param args
     * @return
     * @throws RpcClientException if there is an error occured while making the remote procedure call
     * @throws NullPointerException if the {@code args} argument is {@code null}
     */
    @Override
    public CreateWindow.Result CreateWindow(CreateWindow.Request args) {

        requireNonNull(args, "The 'args' parameter must not be null.");

        try {

            final RPC.Response rpcResponse = rpcGateway.callWithArguments(RPC.ProcedureType.CREATE_WINDOW, args);
            final CreateWindow.Result result = CreateWindow.Result.parseFrom( rpcResponse.getResult() );

            return result;
        } catch (final Exception e) {
            throw new RpcClientException("An error occured while making the remote procedure call.", e);
        }
    }

    /**
     *
     * @param args
     * @return
     * @throws RpcClientException if there is an error occured while making the remote procedure call
     * @throws NullPointerException if the {@code args} argument is {@code null}
     */
    @Override
    public Message.Result message(Message.Request args) {

        requireNonNull(args, "The 'args' parameter must not be null.");

        try {

            final RPC.Response rpcResponse = rpcGateway.callWithArguments(RPC.ProcedureType.MESSAGE, args);
            final Message.Result result = Message.Result.parseFrom( rpcResponse.getResult() );

            return result;
        } catch (final Exception e) {
            throw new RpcClientException("An error occured while making the remote procedure call.", e);
        }
    }
}
