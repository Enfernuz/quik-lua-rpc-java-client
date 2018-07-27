package com.enfernuz.quik.lua.rpc.api.structures;

import com.google.common.base.MoreObjects;
import lombok.Value;

public final class DelAllLabels {

    private DelAllLabels() {}

    @Value
    public static class Request {

        String chartTag;

        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add("chart_tag", chartTag)
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
