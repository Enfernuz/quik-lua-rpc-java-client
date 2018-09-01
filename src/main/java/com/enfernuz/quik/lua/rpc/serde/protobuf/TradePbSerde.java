package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.structures.DateTimeEntry;
import com.enfernuz.quik.lua.rpc.api.structures.Trade;
import com.enfernuz.quik.lua.rpc.serde.PbConverter;
import com.enfernuz.quik.lua.rpc.serde.Serde;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import qlua.structs.QluaStructures;

import java.util.Objects;

import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.convertFromPbString;
import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.convertToPbString;

enum TradePbSerde implements Serde<Trade>, PbConverter<QluaStructures.Trade, Trade> {

    INSTANCE;

    private static final PbConverter<QluaStructures.DateTimeEntry, DateTimeEntry> DATE_TIME_ENTRY_PB_CONVERTER =
            DateTimeEntryPbSerde.INSTANCE;

    @Override
    public byte[] serialize(final Trade trade) {
        return convertToPb(trade).toByteArray();
    }

    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public Trade deserialize(final byte[] data) {
        return convertFromPb(QluaStructures.Trade.parseFrom(data));
    }

    @Override
    public Trade convertFromPb(@NotNull QluaStructures.Trade trade) {

        final QluaStructures.DateTimeEntry dateTime = trade.getDatetime();
        final QluaStructures.DateTimeEntry canceledDateTime = trade.getCanceledDatetime();
        return Trade.builder()
                .tradeNum( trade.getTradeNum() )
                .orderNum( trade.getOrderNum() )
                .brokerRef( convertFromPbString(trade.getBrokerref()) )
                .userId( convertFromPbString(trade.getUserid()) )
                .firmId( convertFromPbString(trade.getFirmid()) )
                .canceledUid( convertFromPbString(trade.getCanceledUid()) )
                .account( convertFromPbString(trade.getAccount()) )
                .price( convertFromPbString(trade.getPrice()) )
                .qty( trade.getQty() )
                .value( convertFromPbString(trade.getValue()) )
                .accruedInt( convertFromPbString(trade.getAccruedint()) )
                .yield( convertFromPbString(trade.getYield()) )
                .settleCode( convertFromPbString(trade.getSettlecode()) )
                .cpFirmId( convertFromPbString(trade.getCpfirmid()) )
                .flags( trade.getFlags() )
                .price2( convertFromPbString(trade.getPrice2()) )
                .repoRate( convertFromPbString(trade.getReporate()) )
                .clientCode( convertFromPbString(trade.getClientCode()) )
                .accrued2( convertFromPbString(trade.getAccrued2()) )
                .repoTerm( convertFromPbString(trade.getRepoterm()) )
                .repoValue( convertFromPbString(trade.getRepovalue()) )
                .repo2Value( convertFromPbString(trade.getRepo2Value()) )
                .startDiscount( convertFromPbString(trade.getStartDiscount()) )
                .lowerDiscount( convertFromPbString(trade.getLowerDiscount()) )
                .upperDiscount( convertFromPbString(trade.getUpperDiscount()) )
                .blockSecurities( convertFromPbString(trade.getBlockSecurities()) )
                .clearingComission( convertFromPbString(trade.getClearingComission()) )
                .exchangeComission( convertFromPbString(trade.getExchangeComission()) )
                .techCenterComission( convertFromPbString(trade.getTechCenterComission()) )
                .settleDate( convertFromPbString(trade.getSettleDate()) )
                .settleCurrency( convertFromPbString(trade.getSettleCurrency()) )
                .tradeCurrency( convertFromPbString(trade.getTradeCurrency()) )
                .exchangeCode( convertFromPbString(trade.getExchangeCode()) )
                .stationId( convertFromPbString(trade.getStationId()) )
                .secCode( convertFromPbString(trade.getSecCode()) )
                .classCode( convertFromPbString(trade.getClassCode()) )
                .datetime(Objects.equals(dateTime, QluaStructures.DateTimeEntry.getDefaultInstance()) ? null : DATE_TIME_ENTRY_PB_CONVERTER.convertFromPb(dateTime) )
                .bankAccId( convertFromPbString(trade.getBankAccId()) )
                .brokerComission( convertFromPbString(trade.getBrokerComission()) )
                .linkedTrade( convertFromPbString(trade.getLinkedTrade()) )
                .period( trade.getPeriod() )
                .transId( convertFromPbString(trade.getTransId()) )
                .kind( trade.getKind() )
                .clearingBankAccId( convertFromPbString(trade.getClearingBankAccid()) )
                .canceledDatetime( Objects.equals(canceledDateTime, QluaStructures.DateTimeEntry.getDefaultInstance()) ? null : DATE_TIME_ENTRY_PB_CONVERTER.convertFromPb(canceledDateTime) )
                .clearingFirmId( convertFromPbString(trade.getClearingFirmid()) )
                .systemRef( convertFromPbString(trade.getSystemRef()) )
                .uid( convertFromPbString(trade.getUid()) )
                .build();
    }

