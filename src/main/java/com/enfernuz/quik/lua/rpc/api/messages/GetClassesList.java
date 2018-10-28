package com.enfernuz.quik.lua.rpc.api.messages;

import com.enfernuz.quik.lua.rpc.api.RemoteProcedure;
import com.enfernuz.quik.lua.rpc.api.RpcResult;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import lombok.NonNull;
import lombok.Value;
import org.jetbrains.annotations.NotNull;

public final class GetClassesList implements RemoteProcedure {

    @Value
    public static class Result implements RpcResult<GetClassesList> {

        private static final String CLASSES_LIST = "classes_list";

        String classesList;

        public Result(@JsonProperty(value = CLASSES_LIST, required = true) @NonNull final String classesList) {
            this.classesList = classesList;
        }

        @NotNull
        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add(CLASSES_LIST, classesList)
                    .toString();
        }
    }
}
