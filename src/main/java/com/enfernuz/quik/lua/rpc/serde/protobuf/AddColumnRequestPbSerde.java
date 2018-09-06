package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.AddColumn;
import com.enfernuz.quik.lua.rpc.serde.PbConverter;
import com.enfernuz.quik.lua.rpc.serde.Serde;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import qlua.rpc.RPC;

import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.assertEquals;
import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.convertFromPbString;
import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.convertToPbString;

enum AddColumnRequestPbSerde implements Serde<AddColumn.Request>, PbConverter<qlua.rpc.AddColumn.Request, AddColumn.Request> {

    INSTANCE;

    @Override
    public byte[] serialize(final AddColumn.Request request) {

        return RPC.Request.newBuilder()
                .setTypeValue( RPC.ProcedureType.ADD_COLUMN.getNumber() )
                .setArgs( convertToPb(request).toByteString() )
                .build()
                .toByteArray();
    }

    @NotNull
    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public AddColumn.Request deserialize(final byte[] data) {

        final RPC.Request request = RPC.Request.parseFrom(data);
        assertEquals(request.getType(), RPC.ProcedureType.ADD_COLUMN);

        return convertFromPb(
                qlua.rpc.AddColumn.Request.parseFrom( request.getArgs() )
        );
    }

    @Override
    public AddColumn.Request convertFromPb(@NotNull final qlua.rpc.AddColumn.Request request) {

        final qlua.rpc.AddColumn.ColumnParameterType pbParType = request.getParType();
        final AddColumn.ColumnParameterType parType;
        switch (pbParType) {
            case QTABLE_INT_TYPE:
                parType = AddColumn.ColumnParameterType.QTABLE_INT_TYPE;
                break;
            case QTABLE_DOUBLE_TYPE:
                parType = AddColumn.ColumnParameterType.QTABLE_DOUBLE_TYPE;
                break;
            case QTABLE_INT64_TYPE:
                parType = AddColumn.ColumnParameterType.QTABLE_INT64_TYPE;
                break;
            case QTABLE_CACHED_STRING_TYPE:
                parType = AddColumn.ColumnParameterType.QTABLE_CACHED_STRING_TYPE;
                break;
            case QTABLE_TIME_TYPE:
                parType = AddColumn.ColumnParameterType.QTABLE_TIME_TYPE;
                break;
            case QTABLE_DATE_TYPE:
                parType = AddColumn.ColumnParameterType.QTABLE_DATE_TYPE;
                break;
            case QTABLE_STRING_TYPE:
                parType = AddColumn.ColumnParameterType.QTABLE_STRING_TYPE;
                break;
            default:
                throw new IllegalArgumentException(String.format("Неподдерживаемый ColumnParameterType (тип столбца) для формата protobuf: '%s'.", pbParType));
        }

        return AddColumn.Request.builder()
                .tId( request.getTId() )
                .iCode( request.getIcode() )
                .name( convertFromPbString(request.getName()) )
                .isDefault( request.getIsDefault() )
                .parType(parType)
                .width( request.getWidth() )
                .build();
    }

    @Override
    public qlua.rpc.AddColumn.Request convertToPb(@NotNull final AddColumn.Request request) {

        final AddColumn.ColumnParameterType parType = request.getParType();
        final qlua.rpc.AddColumn.ColumnParameterType pbParType;
        switch (parType) {
            case QTABLE_INT_TYPE:
                pbParType = qlua.rpc.AddColumn.ColumnParameterType.QTABLE_INT_TYPE;
                break;
            case QTABLE_DOUBLE_TYPE:
                pbParType = qlua.rpc.AddColumn.ColumnParameterType.QTABLE_DOUBLE_TYPE;
                break;
            case QTABLE_INT64_TYPE:
                pbParType = qlua.rpc.AddColumn.ColumnParameterType.QTABLE_INT64_TYPE;
                break;
            case QTABLE_CACHED_STRING_TYPE:
                pbParType = qlua.rpc.AddColumn.ColumnParameterType.QTABLE_CACHED_STRING_TYPE;
                break;
            case QTABLE_TIME_TYPE:
                pbParType = qlua.rpc.AddColumn.ColumnParameterType.QTABLE_TIME_TYPE;
                break;
            case QTABLE_DATE_TYPE:
                pbParType = qlua.rpc.AddColumn.ColumnParameterType.QTABLE_DATE_TYPE;
                break;
            case QTABLE_STRING_TYPE:
                pbParType = qlua.rpc.AddColumn.ColumnParameterType.QTABLE_STRING_TYPE;
                break;
            default:
                throw new IllegalArgumentException(String.format("Неподдерживаемый ColumnParameterType (тип столбца): '%s'.", parType));
        }

        return qlua.rpc.AddColumn.Request.newBuilder()
                .setTId( request.getTId() )
                .setIcode( request.getICode() )
                .setName( convertToPbString(request.getName()) )
                .setIsDefault( request.isDefault() )
                .setParTypeValue( pbParType.getNumber() )
                .setWidth( request.getWidth() )
                .build();
    }
}
