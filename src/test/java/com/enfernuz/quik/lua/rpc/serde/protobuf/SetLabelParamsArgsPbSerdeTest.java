package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.SetLabelParams;
import com.enfernuz.quik.lua.rpc.serde.Serializer;
import com.google.common.collect.ImmutableMap;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

public class SetLabelParamsArgsPbSerdeTest extends AbstractPbSerializationTest<SetLabelParams.Args, qlua.rpc.SetLabelParams.Args> {

    private static final String CHART_TAG = "1";
    private static final int LABEL_ID = 2;
    private static final Map<String, String> LABEL_PARAMS = ImmutableMap.of(
            "key_1", "value_1",
            "key_2", "value_2",
            "key_3", "value_3"
    );

    @Override
    public @NotNull Serializer<SetLabelParams.Args> getSerializerUnderTest() {
        return SetLabelParamsArgsPbSerializer.INSTANCE;
    }

    @NotNull
    @Override
    public qlua.rpc.SetLabelParams.Args getTargetObjectAsPbMessage() {

        return qlua.rpc.SetLabelParams.Args.newBuilder()
                .setChartTag(CHART_TAG)
                .setLabelId(LABEL_ID)
                .putAllLabelParams(LABEL_PARAMS)
                .build();
    }

    @NotNull
    @Override
    public SetLabelParams.Args getTargetObject() {
        return new SetLabelParams.Args(CHART_TAG, LABEL_ID, LABEL_PARAMS);
    }
}
