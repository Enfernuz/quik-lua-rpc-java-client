package com.enfernuz.quik.lua.rpc.api.structures;

import com.google.common.base.MoreObjects;
import lombok.*;
import lombok.experimental.NonFinal;

import java.util.Objects;

@Value
public class ClassInfo {

    String firmId;
    String name;
    String code;
    int npars;
    int nsecs;

    @Getter(AccessLevel.NONE)
    private @NonFinal transient int hashCode;

    @Getter(AccessLevel.NONE)
    private @NonFinal transient String asString;

    @Builder
    private ClassInfo(
            final String firmId,
            final String name,
            final String code,
            int npars,
            int nsecs) {

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
                    .add("firmid", firmId)
                    .add("name", name)
                    .add("code", code)
                    .add("npars", npars)
                    .add("nsecs", nsecs)
                    .toString();
        }

        return asString;
    }
}
