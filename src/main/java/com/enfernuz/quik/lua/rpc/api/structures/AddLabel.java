package com.enfernuz.quik.lua.rpc.api.structures;

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

        String chartTag;
        Map<String, String> labelParams;

        @Builder
        public Request(final @NonNull String chartTag, final @NonNull Map<String, String> labelParams) {
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

        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add("label_id", labelId)
                    .toString();
        }
    }
}
