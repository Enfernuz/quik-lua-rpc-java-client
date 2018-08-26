package com.enfernuz.quik.lua.rpc.api.messages;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableMap;
import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

import java.util.Map;

public final class SetLabelParams {

    private SetLabelParams() {}

    @Value
    public static class Request {

        @NonNull String chartTag;
        int labelId;
        @NonNull Map<String, String> labelParams;

        @Builder
        private Request(final String chartTag, final int labelId, final Map<String, String> labelParams) {
            this.chartTag = chartTag;
            this.labelId = labelId;
            this.labelParams = ImmutableMap.copyOf(labelParams);
        }

        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add("chart_tag", chartTag)
                    .add("label_id", labelId)
                    .add("label_params", labelParams)
                    .toString();
        }
    }

    @Value
    public static class Result {

        boolean result;

        @JsonCreator
        public Result(final @JsonProperty(value = "result", required = true) boolean result) {
            this.result = result;
        }

        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add("result", result)
                    .toString();
        }
    }
}
