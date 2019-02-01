package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.structures.AllTrade;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import qlua.structs.QluaStructures;

import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.convertFromPbString;

enum AllTradePbDeserializer implements Deserializer<AllTrade>, FromPbConverter<QluaStructures.AllTrade, AllTrade> {

    INSTANCE;

    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public AllTrade deserialize(final byte[] data) {
        return convert( QluaStructures.AllTrade.parseFrom(data) );
    }

    @Override
    public AllTrade convert(@NotNull final QluaStructures.AllTrade allTrade) {

        return AllTrade
                .builder()
                .tradeNum( allTrade.getTradeNum() )
                .flags( allTrade.getNullFlags() ? null : allTrade.getValueFlags() )
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
                .datetime( DateTimeEntryPbDeserializer.INSTANCE.convert(allTrade.getDatetime()) )
                .period( allTrade.getPeriod() )
                .openInterest( convertFromPbString(allTrade.getOpenInterest()) )
                .exchangeCode( convertFromPbString(allTrade.getExchangeCode()) )
                .build();
    }
}
