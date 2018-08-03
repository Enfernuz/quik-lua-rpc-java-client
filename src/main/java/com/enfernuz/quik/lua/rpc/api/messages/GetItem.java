package com.enfernuz.quik.lua.rpc.api.messages;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.KeyDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.base.MoreObjects;
import com.sun.istack.internal.NotNull;
import lombok.NonNull;
import lombok.Value;

import java.io.IOException;
import java.util.Map;

public final class GetItem {

    private GetItem() {}

    @Value
    public static class Request {

        @NonNull String tableName;
        int index;

        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add("table_name", tableName)
                    .add("index", index)
                    .toString();
        }
    }

    @Value
    public static class Result {

        @JsonProperty(value = "table_row")
        Map<String, String> tableRow;

        @JsonCreator
        public Result(final @NonNull Map<String, String> tableRow) {
            this.tableRow = tableRow;
        }

        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add("table_row", tableRow)
                    .toString();
        }
    }
}
