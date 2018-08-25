package com.enfernuz.quik.lua.rpc.api.structures;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Value;
import lombok.experimental.NonFinal;

import java.util.Objects;

@Value
public class Security {

    String code;
    String name;
    String shortName;
    String classCode;
    String className;
    String faceValue;
    String faceUnit;
    String scale;
    String matDate;
    String lotSize;
    String isinCode;
    String minPriceStep;

    private transient @NonFinal @Getter(AccessLevel.NONE) int hashCode;
    private transient @NonFinal @Getter(AccessLevel.NONE) String asString;

    @Builder
    @JsonCreator
    private Security(
            final @JsonProperty("code") String code,
            final @JsonProperty("name") String name,
            final @JsonProperty("short_name") String shortName,
            final @JsonProperty("class_code") String classCode,
            final @JsonProperty("class_name") String className,
            final @JsonProperty("face_value") String faceValue,
            final @JsonProperty("face_unit") String faceUnit,
            final @JsonProperty("scale") String scale,
            final @JsonProperty("mat_date") String matDate,
            final @JsonProperty("lot_size") String lotSize,
            final @JsonProperty("isin_code") String isinCode,
            final @JsonProperty("min_price_step") String minPriceStep) {

        this.code = code;
        this.name = name;
        this.shortName = shortName;
        this.classCode = classCode;
        this.className = className;
        this.faceValue = faceValue;
        this.faceUnit = faceUnit;
        this.scale = scale;
        this.matDate = matDate;
        this.lotSize = lotSize;
        this.isinCode = isinCode;
        this.minPriceStep = minPriceStep;
    }

    @Override
    public boolean equals(final Object o) {

        if (o == this) {
            return true;
        } else if ( !(o instanceof Security) ) {
            return false;
        } else {
            final Security security = (Security) o;
            return Objects.equals(code, security.code) &&
                    Objects.equals(name, security.name) &&
                    Objects.equals(shortName, security.shortName) &&
                    Objects.equals(classCode, security.classCode) &&
                    Objects.equals(className, security.className) &&
                    Objects.equals(faceValue, security.faceValue) &&
                    Objects.equals(faceUnit, security.faceUnit) &&
                    Objects.equals(scale, security.scale) &&
                    Objects.equals(matDate, security.matDate) &&
                    Objects.equals(lotSize, security.lotSize) &&
                    Objects.equals(isinCode, security.isinCode) &&
                    Objects.equals(minPriceStep, security.minPriceStep);
        }
    }

    @Override
    public int hashCode() {

        if (hashCode == 0) {
            hashCode = Objects.hash(
                    code,
                    name,
                    shortName,
                    classCode,
                    className,
                    faceValue,
                    faceUnit,
                    scale,
                    matDate,
                    lotSize,
                    isinCode,
                    minPriceStep
            );
        }

        return hashCode;
    }

    @Override
    public String toString() {

        if (asString == null) {
            asString = MoreObjects.toStringHelper(this)
                    .add("code", code)
                    .add("name", name)
                    .add("short_name", shortName)
                    .add("class_code", classCode)
                    .add("class_name", className)
                    .add("face_value", faceValue)
                    .add("face_unit", faceUnit)
                    .add("scale", scale)
                    .add("mat_date", matDate)
                    .add("lot_size", lotSize)
                    .add("isin_code", isinCode)
                    .add("min_price_step", minPriceStep)
                    .toString();
        }

        return asString;
    }
}
