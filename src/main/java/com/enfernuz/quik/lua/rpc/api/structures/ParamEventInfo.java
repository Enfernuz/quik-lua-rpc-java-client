package com.enfernuz.quik.lua.rpc.api.structures;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import lombok.*;
import lombok.experimental.NonFinal;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

@Value
public class ParamEventInfo {

    private static final String CLASS_CODE = "class_code";
    private static final String SECURITY_CODE = "sec_code";

    String classCode;
    String secCode;

    @Getter(AccessLevel.NONE)
    @NonFinal
    private transient int hashCode;

    @Getter(AccessLevel.NONE)
    @NonFinal
    private transient String asString;

    @JsonCreator
    @Builder
    private ParamEventInfo(
            @JsonProperty(value = CLASS_CODE, required = true) @NonNull final String classCode,
            @JsonProperty(value = SECURITY_CODE, required = true) @NonNull final String secCode) {

        this.classCode = classCode;
        this.secCode = secCode;
    }

    @Override
    public boolean equals(final Object o) {

        if (o == this) {
            return true;
        } else if ( !(o instanceof ParamEventInfo) ) {
            return false;
        } else {
            final ParamEventInfo that = (ParamEventInfo) o;
            return Objects.equals(classCode, that.classCode) &&
                    Objects.equals(secCode, that.secCode);
        }
    }

    @Override
    public int hashCode() {

        if (hashCode == 0) {
            hashCode = Objects.hash(classCode, secCode);
        }

        return hashCode;
    }

    @NotNull
    @Override
    public String toString() {

        if (asString == null) {
            asString = MoreObjects.toStringHelper(this)
                    .add(CLASS_CODE, classCode)
                    .add(SECURITY_CODE, secCode)
                    .toString();
        }

        return asString;
    }
}
