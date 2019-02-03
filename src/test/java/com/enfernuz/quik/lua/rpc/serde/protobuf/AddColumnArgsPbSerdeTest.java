package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.AddColumn;
import com.enfernuz.quik.lua.rpc.serde.Serializer;
import org.jetbrains.annotations.NotNull;

public class AddColumnArgsPbSerdeTest extends AbstractPbSerializationTest<AddColumn.Args, qlua.rpc.AddColumn.Args> {

    private static final int T_ID = 1;
    private static final int I_CODE = 2;
    private static final String NAME = "3";
    private static final AddColumn.ColumnParameterType PAR_TYPE = AddColumn.ColumnParameterType.QTABLE_INT64_TYPE;
    private static final qlua.rpc.AddColumn.ColumnParameterType PB_PAR_TYPE = qlua.rpc.AddColumn.ColumnParameterType.QTABLE_INT64_TYPE;
    private static final boolean IS_DEFAULT = true;
    private static final int WIDTH = 6;

    @Override
    public @NotNull Serializer<AddColumn.Args> getSerializerUnderTest() {
        return AddColumnArgsPbSerializer.INSTANCE;
    }

    @NotNull
    @Override
    public qlua.rpc.AddColumn.Args getTargetObjectAsPbMessage() {

        return qlua.rpc.AddColumn.Args.newBuilder()
                .setTId(T_ID)
                .setICode(I_CODE)
                .setName(NAME)
                .setParType(PB_PAR_TYPE) // TODO: add tests for all the enum values
                .setIsDefault(IS_DEFAULT)
                .setWidth(WIDTH)
                .build();
    }

    @NotNull
    @Override
    public AddColumn.Args getTargetObject() {

        return AddColumn.Args.builder()
                .tId(T_ID)
                .iCode(I_CODE)
                .name(NAME)
                .parType(PAR_TYPE)
                .isDefault(IS_DEFAULT)
                .width(WIDTH)
                .build();
    }
}
