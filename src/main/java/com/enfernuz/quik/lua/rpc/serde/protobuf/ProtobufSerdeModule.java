package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.events.api.QluaEvent;
import com.enfernuz.quik.lua.rpc.events.api.structures.Firm;
import com.enfernuz.quik.lua.rpc.serde.Serde;
import com.enfernuz.quik.lua.rpc.serde.SerdeModule;

public class ProtobufSerdeModule implements SerdeModule {

    @Override
    public Serde<QluaEvent.EventType> getQluaEventTypeSerde() {
        return ProtobufQluaEventTypeSerde.INSTANCE;
    }

    @Override
    public Serde<Firm> getFirmSerde() {
        return ProtobufFirmSerde.INSTANCE;
    }
}
