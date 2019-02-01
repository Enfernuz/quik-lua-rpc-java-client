package com.enfernuz.quik.lua.rpc.api.messages;

import com.enfernuz.quik.lua.rpc.api.RemoteProcedure;
import com.enfernuz.quik.lua.rpc.api.RpcResult;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import lombok.NonNull;
import lombok.Value;
import org.jetbrains.annotations.NotNull;

public final class GetWorkingFolder implements RemoteProcedure {

    private GetWorkingFolder() {}

    @Value
    public static class Result implements RpcResult<GetWorkingFolder> {

        private static final String WORKING_FOLDER = "working_folder";

        String workingFolder;

        public Result(@JsonProperty(value = WORKING_FOLDER, required = true) @NonNull final String workingFolder) {
            this.workingFolder = workingFolder;
        }

        @NotNull
        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add(WORKING_FOLDER, workingFolder)
                    .toString();
        }
    }
}
