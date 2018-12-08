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

public final class GetLabelParams implements RemoteProcedure {

    private GetLabelParams() {}

    @JsonPropertyOrder({Args.CHART_TAG, Args.LABEL_ID})
    @EqualsAndHashCode
    public static final class Args implements RpcArgs<GetLabelParams> {

        private static final String CHART_TAG = "chart_tag";
        private static final String LABEL_ID = "label_id";

        @JsonProperty(CHART_TAG)
        private final String chartTag;

        @JsonProperty(LABEL_ID)
        private final int labelId;

        public Args(@NonNull final String chartTag, final int labelId) {
            this.chartTag = chartTag;
            this.labelId = labelId;
        }

        @JsonIgnore
        public String getChartTag() {
            return chartTag;
        }

        @JsonIgnore
        public int getLabelId() {
            return labelId;
        }

        @NotNull
        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add(CHART_TAG, chartTag)
                    .add(LABEL_ID, labelId)
                    .toString();
        }
    }

    @Value
    public static class Result implements RpcResult<GetLabelParams> {

        private static final String LABEL_PARAMS = "label_params";

        Map<String, String> labelParams;

        @JsonCreator
        public static Result getInstance(@JsonProperty(LABEL_PARAMS) final Map<String, String> labelParams) {

            if (labelParams == null) {
                return InstanceHolder.ERROR;
            }

            return new Result(labelParams);
        }

        private Result(final Map<String, String> labelParams) {
            this.labelParams = (labelParams == null) ? null : ImmutableMap.copyOf(labelParams);
        }

        public boolean isError() {
            return labelParams == null;
        }

        @NotNull
        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add(LABEL_PARAMS, labelParams)
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
