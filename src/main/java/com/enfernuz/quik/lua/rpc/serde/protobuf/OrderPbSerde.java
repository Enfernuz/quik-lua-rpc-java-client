package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.structures.DateTimeEntry;
import com.enfernuz.quik.lua.rpc.api.structures.Order;
import com.enfernuz.quik.lua.rpc.serde.PbConverter;
import com.enfernuz.quik.lua.rpc.serde.Serde;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import qlua.structs.QluaStructures;

import java.util.Objects;

import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.convertFromPbString;
import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.convertToPbString;

enum OrderPbSerde implements Serde<Order>, PbConverter<QluaStructures.Order, Order> {

    INSTANCE;

    private static final PbConverter<QluaStructures.DateTimeEntry, DateTimeEntry> DATE_TIME_ENTRY_PB_CONVERTER =
            DateTimeEntryPbSerde.INSTANCE;

    @Override
    public byte[] serialize(final Order firm) {
        return convertToPb(firm).toByteArray();
    }

    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public Order deserialize(final byte[] data) {
        return convertFromPb(QluaStructures.Order.parseFrom(data));
    }

    @Override
    public Order convertFromPb(@NotNull QluaStructures.Order order) {

        final QluaStructures.DateTimeEntry dateTime = order.getDatetime();
        final QluaStructures.DateTimeEntry withdrawDateTime = order.getWithdrawDatetime();
        return Order.builder()
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
                .datetime( Objects.equals(dateTime, QluaStructures.DateTimeEntry.getDefaultInstance()) ? null : DATE_TIME_ENTRY_PB_CONVERTER.convertFromPb(dateTime) )
                .withdrawDatetime( Objects.equals(withdrawDateTime, QluaStructures.DateTimeEntry.getDefaultInstance()) ? null : DATE_TIME_ENTRY_PB_CONVERTER.convertFromPb(withdrawDateTime) )
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
                .visible( order.getVisible() )
                .build();
    }

    @Override
    public QluaStructures.Order convertToPb(@NotNull final Order order) {

        return QluaStructures.Order.newBuilder()
                .setOrderNum( order.getOrderNum() )
                .setFlags( order.getFlags() )
                .setBrokerref( convertToPbString(order.getBrokerRef()) )
                .setUserid( convertToPbString(order.getUserId()) )
                .setFirmid( convertToPbString(order.getFirmId()) )
                .setAccount( convertToPbString(order.getAccount()) )
                .setPrice( convertToPbString(order.getPrice()) )
                .setQty( order.getQty() )
                .setBalance( convertToPbString(order.getBalance()) )
                .setValue( convertToPbString(order.getValue()) )
                .setAccruedint( convertToPbString(order.getAccruedInt()) )
                .setYield( convertToPbString(order.getYield()) )
                .setTransId( convertToPbString(order.getTransId()) )
                .setClientCode( convertToPbString(order.getClientCode()) )
                .setPrice2( convertToPbString(order.getPrice2()) )
                .setSettlecode( convertToPbString(order.getSettleCode()) )
                .setUid( convertToPbString(order.getUid()) )
                .setCanceledUid( convertToPbString(order.getCanceledUid()) )
                .setExchangeCode( convertToPbString(order.getExchangeCode()) )
                .setActivationTime( convertToPbString(order.getActivationTime()) )
                .setLinkedorder( convertToPbString(order.getLinkedOrder()) )
                .setExpiry( convertToPbString(order.getExpiry()) )
                .setSecCode( convertToPbString(order.getSecCode()) )
                .setClassCode( convertToPbString(order.getClassCode()) )
                .setDatetime( order.getDatetime() == null ? QluaStructures.DateTimeEntry.getDefaultInstance() : DATE_TIME_ENTRY_PB_CONVERTER.convertToPb(order.getDatetime()) )
                .setWithdrawDatetime( order.getWithdrawDatetime() == null ? QluaStructures.DateTimeEntry.getDefaultInstance() : DATE_TIME_ENTRY_PB_CONVERTER.convertToPb(order.getWithdrawDatetime()) )
                .setBankAccId( convertToPbString(order.getBankAccId()) )
                .setValueEntryType( order.getValueEntryType() )
                .setRepoterm( convertToPbString(order.getRepoTerm()) )
                .setRepovalue( convertToPbString(order.getRepoValue()) )
                .setRepo2Value( convertToPbString(order.getRepo2Value()) )
                .setRepoValueBalance( convertToPbString(order.getRepoValueBalance()) )
                .setStartDiscount( convertToPbString(order.getStartDiscount()) )
                .setRejectReason( convertToPbString(order.getRejectReason()) )
                .setExtOrderFlags( convertToPbString(order.getExtOrderFlags()) )
                .setMinQty( order.getMinQty() )
                .setExecType( order.getExecType() )
                .setSideQualifier( order.getSideQualifier() )
                .setAcntType( order.getAcntType() )
                .setCapacity( order.getCapacity() )
                .setPassiveOnlyOrder( order.getPassiveOnlyOrder() )
                .setVisible( order.getVisible() )
                .build();
    }
}
