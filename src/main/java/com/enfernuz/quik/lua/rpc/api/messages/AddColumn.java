package com.enfernuz.quik.lua.rpc.api.messages;

import com.enfernuz.quik.lua.rpc.api.RemoteProcedure;
import com.enfernuz.quik.lua.rpc.api.RpcArgs;
import com.enfernuz.quik.lua.rpc.api.RpcResult;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.MoreObjects;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.Value;
import org.jetbrains.annotations.NotNull;

public final class AddColumn implements RemoteProcedure {

    private AddColumn() {}

    @JsonPropertyOrder({Args.T_ID, Args.I_CODE, Args.NAME, Args.IS_DEFAULT, Args.PAR_TYPE, Args.WIDTH})
    @EqualsAndHashCode
    public static class Args implements RpcArgs<AddColumn> {

        private static final String T_ID = "t_id";
        private static final String I_CODE = "iCode";
        private static final String NAME = "name";
        private static final String IS_DEFAULT = "is_default";
        private static final String PAR_TYPE = "par_type";
        private static final String WIDTH = "width";

        @JsonProperty(T_ID)
        private final int tId;

        @JsonProperty(I_CODE)
        private final int iCode;

        @JsonProperty(NAME)
        private final String name;

        @JsonProperty(IS_DEFAULT)
        private final boolean isDefault;

        @JsonProperty(PAR_TYPE)
        private final ColumnParameterType parType;

        @JsonProperty(WIDTH)
        private final int width;

        @Builder
        private Args(
                final int tId,
                final int iCode,
                @NonNull final String name,
                final boolean isDefault,
                @NonNull final ColumnParameterType parType,
                final int width) {

            this.tId = tId;
            this.iCode = iCode;
            this.name = name;
            this.isDefault = isDefault;
            this.parType = parType;
            this.width = width;
        }

        @NotNull
        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add(T_ID, tId)
                    .add(I_CODE, iCode)
                    .add(NAME, name)
                    .add(IS_DEFAULT, isDefault)
                    .add(PAR_TYPE, parType)
                    .add(WIDTH, width)
                    .toString();
        }

        @JsonIgnore
        public int getTId() {
            return this.tId;
        }

        @JsonIgnore
        public int getICode() {
            return this.iCode;
        }

        @JsonIgnore
        public String getName() {
            return this.name;
        }

        @JsonIgnore
        public boolean isDefault() {
            return this.isDefault;
        }

        @JsonIgnore
        public ColumnParameterType getParType() {
            return this.parType;
        }

        @JsonIgnore
        public int getWidth() {
            return this.width;
        }
    }

    @Value
    public static class Result implements RpcResult<AddColumn> {

        private static final String RESULT = "result";

        int result;

        @JsonCreator
        public Result(@JsonProperty(value = RESULT, required = true) final int result) {
            this.result = result;
        }

        @NotNull
        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add(RESULT, result)
                    .toString();
        }
    }

    public enum ColumnParameterType {

        QTABLE_INT_TYPE,
        QTABLE_DOUBLE_TYPE,
        QTABLE_INT64_TYPE,
        QTABLE_CACHED_STRING_TYPE,
        QTABLE_TIME_TYPE,
        QTABLE_DATE_TYPE,
        QTABLE_STRING_TYPE;
    }
}
