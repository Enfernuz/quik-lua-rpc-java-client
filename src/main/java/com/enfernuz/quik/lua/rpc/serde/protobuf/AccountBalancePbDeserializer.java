package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.structures.AccountBalance;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import qlua.structs.QluaStructures;

import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.convertFromPbString;

enum AccountBalancePbDeserializer implements Deserializer<AccountBalance> {

    INSTANCE;

    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public AccountBalance deserialize(final byte[] data) {

        final QluaStructures.AccountBalance accountBalance = QluaStructures.AccountBalance.parseFrom(data);
        return AccountBalance
                .builder()
                .firmId( convertFromPbString(accountBalance.getFirmid()) )
                .secCode( convertFromPbString(accountBalance.getSecCode()) )
                .trdAccId( convertFromPbString(accountBalance.getTrdaccid()) )
                .depAccId( convertFromPbString(accountBalance.getDepaccid()) )
                .openBal( convertFromPbString(accountBalance.getOpenbal()) )
                .currentPos( convertFromPbString(accountBalance.getCurrentpos()) )
                .plannedPosSell( convertFromPbString(accountBalance.getPlannedpossell()) )
                .plannedPosBuy( convertFromPbString(accountBalance.getPlannedposbuy()) )
                .planBal( convertFromPbString(accountBalance.getPlanbal()) )
                .usqtyb( convertFromPbString(accountBalance.getUsqtyb()) )
                .usqtys( convertFromPbString(accountBalance.getUsqtys()) )
                .planned( convertFromPbString(accountBalance.getPlanned()) )
                .settleBal( convertFromPbString(accountBalance.getSettlebal()) )
                .bankAccId( convertFromPbString(accountBalance.getBankAccId()) )
                .firmUse( accountBalance.getFirmuse() )
                .build();
    }
}
