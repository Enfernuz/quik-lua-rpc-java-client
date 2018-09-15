package com.enfernuz.quik.lua.rpc.api.messages;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import lombok.Builder;
import lombok.NonNull;
import lombok.Value;
import org.jetbrains.annotations.NotNull;

public final class GetParamEx {

    private GetParamEx() {}

    @Value
    public static class ParamEx {

        String paramType;
        String paramValue;
        String paramImage;
        String result;

        @Builder
        @JsonCreator
        private ParamEx(final @JsonProperty("param_type") String paramType,
                        final @JsonProperty("param_value") String paramValue,
                        final @JsonProperty("param_image") String paramImage,
                        final @JsonProperty("result") String result) {
            this.paramType = paramType;
            this.paramValue = paramValue;
            this.paramImage = paramImage;
            this.result = result;
        }

        @NotNull
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

        String classCode;
        String secCode;
        String paramName;

        @Builder
        private Request(@NonNull final String classCode, @NonNull final String secCode, @NonNull final String paramName) {
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

        ParamEx paramEx;

        @JsonCreator
        public Result(@JsonProperty(value = "param_ex", required = true) @NonNull final ParamEx paramEx) {
            this.paramEx = paramEx;
        }

        @NotNull
        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add("param_ex", paramEx)
                    .toString();
        }
    }
}
