package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.structures.StopOrder;
import com.enfernuz.quik.lua.rpc.serde.PbConverter;
import com.enfernuz.quik.lua.rpc.serde.Serde;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import qlua.structs.QluaStructures;

import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.*;

enum StopOrderPbSerde implements Serde<StopOrder>, PbConverter<QluaStructures.StopOrder, StopOrder> {

    INSTANCE;

    @Override
    public byte[] serialize(final StopOrder stopOrder) {
        return convertToPb(stopOrder).toByteArray();
    }

    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public StopOrder deserialize(final byte[] data) {
        return convertFromPb(QluaStructures.StopOrder.parseFrom(data));
    }

    @Override
    public StopOrder convertFromPb(@NotNull QluaStructures.StopOrder stopOrder) {

        return StopOrder.builder()
                .orderNum( stopOrder.getOrderNum() )
                .orderTime( convertFromPbString(stopOrder.getOrdertime()) )
                .flags( stopOrder.getFlags() )
                .brokerRef( convertFromPbString(stopOrder.getBrokerref()) )
                .firmId( convertFromPbString(stopOrder.getFirmid()) )
                .account( convertFromPbString(stopOrder.getAccount()) )
                .condition( stopOrder.getCondition() )
                .conditionPrice( convertFromPbString(stopOrder.getConditionPrice()) )
                .price( convertFromPbString(stopOrder.getPrice()) )
                .qty( stopOrder.getQty() )
                .linkedOrder( convertFromPbString(stopOrder.getLinkedorder()) )
                .expiry( convertFromPbString(stopOrder.getExpiry()) )
                .transId( convertFromPbString(stopOrder.getTransId()) )
                .clientCode( convertFromPbString(stopOrder.getClientCode()) )
                .coOrderNum( convertFromPbString(stopOrder.getCoOrderNum()) )
                .coOrderPrice( convertFromPbString(stopOrder.getCoOrderPrice()) )
                .stopOrderType( stopOrder.getStopOrderType() )
                .orderDate( convertFromPbString(stopOrder.getOrderdate()) )
                .allTradeNum( convertFromPbString(stopOrder.getAlltradeNum()) )
                .stopFlags( stopOrder.getStopflags() )
                .offset( convertFromPbString(stopOrder.getOffset()) )
                .spread( convertFromPbString(stopOrder.getSpread()) )
                .balance( convertFromPbString(stopOrder.getBalance()) )
                .uid( convertFromPbString(stopOrder.getUid()) )
                .filledQty( stopOrder.getFilledQty() )
                .withdrawTime( convertFromPbString(stopOrder.getWithdrawTime()) )
                .conditionPrice2( convertFromPbString(stopOrder.getConditionPrice2()) )
                .activeFromTime( convertFromPbString(stopOrder.getActiveFromTime()) )
                .activeToTime( convertFromPbString(stopOrder.getActiveToTime()) )
                .secCode( convertFromPbString(stopOrder.getSecCode()) )
                .classCode( convertFromPbString(stopOrder.getClassCode()) )
                .conditionSecCode( convertFromPbString(stopOrder.getConditionSecCode()) )
                .conditionClassCode( convertFromPbString(stopOrder.getConditionClassCode()) )
                .canceledUid( convertFromPbString(stopOrder.getCanceledUid()) )
                .orderDateTime( convertFromPbDateTimeEntry(stopOrder.getOrderDateTime()) )
                .withdrawDateTime( convertFromPbDateTimeEntry(stopOrder.getWithdrawDatetime()) )
                .build();
    }

    @Override
    public QluaStructures.StopOrder convertToPb(@NotNull final StopOrder stopOrder) {

        return QluaStructures.StopOrder.newBuilder()
                .setOrderNum( stopOrder.getOrderNum() )
                .setOrdertime( convertToPbString(stopOrder.getOrderTime()) )
                .setFlags( stopOrder.getFlags() )
                .setBrokerref( convertToPbString(stopOrder.getBrokerRef()) )
                .setFirmid( convertToPbString(stopOrder.getFirmId()) )
                .setAccount( convertToPbString(stopOrder.getAccount()) )
                .setCondition( stopOrder.getCondition() )
                .setConditionPrice( convertToPbString(stopOrder.getConditionPrice()) )
                .setPrice( convertToPbString(stopOrder.getPrice()) )
                .setQty( stopOrder.getQty() )
                .setLinkedorder( convertToPbString(stopOrder.getLinkedOrder()) )
                .setExpiry( convertToPbString(stopOrder.getExpiry()) )
                .setTransId( convertToPbString(stopOrder.getTransId()) )
                .setClientCode( convertToPbString(stopOrder.getClientCode()) )
                .setCoOrderNum( convertToPbString(stopOrder.getCoOrderNum()) )
                .setCoOrderPrice( convertToPbString(stopOrder.getCoOrderPrice()) )
                .setStopOrderType( stopOrder.getStopOrderType() )
                .setOrderdate( convertToPbString(stopOrder.getOrderDate()) )
                .setAlltradeNum( convertToPbString(stopOrder.getAllTradeNum()) )
                .setStopflags( stopOrder.getStopFlags() )
                .setOffset( convertToPbString(stopOrder.getOffset()) )
                .setSpread( convertToPbString(stopOrder.getSpread()) )
                .setBalance( convertToPbString(stopOrder.getBalance()) )
                .setUid( convertToPbString(stopOrder.getUid()) )
                .setFilledQty( stopOrder.getFilledQty() )
                .setWithdrawTime( convertToPbString(stopOrder.getWithdrawTime()) )
                .setConditionPrice2( convertToPbString(stopOrder.getConditionPrice2()) )
                .setActiveFromTime( convertToPbString(stopOrder.getActiveFromTime()) )
                .setActiveToTime( convertToPbString(stopOrder.getActiveToTime()) )
                .setSecCode( convertToPbString(stopOrder.getSecCode()) )
                .setClassCode( convertToPbString(stopOrder.getClassCode()) )
                .setConditionSecCode( convertToPbString(stopOrder.getConditionSecCode()) )
                .setConditionClassCode( convertToPbString(stopOrder.getConditionClassCode()) )
                .setCanceledUid( convertToPbString(stopOrder.getCanceledUid()) )
                .setOrderDateTime( convertToPbDateTimeEntry(stopOrder.getOrderDateTime()) )
                .setWithdrawDatetime( convertToPbDateTimeEntry(stopOrder.getWithdrawDateTime()) )
                .build();
    }
}
