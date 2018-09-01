package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.structures.AllTrade;
import com.enfernuz.quik.lua.rpc.api.structures.DateTimeEntry;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import com.enfernuz.quik.lua.rpc.serde.PbConverter;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import qlua.structs.QluaStructures;

import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.convertFromPbString;
import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.convertToPbString;

enum AllTradePbSerde implements Deserializer<AllTrade>, PbConverter<QluaStructures.AllTrade, AllTrade> {

    INSTANCE;

    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public AllTrade deserialize(final byte[] data) {
        return convertFromPb( QluaStructures.AllTrade.parseFrom(data) );
    }

    @Override
    public AllTrade convertFromPb(@NotNull final QluaStructures.AllTrade allTrade) {

        return AllTrade
                .builder()
                .tradeNum( allTrade.getTradeNum() )
                .flags( allTrade.getFlags() )
                .price( allTrade.getPrice() )
                .qty( allTrade.getQty() )
                .value( convertFromPbString(allTrade.getValue()) )
                .accruedInt( convertFromPbString(allTrade.getAccruedint()) )
                .yield( convertFromPbString(allTrade.getYield()) )
                .settleCode( convertFromPbString(allTrade.getSettlecode()) )
                .repoRate( convertFromPbString(allTrade.getReporate()) )
                .repoValue( convertFromPbString(allTrade.getRepovalue()) )
                .repo2Value( convertFromPbString(allTrade.getRepo2Value()) )
                .repoTerm( convertFromPbString(allTrade.getRepoterm()) )
                .secCode( convertFromPbString(allTrade.getSecCode()) )
                .classCode( convertFromPbString(allTrade.getClassCode()) )
                .datetime( DateTimeEntryPbSerde.INSTANCE.convertFromPb(allTrade.getDatetime()) )
                .period( allTrade.getPeriod() )
                .openInterest( convertFromPbString(allTrade.getOpenInterest()) )
                .exchangeCode( convertFromPbString(allTrade.getExchangeCode()) )
                .build();
    }

    @Override
    public QluaStructures.AllTrade convertToPb(@NotNull final AllTrade allTrade) {

        return QluaStructures.AllTrade.newBuilder()
                .setTradeNum( allTrade.getTradeNum() )
                .setFlags( allTrade.getFlags() )
                .setPrice( allTrade.getPrice() )
                .setQty( allTrade.getQty() )
                .setValue( convertToPbString(allTrade.getValue()) )
                .setAccruedint( convertToPbString(allTrade.getAccruedInt()) )
                .setYield( convertToPbString(allTrade.getYield()) )
                .setSettlecode( convertToPbString(allTrade.getSettleCode()) )
                .setReporate( convertToPbString(allTrade.getRepoRate()) )
                .setRepovalue( convertToPbString(allTrade.getRepoValue()) )
                .setRepo2Value( convertToPbString(allTrade.getRepo2Value()) )
                .setRepoterm( convertToPbString(allTrade.getRepoTerm()) )
                .setSecCode( convertToPbString(allTrade.getSecCode()) )
                .setClassCode( convertToPbString(allTrade.getClassCode()) )
                .setDatetime( DateTimeEntryPbSerde.INSTANCE.convertToPb(allTrade.getDatetime()) )
                .setPeriod( allTrade.getPeriod() )
                .setOpenInterest( convertToPbString(allTrade.getOpenInterest()) )
                .setExchangeCode( convertToPbString(allTrade.getExchangeCode()) )
                .build();
    }


}
