package com.enfernuz.quik.lua.rpc.api.messages;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

public final class GetParamEx2 {

    private GetParamEx2() {}

    @Value
    public static class ParamEx2 {

        String paramType;
        String paramValue;
        String paramImage;
        String result;

        @Builder
        @JsonCreator
        private ParamEx2(final @JsonProperty("param_type") String paramType,
                         final @JsonProperty("param_value") String paramValue,
                         final @JsonProperty("param_image") String paramImage,
                         final @JsonProperty("result") String result) {
            this.paramType = paramType;
            this.paramValue = paramValue;
            this.paramImage = paramImage;
            this.result = result;
        }

        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add("param_type", paramType)
                    .add("param_value", paramValue)
                    .add("param_image", paramImage)
                    .add("result", result)
                    .toString();
        }
    }

    @Value
    public static class Request {

        @NonNull String classCode;
        @NonNull String secCode;
        @NonNull String paramName;

        @Builder
        private Request(final String classCode, final String secCode, final String paramName) {
            this.classCode = classCode;
            this.secCode = secCode;
            this.paramName = paramName;
        }

        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add("class_code", classCode)
                    .add("sec_code", secCode)
                    .add("param_name", paramName)
                    .toString();
        }
    }

    @Value
    public static class Result {

        @NonNull ParamEx2 paramEx;

        @JsonCreator
        public Result(final @JsonProperty(value = "param_ex", required = true) ParamEx2 paramEx) {
            this.paramEx = paramEx;
        }

        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add("param_ex", paramEx)
                    .toString();
        }
    }
}
