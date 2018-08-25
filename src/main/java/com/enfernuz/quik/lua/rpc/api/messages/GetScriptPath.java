package com.enfernuz.quik.lua.rpc.api.messages;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import lombok.NonNull;
import lombok.Value;

public final class GetScriptPath {

    private GetScriptPath() {}

    public static enum Request { INSTANCE; }

    @Value
    public static class Result {

        @NonNull String scriptPath;

        public Result(final @JsonProperty(value = "script_path", required = true) String scriptPath) {
            this.scriptPath = scriptPath;
        }

        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add("script_path", scriptPath)
                    .toString();
        }
    }
}
