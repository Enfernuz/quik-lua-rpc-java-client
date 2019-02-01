package com.enfernuz.quik.lua.rpc.api.structures;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import lombok.*;
import lombok.experimental.NonFinal;

import java.util.Objects;

@Value
public class ClassInfo {

    private static final String FIRM_ID = "firmid";
    private static final String NAME = "name";
    private static final String CODE = "code";
    private static final String NPARS = "npars";
    private static final String NSECS = "nsecs";

    String firmId;
    String name;
    String code;
    int npars;
    int nsecs;

    @Getter(AccessLevel.NONE)
    @NonFinal
    private transient int hashCode;

    @Getter(AccessLevel.NONE)
    @NonFinal
    private transient String asString;

    @JsonCreator
    @Builder
    private ClassInfo(
            @JsonProperty(FIRM_ID) final String firmId,
            @JsonProperty(NAME) final String name,
            @JsonProperty(CODE) final String code,
            @JsonProperty(NPARS) final int npars,
            @JsonProperty(NSECS) final int nsecs) {

        this.firmId = firmId;
        this.name = name;
        this.code = code;
        this.npars = npars;
        this.nsecs = nsecs;
    }

    @Override
    public boolean equals(final Object o) {

        if (o == this) {
            return true;
        } else if ( !(o instanceof ClassInfo) ) {
            return false;
        } else {
            final ClassInfo classInfo = (ClassInfo) o;
            return npars == classInfo.npars &&
                    nsecs == classInfo.nsecs &&
                    Objects.equals(firmId, classInfo.firmId) &&
                    Objects.equals(name, classInfo.name) &&
                    Objects.equals(code, classInfo.code);
        }
    }

    @Override
    public int hashCode() {

        if (hashCode == 0) {
            hashCode = Objects.hash(firmId, name, code, npars, nsecs);
        }

        return hashCode;
    }

    @Override
    public String toString() {

        if (asString == null) {
            asString = MoreObjects.toStringHelper(this)
                    .add(FIRM_ID, firmId)
                    .add(NAME, name)
                    .add(CODE, code)
                    .add(NPARS, npars)
                    .add(NSECS, nsecs)
                    .toString();
        }

        return asString;
    }
}
