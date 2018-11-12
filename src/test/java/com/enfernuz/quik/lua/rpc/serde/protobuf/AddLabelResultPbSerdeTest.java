package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.AddLabel;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import org.jetbrains.annotations.NotNull;

public class AddLabelResultPbSerdeTest extends AbstractPbDeserializationTest<qlua.rpc.AddLabel.Result, AddLabel.Result> {

    private static final int LABEL_ID = 1;

    @Override
    public @NotNull Deserializer<AddLabel.Result> getDeserializerUnderTest() {
        return AddLabelResultPbDeserializer.INSTANCE;
    }

    @NotNull
    @Override
    public AddLabel.Result getTargetObject() {
        return new AddLabel.Result(LABEL_ID);
    }

    @NotNull
    @Override
    public qlua.rpc.AddLabel.Result getTargetObjectAsPbMessage() {

        return qlua.rpc.AddLabel.Result.newBuilder()
                .setLabelId(LABEL_ID)
                .build();
    }
}
