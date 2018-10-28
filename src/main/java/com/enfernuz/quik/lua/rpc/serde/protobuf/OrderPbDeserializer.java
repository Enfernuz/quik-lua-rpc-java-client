package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.structures.Order;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import qlua.structs.QluaStructures;

import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.convertFromPbDateTimeEntry;
import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.convertFromPbString;

enum OrderPbDeserializer implements Deserializer<Order>, FromPbConverter<QluaStructures.Order, Order> {

    INSTANCE;

    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public Order deserialize(final byte[] data) {
        return convert(QluaStructures.Order.parseFrom(data));
    }

    @Override
    public Order convert(@NotNull QluaStructures.Order order) {

        final Order.OrderBuilder result = Order.builder()
                .orderNum( order.getOrderNum() )
                .flags( order.getFlags() )
                .brokerRef( convertFromPbString(order.getBrokerref()) )
                .userId( convertFromPbString(order.getUserid()) )
                .firmId( convertFromPbString(order.getFirmid()) )
                .account( convertFromPbString(order.getAccount()) )
                .price( convertFromPbString(order.getPrice()) )
                .qty( order.getQty() )
                .balance( convertFromPbString(order.getBalance()) )
                .value( convertFromPbString(order.getValue()) )
                .accruedInt( convertFromPbString(order.getAccruedint()) )
                .yield( convertFromPbString(order.getYield()) )
                .transId( convertFromPbString(order.getTransId()) )
                .clientCode( convertFromPbString(order.getClientCode()) )
                .price2( convertFromPbString(order.getPrice2()) )
                .settleCode( convertFromPbString(order.getSettlecode()) )
                .uid( convertFromPbString(order.getUid()) )
                .canceledUid( convertFromPbString(order.getCanceledUid()) )
                .exchangeCode( convertFromPbString(order.getExchangeCode()) )
                .activationTime( convertFromPbString(order.getActivationTime()) )
                .linkedOrder( convertFromPbString(order.getLinkedorder()) )
                .expiry( convertFromPbString(order.getExpiry()) )
                .secCode( convertFromPbString(order.getSecCode()) )
                .classCode( convertFromPbString(order.getClassCode()) )
                .bankAccId( convertFromPbString(order.getBankAccId()) )
                .valueEntryType( order.getValueEntryType() )
                .repoTerm( convertFromPbString(order.getRepoterm()) )
                .repoValue( convertFromPbString(order.getRepovalue()) )
                .repo2Value( convertFromPbString(order.getRepo2Value()) )
                .repoValueBalance( convertFromPbString(order.getRepoValueBalance()) )
                .startDiscount( convertFromPbString(order.getStartDiscount()) )
                .rejectReason( convertFromPbString(order.getRejectReason()) )
                .extOrderFlags( convertFromPbString(order.getExtOrderFlags()) )
                .minQty( order.getMinQty() )
                .execType( order.getExecType() )
                .sideQualifier( order.getSideQualifier() )
                .acntType( order.getAcntType() )
                .capacity( order.getCapacity() )
                .passiveOnlyOrder( order.getPassiveOnlyOrder() )
                .visible( order.getVisible() );

        if (order.hasDatetime()) {
            result.datetime( convertFromPbDateTimeEntry(order.getDatetime()) );
        }

        if (order.hasWithdrawDatetime()) {
            result.withdrawDatetime( convertFromPbDateTimeEntry(order.getWithdrawDatetime()) );
        }

        return result.build();
    }
}
