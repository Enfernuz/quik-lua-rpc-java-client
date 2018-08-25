package com.enfernuz.quik.lua.rpc.api.messages;

import com.enfernuz.quik.lua.rpc.api.structures.Security;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

public final class GetSecurityInfo {

    @Value
    public static class Request {

        @NonNull String classCode;
        @NonNull String secCode;

        @Builder
        private Request(final String classCode, final String secCode) {
            this.classCode = classCode;
            this.secCode = secCode;
        }

        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add("class_code", classCode)
                    .add("sec_code", secCode)
                    .toString();
        }
    }

    @Value
    public static class Result {

        @NonNull Security securityInfo;

        @JsonCreator
        public Result(final @JsonProperty(value = "security_info", required = true) Security securityInfo) {
            this.securityInfo = securityInfo;
        }

        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add("security_info", securityInfo)
                    .toString();
        }
    }
}
