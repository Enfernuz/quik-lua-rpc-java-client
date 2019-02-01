package com.enfernuz.quik.lua.rpc.api.messages;

import com.enfernuz.quik.lua.rpc.api.RemoteProcedure;
import com.enfernuz.quik.lua.rpc.api.RpcArgs;
import com.enfernuz.quik.lua.rpc.api.RpcResult;
import com.enfernuz.quik.lua.rpc.api.structures.ClassInfo;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.Value;
import org.jetbrains.annotations.NotNull;

public final class GetClassInfo implements RemoteProcedure {

    private GetClassInfo() {}

    @EqualsAndHashCode
    public static final class Args implements RpcArgs<GetClassInfo> {

        private static final String CLASS_CODE = "class_code";

        @JsonProperty(value = CLASS_CODE, required = true)
        private final String classCode;

        public Args(@NonNull final String classCode) {
            this.classCode = classCode;
        }

        @NotNull
        @JsonIgnore
        public String getClassCode() {
            return classCode;
        }

        @NotNull
        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add(CLASS_CODE, classCode)
                    .toString();
        }
    }

    @Value
    public static class Result implements RpcResult<GetClassInfo> {

        private static final String CLASS_INFO = "class_info";

        ClassInfo classInfo;

        @JsonCreator
        public Result(@JsonProperty(value = CLASS_INFO, required = true) @NonNull final ClassInfo classInfo) {
            this.classInfo = classInfo;
        }

        @NotNull
        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add(CLASS_INFO, classInfo)
                    .toString();
        }
    }
}
