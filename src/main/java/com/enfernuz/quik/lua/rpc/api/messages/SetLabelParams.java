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
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.Value;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

public final class SetLabelParams implements RemoteProcedure {

    private SetLabelParams() {}

    @JsonPropertyOrder({Args.CHART_TAG, Args.LABEL_ID, Args.LABEL_PARAMS})
    @EqualsAndHashCode
    public static final class Args implements RpcArgs<SetLabelParams> {

        private static final String CHART_TAG = "chart_tag";
        private static final String LABEL_ID = "label_id";
        private static final String LABEL_PARAMS = "label_params";

        @JsonProperty(CHART_TAG)
        private final String chartTag;

        @JsonProperty(LABEL_ID)
        private final int labelId;

        @JsonProperty(LABEL_PARAMS)
        private final Map<String, String> labelParams;

        public Args(@NonNull final String chartTag, final int labelId, @NonNull final Map<String, String> labelParams) {

            this.chartTag = chartTag;
            this.labelId = labelId;
            this.labelParams = ImmutableMap.copyOf(labelParams);
        }

        @JsonIgnore
        public String getChartTag() {
            return chartTag;
        }

        @JsonIgnore
        public int getLabelId() {
            return labelId;
        }

        @JsonIgnore
        public Map<String, String> getLabelParams() {
            return labelParams;
        }

        @NotNull
        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add(CHART_TAG, chartTag)
                    .add(LABEL_ID, labelId)
                    .add(LABEL_PARAMS, labelParams)
                    .toString();
        }
    }

    @Value
    public static class Result implements RpcResult<SetLabelParams> {

        private static final String RESULT = "result";

        boolean result;

        @JsonCreator
        public static Result getInstance(@JsonProperty(value = RESULT, required = true) final boolean result) {
            return result ? InstanceHolder.TRUE : InstanceHolder.FALSE;
        }

        private Result(final  boolean result) {
            this.result = result;
        }

        @NotNull
        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add(RESULT, result)
                    .toString();
        }

        private static final class InstanceHolder {

            private static final Result TRUE = new Result(true);
            private static final Result FALSE = new Result(false);

            // sanity check
            static {
                assert TRUE.result;
                assert !FALSE.result;
            }
        }
    }
}
