package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.DelLabel;
import com.enfernuz.quik.lua.rpc.serde.Serializer;
import org.jetbrains.annotations.NotNull;

public class DelLabelArgsPbSerdeTest extends AbstractPbSerializationTest<DelLabel.Args, qlua.rpc.DelLabel.Request> {

    private static final String CHART_TAG = "1";
    private static final int LABEL_ID = 2;

    @Override
    public @NotNull Serializer<DelLabel.Args> getSerializerUnderTest() {
        return DelLabelArgsPbSerializer.INSTANCE;
    }

    @NotNull
    @Override
    public qlua.rpc.DelLabel.Request getTargetObjectAsPbMessage() {

        return qlua.rpc.DelLabel.Request.newBuilder()
                .setChartTag(CHART_TAG)
                .setLabelId(LABEL_ID)
                .build();
    }

    @NotNull
    @Override
    public DelLabel.Args getTargetObject() {
        return new DelLabel.Args(CHART_TAG, LABEL_ID);
    }
}
