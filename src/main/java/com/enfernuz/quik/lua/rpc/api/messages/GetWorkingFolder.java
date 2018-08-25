package com.enfernuz.quik.lua.rpc.api.messages;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import lombok.NonNull;
import lombok.Value;

public final class GetWorkingFolder {

    private GetWorkingFolder() {}

    public static enum Request { INSTANCE; }

    @Value
    public static class Result {

        @NonNull String workingFolder;

        public Result(final @JsonProperty(value = "working_folder", required = true) String workingFolder) {
            this.workingFolder = workingFolder;
        }

        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add("working_folder", workingFolder)
                    .toString();
        }
    }
}
