package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetWorkingFolder;
import org.jetbrains.annotations.NotNull;

public class GetWorkingFolderResultPbSerdeTest extends AbstractResultPbSerdeTest<GetWorkingFolder.Result, qlua.rpc.GetWorkingFolder.Result> {

    private static final String WORKING_FOLDER = "1";

    @Override
    public @NotNull Class<GetWorkingFolder.Result> getTargetObjectClass() {
        return GetWorkingFolder.Result.class;
    }

    @NotNull
    @Override
    public qlua.rpc.GetWorkingFolder.Result getTargetObjectAsPbMessage() {
        return qlua.rpc.GetWorkingFolder.Result.newBuilder()
                .setWorkingFolder(WORKING_FOLDER)
                .build();
    }

    @NotNull
    @Override
    public GetWorkingFolder.Result getTargetObject() {
        return new GetWorkingFolder.Result(WORKING_FOLDER);
    }
}
