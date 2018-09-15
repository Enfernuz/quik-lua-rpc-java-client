package com.enfernuz.quik.lua.rpc.api.messages;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import lombok.NonNull;
import lombok.Value;
import org.jetbrains.annotations.NotNull;

public final class GetWorkingFolder {

    private GetWorkingFolder() {}

    public enum Request { INSTANCE; }

    @Value
    public static class Result {

        private static final String WORKING_FOLDER_FIELD = "working_folder";

        String workingFolder;

        public Result(@JsonProperty(value = WORKING_FOLDER_FIELD, required = true) @NonNull final String workingFolder) {
            this.workingFolder = workingFolder;
        }

        @NotNull
        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add(WORKING_FOLDER_FIELD, workingFolder)
                    .toString();
        }
    }
}
