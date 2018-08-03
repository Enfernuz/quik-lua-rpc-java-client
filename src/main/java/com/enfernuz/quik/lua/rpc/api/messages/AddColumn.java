package com.enfernuz.quik.lua.rpc.api.messages;

import com.google.common.base.MoreObjects;
import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

public final class AddColumn {

    private AddColumn() {}

    @Value
    public static class Request {

        int tId;
        int iCode;
        String name;
        boolean isDefault;
        ColumnParameterType parType;
        int width;

        @Builder
        private Request(
                final int tId,
                final int iCode,
                final @NonNull String name,
                final boolean isDefault,
                final @NonNull ColumnParameterType parType,
                final int width) {

            this.tId = tId;
            this.iCode = iCode;
            this.name = name;
            this.isDefault = isDefault;
            this.parType = parType;
            this.width = width;
        }

        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add("t_id", tId)
                    .add("icode", iCode)
                    .add("name", name)
                    .add("is_default", isDefault)
                    .add("par_type", parType)
                    .add("width", width)
                    .toString();
        }
    }

    @Value
    public static class Result {

        int result;

        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add("result", result)
                    .toString();
        }
    }

    public static enum ColumnParameterType {

        QTABLE_INT_TYPE,
        QTABLE_DOUBLE_TYPE,
        QTABLE_INT64_TYPE,
        QTABLE_CACHED_STRING_TYPE,
        QTABLE_TIME_TYPE,
        QTABLE_DATE_TYPE,
        QTABLE_STRING_TYPE;
    }
}
