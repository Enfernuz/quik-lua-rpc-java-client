package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.datasource.CreateDataSource;
import com.enfernuz.quik.lua.rpc.serde.Serializer;
import org.jetbrains.annotations.NotNull;

enum DsCreateDataSourcePbArgsSerializer implements Serializer<CreateDataSource.Args>, ToPbConverter<CreateDataSource.Args, qlua.rpc.datasource.CreateDataSource.Args> {

    INSTANCE;

    @NotNull
    @Override
    public byte[] serialize(@NotNull final CreateDataSource.Args args) {
        return convert(args).toByteArray();
    }

    @NotNull
    @Override
    public qlua.rpc.datasource.CreateDataSource.Args convert(@NotNull final CreateDataSource.Args args) {

        final CreateDataSource.Interval interval = args.getInterval();
        final qlua.rpc.datasource.CreateDataSource.Interval pbInterval;
        switch (interval) {
            case INTERVAL_TICK:
                pbInterval = qlua.rpc.datasource.CreateDataSource.Interval.INTERVAL_TICK;
                break;
            case INTERVAL_M1:
                pbInterval = qlua.rpc.datasource.CreateDataSource.Interval.INTERVAL_M1;
                break;
            case INTERVAL_M2:
                pbInterval = qlua.rpc.datasource.CreateDataSource.Interval.INTERVAL_M2;
                break;
            case INTERVAL_M3:
                pbInterval = qlua.rpc.datasource.CreateDataSource.Interval.INTERVAL_M3;
                break;
            case INTERVAL_M4:
                pbInterval = qlua.rpc.datasource.CreateDataSource.Interval.INTERVAL_M4;
                break;
            case INTERVAL_M5:
                pbInterval = qlua.rpc.datasource.CreateDataSource.Interval.INTERVAL_M5;
                break;
            case INTERVAL_M6:
                pbInterval = qlua.rpc.datasource.CreateDataSource.Interval.INTERVAL_M6;
                break;
            case INTERVAL_M10:
                pbInterval = qlua.rpc.datasource.CreateDataSource.Interval.INTERVAL_M10;
                break;
            case INTERVAL_M15:
                pbInterval = qlua.rpc.datasource.CreateDataSource.Interval.INTERVAL_M15;
                break;
            case INTERVAL_M20:
                pbInterval = qlua.rpc.datasource.CreateDataSource.Interval.INTERVAL_M20;
                break;
            case INTERVAL_M30:
                pbInterval = qlua.rpc.datasource.CreateDataSource.Interval.INTERVAL_M30;
                break;
            case INTERVAL_H1:
                pbInterval = qlua.rpc.datasource.CreateDataSource.Interval.INTERVAL_H1;
                break;
            case INTERVAL_H2:
                pbInterval = qlua.rpc.datasource.CreateDataSource.Interval.INTERVAL_H2;
                break;
            case INTERVAL_H4:
                pbInterval = qlua.rpc.datasource.CreateDataSource.Interval.INTERVAL_H4;
                break;
            case INTERVAL_D1:
                pbInterval = qlua.rpc.datasource.CreateDataSource.Interval.INTERVAL_D1;
                break;
            case INTERVAL_W1:
                pbInterval = qlua.rpc.datasource.CreateDataSource.Interval.INTERVAL_W1;
                break;
            case INTERVAL_MN1:
                pbInterval = qlua.rpc.datasource.CreateDataSource.Interval.INTERVAL_MN1;
                break;
            default:
                throw new IllegalArgumentException( String.format("Неизвестный тип интервала: %s.", interval) );
        }

        final qlua.rpc.datasource.CreateDataSource.Args.Builder result =
                qlua.rpc.datasource.CreateDataSource.Args.newBuilder()
                        .setClassCode( args.getClassCode() )
                        .setSecCode( args.getSecCode() )
                        .setInterval(pbInterval);

        final String param = args.getParam();
        if (param != null) {
            result.setParam(param);
        }

        return result.build();
    }
}
