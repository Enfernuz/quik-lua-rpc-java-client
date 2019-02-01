package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetLabelParams;
import com.enfernuz.quik.lua.rpc.serde.Serializer;
import org.jetbrains.annotations.NotNull;

public class GetLabelParamsArgsPbSerdeTest extends AbstractPbSerializationTest<GetLabelParams.Args, qlua.rpc.GetLabelParams.Args> {

    private static final String CHART_TAG = "1";
    private static final int LABEL_ID = 2;

    @Override
    public @NotNull Serializer<GetLabelParams.Args> getSerializerUnderTest() {
        return GetLabelParamsArgsPbSerializer.INSTANCE;
    }

    @NotNull
    @Override
    public qlua.rpc.GetLabelParams.Args getTargetObjectAsPbMessage() {

        return qlua.rpc.GetLabelParams.Args.newBuilder()
                .setChartTag(CHART_TAG)
                .setLabelId(LABEL_ID)
                .build();
    }

    @NotNull
    @Override
    public GetLabelParams.Args getTargetObject() {
        return new GetLabelParams.Args(CHART_TAG, LABEL_ID);
    }
}
