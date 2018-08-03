package com.enfernuz.quik.lua.rpc.api.messages;

import com.enfernuz.quik.lua.rpc.api.structures.ClassInfo;
import com.google.common.base.MoreObjects;
import lombok.NonNull;
import lombok.Value;

public final class GetClassInfo {

    private GetClassInfo() {}

    @Value
    public static class Request {

        @NonNull String classCode;

        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add("class_code", classCode)
                    .toString();
        }
    }

    @Value
    public static class Result {

        @NonNull
        ClassInfo classInfo;

        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add("class_info", classInfo)
                    .toString();
        }
    }
}
