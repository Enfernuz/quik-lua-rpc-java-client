package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.AddColumn;
import com.enfernuz.quik.lua.rpc.serde.Serializer;
import org.jetbrains.annotations.NotNull;

import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.convertToPbString;

enum AddColumnArgsPbSerializer implements Serializer<AddColumn.Args>, ToPbConverter<AddColumn.Args, qlua.rpc.AddColumn.Args> {

    INSTANCE;

    @Override
    public @NotNull byte[] serialize(@NotNull final AddColumn.Args args) {
        return convert(args).toByteArray();
    }

    @Override
    public @NotNull qlua.rpc.AddColumn.Args convert(@NotNull final AddColumn.Args args) {

        final AddColumn.ColumnParameterType parType = args.getParType();
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

        return qlua.rpc.AddColumn.Args.newBuilder()
                .setTId( args.getTId() )
                .setICode( args.getICode() )
                .setName( convertToPbString(args.getName()) )
                .setIsDefault( args.isDefault() )
                .setParTypeValue( pbParType.getNumber() )
                .setWidth( args.getWidth() )
                .build();
    }
}