    @Override
    public QluaStructures.Trade convertToPb(@NotNull final Trade trade) {

        return QluaStructures.Trade.newBuilder()
                .setTradeNum( trade.getTradeNum() )
                .setOrderNum( trade.getOrderNum() )
                .setBrokerref( convertToPbString(trade.getBrokerRef()) )
                .setUserid( convertToPbString(trade.getUserId()) )
                .setFirmid( convertToPbString(trade.getFirmId()) )
                .setCanceledUid( convertToPbString(trade.getCanceledUid()) )
                .setAccount( convertToPbString(trade.getAccount()) )
                .setPrice( convertToPbString(trade.getPrice()) )
                .setQty( trade.getQty() )
                .setValue( convertToPbString(trade.getValue()) )
                .setAccruedint( convertToPbString(trade.getAccruedInt()) )
                .setYield( convertToPbString(trade.getYield()) )
                .setSettlecode( convertToPbString(trade.getSettleCode()) )
                .setCpfirmid( convertToPbString(trade.getCpFirmId()) )
                .setFlags( trade.getFlags() )
                .setPrice2( convertToPbString(trade.getPrice2()) )
                .setReporate( convertToPbString(trade.getRepoRate()) )
                .setClientCode( convertToPbString(trade.getClientCode()) )
                .setAccrued2( convertToPbString(trade.getAccrued2()) )
                .setRepoterm( convertToPbString(trade.getRepoTerm()) )
                .setRepovalue( convertToPbString(trade.getRepoValue()) )
                .setRepo2Value( convertToPbString(trade.getRepo2Value()) )
                .setStartDiscount( convertToPbString(trade.getStartDiscount()) )
                .setLowerDiscount( convertToPbString(trade.getLowerDiscount()) )
                .setUpperDiscount( convertToPbString(trade.getUpperDiscount()) )
                .setBlockSecurities( convertToPbString(trade.getBlockSecurities()) )
                .setClearingComission( convertToPbString(trade.getClearingComission()) )
                .setExchangeComission( convertToPbString(trade.getExchangeComission()) )
                .setTechCenterComission( convertToPbString(trade.getTechCenterComission()) )
                .setSettleDate( convertToPbString(trade.getSettleDate()) )
                .setSettleCurrency( convertToPbString(trade.getSettleCurrency()) )
                .setTradeCurrency( convertToPbString(trade.getTradeCurrency()) )
                .setExchangeCode( convertToPbString(trade.getExchangeCode()) )
                .setStationId( convertToPbString(trade.getStationId()) )
                .setSecCode( convertToPbString(trade.getSecCode()) )
                .setClassCode( convertToPbString(trade.getClassCode()) )
                .setDatetime( trade.getDatetime() == null ? QluaStructures.DateTimeEntry.getDefaultInstance() : DATE_TIME_ENTRY_PB_CONVERTER.convertToPb(trade.getDatetime()))
                .setBankAccId( convertToPbString(trade.getBankAccId()) )
                .setBrokerComission( convertToPbString(trade.getBrokerComission()) )
                .setLinkedTrade( convertToPbString(trade.getLinkedTrade()) )
                .setPeriod( trade.getPeriod() )
                .setTransId( convertToPbString(trade.getTransId()) )
                .setKind( trade.getKind() )
                .setClearingBankAccid( convertToPbString(trade.getClearingBankAccId()) )
                .setCanceledDatetime( trade.getCanceledDatetime() == null ? QluaStructures.DateTimeEntry.getDefaultInstance() : DATE_TIME_ENTRY_PB_CONVERTER.convertToPb(trade.getCanceledDatetime()) )
                .setClearingFirmid( convertToPbString(trade.getClearingFirmId()) )
                .setSystemRef( convertToPbString(trade.getSystemRef()) )
                .setUid( convertToPbString(trade.getUid()) )
                .build();
    }
}
