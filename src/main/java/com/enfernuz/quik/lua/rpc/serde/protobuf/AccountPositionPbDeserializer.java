package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.structures.AccountPosition;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import qlua.structs.QluaStructures;

import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.convertFromPbString;

enum AccountPositionPbDeserializer implements Deserializer<AccountPosition>, FromPbConverter<QluaStructures.AccountPosition, AccountPosition> {

    INSTANCE;

    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public AccountPosition deserialize(final byte[] data) {
        return convert( QluaStructures.AccountPosition.parseFrom(data) );
    }

    @Override
    public AccountPosition convert(@NotNull final QluaStructures.AccountPosition accountPosition) {

        return AccountPosition
                .builder()
                .firmId( convertFromPbString(accountPosition.getFirmid()) )
                .currCode( convertFromPbString(accountPosition.getCurrcode()) )
                .tag( convertFromPbString(accountPosition.getTag()) )
                .description( convertFromPbString(accountPosition.getDescription()) )
                .openBal( convertFromPbString(accountPosition.getOpenbal()) )
                .currentPos( convertFromPbString(accountPosition.getCurrentpos()) )
                .plannedPos( convertFromPbString(accountPosition.getPlannedpos()) )
                .limit1( convertFromPbString(accountPosition.getLimit1()) )
                .limit2( convertFromPbString(accountPosition.getLimit2()) )
                .orderBuy( convertFromPbString(accountPosition.getOrderbuy()) )
                .orderSell( convertFromPbString(accountPosition.getOrdersell()) )
                .netto( convertFromPbString(accountPosition.getNetto()) )
                .plannedBal( convertFromPbString(accountPosition.getPlannedbal()) )
                .debit( convertFromPbString(accountPosition.getDebit()) )
                .credit( convertFromPbString(accountPosition.getCredit()) )
                .bankAccId( convertFromPbString(accountPosition.getBankAccId()) )
                .marginCall( convertFromPbString(accountPosition.getMargincall()) )
                .settleBal( convertFromPbString(accountPosition.getSettlebal()) )
                .build();
    }
}
