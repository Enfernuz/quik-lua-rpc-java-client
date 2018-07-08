package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.events.api.QluaEvent;
import com.enfernuz.quik.lua.rpc.events.api.structures.Firm;
import com.enfernuz.quik.lua.rpc.events.api.structures.MoneyLimit;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import com.enfernuz.quik.lua.rpc.serde.Serde;
import com.enfernuz.quik.lua.rpc.serde.SerdeModule;

public enum ProtobufSerdeModule implements SerdeModule {

    INSTANCE;

    @Override
    public Serde<QluaEvent.EventType> getQluaEventTypeSerde() {
        return ProtobufQluaEventTypeSerde.INSTANCE;
    }

    @Override
    public Deserializer<Firm> getFirmDeserializer() {
        return ProtobufFirmDeserializer.INSTANCE;
    }

    @Override
    public Deserializer<MoneyLimit> getMoneyLimitDeserializer() {
        return ProtobufMoneyLimitDeserializer.INSTANCE;
    }


}
