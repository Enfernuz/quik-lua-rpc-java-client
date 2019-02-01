package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.structures.TransReply;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import qlua.structs.QluaStructures;

import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.convertFromPbDateTimeEntry;
import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.convertFromPbString;

enum TransReplyPbDeserializer implements Deserializer<TransReply>, FromPbConverter<QluaStructures.Transaction, TransReply> {

    INSTANCE;

    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public TransReply deserialize(final byte[] data) {
        return convert(QluaStructures.Transaction.parseFrom(data));
    }

    @Override
    public TransReply convert(@NotNull QluaStructures.Transaction transaction) {

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
}
