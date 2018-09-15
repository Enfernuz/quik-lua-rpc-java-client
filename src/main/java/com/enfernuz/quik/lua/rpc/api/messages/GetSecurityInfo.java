package com.enfernuz.quik.lua.rpc.api.messages;

import com.enfernuz.quik.lua.rpc.api.structures.Security;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import lombok.Builder;
import lombok.NonNull;
import lombok.Value;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public final class GetSecurityInfo {

    private GetSecurityInfo() {}

    private static final String CLASS_CODE_FIELD = "class_code";
    private static final String SEC_CODE_FIELD = "sec_code";

    @Value
    public static class Request {

        String classCode;
        String secCode;

        @Builder
        private Request(@NonNull final String classCode, @NonNull final String secCode) {
            this.classCode = classCode;
            this.secCode = secCode;
        }

        @NotNull
        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add(CLASS_CODE_FIELD, classCode)
                    .add(SEC_CODE_FIELD, secCode)
                    .toString();
        }
    }

    @Value
    public static class Result {

        private static final String SECURITY_INFO_FIELD = "security_info";

        Security securityInfo;

        @JsonCreator
        public static Result getInstance(@JsonProperty(value = SECURITY_INFO_FIELD) final Security securityInfo) {
            return securityInfo == null ? InstanceHolder.ERROR : new Result(securityInfo);
        }

        @Contract(pure = true)
        public static Result getErrorInstance() {
            return InstanceHolder.ERROR;
        }

        private Result(final Security securityInfo) {
            this.securityInfo = securityInfo;
        }

        @Contract(pure = true)
        public boolean isError() {
            return securityInfo == null;
        }

        @NotNull
        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add(SECURITY_INFO_FIELD, securityInfo)
                    .toString();
        }

        private static final class InstanceHolder {

            private static final Result ERROR = new Result(null);

            // sanity check
            static {
                assert ERROR.isError();
            }
        }
    }
}
