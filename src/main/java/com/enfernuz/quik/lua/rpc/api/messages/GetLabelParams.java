package com.enfernuz.quik.lua.rpc.api.messages;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import lombok.NonNull;
import lombok.Value;

import java.util.Map;

public final class GetLabelParams {

    private GetLabelParams() {}

    @Value
    public static class Request {

        @NonNull String chartTag;
        int labelId;

        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add("chart_tag", chartTag)
                    .add("label_id", labelId)
                    .toString();
        }
    }

    @Value
    public static class Result {

        @JsonProperty(value = "label_params")
        Map<String, String> labelParams;

        @JsonCreator
        public Result(final @NonNull Map<String, String> labelParams) {
            this.labelParams = labelParams;
        }

        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add("label_params", labelParams)
                    .toString();
        }
    }
}
