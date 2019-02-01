package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.DelAllLabels;
import com.enfernuz.quik.lua.rpc.serde.Serializer;
import org.jetbrains.annotations.NotNull;

public class DelAllLabelsArgsPbSerdeTest extends AbstractPbSerializationTest<DelAllLabels.Args, qlua.rpc.DelAllLabels.Args> {

    private static final String CHART_TAG = "1";

    @Override
    public @NotNull Serializer<DelAllLabels.Args> getSerializerUnderTest() {
        return DelAllLabelsArgsPbSerializer.INSTANCE;
    }

    @NotNull
    @Override
    public qlua.rpc.DelAllLabels.Args getTargetObjectAsPbMessage() {

        return qlua.rpc.DelAllLabels.Args.newBuilder()
                .setChartTag(CHART_TAG)
                .build();
    }

    @NotNull
    @Override
    public DelAllLabels.Args getTargetObject() {
        return new DelAllLabels.Args(CHART_TAG);
    }
}
