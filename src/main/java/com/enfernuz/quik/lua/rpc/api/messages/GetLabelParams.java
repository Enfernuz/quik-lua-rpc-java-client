package com.enfernuz.quik.lua.rpc.api.messages;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableMap;
import lombok.NonNull;
import lombok.Value;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

public final class GetLabelParams {

    private GetLabelParams() {}

    @Value
    public static class Request {

        String chartTag;
        int labelId;

        public Request(@NonNull final String chartTag, final int labelId) {
            this.chartTag = chartTag;
            this.labelId = labelId;
        }

        @NotNull
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

        Map<String, String> labelParams;

        @JsonCreator
        public static Result getInstance(@JsonProperty("label_params") final Map<String, String> labelParams) {

            if (labelParams == null || labelParams.isEmpty()) {
                return InstanceHolder.ERROR;
            }

            return new Result(labelParams);
        }

        private Result(final Map<String, String> labelParams) {
            this.labelParams = (labelParams == null || labelParams.isEmpty()) ? null : ImmutableMap.copyOf(labelParams);
        }

        @Contract(pure = true)
        public boolean isError() {
            return labelParams == null;
        }

        @NotNull
        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add("label_params", labelParams)
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
