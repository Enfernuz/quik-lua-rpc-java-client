package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.structures.StopOrder;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import qlua.structs.QluaStructures;

import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.convertFromPbDateTimeEntry;
import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.convertFromPbString;

enum StopOrderPbDeserializer implements Deserializer<StopOrder>, FromPbConverter<QluaStructures.StopOrder, StopOrder> {

    INSTANCE;

    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public StopOrder deserialize(final byte[] data) {
        return convert(QluaStructures.StopOrder.parseFrom(data));
    }

    @Override
    public StopOrder convert(@NotNull QluaStructures.StopOrder stopOrder) {

        final StopOrder.StopOrderBuilder result = StopOrder.builder()
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
                .canceledUid( convertFromPbString(stopOrder.getCanceledUid()) );

        if (stopOrder.hasOrderDateTime()) {
            result.orderDateTime( convertFromPbDateTimeEntry(stopOrder.getOrderDateTime()) );
        }

        if (stopOrder.hasWithdrawDatetime()) {
            result.withdrawDateTime( convertFromPbDateTimeEntry(stopOrder.getWithdrawDatetime()) );
        }

        return result.build();
    }
}
