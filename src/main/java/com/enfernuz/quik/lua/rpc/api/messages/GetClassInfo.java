package com.enfernuz.quik.lua.rpc.api.messages;

import com.enfernuz.quik.lua.rpc.api.structures.ClassInfo;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import lombok.NonNull;
import lombok.Value;

public final class GetClassInfo {

    private GetClassInfo() {}

    @Value
    public static class Request {

        String classCode;

        public Request(@NonNull final String classCode) {
            this.classCode = classCode;
        }

        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add("class_code", classCode)
                    .toString();
        }
    }

    @Value
    public static class Result {

        ClassInfo classInfo;

        @JsonCreator
        public Result(@JsonProperty("class_info") final ClassInfo classInfo) {
            this.classInfo = classInfo;
        }

        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add("class_info", classInfo)
                    .toString();
        }
    }
}
