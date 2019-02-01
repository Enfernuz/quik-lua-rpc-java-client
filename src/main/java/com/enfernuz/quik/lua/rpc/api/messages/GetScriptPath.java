package com.enfernuz.quik.lua.rpc.api.messages;

import com.enfernuz.quik.lua.rpc.api.RemoteProcedure;
import com.enfernuz.quik.lua.rpc.api.RpcArgs;
import com.enfernuz.quik.lua.rpc.api.RpcResult;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import lombok.NonNull;
import lombok.Value;
import org.jetbrains.annotations.NotNull;

public final class GetScriptPath implements RemoteProcedure {

    private GetScriptPath() {}

    @Value
    public static class Result implements RpcResult<GetScriptPath> {

        private static final String SCRIPT_PATH = "script_path";

        String scriptPath;

        public Result(@JsonProperty(value = SCRIPT_PATH, required = true) @NonNull final String scriptPath) {
            this.scriptPath = scriptPath;
        }

        @NotNull
        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add(SCRIPT_PATH, scriptPath)
                    .toString();
        }
    }
}
