package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetClassesList;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import org.jetbrains.annotations.NotNull;

public class GetClassesListResultPbSerdeTest extends AbstractPbDeserializationTest<qlua.rpc.GetClassesList.Result, GetClassesList.Result> {

    private static final String CLASSES_LIST = "1";

    @Override
    public @NotNull Deserializer<GetClassesList.Result> getDeserializerUnderTest() {
        return GetClassesListResultPbDeserializer.INSTANCE;
    }

    @NotNull
    @Override
    public GetClassesList.Result getTargetObject() {
        return new GetClassesList.Result(CLASSES_LIST);
    }

    @NotNull
    @Override
    public qlua.rpc.GetClassesList.Result getTargetObjectAsPbMessage() {

        return qlua.rpc.GetClassesList.Result.newBuilder()
                .setClassesList(CLASSES_LIST)
                .build();
    }
}
