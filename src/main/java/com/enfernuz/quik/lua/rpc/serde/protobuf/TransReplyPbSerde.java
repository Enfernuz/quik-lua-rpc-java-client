package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.structures.DateTimeEntry;
import com.enfernuz.quik.lua.rpc.api.structures.TransReply;
import com.enfernuz.quik.lua.rpc.serde.PbConverter;
import com.enfernuz.quik.lua.rpc.serde.Serde;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import qlua.structs.QluaStructures;

import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.*;

enum TransReplyPbSerde implements Serde<TransReply>, PbConverter<QluaStructures.Transaction, TransReply> {

    INSTANCE;

    @Override
    public byte[] serialize(final TransReply transReply) {
        return convertToPb(transReply).toByteArray();
    }

    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public TransReply deserialize(final byte[] data) {
        return convertFromPb(QluaStructures.Transaction.parseFrom(data));
    }

    @Override
    public TransReply convertFromPb(@NotNull QluaStructures.Transaction transaction) {

        final TransReply.TransReplyBuilder result = TransReply.builder()
                .transId( transaction.getTransId() )
                .status( transaction.getStatus() )
                .resultMsg( convertFromPbString(transaction.getResultMsg()) )
                .uid( convertFromPbString(transaction.getUid()) )
                .flags( transaction.getFlags() )
                .serverTransId( convertFromPbString(transaction.getServerTransId()) )
                .orderNum( convertFromPbString(transaction.getOrderNum()) )
                .price( convertFromPbString(transaction.getPrice()) )
                .quantity( convertFromPbString(transaction.getQuantity()) )
                .balance( convertFromPbString(transaction.getBalance()) )
                .firmId( convertFromPbString(transaction.getFirmId()) )
                .account( convertFromPbString(transaction.getAccount()) )
                .clientCode( convertFromPbString(transaction.getClientCode()) )
                .brokerRef( convertFromPbString(transaction.getBrokerref()) )
                .classCode( convertFromPbString(transaction.getClassCode()) )
                .secCode( convertFromPbString(transaction.getSecCode()) )
                .exchangeCode( convertFromPbString(transaction.getExchangeCode()) );

        if (transaction.hasDateTime()) {
            result.dateTime( convertFromPbDateTimeEntry(transaction.getDateTime()) );
        }

        return result.build();
    }

    @Override
    public QluaStructures.Transaction convertToPb(@NotNull final TransReply transReply) {

        final QluaStructures.Transaction.Builder result = QluaStructures.Transaction.newBuilder()
                .setTransId( transReply.getTransId() )
                .setStatus( transReply.getStatus() )
                .setResultMsg( convertToPbString(transReply.getResultMsg()) )
                .setUid( convertToPbString(transReply.getUid()) )
                .setFlags( transReply.getFlags() )
                .setServerTransId( convertToPbString(transReply.getServerTransId()) )
                .setOrderNum( convertToPbString(transReply.getOrderNum()) )
                .setPrice( convertToPbString(transReply.getPrice()) )
                .setQuantity( convertToPbString(transReply.getQuantity()) )
                .setBalance( convertToPbString(transReply.getBalance()) )
                .setFirmId( convertToPbString(transReply.getFirmId()) )
                .setAccount( convertToPbString(transReply.getAccount()) )
                .setClientCode( convertToPbString(transReply.getClientCode()) )
                .setBrokerref( convertToPbString(transReply.getBrokerRef()) )
                .setClassCode( convertToPbString(transReply.getClassCode()) )
                .setSecCode( convertToPbString(transReply.getSecCode()) )
                .setExchangeCode( convertToPbString(transReply.getExchangeCode()) );

        final DateTimeEntry dateTime = transReply.getDateTime();
        if (dateTime != null) {
            result.setDateTime( convertToPbDateTimeEntry(dateTime) );
        }

        return result.build();
    }
}
