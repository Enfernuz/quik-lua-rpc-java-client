package com.enfernuz.quik.lua.rpc.api.messages;

import com.enfernuz.quik.lua.rpc.api.RemoteProcedure;
import com.enfernuz.quik.lua.rpc.api.RpcArgs;
import com.enfernuz.quik.lua.rpc.api.RpcResult;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableMap;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.Value;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Map;

import static java.util.Collections.emptyMap;

public final class AddLabel implements RemoteProcedure {

    private AddLabel() {}

    @JsonPropertyOrder({Args.CHART_TAG, Args.LABEL_PARAMS})
    @EqualsAndHashCode
    public static class Args implements RpcArgs<AddLabel> {

        private static final String CHART_TAG = "chart_tag";
        private static final String LABEL_PARAMS = "label_params";

        @JsonProperty(CHART_TAG)
        private final String chartTag;

        @JsonProperty(LABEL_PARAMS)
        private final Map<String, String> labelParams;

        @Builder
        private Args(@NonNull final String chartTag, final Map<String, String> labelParams) {
            this.chartTag = chartTag;
            this.labelParams = (labelParams == null) ? emptyMap() : ImmutableMap.copyOf(labelParams);
        }

        @NotNull
        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add(CHART_TAG, chartTag)
                    .add(LABEL_PARAMS, labelParams)
                    .toString();
        }

        @JsonIgnore
        public String getChartTag() {
            return this.chartTag;
        }

        @JsonIgnore
        public Map<String, String> getLabelParams() {
            return this.labelParams;
        }
    }

    @Value
    public static class Result implements RpcResult<AddLabel> {

        private static final String LABEL_ID = "label_id";

        @Nullable
        Integer labelId;

        @JsonCreator
        public Result(@JsonProperty(value = LABEL_ID) final Integer labelId) {
            this.labelId = labelId;
        }

        @NotNull
        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add(LABEL_ID, labelId)
                    .toString();
        }
    }
}
