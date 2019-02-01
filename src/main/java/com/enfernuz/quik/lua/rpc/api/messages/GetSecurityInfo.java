package com.enfernuz.quik.lua.rpc.api.messages;

import com.enfernuz.quik.lua.rpc.api.RemoteProcedure;
import com.enfernuz.quik.lua.rpc.api.RpcArgs;
import com.enfernuz.quik.lua.rpc.api.RpcResult;
import com.enfernuz.quik.lua.rpc.api.structures.Security;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.MoreObjects;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.Value;
import org.jetbrains.annotations.NotNull;

public final class GetSecurityInfo implements RemoteProcedure {

    private GetSecurityInfo() {}

    @JsonPropertyOrder({Args.CLASS_CODE, Args.SEC_CODE})
    @EqualsAndHashCode
    public static final class Args implements RpcArgs<GetSecurityInfo> {

        private static final String CLASS_CODE = "class_code";
        private static final String SEC_CODE = "sec_code";

        @JsonProperty(CLASS_CODE)
        private final String classCode;

        @JsonProperty(SEC_CODE)
        private final String secCode;

        @Builder
        private Args(@NonNull final String classCode, @NonNull final String secCode) {

            this.classCode = classCode;
            this.secCode = secCode;
        }

        @JsonIgnore
        public String getClassCode() {
            return classCode;
        }

        @JsonIgnore
        public String getSecCode() {
            return secCode;
        }

        @NotNull
        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add(CLASS_CODE, classCode)
                    .add(SEC_CODE, secCode)
                    .toString();
        }
    }

    @Value
    public static class Result implements RpcResult<GetSecurityInfo> {

        private static final String SECURITY_INFO = "security_info";

        Security securityInfo;

        @JsonCreator
        public static Result getInstance(@JsonProperty(SECURITY_INFO) final Security securityInfo) {
            return securityInfo == null ? InstanceHolder.ERROR : new Result(securityInfo);
        }

        public static Result getErrorInstance() {
            return InstanceHolder.ERROR;
        }

        private Result(final Security securityInfo) {
            this.securityInfo = securityInfo;
        }

        public boolean isError() {
            return securityInfo == null;
        }

        @NotNull
        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add(SECURITY_INFO, securityInfo)
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
