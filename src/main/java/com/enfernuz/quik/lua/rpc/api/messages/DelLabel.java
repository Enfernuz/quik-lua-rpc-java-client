package com.enfernuz.quik.lua.rpc.api.messages;

import com.google.common.base.MoreObjects;
import lombok.NonNull;
import lombok.Value;

public final class DelLabel {

    private DelLabel() {}

    @Value
    public static class Request {

        String chartTag;
        int labelId;

        public Request(@NonNull final String chartTag, final int labelId) {
            this.chartTag = chartTag;
            this.labelId = labelId;
        }

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

        boolean result;

        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add("result", result)
                    .toString();
        }
    }
}