package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.structures.Trade;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import qlua.structs.QluaStructures;

import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.convertFromPbDateTimeEntry;
import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.convertFromPbString;

enum TradePbDeserializer implements Deserializer<Trade>, FromPbConverter<QluaStructures.Trade, Trade> {

    INSTANCE;

    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public Trade deserialize(final byte[] data) {
        return convert(QluaStructures.Trade.parseFrom(data));
    }

    @Override
    public Trade convert(@NotNull QluaStructures.Trade trade) {

        final Trade.TradeBuilder result = Trade.builder()
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
                .bankAccId( convertFromPbString(trade.getBankAccId()) )
                .brokerComission( convertFromPbString(trade.getBrokerComission()) )
                .linkedTrade( convertFromPbString(trade.getLinkedTrade()) )
                .period( trade.getPeriod() )
                .transId( convertFromPbString(trade.getTransId()) )
                .kind( trade.getKind() )
                .clearingBankAccId( convertFromPbString(trade.getClearingBankAccid()) )
                .clearingFirmId( convertFromPbString(trade.getClearingFirmid()) )
                .systemRef( convertFromPbString(trade.getSystemRef()) )
                .uid( convertFromPbString(trade.getUid()) );

        if (trade.hasDatetime()) {
            result.datetime( convertFromPbDateTimeEntry(trade.getDatetime()) );
        }

        if (trade.hasCanceledDatetime()) {
            result.canceledDatetime( convertFromPbDateTimeEntry(trade.getCanceledDatetime()) );
        }

        return result.build();
    }
}
