package com.enfernuz.quik.lua.rpc.api.messages;

import com.google.common.base.MoreObjects;
import lombok.NonNull;
import lombok.Value;

public final class GetClassSecurities {

    private GetClassSecurities() {}

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

        String classSecurities;

        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add("class_securities", classSecurities)
                    .toString();
        }
    }
}
