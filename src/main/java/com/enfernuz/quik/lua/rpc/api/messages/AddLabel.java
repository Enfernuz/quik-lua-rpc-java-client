package com.enfernuz.quik.lua.rpc.api.messages;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableMap;
import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

import java.util.Map;

public final class AddLabel {

    private AddLabel() {}

    @Value
    public static class Request {

        @NonNull String chartTag;
        @NonNull Map<String, String> labelParams;

        @Builder
        private Request(final String chartTag, final Map<String, String> labelParams) {
            this.chartTag = chartTag;
            this.labelParams = ImmutableMap.copyOf(labelParams);
        }

        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add("chart_tag", chartTag)
                    .add("label_params", labelParams)
                    .toString();
        }
    }

    @Value
    public static class Result {

        int labelId;

        @JsonCreator
        public Result(@JsonProperty(value = "label_id", required = true) int labelId) {
            this.labelId = labelId;
        }

        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add("label_id", labelId)
                    .toString();
        }
    }
}
