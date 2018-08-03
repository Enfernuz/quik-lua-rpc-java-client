package com.enfernuz.quik.lua.rpc.api.structures;

import com.google.common.base.MoreObjects;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Value;
import lombok.experimental.NonFinal;

import java.util.Objects;

@Value
public class ParamEventInfo {

    String classCode;
    String secCode;

    private transient @NonFinal @Getter(AccessLevel.NONE) int hashCode;
    private transient @NonFinal @Getter(AccessLevel.NONE) String asString;

    @Builder
    private ParamEventInfo(final String classCode, final String secCode) {
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

    @Override
    public String toString() {

        if (asString == null) {
            asString = MoreObjects.toStringHelper(this)
                    .add("class_code", classCode)
                    .add("sec_code", secCode)
                    .toString();
        }

        return asString;
    }
}
