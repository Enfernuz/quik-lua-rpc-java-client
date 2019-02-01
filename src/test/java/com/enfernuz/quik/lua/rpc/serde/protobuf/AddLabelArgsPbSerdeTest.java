package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.AddLabel;
import com.enfernuz.quik.lua.rpc.serde.Serializer;
import com.google.common.collect.ImmutableMap;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

public class AddLabelArgsPbSerdeTest extends AbstractPbSerializationTest<AddLabel.Args, qlua.rpc.AddLabel.Args> {

    private static final String CHART_TAG = "1";
    private static final Map<String, String> LABEL_PARAMS =
            ImmutableMap.of(
                    "key1", "value1",
                    "key2", "value2",
                    "key3", "value3"
            );

    @Override
    public @NotNull Serializer<AddLabel.Args> getSerializerUnderTest() {
        return AddLabelArgsPbSerializer.INSTANCE;
    }

    @NotNull
    @Override
    public qlua.rpc.AddLabel.Args getTargetObjectAsPbMessage() {

        return qlua.rpc.AddLabel.Args.newBuilder()
                .setChartTag(CHART_TAG)
                .putAllLabelParams(LABEL_PARAMS)
                .build();
    }

    @NotNull
    @Override
    public AddLabel.Args getTargetObject() {

        return AddLabel.Args.builder()
                .chartTag(CHART_TAG)
                .labelParams(LABEL_PARAMS)
                .build();
    }
}
