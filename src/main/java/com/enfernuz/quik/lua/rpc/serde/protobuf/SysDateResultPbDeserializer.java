package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.os.SysDate;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;

import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.convertFromPbDateTimeEntry;

enum SysDateResultPbDeserializer implements Deserializer<SysDate.Result>, FromPbConverter<qlua.rpc.os.Sysdate.Result, SysDate.Result> {

    INSTANCE;

    @NotNull
    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public SysDate.Result deserialize(final byte[] data) {
        return convert( qlua.rpc.os.Sysdate.Result.parseFrom(data) );
    }

    @Override
    public SysDate.Result convert(@NotNull final qlua.rpc.os.Sysdate.Result result) {
        return new SysDate.Result( convertFromPbDateTimeEntry(result.getResult()) );
    }
}
