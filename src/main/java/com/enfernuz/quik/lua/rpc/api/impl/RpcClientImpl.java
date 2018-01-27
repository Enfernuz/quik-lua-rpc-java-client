package com.enfernuz.quik.lua.rpc.api.impl;

import com.enfernuz.quik.lua.rpc.api.QluaRpcClient;
import qlua.rpc.*;

import static java.util.Objects.requireNonNull;

public final class RpcClientImpl {//implements QluaRpcClient {

//    private final ZmqTcpRpcGateway rpcGateway;
//
//    public RpcClientImpl(final ZmqTcpRpcGateway rpcGateway) {
//        this.rpcGateway = rpcGateway;
//    }
//
//    /**
//     *
//     * @param args
//     * @return
//     * @throws RpcClientException if there is an error occurred while making the remote procedure call
//     * @throws NullPointerException if the {@code args} argument is {@code null}
//     */
//    @Override
//    public AddColumn.Result AddColumn(final AddColumn.Request args) {
//
//        requireNonNull(args, "The 'args' parameter must not be null.");
//
//        try {
//
//            final RPC.Response rpcResponse = rpcGateway.call(RPC.ProcedureType.ADD_COLUMN, args);
//            final AddColumn.Result result = AddColumn.Result.parseFrom( rpcResponse.getResult() );
//
//            return result;
//        } catch (final Exception e) {
//            throw new RpcClientException("An error occurred while making the remote procedure call.", e);
//        }
//    }
//
//    /**
//     *sfa
//     * @param args
//     * @return
//     * @throws RpcClientException if there is an error occurred while making the remote procedure call
//     * @throws NullPointerException if the {@code args} argument is {@code null}
//     */
//    @Override
//    public AddLabel.Result AddLabel(final AddLabel.Request args) {
//        this.AddLabel(null);
//        requireNonNull(args, "The 'args' parameter must not be null.");
//
//        try {
//
//            final RPC.Response rpcResponse = rpcGateway.call(RPC.ProcedureType.ADD_LABEL, args);
//            final AddLabel.Result result = AddLabel.Result.parseFrom( rpcResponse.getResult() );
//
//            return result;
//        } catch (final Exception e) {
//            throw new RpcClientException("An error occurred while making the remote procedure call.", e);
//        }
//    }
//
//    /**
//     *
//     * @return
//     * @throws RpcClientException if there is an error occurred while making the remote procedure call
//     */
//    @Override
//    public AllocTable.Result AllocTable() {
//
//        try {
//
//            final RPC.Response rpcResponse = rpcGateway.call(RPC.ProcedureType.ALLOC_TABLE);
//            final AllocTable.Result result = AllocTable.Result.parseFrom( rpcResponse.getResult() );
//
//            return result;
//        } catch (final Exception e) {
//            throw new RpcClientException("An error occurred while making the remote procedure call.", e);
//        }
//    }
//
//    /**
//     *
//     * @param args
//     * @return
//     * @throws RpcClientException if there is an error occurred while making the remote procedure call
//     * @throws NullPointerException if the {@code args} argument is {@code null}
//     */
//    @Override
//    public CalcBuySell.Result CalcBuySell(final CalcBuySell.Request args) {
//
//        requireNonNull(args, "The 'args' parameter must not be null.");
//
//        try {
//
//            final RPC.Response rpcResponse = rpcGateway.call(RPC.ProcedureType.CALC_BUY_SELL, args);
//            final CalcBuySell.Result result = CalcBuySell.Result.parseFrom( rpcResponse.getResult() );
//
//            return result;
//        } catch (final Exception e) {
//            throw new RpcClientException("An error occurred while making the remote procedure call.", e);
//        }
//    }
//
//    /**
//     *
//     * @param args
//     * @return
//     * @throws RpcClientException if there is an error occurred while making the remote procedure call
//     * @throws NullPointerException if the {@code args} argument is {@code null}
//     */
//    @Override
//    public CancelParamRequest.Result CancelParamRequest(final CancelParamRequest.Request args) {
//
//        requireNonNull(args, "The 'args' parameter must not be null.");
//
//        try {
//
//            final RPC.Response rpcResponse = rpcGateway.call(RPC.ProcedureType.CANCEL_PARAM_REQUEST, args);
//            final CancelParamRequest.Result result = CancelParamRequest.Result.parseFrom( rpcResponse.getResult() );
//
//            return result;
//        } catch (final Exception e) {
//            throw new RpcClientException("An error occurred while making the remote procedure call.", e);
//        }
//    }
//
//    /**
//     *
//     * @param args
//     * @return
//     * @throws RpcClientException if there is an error occurred while making the remote procedure call
//     * @throws NullPointerException if the {@code args} argument is {@code null}
//     */
//    @Override
//    public Clear.Result Clear(final Clear.Request args) {
//
//        requireNonNull(args, "The 'args' parameter must not be null.");
//
//        try {
//
//            final RPC.Response rpcResponse = rpcGateway.call(RPC.ProcedureType.CLEAR, args);
//            final Clear.Result result = Clear.Result.parseFrom( rpcResponse.getResult() );
//
//            return result;
//        } catch (final Exception e) {
//            throw new RpcClientException("An error occurred while making the remote procedure call.", e);
//        }
//    }
//
//    /**
//     *
//     * @param args
//     * @return
//     * @throws RpcClientException if there is an error occurred while making the remote procedure call
//     * @throws NullPointerException if the {@code args} argument is {@code null}
//     */
//    @Override
//    public CreateWindow.Result CreateWindow(final CreateWindow.Request args) {
//
//        requireNonNull(args, "The 'args' parameter must not be null.");
//
//        try {
//
//            final RPC.Response rpcResponse = rpcGateway.call(RPC.ProcedureType.CREATE_WINDOW, args);
//            final CreateWindow.Result result = CreateWindow.Result.parseFrom( rpcResponse.getResult() );
//
//            return result;
//        } catch (final Exception e) {
//            throw new RpcClientException("An error occurred while making the remote procedure call.", e);
//        }
//    }
//
//    /**
//     * @param args
//     * @return
//     * @throws RpcClientException if there is an error occurred while making the remote procedure call
//     * @throws NullPointerException if the {@code args} argument is {@code null}
//     */
//    @Override
//    public DelAllLabels.Result DelAllLabels(final DelAllLabels.Request args) {
//
//        requireNonNull(args, "The 'args' parameter must not be null.");
//
//        try {
//
//            final RPC.Response rpcResponse = rpcGateway.call(RPC.ProcedureType.DEL_ALL_LABELS, args);
//            final DelAllLabels.Result result = DelAllLabels.Result.parseFrom( rpcResponse.getResult() );
//
//            return result;
//        } catch (final Exception e) {
//            throw new RpcClientException("An error occurred while making the remote procedure call.", e);
//        }
//    }
//
//    /**
//     * @param args
//     * @return
//     * @throws RpcClientException if there is an error occurred while making the remote procedure call
//     * @throws NullPointerException if the {@code args} argument is {@code null}
//     */
//    @Override
//    public DeleteRow.Result DeleteRow(final DeleteRow.Request args) {
//
//        requireNonNull(args, "The 'args' parameter must not be null.");
//
//        try {
//
//            final RPC.Response rpcResponse = rpcGateway.call(RPC.ProcedureType.DELETE_ROW, args);
//            final DeleteRow.Result result = DeleteRow.Result.parseFrom( rpcResponse.getResult() );
//
//            return result;
//        } catch (final Exception e) {
//            throw new RpcClientException("An error occurred while making the remote procedure call.", e);
//        }
//    }
//
//    /**
//     * @param args
//     * @return
//     * @throws RpcClientException if there is an error occurred while making the remote procedure call
//     * @throws NullPointerException if the {@code args} argument is {@code null}
//     */
//    @Override
//    public DelLabel.Result DelLabel(final DelLabel.Request args) {
//
//        requireNonNull(args, "The 'args' parameter must not be null.");
//
//        try {
//
//            final RPC.Response rpcResponse = rpcGateway.call(RPC.ProcedureType.DEL_LABEL, args);
//            final DelLabel.Result result = DelLabel.Result.parseFrom( rpcResponse.getResult() );
//
//            return result;
//        } catch (final Exception e) {
//            throw new RpcClientException("An error occurred while making the remote procedure call.", e);
//        }
//    }
//
//    /**
//     * @param args
//     * @return
//     * @throws RpcClientException if there is an error occurred while making the remote procedure call
//     * @throws NullPointerException if the {@code args} argument is {@code null}
//     */
//    @Override
//    public DestroyTable.Result DestroyTable(final DestroyTable.Request args) {
//
//        requireNonNull(args, "The 'args' parameter must not be null.");
//
//        try {
//
//            final RPC.Response rpcResponse = rpcGateway.call(RPC.ProcedureType.DESTROY_TABLE, args);
//            final DestroyTable.Result result = DestroyTable.Result.parseFrom( rpcResponse.getResult() );
//
//            return result;
//        } catch (final Exception e) {
//            throw new RpcClientException("An error occurred while making the remote procedure call.", e);
//        }
//    }
//
//    /**
//     * @param args
//     * @return
//     * @throws RpcClientException if there is an error occurred while making the remote procedure call
//     * @throws NullPointerException if the {@code args} argument is {@code null}
//     */
//    @Override
//    public GetBuySellInfo.Result getBuySellInfo(final GetBuySellInfo.Request args) {
//
//        requireNonNull(args, "The 'args' parameter must not be null.");
//
//        try {
//
//            final RPC.Response rpcResponse = rpcGateway.call(RPC.ProcedureType.GET_BUY_SELL_INFO, args);
//            final GetBuySellInfo.Result result = GetBuySellInfo.Result.parseFrom( rpcResponse.getResult() );
//
//            return result;
//        } catch (final Exception e) {
//            throw new RpcClientException("An error occurred while making the remote procedure call.", e);
//        }
//    }
//
//    /**
//     * @param args
//     * @return
//     * @throws RpcClientException if there is an error occurred while making the remote procedure call
//     * @throws NullPointerException if the {@code args} argument is {@code null}
//     */
//    @Override
//    public GetBuySellInfoEx.Result getBuySellInfoEx(final GetBuySellInfoEx.Request args) {
//
//        requireNonNull(args, "The 'args' parameter must not be null.");
//
//        try {
//
//            final RPC.Response rpcResponse = rpcGateway.call(RPC.ProcedureType.GET_BUY_SELL_INFO_EX, args);
//            final GetBuySellInfoEx.Result result = GetBuySellInfoEx.Result.parseFrom( rpcResponse.getResult() );
//
//            return result;
//        } catch (final Exception e) {
//            throw new RpcClientException("An error occurred while making the remote procedure call.", e);
//        }
//    }
//
//    /**
//     * @param args
//     * @return
//     * @throws RpcClientException if there is an error occurred while making the remote procedure call
//     * @throws NullPointerException if the {@code args} argument is {@code null}
//     */
//    @Override
//    public GetCandlesByIndex.Result getCandlesByIndex(final GetCandlesByIndex.Result args) {
//
//        requireNonNull(args, "The 'args' parameter must not be null.");
//
//        try {
//
//            final RPC.Response rpcResponse = rpcGateway.call(RPC.ProcedureType.GET_CANDLES_BY_INDEX, args);
//            final GetCandlesByIndex.Result result = GetCandlesByIndex.Result.parseFrom( rpcResponse.getResult() );
//
//            return result;
//        } catch (final Exception e) {
//            throw new RpcClientException("An error occurred while making the remote procedure call.", e);
//        }
//    }
//
//    /**
//     * @param args
//     * @return
//     * @throws RpcClientException if there is an error occurred while making the remote procedure call
//     * @throws NullPointerException if the {@code args} argument is {@code null}
//     */
//    @Override
//    public GetCell.Result GetCell(final GetCell.Result args) {
//
//        requireNonNull(args, "The 'args' parameter must not be null.");
//
//        try {
//
//            final RPC.Response rpcResponse = rpcGateway.call(RPC.ProcedureType.GET_CELL, args);
//            final GetCell.Result result = GetCell.Result.parseFrom( rpcResponse.getResult() );
//
//            return result;
//        } catch (final Exception e) {
//            throw new RpcClientException("An error occurred while making the remote procedure call.", e);
//        }
//    }
//
//    /**
//     * @return
//     * @throws RpcClientException if there is an error occurred while making the remote procedure call
//     */
//    @Override
//    public GetClassesList.Result getClassesList() {
//
//        try {
//
//            final RPC.Response rpcResponse = rpcGateway.call(RPC.ProcedureType.GET_CLASSES_LIST);
//            final GetClassesList.Result result = GetClassesList.Result.parseFrom( rpcResponse.getResult() );
//
//            return result;
//        } catch (final Exception e) {
//            throw new RpcClientException("An error occurred while making the remote procedure call.", e);
//        }
//    }
//
//    /**
//     * @param args
//     * @return
//     * @throws RpcClientException if there is an error occurred while making the remote procedure call
//     * @throws NullPointerException if the {@code args} argument is {@code null}
//     */
//    @Override
//    public GetClassInfo.Result getClassInfo(final GetClassInfo.Request args) {
//
//        requireNonNull(args, "The 'args' parameter must not be null.");
//
//        try {
//
//            final RPC.Response rpcResponse = rpcGateway.call(RPC.ProcedureType.GET_CLASS_INFO, args);
//            final GetClassInfo.Result result = GetClassInfo.Result.parseFrom( rpcResponse.getResult() );
//
//            return result;
//        } catch (final Exception e) {
//            throw new RpcClientException("An error occurred while making the remote procedure call.", e);
//        }
//    }
//
//    /**
//     *
//     * @param args
//     * @return
//     * @throws RpcClientException if there is an error occurred while making the remote procedure call
//     * @throws NullPointerException if the {@code args} argument is {@code null}
//     */
//    @Override
//    public Message.Result message(final Message.Request args) {
//
//        requireNonNull(args, "The 'args' parameter must not be null.");
//
//        try {
//
//            final RPC.Response rpcResponse = rpcGateway.call(RPC.ProcedureType.MESSAGE, args);
//            final Message.Result result = Message.Result.parseFrom( rpcResponse.getResult() );
//
//            return result;
//        } catch (final Exception e) {
//            throw new RpcClientException("An error occurred while making the remote procedure call.", e);
//        }
//    }
}
