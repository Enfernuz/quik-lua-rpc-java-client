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

    private static final String CODE = "code";
    private static final String NAME = "name";
    private static final String SHORT_NAME = "short_name";
    private static final String CLASS_CODE = "class_code";
    private static final String CLASS_NAME = "class_name";
    private static final String FACE_VALUE = "face_value";
    private static final String FACE_UNIT = "face_unit";
    private static final String SCALE = "scale";
    private static final String MATURITY_DATE = "mat_date";
    private static final String LOT_SIZE = "lot_size";
    private static final String ISIN_CODE = "isin_code";
    private static final String MIN_PRICE_STEP = "min_price_step";

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

    @Getter(AccessLevel.NONE)
    @NonFinal
    private transient int hashCode;

    @Getter(AccessLevel.NONE)
    @NonFinal
    private transient String asString;

    @JsonCreator
    @Builder
    private Security(
            @JsonProperty(CODE) final String code,
            @JsonProperty(NAME) final String name,
            @JsonProperty(SHORT_NAME) final String shortName,
            @JsonProperty(CLASS_CODE) final String classCode,
            @JsonProperty(CLASS_NAME) final String className,
            @JsonProperty(FACE_VALUE) final String faceValue,
            @JsonProperty(FACE_UNIT) final String faceUnit,
            @JsonProperty(SCALE) final String scale,
            @JsonProperty(MATURITY_DATE) final String matDate,
            @JsonProperty(LOT_SIZE) final String lotSize,
            @JsonProperty(ISIN_CODE) final String isinCode,
            @JsonProperty(MIN_PRICE_STEP) final String minPriceStep) {

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
                    .add(CODE, code)
                    .add(NAME, name)
                    .add(SHORT_NAME, shortName)
                    .add(CLASS_CODE, classCode)
                    .add(CLASS_NAME, className)
                    .add(FACE_VALUE, faceValue)
                    .add(FACE_UNIT, faceUnit)
                    .add(SCALE, scale)
                    .add(MATURITY_DATE, matDate)
                    .add(LOT_SIZE, lotSize)
                    .add(ISIN_CODE, isinCode)
                    .add(MIN_PRICE_STEP, minPriceStep)
                    .toString();
        }

        return asString;
    }
}
