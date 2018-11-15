package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetWorkingFolder;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import org.jetbrains.annotations.NotNull;

public class GetWorkingFolderResultPbSerdeTest extends AbstractPbDeserializationTest<qlua.rpc.GetWorkingFolder.Result, GetWorkingFolder.Result> {

    private static final String WORKING_FOLDER = "1";

    @Override
    public @NotNull Deserializer<GetWorkingFolder.Result> getDeserializerUnderTest() {
        return GetWorkingFolderResultPbDeserializer.INSTANCE;
    }

    @NotNull
    @Override
    public GetWorkingFolder.Result getTargetObject() {
        return new GetWorkingFolder.Result(WORKING_FOLDER);
    }

    @NotNull
    @Override
    public qlua.rpc.GetWorkingFolder.Result getTargetObjectAsPbMessage() {

        return qlua.rpc.GetWorkingFolder.Result.newBuilder()
                .setWorkingFolder(WORKING_FOLDER)
                .build();
    }
}
