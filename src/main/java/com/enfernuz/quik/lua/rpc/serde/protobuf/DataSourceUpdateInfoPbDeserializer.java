package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.structures.DataSourceUpdateInfo;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import qlua.structs.QluaStructures;

import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.convertFromDataSourceTime;
import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.convertFromPbString;

enum DataSourceUpdateInfoPbDeserializer implements Deserializer<DataSourceUpdateInfo>, FromPbConverter<QluaStructures.DataSourceUpdateInfo, DataSourceUpdateInfo> {

    INSTANCE;

    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public DataSourceUpdateInfo deserialize(final byte[] data) {
        return convert( QluaStructures.DataSourceUpdateInfo.parseFrom(data) );
    }

    @Override
    public DataSourceUpdateInfo convert(@NotNull final QluaStructures.DataSourceUpdateInfo pbDataSourceUpdateInfo) {

        final DataSourceUpdateInfo.DataSourceUpdateInfoBuilder result = DataSourceUpdateInfo.builder()
                .datasourceUUID( pbDataSourceUpdateInfo.getUuid() )
                .index( pbDataSourceUpdateInfo.getIndex() )
                .open( convertFromPbString(pbDataSourceUpdateInfo.getOpen()) )
                .high( convertFromPbString(pbDataSourceUpdateInfo.getHigh()) )
                .low( convertFromPbString(pbDataSourceUpdateInfo.getLow()) )
                .close( convertFromPbString(pbDataSourceUpdateInfo.getClose()) )
                .volume( convertFromPbString(pbDataSourceUpdateInfo.getVolume()) );

        if (pbDataSourceUpdateInfo.hasTime()) {
            result.time( convertFromDataSourceTime(pbDataSourceUpdateInfo.getTime()) );
        }

        if (!pbDataSourceUpdateInfo.getNullSize()) {
            result.size( pbDataSourceUpdateInfo.getValueSize() );
        }

        return result.build();
    }
}
