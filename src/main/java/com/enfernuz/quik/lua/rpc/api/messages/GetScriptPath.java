package com.enfernuz.quik.lua.rpc.api.messages;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import lombok.NonNull;
import lombok.Value;
import org.jetbrains.annotations.NotNull;

public final class GetScriptPath {

    private GetScriptPath() {}

    public static enum Request { INSTANCE; }

    @Value
    public static class Result {

        String scriptPath;

        public Result(@JsonProperty(value = "script_path", required = true) @NonNull final String scriptPath) {
            this.scriptPath = scriptPath;
        }

        @NotNull
        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add("script_path", scriptPath)
                    .toString();
        }
    }
}
